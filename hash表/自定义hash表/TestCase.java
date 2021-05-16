package 自定义hash表;

public class TestCase {
    public static void main(String[] args) {
        int[] a = {103,29,38,4,7,55,907,32};
        MyHashTable hashTable = new MyHashTable();
        for (int e : a) {
            hashTable.insert(e);
        }
    }
}
