package movierecommendationsystem1;

public class MaxHeap{

    private static class Node{
        UserEntry data;
        Node left, right, parent;

        Node(UserEntry data){
            this.data = data;
        }
    }

    private Node root;
    private int size;

    // Creates an empty heap
    public MaxHeap(){
        root = null;
        size = 0;
    }

    // Returns the number of elements in the heap
    public int getSize(){
        return size;
    }

    // Checks whether the heap is empty
    public boolean isEmpty(){
        return size == 0;
    }

    // Inserts a new user into the heap
    public void insert(UserEntry entry){

        Node newNode = new Node(entry);
        size++;

        if(root == null){
            root = newNode;
            return;
        }

        Node parent = getNodeAt(size / 2);
        newNode.parent = parent;

        if(parent.left == null){
            parent.left = newNode;
        }else{
            parent.right = newNode;
        }

        bubbleUp(newNode);
    }

    // Finds the node at the given heap index
    private Node getNodeAt(int index){

        if(index <= 0){
            return root;
        }

        String path = Integer.toBinaryString(index);
        Node current = root;

        for(int i = 1; i < path.length(); i++){

            if(path.charAt(i) == '0'){
                current = current.left;
            }else{
                current = current.right;
            }
        }

        return current;
    }

    // Moves larger similarity values upward
    private void bubbleUp(Node node){

        while(node.parent != null && node.data.similarity > node.parent.data.similarity){

            UserEntry temp = node.data;
            node.data = node.parent.data;
            node.parent.data = temp;

            node = node.parent;
        }
    }

    // Removes and returns the maximum element
    public UserEntry extractMax(){

        if(root == null){
            return null;
        }

        UserEntry max = root.data;

        if(size == 1){
            root = null;
            size--;
            return max;
        }

        Node lastNode = getNodeAt(size);

        root.data = lastNode.data;

        if(lastNode.parent.right == lastNode){
            lastNode.parent.right = null;
        }else{
            lastNode.parent.left = null;
        }

        lastNode.parent = null;
        size--;

        heapifyDown(root);

        return max;
    }

    // Restores heap order from top to bottom
    private void heapifyDown(Node node){

        while(node != null){

            Node largest = node;

            if(node.left != null && node.left.data.similarity > largest.data.similarity){

                largest = node.left;
            }

            if(node.right != null && node.right.data.similarity > largest.data.similarity){

                largest = node.right;
            }

            if(largest == node){
                break;
            }

            UserEntry temp = node.data;
            node.data = largest.data;
            largest.data = temp;

            node = largest;
        }
    }

    // Returns the root element without removing it
    public UserEntry peek(){

        if(root == null){
            return null;
        }

        return root.data;
    }
}
