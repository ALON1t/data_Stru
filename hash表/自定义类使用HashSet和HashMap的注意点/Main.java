package 自定义类使用HashSet和HashMap的注意点;

import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main1(String[] args) {
        Person p1 = new Person("ya",18);
        Person p2 = new Person("ya",18);

        HashMap<Person,String> hashMap = new HashMap<>();
        hashMap.put(p1,"ya");
        System.out.println(hashMap.get(p2)); //ya

        HashMap<String,Person> hashMap1 = new HashMap<>();
        hashMap1.put("ya",p1);
        System.out.println(hashMap1.get("ya"));

    }
    public static void main(String[] args) {
        Person p1 = new Person("ya",18);
        Person p2 = new Person("ya",18);

        HashSet<Person> hashSet = new HashSet<>();
        hashSet.add(p1);
        System.out.println(hashSet.contains(p2)); //目前返回false
        //要想返回true，应该如何做？
        //重写hashCode() 和 equals() 方法

    }
}
