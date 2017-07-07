package com.sist.user;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import com.sist.movie.MovieCGVManager;
import com.sist.movie.MovieVO;

public class MovieMain extends JFrame
					implements MouseListener{

	JLabel la1,la2,la3;
	JTable table1,table2,table3;
	DefaultTableModel model1,model2,model3;
	JLabel[] poster=new JLabel[7];
	
	MovieCGVManager mgr=new MovieCGVManager();
	
	
	public MovieMain(){
		JMenuBar bar=new JMenuBar();
		
		JMenu menu=new JMenu("홈");
		JMenuItem item1=new JMenuItem("홈");
		JMenuItem item2=new JMenuItem("영화목록");
		JMenuItem item3=new JMenuItem("종료");
		menu.add(item1);
		menu.add(item2);
		menu.add(item3);
		bar.add(menu);
		
		JMenu menu1=new JMenu("영화애매");
		JMenuItem item4=new JMenuItem("빠른 예매");
		JMenuItem item5=new JMenuItem("영화 예매");
		menu1.add(item4);
		menu1.add(item5);
		bar.add(menu1);		
		
		JMenu menu2=new JMenu("고객센터");
		JMenuItem item6=new JMenuItem("리뷰");
		JMenuItem item7=new JMenuItem("마이페이지");
		menu2.add(item6);
		menu2.add(item7);
		bar.add(menu2);
		
		la1=new JLabel("영화랭크", JLabel.CENTER);
		la1.setForeground(Color.PINK);
		la1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		
		
		
		setLayout(null);
		
		
		
		
		String[] col1={"영화명","변동폭"};
		String[][] row1=new String[0][2];
		model1=new DefaultTableModel(row1,col1);
		
		//테이블
		table1=new JTable(model1);
		table1.setRowHeight(27);
		table1.getTableHeader().setBackground(Color.PINK);
		JScrollPane js1=new JScrollPane(table1);
		
		
		la1.setBounds(10, 300, 250, 30);
		js1.setBounds(10, 335, 250, 300);
		
		MovieVO[] mv=mgr.getMovieData();
		try{
			for(int i=0;i<mv.length;i++){
				URL url=new URL(mv[i].getPoster());
				poster[i]=
				new JLabel(
				new ImageIcon(
				getImageChange(
				new ImageIcon(url), 125, 270)));
				poster[i].setToolTipText(mv[i].getTitle());
				poster[i].setBounds(10+(i*125), 15, 120, 270);
				add(poster[i]);
				//
					
			}
			
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
		add(la1);
		add(js1);
		
		setJMenuBar(bar);
		setSize(900, 695);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void getData(){
		
	}
	
	public Image getImageChange(ImageIcon img,int width,int height){
		Image i=img.getImage();
		Image c=i.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return c;
	}
	
	public static void main(String[] args){
		try{
			UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
			JFrame.setDefaultLookAndFeelDecorated(true);
			
			
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
		MovieMain m=new MovieMain();
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}







