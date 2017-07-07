package com.sist.movie;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MovieCGVManager {
	public MovieVO[] getMovieData(){
		MovieVO[] mv=new MovieVO[7];
		
		try{
			Document doc=
					Jsoup.connect("http://www.cgv.co.kr/movies/?ft=0").get();
			
			Elements title=doc.select("div.box-contents a strong.title");
			Elements poster=doc.select("div.box-image a span.thumb-image img");
			
			for(int i=0;i<mv.length;i++){
				Element telem=title.get(i);
				Element pelem=poster.get(i);
				String img=pelem.attr("src");
				//System.out.println(telem.text()+" "+img);
				MovieVO vo=new MovieVO();
				vo.setTitle(telem.text());
				vo.setPoster(img);
				mv[i]=vo;
			}			
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
		return mv;
	}
}
