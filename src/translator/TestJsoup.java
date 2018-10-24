package translator;


import java.io.IOException;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class TestJsoup {
    
    
    public static String[][]  translator(String word) throws IOException {
    	String[][] out = new String [4][8];
    	String url = "http://dict.youdao.com/search?q="+word;
    	try {
            Document document = Jsoup.connect(url).post();//���е������ȡ���ʽ���
            out[0][0] = document.select("#phrsListTab > h2 > div > span:nth-child(1) > span").text();//��ȡ1������
            out[0][1] = document.select("#phrsListTab > h2 > div > span:nth-child(2) > span").text();//��ȡ2������
            out[1][0] = document.select("#phrsListTab > div.trans-container > ul > li:nth-child(1)").text();//��ȡ1�鷭��
            out[1][1] = document.select("#phrsListTab > div.trans-container > ul > li:nth-child(2)").text();//��ȡ2�鷭��
            out[1][2] = document.select("#phrsListTab > div.trans-container > ul > li:nth-child(3)").text();//��ȡ3�鷭��
            out[1][3] = document.select("#phrsListTab > div.trans-container > ul > li:nth-child(4)").text();//��ȡ4�鷭��
            out[1][4] = document.select("#phrsListTab > div.trans-container > ul > li:nth-child(5)").text();//��ȡ5�鷭��
            out[1][5] = document.select("#phrsListTab > div.trans-container > ul > li:nth-child(6)").text();//��ȡ6�鷭��
            out[1][6] = document.select("#phrsListTab > div.trans-container > ul > li:nth-child(7)").text();//��ȡ7�鷭��
            out[1][7] = document.select("#phrsListTab > div.trans-container > ul > li:nth-child(8)").text();//��ȡ8�鷭��
            
            url = "https://cn.bing.com/dict/search?q="+word+"&go=%E6%90%9C%E7%B4%A2&qs=ds&form=Z9LH5";
            document = Jsoup.connect(url).post();//�ӱ�Ӧ�����ȡ����           
            out[2][0] =document.select("#pos_0 > div:nth-child(2) > table > tbody > tr:nth-child(1) > td:nth-child(2) > div > div.val_ex").text();
            out[3][0] =document.select("#pos_0 > div:nth-child(2) > table > tbody > tr:nth-child(1) > td:nth-child(2) > div > div.bil_ex").text();
            out[2][1] =document.select("#pos_0 > div:nth-child(4) > table > tbody > tr:nth-child(1) > td:nth-child(2) > div > div.val_ex").text();
            out[3][1] =document.select("#pos_0 > div:nth-child(4) > table > tbody > tr:nth-child(1) > td:nth-child(2) > div > div.bil_ex").text();
            out[2][2] =document.select("#pos_0 > div:nth-child(6) > table > tbody > tr:nth-child(1) > td:nth-child(2) > div > div.val_ex").text();
            out[3][2] =document.select("#pos_0 > div:nth-child(6) > table > tbody > tr:nth-child(1) > td:nth-child(2) > div > div.bil_ex").text();
            
        } catch (IOException e) {
        	Document document = Jsoup.connect(url).post();//���е������ȡ���ʽ���
            out[0][0] = document.select("#phrsListTab > h2 > div > span:nth-child(1) > span").text();//��ȡ1������
            out[0][1] = document.select("#phrsListTab > h2 > div > span:nth-child(2) > span").text();//��ȡ2������
            out[1][0] = document.select("#phrsListTab > div.trans-container > ul > li:nth-child(1)").text();//��ȡ1�鷭��
            out[1][1] = document.select("#phrsListTab > div.trans-container > ul > li:nth-child(2)").text();//��ȡ2�鷭��
            out[1][2] = document.select("#phrsListTab > div.trans-container > ul > li:nth-child(3)").text();//��ȡ3�鷭��
            out[1][3] = document.select("#phrsListTab > div.trans-container > ul > li:nth-child(4)").text();//��ȡ4�鷭��
            out[1][4] = document.select("#phrsListTab > div.trans-container > ul > li:nth-child(5)").text();//��ȡ5�鷭��
            out[1][5] = document.select("#phrsListTab > div.trans-container > ul > li:nth-child(6)").text();//��ȡ6�鷭��
            out[1][6] = document.select("#phrsListTab > div.trans-container > ul > li:nth-child(7)").text();//��ȡ7�鷭��
            out[1][7] = document.select("#phrsListTab > div.trans-container > ul > li:nth-child(8)").text();//��ȡ8�鷭��
            
            url = "https://cn.bing.com/dict/search?q="+word+"&go=%E6%90%9C%E7%B4%A2&qs=ds&form=Z9LH5";
            document = Jsoup.connect(url).post();//�ӱ�Ӧ�����ȡ����           
            out[2][0] =document.select("#pos_0 > div:nth-child(2) > table > tbody > tr:nth-child(1) > td:nth-child(2) > div > div.val_ex").text();
            out[3][0] =document.select("#pos_0 > div:nth-child(2) > table > tbody > tr:nth-child(1) > td:nth-child(2) > div > div.bil_ex").text();
            out[2][1] =document.select("#pos_0 > div:nth-child(4) > table > tbody > tr:nth-child(1) > td:nth-child(2) > div > div.val_ex").text();
            out[3][1] =document.select("#pos_0 > div:nth-child(4) > table > tbody > tr:nth-child(1) > td:nth-child(2) > div > div.bil_ex").text();
            out[2][2] =document.select("#pos_0 > div:nth-child(6) > table > tbody > tr:nth-child(1) > td:nth-child(2) > div > div.val_ex").text();
            out[3][2] =document.select("#pos_0 > div:nth-child(6) > table > tbody > tr:nth-child(1) > td:nth-child(2) > div > div.bil_ex").text();
    	}
    	return out;
    }
  
    public static void main(String[] args) throws IOException {
    	while(true) {
    		Scanner in = new Scanner(System.in);
    		
    		String [][] a =translator(in.next());  
        	
        	System.out.print(a[0][0]);//��һ������[Ӣ]
        	System.out.println(a[0][1]);//�ڶ�������[��]
        	for(int i=0;i<7; i++)
        		System.out.print(a[1][i]);//8�����룬�е�û������
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
    
