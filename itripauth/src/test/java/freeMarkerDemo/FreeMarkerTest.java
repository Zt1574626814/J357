package freeMarkerDemo;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.*;

public class FreeMarkerTest {

    @Test
    public void test1() throws Exception {

        Map<String, Object> map = new HashMap<>();
        List<UserTest> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(new UserTest(i, "名字" + i));
        }
        map.put("list",list);
        Configuration config = new Configuration();
        // 查找文件模板路径
        config.setDirectoryForTemplateLoading(new File("/Users/Zt/Develop/IdeaProjects/Itrip_System/itripauth/src/test/java/freeMarkerDemo"));
        Template t = config.getTemplate("Data.flt");
        // 二进制输出新的内容
        t.process(map,new FileWriter("/Users/Zt/Desktop/test.txt"));
    }

    @Test
    public void test(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.format(new Date(System.currentTimeMillis())));
    }
}
