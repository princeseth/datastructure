class Node {
    int key, height;
    Node left, right;
 
    Node(int d) {
        key = d;
        height = 1;
    }
}

class AVL{
    public Node insertToAVL(Node node,int data)
    { 
        if(node == null){
        return (new Node(data));
        }
        
        if(node.data>data){
        node.left = insertToAVL(node.left,data);
        }
        else if(node.data<data){
        node.right = insertToAVL(node.right,data);
        }
        else
        return node;
        
        node.height = 1 + max(heightOf(node.left), heightOf(node.right));
        
        int balance = getBalance(node);
        
        if(balance<-1 && node.right.data > data ){
        node = rotateRight(node.right);
        rotateLeft(node);
        }
        else if(balance<-1 && node.right.data < data ){
        rotateLeft(node);
        }
        else if(balance>1 && node.left.data > data ){
        rotateRight(node);
        }
        else if(balance>1 && node.left.data < data ){
        node = rotateLeft(node.left);
        rotateRight(node);
        }
        return node;
        }
        
        int heightOf(Node node){
        return node.height;
        }
        
        int max(int leftHeight, int rightHeight){
        return (leftHeight>rightHeight)?leftHeight:rightHeight;
        }
        
        int getBalance(Node node){
        return (heightOf(node.left) - heightOf(node.right));
        }
        
        Node rotateLeft(Node node){
        Node y = node.right;
        Node t2 = y.left;
        
        y.left=node;
        node.right=t2;
        
        node.height = max(heightOf(node.right),heightOf(node.left)+1);
        y.height = max(heightOf(y.right),heightOf(y.left)+1);
        
        return node;
        }
        
        Node rotateRight(Node node){
        Node x = node.left;
        Node t2 = x.right;
        
        x.right = node;
        node.left= t2;
        
        node.height = max(heightOf(node.right),heightOf(node.left)+1);
        x.height = max(heightOf(x.right),heightOf(x.left)+1);
        
        return node;
        }
    
}

public static void main(String[] args) {
      Avl avl = new Avl();
      avl.root = avl.insert(avl.root, 50);
        avl.root = avl.insert(avl.root, 60);
        avl.root = avl.insert(avl.root, 70);
        avl.root = avl.insert(avl.root, 80);
        avl.root = avl.insert(avl.root, 90);
        avl.root = avl.insert(avl.root, 65);

}
