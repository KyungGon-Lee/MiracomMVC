package com.spring.miracom;

import java.util.ArrayList;

public class MemberDAO {
	
	ArrayList<Member> lists = new ArrayList<Member>(); 

	public MemberDAO() {
		for(int i=0; i < 10; i++) {
			lists.add(new Member("김아이디"+i,"테스트트"+i, "인간"+i,
						Math.random() > 0.5 ? "man" : "woman",
						Math.random() > 0.5 ? "피아노" : "우주여행"));
		}
	}
	public int insert(Member member) throws Exception {
		lists.add(member);
		return 1;			
	}
	
	public  Member read(String id) throws Exception {
		for(int i = 0; i < lists.size(); i++) {
			if ( lists.get(i).getId().equals( id ) ) 
				return lists.get(i);
		}			
		return null; 
	}
	
	public  int update(Member member) throws Exception {
		for(int i = 0; i < lists.size(); i++) {
			if ( lists.get(i).getId().equals( member.getId() ) ) { 
				lists.get(i).setPwd( member.getPwd() );
				lists.get(i).setName( member.getName() );
				lists.get(i).setGender( member.getGender() );
				lists.get(i).setHobby( member.getHobby() );
			}		
		}			
		return 1;
	}	
	public  void delete(String id) {
		for(int i = 0; i < lists.size(); i++) {
			if ( lists.get(i).getId().equals( id ) ) { 
				lists.remove(lists.get(i));
				return;
			}		
		}	
		return;
	}
	
	public boolean login(String id, String pwd) {
		for(int i = 0; i < lists.size(); i++) {
			if ( lists.get(i).getId().equals(id) &&
				 lists.get(i).getId().equals(pwd)) 
				return true;
		}		
		return false;
	}
	
	public  ArrayList<Member>   selectAll() throws Exception {
		 return lists;
	}
}
