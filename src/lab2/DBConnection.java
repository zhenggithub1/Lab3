package lab2;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.sql.Connection;

public class DBConnection  
{  
    private String dbDriver="com.mysql.jdbc.Driver";   
    private String dbUrl="jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_zheng22?useUnicode=true&characterEncoding=utf-8&useSSL=false";
    private String dbUser="2k0wzj30jk";  
    private String dbPass="l5h0ix2wlwhjw25l03wimy1mi1lhy1wjkw30x3ji";  
    public Connection getConn()  
    {  
        Connection conn=null;  
        try  
        {  
            Class.forName(dbDriver).newInstance();  
        }  
        catch (Exception e)  
        {  
            e.printStackTrace();  
        }  
        try  
        {  
            conn = DriverManager.getConnection(dbUrl,dbUser,dbPass);  
        }  
        catch (SQLException e)  
        {  
            e.printStackTrace();  
        }  
        return conn;  
    }

public int insert(String sql)  
{  
    int i=0;  
    Connection cnn=getConn();  

    try{  
        PreparedStatement preStmt =cnn.prepareStatement(sql);  
        i=preStmt.executeUpdate();  
    }  
    catch (SQLException e)  
    {  
        e.printStackTrace();  
    }  
    return i;//1Ϊִ�гɹ�  
}  
public int update(String sql)
{  
    int i=0;  
    Connection cnn=getConn();  
    try{  
        PreparedStatement preStmt =cnn.prepareStatement(sql);  
        i=preStmt.executeUpdate();  
    }  
    catch (SQLException e)  
    {  
        e.printStackTrace();  
    }  
    return i;//1Ϊִ�гɹ�  
}  
public List<String> select(String sql)
{  
    int i;
    Connection cnn = getConn();
    List<String> list = new LinkedList<String>();
    try  
    {  
        Statement stmt = cnn.createStatement();  
        ResultSet rs = stmt.executeQuery(sql);  
        while(rs.next())  
        {  
            for(i = 1;i<=rs.getMetaData().getColumnCount();i++){
            list.add(rs.getString(i));}
        }  
        //���Խ����ҵ���ֵд���࣬Ȼ�󷵻���Ӧ�Ķ���  
    }  
    catch (Exception e)  
    {  
        e.printStackTrace();  
    }  
    return list;  
}  
public int delete(String sql)  
{  
    int i=0;  
    Connection conn = getConn();
    try  
    {  
        Statement stmt = conn.createStatement();  
        i = stmt.executeUpdate(sql);  
    }  
    catch (SQLException e)  
    {  
        e.printStackTrace();  
    }  
    return i;//������ص���1����ִ�гɹ�;  
}  
}