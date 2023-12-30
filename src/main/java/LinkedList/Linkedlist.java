package LinkedList;

public class Linkedlist<T> {
    Node<T> head;
    Linkedlist(){
        head=null;
    }

    public void addNode(T data){
        Node<T>newNode=new Node(data);
        if(head==null){
            head=newNode;
            return;
        }

        Node<T>temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }

        temp.next=newNode;
    }

    public void reverseLinkedList(){
        if(head==null){
            System.out.println("Linked list cant be reversed");
            return ;
        }

        Node<T>prev=null;
        Node<T>current=head;
        Node<T>next=null;

        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }

        while(prev!=null){
            System.out.println(prev.data);
            prev=prev.next;
        }

    }

    void displayLinkedList(){
        reverseLinkedList();
    }

}
