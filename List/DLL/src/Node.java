public class Node {
    public Node prev;
    public Node next;
    public int value;

    public Node(){
        prev = next = null;
        value = 0;
    }
    public Node(int v){
        prev = next = null;
        this.value = v;
    }

}
