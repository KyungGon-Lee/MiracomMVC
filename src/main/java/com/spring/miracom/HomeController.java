package com.spring.miracom;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	MemberDAO dao = new MemberDAO();
	
	ArrayList<Member> lists = new ArrayList<Member>();

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		// 여기서 home은 다른거로 바꾸고 Locale 없애도 상관없음
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("title", "miracom home");
		model.addAttribute("name", "이경곤");
		model.addAttribute("a", formattedDate );
		
		Member m = new Member();
		m.id = "ckt";
		model.addAttribute("member", m);

		return "home";
		// 여기에서 리턴값을 h 로하면 h.jsp로 연결되서 안됨
		// 그래서 h.jsp에 전달을 해버려서 안됨 만약 되게하려면 h.jsp가 있어야 함
	}
	
	@RequestMapping(value = "/login.do") //.do는 써도되고 안써도 됨
	@ResponseBody // @ResponseBody 하면 주소가 아니라 그냥 결과값으로 리턴함 스트링 앞에다가 써도 됨 JSON 할때 씀 
	public String login(@RequestParam("id") String id,
						@RequestParam("pwd") String pwd,
						HttpSession session) {
		if(id.equals(pwd)) {
			session.setAttribute("id", id);
			return "{\"msg\":\"ok\"}";
		}else {
			return "{\"msg\":\"no\"}"; // \" <- 이거쓰면 스위칭 됨

		}
		// return "--> " + id + "/" + pwd;
		// login.do가서 주소창뒤에?id=50&pwd=haha 치면 --> 50/haha 라고 나옴
	}
	@RequestMapping(value = "/service.do")
	public String service(Model model, HttpSession session) { 
		// 데이터 넘겨받아서 Model 해줘야됨 그리고 세션을 알아야되서 HttpSession 만들어줘야됨
		String id = (String)session.getAttribute("id");
	    if(id == null){
	    	return "redirect:/";
	    }
		model.addAttribute("id", id);
		return "service";
	}
	

	@RequestMapping(value = "/logout")
	public String logout() {
		return "logout";
	}
	@RequestMapping(value = "/listmember.do")
	public String listmember(Model model) throws Exception {
//		lists.add(new Member("ckt0", "hong", "ckt0", "man", "maple"));
//		lists.add(new Member("ckt1", "kong", "ckt1", "woman", "overwatch"));
//		lists.add(new Member("ckt2", "dong", "ckt2", "woman", "fifa"));
//		lists.add(new Member("ckt3", "tong", "ckt3", "woman", "ppap"));
//		lists.add(new Member("ckt4", "song", "ckt4", "man", "singing"));
//		lists.add(new Member("ckt5", "vong", "ckt5", "woman", "piano"));

		model.addAttribute("lists", dao.selectAll()); // dao 하면 이렇게
		return "listmember";
	}
	
	@RequestMapping(value = "/registerform")
	public String registerform() {
		// registerform이라는 요청이 들어오면 registerform 이라는 걸 호출함
		return "registerform";
	}
	
	@RequestMapping(value = "/register.do")
	public String register(Member member) throws Exception {
//		return "--> " + member.getId() + "/" + member.getName() + 
//				"/" + member.getGender() + "/" + member.getHobby();
		dao.insert(member); // dao 추가해주면 이렇게 하면 된다 간단하게
		// lists.add(member); // 이렇게하면 위에처럼 노가다 안해도 된다
		return "redirect:/listmember.do";
	}
	@RequestMapping(value = "/deletemember.do")
	public String deletemember(@RequestParam("id") String id) throws Exception {
		dao.delete(id); 
		return "redirect:/listmember.do";
	}
	
	
}
