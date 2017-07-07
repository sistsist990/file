package com.sist.movie;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class MovieRankDAO {
	public MovieRankVO[] getRankData(){
		MovieRankVO[] mrv=new MovieRankVO[10];
		
		try{
			Document doc=
				Jsoup.connect("http://movie.naver.com/movie/sdb/rank/rmovie.nhn").get();
				//title,º¯µ¿Æø
				
			
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return mrv;
	}
}



