package DataStructures;

import java.util.Calendar;

public class LinkedList {

    // 头节点
    private Node head;
    // 尾节点
    private  Node last;
    // 长度
    private int length;

    /*
    插入节点
     */
    public void insert(int data, int index) throws Exception{
        if(index < 0 || index > length) {
            throw new IndexOutOfBoundsException("超出链表长度");
        }
        Node newNode = new Node(data);
        if (length == 0) {
            head = newNode;
            last = newNode;
        } else if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else if (length == index) {
            last.next = newNode;
            last = newNode;
        } else {
            Node temp = getNode(index);
            newNode.next = temp.next;
            temp.next = newNode;
        }
        length++;
    }

    /*
    删除节点
     */
    public Node remove(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("超出链表长度");
        }
        Node removeNode = null;
        if (index == 0) {
            removeNode = head;
            head = head.next;
        } else if (index == length - 1) {
            Node preNode = getNode(index - 1);
            removeNode = preNode.next;
            preNode.next = null;
            last = preNode;
        } else {
            Node preNode = getNode(index - 1);
            Node nextNode = preNode.next.next;
            removeNode = preNode.next;
            preNode.next = nextNode;
        }
        length--;
        return removeNode;
    }

    /*
    获取指定下标节点
     */
    public Node getNode(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("超出链表长度");
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /*
    打印数据
     */
    public void print() {
        Node temp = head;
        System.out.print("链表的值为：[");
        while (temp != null) {
            if (temp.next == null) System.out.print(temp.data);
            else System.out.print(temp.data + ", ");
            temp = temp.next;
        }
        System.out.println("]");
    }

    public static void main(String[] args) throws Exception{
        LinkedList linkedList = new LinkedList();
        linkedList.insert(1, 0);
        linkedList.insert(2, 1);
        linkedList.insert(3, 2);
        linkedList.insert(4, 3);
        linkedList.insert(5, 0);

        System.out.println("链表长度为：" + linkedList.length);
        linkedList.print();
    }

}


class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}