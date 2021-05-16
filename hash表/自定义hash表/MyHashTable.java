package 自定义hash表;

//元素类型：Integer
//使用拉链法解决冲突
public class MyHashTable {
    //需要一个数组
    private Node[] arr = new Node[11];
    //记录hash表中有的元素个数
    private int size;

    //true:key之前不在hash表中
    //false:key之前在hash表中
    //插入的时间复杂度与链表的长度有关
    public boolean insert(Integer key) {
        //把对象转化为int类型
        int hashValue = key.hashCode();
        //把hash值转为合法的下标
        int index = hashValue % arr.length;
        //遍历index位置处的链表，确定key在不在链表中
        Node cur = arr[index];
        while (cur != null) {
            if (key.equals(cur.key)) {
                return false;
            }
            cur = cur.next;
        }
        //把key装入到节点中，并插入到对应的链表中
        //头插尾插都可以
        Node node = new Node(key);
        node.next = arr[index];
        arr[index] = node;
        //维护元素个数
        size++;
        //通过维护负载因子，进而维护较低的冲突率
        if (size / arr.length * 100 >= 75) { //size / arr.length >= 0.75两边同时×100
            //扩容
            expandTheCapacity();
        }
        return true;
    }

    //时间复杂度O(n)
    private void expandTheCapacity() {
        Node[] newArr = new Node[arr.length * 2]; //2倍
        //复制原来的元素
        //不能直接按链表的搬运，因为元素保存的下标的数组长度有关
        // 数组长度变了，下标也会变，所以需要把每个元素重新计算一次
        for (int i = 0; i < arr.length;i++) {
            //遍历每条链表
            Node cur = arr[i];
            while (cur != null) {
                //复制节点
                Integer key = cur.key;
                int hashValue = key.hashCode();
                int index = hashValue % newArr.length;
                //头插
                Node node = new Node(key);
                node.next = newArr[index];
                newArr[index] = node;

                cur = cur.next;
            }
        }
        arr = newArr;
    }

    //值在并且删除成功返回true
    //值不在返回false
    public boolean remove(Integer key) {
        int hashValue = key.hashCode();
        int index = hashValue % arr.length;
        Node cur = arr[index];
        Node prv = null;
        while (cur != null) {
            if (key.equals(cur.key)) { //找到了该元素
                //开始删除
                if (prv != null) {
                    prv.next = cur.next;
                } else {
                    //cur是链表的头结点
                    arr[index] = cur.next;
                }
                size--;
                return true;
            }
            prv = cur;
            cur = cur.next;
        }
        return false;
    }

    public boolean contains(Integer key){
        int hashValue = key.hashCode();
        int index = hashValue % arr.length;
        Node cur = arr[index];
        while (cur != null) {
            if (key.equals(cur.key)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
}
