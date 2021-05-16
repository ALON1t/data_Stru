package java中hash表的使用;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        System.out.println(map.put("ta",1)); //null
        System.out.println(map); //{ta=1}
        System.out.println(map.put("ta",2)); //1
        System.out.println(map.put("ya",22)); //null
        map.put("aa",33);
        System.out.println(map); //{aa=33, ya=22, ta=2}
        for (String k : map.keySet()) {
            System.out.print(k + " "); //aa ya ta
        }
    }
    public static void main1(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        System.out.println(set);
        System.out.println(set.add(1)); //false
        System.out.println(set);
        set.remove(3); //true
        System.out.println(set);
        System.out.println(set.contains(4)); //false
        System.out.println(set.contains(2)); //true
    }

}
