public class Node {
    private static int value;
    private static Node next;
    public Node(int value, Node next){
        int v = value;
        Node n = next;
    }
    public int getvalue(){return value;}
    public Node getnext(){return next;}
    public void setvalue(int v){value = v;}
    public void setnext(Node n){next = n;}

    public void main(String[] args) {
        Node dummy = new Node(value, next);
        //dummy.setvalue(0); //Not needed, deafault value is 0
        //dummy.setnext(null); //Not needed, deafault is null
        Node h = dummy;
        Node c = h;
        System.out.println("Cursor is pointing to dummy node with value: " + c.getvalue());
        System.out.println("Cursor is pinting to: " + c.getnext());
        Node node1 = new Node(value, next);
        node1.setvalue(23);
        c.setnext(node1);
        System.out.println(c.getvalue());

        //I want to make 10 nodes after node1 that contain values 1-10 and print each value
        for(int i = 0; i<=10; i++){
            Node temp = new Node(value, next);
            c.setnext(temp);
            c.setvalue(i);
            System.out.println(c.getvalue());

        //I want to print the summ of all the elements in the linked list
        need a method.....
        c = h;
        if(c == null){
            return 0;
        }
            
        }
        }
    }
}
