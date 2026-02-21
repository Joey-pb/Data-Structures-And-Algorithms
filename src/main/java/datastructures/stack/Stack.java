package datastructures.stack;

public class Stack {
    private Node top;
    private int height;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public Stack(int value) {
        Node newNode = new Node(value);
        top = newNode;
        this.height++;
    }

    public void printStack() {
        Node cur = top;
        while (cur != null) {
            System.out.println(cur.value);
            cur = cur.next;
        }
    }

    public void getTop() {
        System.out.println("Top: " + top.value);
    }

    public void getHeight() {
        System.out.println("Height: " + height);
    }

    public void push(int value) {
        Node newNode = new Node(value);
        if (height == 0) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }

        height++;
    }

    public Node pop(){
        if (height == 0) return null;
        Node temp = top;
        if (height == 1) {
            top = null;
        } else {
            top = top.next;
            temp.next = null;
        }

        height--;
        return temp;
    }
}
