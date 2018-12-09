public class LinkedListDeque<T> {

    protected class LListNode<T>{
        public LListNode(T val, LListNode<T> prev, LListNode<T> next){
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
        protected T val;
        protected LListNode<T> prev;
        protected LListNode<T> next;
    }

    public LinkedListDeque(){
        size = 0;
    }

    private LListNode<T> first;
    private LListNode<T> last;
    private int size;

    private void addFirstNode(T item){
        first = new LListNode<>(item, null, null);
        last = first;
        size += 1;
    }

    public void addFirst(T item){
        if(size == 0){
            addFirstNode(item);
            return;
        }

        LListNode<T> node = new LListNode<>(item, null, first);
        first.prev = node;
        first = node;
        size += 1;
    }

    public void addLast(T item){
        if(size == 0){
            addFirstNode(item);
            return;
        }

        LListNode<T> node = new LListNode<>(item, last,  null);
        last.next = node;
        last = node;
        size += 1;

    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        if(size == 0){
            return;
        }
        LListNode<T> node = first;
        while(node != null){
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public T removeFirst(){
        if(size == 0){
            return  null;
        }

        T val = first.val;
        if(size == 1){
            size = 0;
            first = last = null;
        }
        else {
            LListNode<T> node = first.next;
            first.next = null;
            first = node;
            first.prev = null;
            size -= 1;
        }

        return val;
    }

    public T removeLast(){
        if(size == 0){
            return null;
        }

        T val = last.val;
        if(size == 1){
            size = 0;
            last = first = null;
        }
        else{
            LListNode<T> node = last.prev;
            last.prev = null;
            last = node;
            last.next = null;
            size -= 1;
        }

        return val;
    }

    public T get(int index){
        if(index >= size){
            return null;
        }
        LListNode<T> node = first;
        for(int i = 0; i < index; i += 1){
            node = node.next;
        }
        T val = node.val;
        return val;
    }

    private T getR(LListNode<T> node, int index){
        if(index == 0){
            return node.val;
        }
        return getR(node.next, index-1);
    }

    public T getRecursive(int index){
        if(index >= size) {
            return null;
        }

        return getR(first, index);

    }

}
