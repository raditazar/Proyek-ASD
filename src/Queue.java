public class Queue <Object>{
    Node <Object> front;
    Node <Object> rear;
    int size;
    class Node<Object>{
        Node<Object> next;
        int priority;
        Object value;

        public Node(int priority, Object value){
            this.priority = priority;
            this.value = value;
        }
    }

    boolean isEmpty(){
        return size==0;
    }

    void enqueue(int priority, Object value){
        Node<Object> newNode = new Node<Object>(priority, value);
        if(isEmpty()){
            front = rear = newNode;
            size++;
            return;
        }
        if(size == 1){
            if(front.priority > priority){
                newNode.next = front;
                front = newNode;
                size++;
            }else{
                rear.next = newNode;
                rear = newNode;
            }
        }
        Node<Object> temp = front;
        while(temp != rear){
            if(temp.priority >= priority){
                Node<Object> current = temp.next;
                temp.next = newNode;
                newNode.next = current;
                size++;
                return;
            }
            else{
                temp = temp.next;
            }
        }
        rear.next = newNode;
        rear = newNode;
        size++;
    }

    Object dequeue(){
        if(isEmpty()){
            return null;
        }if(size==1){
            front = rear = null;
            size--;
            return  front.value;
        }
        Object data = front.value;
        front = front.next;
        size--;
        return data;
    }

    Object peek(){
        if(isEmpty()){
            return null;
        }
        return front.value;
    }
}


