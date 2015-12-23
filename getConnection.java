//import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.Test;

public class getConnection {

	String username = "root";
	String password = "GrxchH6";
	String dbname = "course";
	String mysqlurl = "jdbc:mysql://10.96.141.83:3306/"+dbname;
	//String driver = "com.mysql.jbbc.Driver"

	@Test
	public  void getConnection() throws InterruptedException {

    try {

      Class.forName("com.mysql.jdbc.Driver");     //java.lang.class类的静态方法：forName加载MYSQL JDBC驱动程序
      //Class.forName("org.gjt.mm.mysql.Driver");

     System.out.println("Now Success loading Mysql Driver!");
    }
    catch (Exception e) {

      System.out.print("Error loading Mysql Driver!");

      e.printStackTrace();
    }

    try {

      //Connection connect = DriverManager.getConnection( "jdbc:mysql://10.96.141.83:3306/course","root","GrxchH6");
        Connection connect = DriverManager.getConnection(mysqlurl,username,password);
           //连接URL为jdbc:mysql//服务器地址/数据库名,后面的2个参数分别是登陆用户名和密码
           //创建数据库连接
      System.out.println("Success connect Mysql server:10.96.141.83! port:3306,dababase:course");

      Statement stmt = connect.createStatement();
          //创建Statement，执行SQL语句
      ResultSet rs = stmt.executeQuery("select * from tbl_course where status =3 and company_id = 0 order by id desc");//tbl_course表的名称
         //执行SQL，返回结果集ResultSet
 while (rs.next()) {

        System.out.println("课程名称:"+rs.getString("name")+"\40\40"+"课程图片pic："+rs.getString("pic"));
         //循环，输出结果集中的name字段
       
      }
       System.out.println("Now connect Mysql server，executeQuery completely!");
//关闭记录集

 if (rs != null) {

     try {

         rs.close();

     } catch (SQLException e) {

         e.printStackTrace();

     }

  }

 // 关闭声明

 if (stmt != null) {

     try {

         stmt.close();

     } catch (SQLException e) {

         e.printStackTrace();

     }

  }

 // 关闭链接对象

 if (connect != null) {

     try {

         connect.close();

     } catch (SQLException e) {

         e.printStackTrace();

     }

  }


    }catch (Exception e) {
      System.out.print("get data error!");

      e.printStackTrace();
    }


	   }

 }
