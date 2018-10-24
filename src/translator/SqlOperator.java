package translator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SqlOperator {
	Connection conn = null;  
	Statement stmt;

	public void connectToMysql(String url,String userName , String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("加载mysql驱动成功"); 
			conn = DriverManager.getConnection( url , userName , password);
			System.out.println("数据库连接成功");
			stmt = conn.createStatement();
		}
		catch(Exception e ) {
			
		}				
	}
	public void sqlOperate(String sentence) throws SQLException {		
		int result = stmt.executeUpdate(sentence);
		if(result !=-1) {
			System.out.println("语句写入成功");
		}		
	}
	public void sqlclose() throws SQLException {
		conn.close();  
		System.out.println("数据库连接关闭");
	}
	public String sentenceNewData(String table , Map data) {
		String keys = new String ()  ;
		String values =  new String () ;
		String sentence ;
		Iterator it = data.entrySet().iterator();
		  while (it.hasNext()) {
		   Map.Entry entry = (Map.Entry) it.next();
		   Object key = entry.getKey();
		   Object value = entry.getValue();
		   System.out.println("key=" + key + " value=" + value);
		   keys = keys + key+",";
		   values = values + value +"','";
		 }
		 keys= keys.substring(0, keys.length()-1);
		 values = values.substring(0, values.length() -2);
		sentence = "insert into " + table + "(" + keys + ")" + "values('" + values +" )";	
		System.out.println(sentence);
		return sentence;  
	}
	public String sentenceNewTable( String newTableName , String primaryKey , String type) {
		String sentence = "create table " + newTableName + " ( " + primaryKey + " " + type + " primary key not null auto_increment "+")";
		System.out.print(sentence);
		return sentence;  
	}
	public String sentenceNewList(String selectedTable ,String column , String type ) {
		String sentence = "alter table " + selectedTable + " add " + column + " " + type + " " +  "not null default 0" ;
		System.out.println(sentence);
		return sentence;
	}
	public String sentenceModify(String table , String selectedColumn , String selectedValue , String modifiedColumn , String  modifiedValue) {
		String sentence = "update "+table+" set "+ modifiedColumn +"="+ modifiedValue +" where "+ selectedColumn +"="+ "'"+selectedValue+"'";
		System.out.println(sentence);
		return  sentence;
	}
//update tablexx set column=XXX where XXX=XXX;
	public static void main(String[] args) throws SQLException {
		

	}
}

