public class CLL {
    public Node Head;
    public Node Tail;
    public int size;

    public CLL() {
        Head = Tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Node search(int key) {
        if (isEmpty()) {
            return null;
        }
        Node Cursor = Head;
        while (Cursor != null) {
            if (Cursor.value == key) {
                return Cursor;
            }
            Cursor = Cursor.next;
        }
        return null;
    }

    public void insert(int key) {
        Node N = new Node(key);
        // From the beginning
        if (isEmpty()) {
            Head = Tail = N;
            Head.next = Head.prev = Head;
            size++;
            return;
        }
        // END
        N.prev = Tail;
        N.next = Head;
        Tail.next = N;
        Head.prev = N;
        size++;
    }

    public void insert(int key, int pos) {
        if (pos == 0) {
            insert(key);
            return;
        }
        Node newNode = new Node(key);
        Node iter = Head;
        for (int i = 1; i < pos && iter.next != Head; i++) {
            iter = iter.next;
        }
        newNode.next = iter.next;
        newNode.prev = iter;
        iter.next.prev = newNode;
        iter.next = newNode;

        if (iter == Tail) {
            Tail = newNode;
        }
        size++;
    }

    public boolean remove(int key) {
        if (isEmpty()) {
            return false;
        }
        Node temp = Head;
        do {
            if (temp.value == key) {
                if (temp == Head) {
                    if (Head == Tail) { // Only one element in the list
                        Head = Tail = null;
                    } else {
                        Head = Head.next;
                        Tail.next = Head;
                        Head.prev = Tail;
                    }
                } else if (temp == Tail) {
                    Tail = Tail.prev;
                    Tail.next = Head;
                    Head.prev = Tail;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                size--;
                return true;
            }
            temp = temp.next;
        } while (temp != Head);

        return false;
    }


    public String toString()
    {
        String str = "";
        Node temp = Head;
        while(temp!=null)
        {
            str = str + "[" + temp.value + "]";
            temp = temp.next;
        }
        return str;
    }
}



