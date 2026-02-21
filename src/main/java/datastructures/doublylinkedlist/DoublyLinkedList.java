package datastructures.doublylinkedlist;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

   class Node {
        int value;
        Node prev;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        this.length = 1;
    }

    public void printList() {
        Node curr = head;
        while (curr != null) {
            System.out.println(curr.value);
            curr = curr.next;
        }
    }

    public void getHead() {
        System.out.println(this.head);
    }

    public void getTail() {
        System.out.println(this.tail);
    }

    public void getLength() {
        System.out.println(this.length);
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast() {
        if (length == 0) return null;

        Node temp = tail;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }
        length--;
        return temp;
    }

    public void prepend(int value) {
       Node newNode = new Node(value);
       if (length == 0) {
           head = newNode;
           tail = newNode;
       } else {
           head.prev = newNode;
           newNode.next = head;
           head = newNode;
       }
       length++;
    }

    public Node removeFirst() {
       if (length == 0) return null;

       Node temp = head;
       if (length == 1) {
           head = null;
           tail = null;
       } else {
           head = head.next;
           head.prev = null;
           temp.next = null;
       }
       length--;
       return temp;
    }

    public Node get(int index) {
       if (index < 0 || index >= length) return null;

       Node temp = head;
       if (index < length / 2) {
          for (int i = 0; i < index; i++) {
              temp = temp.next;
          }
       } else {
           temp = tail;
           for (int i = length - 1; i > index; i--) {
               temp = temp.prev;
           }
       }
       return temp;
    }

    public boolean set(int index, int value) {
       Node temp = get(index);
       if (temp != null) {
           temp.value = value;
           return true;
       }
       return false;
    }

    public boolean insert(int index, int value) {
       if (index < 0 || index > length) return false;
       if (index == 0) {
           prepend(value);
           return true;
       }
       if (index == length) {
           append(value);
           return true;
       }

       Node newNode = new Node(value);
       Node pre = get(index - 1);
       Node suc = pre.next;
       newNode.prev = pre;
       newNode.next = suc;
       pre.next = newNode;
       suc.prev = newNode;

       length++;
       return true;
    }

    public Node remove(int index) {
       if (index < 0 || index >=length) return null;
       if (index == 0) return removeFirst();
       if (index == (length - 1)) return removeLast();

       Node temp = get(index);
       temp.prev.next = temp.next;
       temp.next.prev = temp.prev;
       temp.prev = null;
       temp.next = null;

       length--;
       return temp;
    }
}
