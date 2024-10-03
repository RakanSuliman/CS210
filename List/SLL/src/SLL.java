public class SLL {
    public Node head;
    public int size;
    public SLL() {
        head = null;
        size = 0;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public Node search(int key) {
        Node current = head;
        while (current != null) {
            if(current.value == key) {

                return current;
            }
            current = current.next;
        }
        return null;

    }

    public void insert(int key) {
        // First Case: If the head is NULL
        if(head == null) {
            head = new Node(key,null);
            size++;
            return;
        }
//    Second Case: If the head is not NULL
        if(head != null) {
            Node temp = new Node();
            temp.value = key;
            temp.next = head;
            head = temp;
            size++;
            return;
        }
    }
    public void insert(int key, int position) {
//       Third Case: From the middle
        Node iter = head;
        while (iter != null) {
            if(iter.next.value == key) {
                Node temp = new Node(key,iter.next);
                iter.next = temp;
                size++;
                return;
            }
            iter = iter.next;
        }

    }
    public boolean remove(int key) {
        if (head == null) {
            return false;
        }
        if(head.value == key) {
            head = head.next;
            size--;
            return true;
        }
        Node prev = head;
        Node temp = head.next;
        while (temp != null) {
            if(temp.value == key) {
                prev.next = temp.next;
                size--;
                return true;
            }
            prev = temp;
            temp = temp.next;
        }
        return false;
    }
    public String toString() {
        String s = "";
        Node temp = head;
        while (temp != null) {
            s += temp.value + " ";
            temp = temp.next;
        }
        return s;
    }
    public String toDOT() {
        StringBuilder dot = new StringBuilder("digraph LinkedList {\n");
        Node current = head;
        while (current != null) {
            dot.append("    ").append(current.hashCode()).append(" [label=\"").append(current.value).append("\"];\n");
            if (current.next != null) {
                dot.append("    ").append(current.hashCode()).append(" -> ").append(current.next.hashCode()).append(";\n");
            }
            current = current.next;
        }
        dot.append("}");
        return dot.toString();
    }

}
