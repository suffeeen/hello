package translator;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TableUser {
	SqlOperator sql = new SqlOperator();
	public static String wordoperate(String sentence) {
                         //Ҫ������ַ���
		String sc = sentence.replaceAll("'","\\\\'");
       
        return sc;
	}
	public void newTable() throws SQLException {
		sql.connectToMysql("jdbc:mysql://127.0.0.1:5566/kscus", "root", "3.1415926");
		sql.sqlOperate(sql.sentenceNewTable("dictionary", "wordNo", "int"));
		sql.sqlOperate(sql.sentenceNewList("dictionary", "word", "varchar(30)"));//����20���ַ����û���
		sql.sqlOperate(sql.sentenceNewList("dictionary", "americanPronu", "varchar(100)"));//����20���ַ�������
		sql.sqlOperate(sql.sentenceNewList("dictionary", "britishPronu", "varchar(100)"));
		
		sql.sqlOperate(sql.sentenceNewList("dictionary", "meaning1", "varchar(100)"));//����������������0~255;
		sql.sqlOperate(sql.sentenceNewList("dictionary", "meaning2", "varchar(100)"));//����������������0~255;
		sql.sqlOperate(sql.sentenceNewList("dictionary", "meaning3", "varchar(100)"));//����������������0~255;
		sql.sqlOperate(sql.sentenceNewList("dictionary", "meaning4", "varchar(100)"));//����������������0~255;
		sql.sqlOperate(sql.sentenceNewList("dictionary", "meaning5", "varchar(100)"));//����������������0~255;
		sql.sqlOperate(sql.sentenceNewList("dictionary", "meaning6", "varchar(100)"));//����������������0~255;
		sql.sqlOperate(sql.sentenceNewList("dictionary", "meaning7", "varchar(100)"));//����������������0~255;
		sql.sqlOperate(sql.sentenceNewList("dictionary", "meaning8", "varchar(100)"));//����������������0~255;
		
		sql.sqlOperate(sql.sentenceNewList("dictionary", "sentence1", "varchar(200)"));//����������������0~255;
		sql.sqlOperate(sql.sentenceNewList("dictionary", "sentenceTrans1", "varchar(200)"));//����������������0~255;
		sql.sqlOperate(sql.sentenceNewList("dictionary", "sentence2", "varchar(200)"));//����������������0~255;
		sql.sqlOperate(sql.sentenceNewList("dictionary", "sentenceTrans2", "varchar(200)"));//����������������0~255;
		sql.sqlOperate(sql.sentenceNewList("dictionary", "sentence3", "varchar(200)"));//����������������0~255;
		sql.sqlOperate(sql.sentenceNewList("dictionary", "sentenceTrans3", "varchar(200)"));//����������������0~255;//
		sql.sqlclose();
		
	}
	public void insertData() throws SQLException, IOException {
		sql.connectToMysql("jdbc:mysql://127.0.0.1:5566/kscus", "root", "3.1415926");
		Scanner in = new Scanner(System.in);
		int count =0;
		while(in.hasNext()) {
			Map<String,String> map = new HashMap<String,String>();
    		count++;
    		String word = in.nextLine();
    		map.put("wordNo", String.valueOf(count));
    		map.put("word", word);
    		String [][] a =TestJsoup.translator(word);  
        	System.out.print(a[0][0]);//��һ������[Ӣ]
        	map.put("americanPronu",wordoperate(a[0][0]) );
        	System.out.print(a[0][1]);//�ڶ�������[��]
        	map.put("britishPronu",wordoperate(a[0][1]));
        	for(int i=0;i<8; i++) {
        		System.out.print(a[1][i]);//8�����룬�е�û������
        		map.put("meaning"+String.valueOf(i+1),wordoperate(a[1][i]));
        	}
        	System.out.print(a[2][0]);        	
        	map.put("sentence1",wordoperate(a[2][0]));
        	System.out.print(a[3][0]);
        	map.put("sentenceTrans1",wordoperate(a[3][0]) );
        	System.out.print(a[2][1]);
        	map.put("sentence2",wordoperate(a[2][1]) );
        	System.out.print(a[3][1]);
        	map.put("sentenceTrans2",wordoperate(a[3][1]));
        	System.out.print(a[2][2]);
        	map.put("sentence3",wordoperate(a[2][2]) );
        	System.out.print(a[3][2]);
        	map.put("sentenceTrans3",wordoperate(a[3][2]) );
        	sql.sqlOperate(sql.sentenceNewData("dictionary", map));
    	}
		
		sql.sqlclose();
		in.close();
	}
	public static void main(String[] args) throws SQLException, IOException {

		
		TableUser a = new TableUser();
		a.newTable();
		a.insertData();
		
	}
	


}
