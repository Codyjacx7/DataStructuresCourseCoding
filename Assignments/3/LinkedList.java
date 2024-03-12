class Node<T>{
    private T value;
    private Node<T> next;
    public Node(T v, Node<T> n){
        value = v;
        next = n;
    }
    public T getValue(){return value;}
    public Node<T> getNext(){return next;}
    public void setValue(T v){value = v;}
    public void setNext(Node<T> n){next =n;}
}

public class LinkedList<T>{
    private Node<T> head;	// head of the list always at the front
    private Node<T> cursor;	// cursor that moves along the one way list

    // constructor
    public LinkedList ()
	{
	    // the first node is not used, dummy node 
	    // so we're always dealing with the element to the right of 
	    // the cursor not what the cursor is pointing to.
	    head = new Node<T>(null, null);
	    cursor = head;
	}

    // if the cursor's next is null, then we're at the end
    public boolean isAtEnd()
    {

	return(cursor.getNext() == null);

    }

    // move the cursor to the beginning of the list
    public void reset()
    {
	cursor = head;

    }

    // advance the cursor one spot to the right
    public void advance()
    {

	cursor = cursor.getNext();
    }

    // return the node to the right of the cursor
    public Node<T> getCurrent()
    {

	return cursor.getNext();

    }

    // return the first node in the list
    public Node<T> getFirst()
    {

	return head.getNext();

    }

    
    // insert at the beginning of the list, this insert is done to the 
    // right of the dummy node, but to the left of the first meaningful
    // node.
    public void listHeadInsert(T value)
    {
	head.setNext(new Node<T>(value, head.getNext()));
	
    }

    // wherever the cursor is, insert to the right of it, and move the
    // cursor to point to the newly inserted node
    // you may remove the line that advances the cursor, but you need
    // to make sure that you advance the cursor when inserting elements
    // at the end of the list one after another.
    public void listInsert(T value)
    {
	// insert to the right of the cursor
	cursor.setNext(new Node<T>(value, cursor.getNext()));

	cursor = cursor.getNext();
	
    }


    // move the cursor to the head of the list, and keep moving it
    // looking for the value, stop if you either find the value
    // or you have reached the end of the list without finding it.
    // return the node that contains the given value back to me.
    // this return will return null if the value is not found.
    public Node<T> listSearch(T value)
    {
	cursor = head;
	while(cursor.getNext() != null && !cursor.getNext().getValue().equals(value))
	    cursor = cursor.getNext();

	return cursor.getNext();

    }


    // first search (first 4 lines of the code)
    // if you find it (not null) then just remove it by making the
    // cursor's next pointer point to the node next to it's next 
    // pointer (skip a node)
    public void listRemove(T value)
    {
	cursor = head;
	while(cursor.getNext() != null && 
	      !cursor.getNext().getValue().equals(value))
	    cursor = cursor.getNext();

	if(cursor.getNext() != null)
	    {
		cursor.setNext(cursor.getNext().getNext());

	    }

    }

    // don't search, just remove the node to the right of the cursor 
    // if it's not null.
    public void listRemoveCurrent()
    {

	if(cursor.getNext() != null)
	    {
		cursor.setNext(cursor.getNext().getNext());

	    }

    }

    public void addList(LinkedList<T> l2){
        for(l2.reset(); !l2.isAtEnd(); l2.advance()){
            T value = l2.getCurrent().getValue();
            if(listSearch(value) == null){
                listInsert(value);
            }
        }
        
    }
    public void subtractList(LinkedList<T> l2){
        for(l2.reset(); !l2.isAtEnd(); l2.advance()){
            T value = l2.getCurrent().getValue();
            if(listSearch(value) == value){
                listRemove(value);
            }
        }
    }
    public void reverseList(){
        Node<T> reverse = null;
        Node<T> present = head;
        Node<T> newNext = null;
        while(present != null){
            newNext = present.getNext();
            present.setNext(reverse);
            reverse = present;
            present = newNext;
        }
        head = reverse;
    }
}