package com.example.studyInterface;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // @Controller 컨트롤러 빈
public class MemoController {
	@Inject
	MemoDAO memoDao;
	
	@RequestMapping("/") // 시작
	public ModelAndView list(ModelAndView mav) { // ModelAndView: 데이터와 페이지를 같이 감
		List<MemoDTO> items = memoDao.list();
		mav.setViewName("list"); // list.jsp로 가세요~
		mav.addObject("list", items);
		return mav;
	} // list
	
	@RequestMapping("insert.do")
	public String insert(MemoDTO dto) {
		memoDao.insert(dto.getWriter(), dto.getMemo());
		return "redirect:/";
	} // insert
	
	@RequestMapping("view/{idx}")
	public ModelAndView view(@PathVariable int idx, ModelAndView mav) {
		mav.setViewName("view");
		mav.addObject("dto", memoDao.view(idx));
		return mav;
	} // view
	
	@RequestMapping("update/{idx}")
	public String update(@PathVariable int idx, MemoDTO dto) {
		memoDao.update(dto);
		return "redirect:/";
	} // update
	
	@RequestMapping("delete/{idx}")
	public String delete(@PathVariable int idx) {
		memoDao.delete(idx);
		return "redirect:/";
	} // delete
		
} // class
