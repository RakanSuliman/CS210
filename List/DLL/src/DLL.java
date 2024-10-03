public class DLL {
    public Node Head;
    public Node Tail;
    public int size;
    public DLL() {
        Head = Tail = null;
        size = 0;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public Node search(int key){
        Node temp = Head;
        while (temp != null){
            if (temp.value==key){
                return temp;
            }
            temp = temp.next;
        }
        return temp;
    }
    public void insert(int key) {
        // If the list is Empty; insert in the begging
        Node N = new Node(key);
        if (isEmpty()){
            Head = Tail = N;
            size++;
            return;
        }

        // If it's not then insert also in the begging
        N.next = Head;
        Head.prev = N;
        Head = N;
        N.prev = null;
        size++;






    }
    public void insert(int key,int pos) {
        Node newNode = new Node(key);

        if (pos==0){
            // If inserting at the beginning, set newNode's next to the current Head
            newNode.next = Head;
            // If the list is not empty, update the current Head's prev pointer to newNode
            if (Head!=null){
                Head.prev = newNode;
            }
            // Update Head to the new node
            Head = newNode;
            // If Tail is null, this means the list was empty before insertion
            if (Tail==null){
                Tail = newNode;
            }
            size++;
            return;
        }
        Node iter = Head;
        for (int i = 1; i<pos && iter.next!=null; i++){
            iter = iter.next;
        }
        newNode.next = iter.next;
        newNode.prev = iter;
        if (iter.next != null){
            iter.next.prev = newNode;
        } else {
            Tail = newNode;
        }
        iter.next = newNode;
        size++;
    }


    public boolean remove(int key) {
        if (isEmpty()){ // Check if the list is empty
            return false;
        }
        Node temp = Head;
        while(temp!=null){
            if (temp.value==key){
                // if the key was found, now the next code is handling the removal
                if (temp == Head){
                    Head = Head.next;
                    if (Head!=null){
                        Head.prev = null;
                    } else {
                        Tail = null;
                    }
                }else if (temp == Tail){
                    Tail = Tail.prev;
                } if (Tail != null){
                    Tail.next = null;
                } else {
                    Head = null;
                } if(temp.next != null){
                    temp.next.prev=temp.prev;
                } if (temp.prev!=null){
                    temp.prev.next = temp.next;
                }
                size--;
                return true;
            }
            temp = temp.next;
        }
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
