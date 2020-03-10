package com.dizewei.cms.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.dizewei.cms.common.CmsConst;
import com.dizewei.cms.common.JsonResult;
import com.dizewei.cms.pojo.Article;
import com.dizewei.cms.pojo.Category;
import com.dizewei.cms.pojo.Channel;
import com.dizewei.cms.pojo.Slide;
import com.dizewei.cms.pojo.User;
import com.dizewei.cms.service.ArticleService;

@Controller
@RequestMapping("/article/")
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	
	/**
	 * @Title: add   
	 * @Description: 跳转到文章编辑页面
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	@GetMapping("/add")
	public String toAdd(Integer id,Model model) {
		List<Channel> channelList = articleService.getChannelAll();
		model.addAttribute("channelList", channelList);
		if(id!=null) {
			Article article = articleService.getById(id);
			List<Category> cateList = articleService.getCateListByChannelId(article.getChannel_id());
			model.addAttribute("article", article);
			model.addAttribute("cateList", cateList);
		}
		return "article/add";
	}
	/**
	 * @Title: save   
	 * @Description: 保存文章   
	 * @param: @param article
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	@PostMapping("/save")
	public @ResponseBody JsonResult save(Article article,HttpSession session) {
		User userInfo = (User)session.getAttribute(CmsConst.UserSessionKey);
		article.setUser_id(userInfo.getId());
		articleService.save(article);
		return JsonResult.sucess();
	}
	/**
	 * @Title: getCateListByChannelId   
	 * @Description: 根据频道Id查询分类列表  
	 * @param: @param channelId
	 * @param: @return      
	 * @return: JsonResult      
	 * @throws
	 */
	@GetMapping("/getCateListByChannelId")
	public @ResponseBody JsonResult getCateListByChannelId(Integer channelId) {
		List<Category> cateList = articleService.getCateListByChannelId(channelId);
		return JsonResult.sucess(cateList);
	}
	
	/**
	 * @Title: articles   
	 * @Description: 文章管理（我的文章）   
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	@RequestMapping("/articles")
	public String articles(Article article,Model model,HttpSession session,
			@RequestParam(value="pageNum",defaultValue="1") Integer pageNum,
			@RequestParam(value="pageSize",defaultValue="2") Integer pageSize) {
		User userInfo = (User)session.getAttribute(CmsConst.UserSessionKey);
		article.setUser_id(userInfo.getId());
		PageInfo<Article> pageInfo = articleService.getPageInfo(article, pageNum, pageSize);
		model.addAttribute("pageInfo", pageInfo);
		return "article/articles";
	}
	/**
	 * @Title: deleteByIds   
	 * @Description: 根据Ids批量删除文章   
	 * @param: @param ids
	 * @param: @return      
	 * @return: JsonResult      
	 * @throws
	 */
	@PostMapping("/deleteByIds")
	public @ResponseBody JsonResult deleteByIds(String ids) {
		articleService.deleteByIds(ids);
		return JsonResult.sucess();
	}
	
	@RequestMapping("/hot/{pageNum}.html")
	public String hot(Model model,@PathVariable Integer pageNum) {
		PageInfo<Article> pageInfo = articleService.getHotList(pageNum,4);
		model.addAttribute("pageInfo", pageInfo);
		return "article-detail";
	}
	
}
