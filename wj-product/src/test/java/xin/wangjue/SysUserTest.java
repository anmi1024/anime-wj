package xin.wangjue;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xin.wangjue.dao.SysUserDao;
import xin.wangjue.domain.entity.SysUser;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysUserTest {

    @Autowired
    private SysUserDao sysUserDao;

    @Test
    public void test_listSysUser() {
        List<SysUser> userList = sysUserDao.listSysUser();
        userList.forEach(t -> System.out.println(t.getCn()));
    }

    @Test
    public void test_findSysUserById() {
        SysUser user = sysUserDao.findSysUserById(1);
        Assert.assertEquals("admin",user.getUserName());
    }
}
