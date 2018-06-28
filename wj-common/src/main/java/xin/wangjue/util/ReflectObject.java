package xin.wangjue.util;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ReflectObject {

    public static void main(String[] args) {
        HashMap map = new HashMap<String,String>();
        map.put("name","wj");
        map.put("sex","male");
        StringBuffer sb = new StringBuffer("");
        StringBuilder sbi = new StringBuilder("");
        ReflectObject rb = new ReflectObject();
        try {
            User user = rb.reflect(User.class, map);
            System.out.println(user.getName());
            System.out.println(23>>1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public <T> T reflect(Class<T> clazz, HashMap<String,String> map) throws Exception {
        T o = clazz.newInstance();
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            Method method = clazz.getMethod("set"+key.substring(0,1).toUpperCase()+key.substring(1),String.class);
            method.invoke(o,value);
        }
        return o;
    }

}
