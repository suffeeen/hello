package translator;


import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class TestJsoup {
    
    
    public static String[][]  translator(String word) {
    	String[][] out = new String [4][8];
    	String url = "http://dict.youdao.com/search?q="+word;
    	try {
            Document document = Jsoup.connect(url).post();//从有道翻译获取单词解释
            out[0][0] = document.select("#phrsListTab > h2 > div > span:nth-child(1) > span").text();//获取1组音标
            out[0][1] = document.select("#phrsListTab > h2 > div > span:nth-child(2) > span").text();//获取2组音标
            out[1][0] = document.select("#phrsListTab > div.trans-container > ul > li:nth-child(1)").text();//获取1组翻译
            out[1][1] = document.select("#phrsListTab > div.trans-container > ul > li:nth-child(2)").text();//获取2组翻译
            out[1][2] = document.select("#phrsListTab > div.trans-container > ul > li:nth-child(3)").text();//获取3组翻译
            out[1][3] = document.select("#phrsListTab > div.trans-container > ul > li:nth-child(4)").text();//获取4组翻译
            out[1][4] = document.select("#phrsListTab > div.trans-container > ul > li:nth-child(5)").text();//获取5组翻译
            out[1][5] = document.select("#phrsListTab > div.trans-container > ul > li:nth-child(6)").text();//获取6组翻译
            out[1][6] = document.select("#phrsListTab > div.trans-container > ul > li:nth-child(7)").text();//获取7组翻译
            out[1][7] = document.select("#phrsListTab > div.trans-container > ul > li:nth-child(8)").text();//获取8组翻译
            
            url = "https://cn.bing.com/dict/search?q="+word+"&go=%E6%90%9C%E7%B4%A2&qs=ds&form=Z9LH5";
            document = Jsoup.connect(url).post();//从必应翻译获取例句           
            out[2][0] =document.select("#pos_0 > div:nth-child(2) > table > tbody > tr:nth-child(1) > td:nth-child(2) > div > div.val_ex").text();
            out[3][0] =document.select("#pos_0 > div:nth-child(2) > table > tbody > tr:nth-child(1) > td:nth-child(2) > div > div.bil_ex").text();
            out[2][1] =document.select("#pos_0 > div:nth-child(4) > table > tbody > tr:nth-child(1) > td:nth-child(2) > div > div.val_ex").text();
            out[3][1] =document.select("#pos_0 > div:nth-child(4) > table > tbody > tr:nth-child(1) > td:nth-child(2) > div > div.bil_ex").text();
            out[2][2] =document.select("#pos_0 > div:nth-child(6) > table > tbody > tr:nth-child(1) > td:nth-child(2) > div > div.val_ex").text();
            out[3][2] =document.select("#pos_0 > div:nth-child(6) > table > tbody > tr:nth-child(1) > td:nth-child(2) > div > div.bil_ex").text();
            
        } catch (IOException e) {
            e.printStackTrace();
    	}
    	return out;
    }
  
    public static void main(String[] args) {
    	while(true) {
    		Scanner in = new Scanner(System.in);
    		
    		String [][] a =translator(in.next());  
        	
        	System.out.print(a[0][0]);//第一个音标[英]
        	System.out.println(a[0][1]);//第二个音标[美]
        	for(int i=0;i<7; i++)
        		System.out.print(a[1][i]);//8个翻译，有的没有内容
        	System.out.println(a[1][7]);
        	System.out.println(a[2][0]);
        	System.out.println(a[3][0]);
        	System.out.println(a[2][1]);
        	System.out.println(a[3][1]);
        	System.out.println(a[2][2]);
        	System.out.println(a[3][2]);
    	}
    	
    }
}
    
