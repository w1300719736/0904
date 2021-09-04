/**
 * @Description: yy-2332
 * @Author WuHao
 * @Date: 2021/9/4 23:09
 * @Version 1.0
 */

package ujiuye.dao;




import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import ujiuye.entity.User;
import ujiuye.util.JdbcUtil;

import java.sql.SQLException;

public class UserDao {
    QueryRunner qr = JdbcUtil.getQueryRunner();
    public User login(String username, String pwd){
        User user = null;
        String sql = "select * from tb_user where username = ? and pwd = ?";
        System.out.println(username + " "+pwd);
        try {
           user = qr.query(sql,new BeanHandler<>(User.class),username,pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}

