package assn4;
public class MyLinkedList<E> extends MyAbstractList<E> {

    private Node<E> head, tail;

    /** Create a default list */
    public MyLinkedList() {
    }

    /** Create a list from an array of objects */
    public MyLinkedList(E[] objects) {
        super(objects);
    }

    /** Return the head element in the list */
    public E getFirst() {
       if (size == 0) {
            return null;
        } else {
            return head.element;
        }
    }

    /** Return the last element in the list */
    public E getLast() {
        if (size == 0) {
            return null;
        } else {
            return tail.element;
        }
    }

    /** Add an element to the beginning of the list */
    public void addFirst(E e) {
        Node<E> newNode = new Node<E>(e); // Create a new node
        newNode.next = head; // link the new node with the head
        head = newNode; // head points to the new node
        size++; // Increase list size

        if (tail == null) // the new node is the only node in list
        {
            tail = head;
        }

    }

    /** Add an element to the end of the list */
    public void addLast(E e) {
        Node<E> newNode = new Node<E>(e); // Create a new for element e
        if (tail == null) {
            head = tail = newNode; // The new node is the only node in list
        } else {
            tail.next = newNode; // Link the new with the last node
            tail = tail.next; // tail now points to the last node
        }
        size++; // Increase size
    }

    /** Add a new element at the specified index in this list
     * The index of the head element is 0 */
    public void add(int index, E e) {
        if (index == 0) {
            addFirst(e);
        } else if (index >= size) {
            addLast(e);
        } else {
            Node<E> current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            Node<E> temp = current.next;
            current.next = new Node<E>(e);
            (current.next).next = temp;
            size++;
        }

    }

    /** Remove the head node and
     *  return the object that is contained in the removed node. */
    public E removeFirst() {
        if (size == 0) {
            return null;
        } else {
            Node<E> temp = head;
            head = head.next;
            size--;
            if (head == null) {
                tail = null;
            }
            return temp.element;
        }
    }

    /** Remove the last node and
     * return the object that is contained in the removed node. */
    public E removeLast() {
        if (size == 0) {
            return null;
        } else if (size == 1) {
            Node<E> temp = head;
            head = tail = null;
            size = 0;
            return temp.element;
        } else {
            Node<E> current = head;
            for (int i = 0; i < size - 2; i++) {
                current = current.next;
            }
            Node<E> temp = tail;
            tail = current;
            tail.next = null;
            size--;
            return temp.element;
        }
    }

    /** Remove the element at the specified position in this list.
     *  Return the element that was removed from the list. */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        } else if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            Node<E> previous = head;
            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }
            Node<E> current = previous.next;
            previous.next = current.next;
            size--;
            return current.element;
        }
    }

    /** Override toString() to return elements in the list */
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            result.append(current.element);
            current = current.next;
            if (current != null) {
                result.append(", "); // Separate two elements with a comma
            } else {
                result.append("]"); // Insert the closing ] in the string
            }
        }
        return result.toString();
    }

    /** Clear the list */
    public void clear() {
        head = tail = null;
    }
    
    /**
     methods for lab 8 should be implemented here
     */
    //searches for whether the value is in there or not
    public boolean contains (E e){
        Node<E> temp = head;
        while(temp != null){
            if (e.equals(temp.element))
                return true;
            temp = temp.next;
        }
        return false;
    } //contains
    
    public boolean contains(E e, int[] count){
        Node<E> temp = head;
        for(int i= 0; i < size; i++){
            if(e.equals(temp.element)){
                count[0]=i+1;
                return true;
            }//if
            temp = temp.next;
        }//for
        count[0]=size;
        return false;
    }//contains
    
    //get returns the data at the index you searched
    public E get (int index){
        if (index < 0 || index >= size)
            return null;
            else{
                  Node<E> temp = head;
                    for (int i = 0; i < index; i++)
                        temp = temp.next;
                    return temp.element;
                }//else
    }//get
    
    //sets the data at the index
    public E set (int index, E e){
        if(index<0 || index >= size)
            return null;
        else {
            Node<E> temp = head;
            for (int i = 0; i < index; i++)
                temp = temp.next;
            E old = temp.element;
            temp.element = e;
            return old;
        }//else
    }//set
    
    //send an element and checking if its in there, returns the index of the first
    //appearance of whatever element youre searching for
    public int indexOf(E e){
        Node<E> temp = head;
        for (int i = 0; i < size; i++) {
            if (e.equals(temp.element))
                return i;
            temp = temp.next;
        }
        return -1; //never found
    }//index of
    
    //send an element and checking if its in there, returns the index of the last
    //appearance of whatever element youre searching for   
    public int lastIndexOf (E e){
       int tempIndex = -1;
       Node<E> temp = head;
            for (int i = 0; i < size; i++) {
                if (e.equals(temp.element))
                    tempIndex = i;
                temp = temp.next;
            } //for
            return tempIndex;
    }//last index of 
    
    
    
    
    
    private static class Node<E> {
        E element;
        Node<E> next;
        public Node(E element) {
            this.element = element;
        }
    }
}
    
    