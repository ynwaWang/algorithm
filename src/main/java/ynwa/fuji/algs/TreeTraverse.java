package ynwa.fuji.algs;

/**
 * Created by ynwa on 16/7/9.
 */
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class TreeTraverse {
    //private int[] array={ 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    private int[] array={ 10,6,14,4,8,12,16};//BinarySearchTree
    private static List<Node> nodeList=null;


    public static void main(String[] args) {
        TreeTraverse tree=new TreeTraverse();
        tree.createBinTree();
        System.out.println("递归式前序遍历");
        preOrder(nodeList.get(0));
        System.out.println();
        System.out.println("循环式前序遍历");
        preOrderStack(nodeList.get(0));
        System.out.println();

        System.out.println("递归式中序遍历");
        inOrder(nodeList.get(0));
        System.out.println();
        System.out.println("循环式中序遍历");
        inOrderStack(nodeList.get(0));
        System.out.println();

        System.out.println("递归式后序遍历");
        postOrder(nodeList.get(0));
        System.out.println();
        System.out.println("循环式后序遍历");
        postOrderStack(nodeList.get(0));
        System.out.println();


        System.out.println("层次遍历");
        levelOrderStack(nodeList.get(0));
    }


    public static void visit(Node node){
        System.out.print(node.getData()+" ");
    }

    //create binary tree from array.the data stored in level-order
    public void createBinTree(){

        nodeList=new LinkedList<Node>();
        for(int i=0,len=array.length;i<len;i++){
            nodeList.add(new Node(array[i]));
        }

        int len=array.length;
        int lastRootIndex=(len>>1)-1;
        for(int i=lastRootIndex;i>=0;i--){
            Node root=nodeList.get(i);
            int leftIndex=i*2+1;
            Node leftNode=nodeList.get(leftIndex);
            //Node leftNode=new Node(array[leftIndex]);//this is wrong
            root.setLeft(leftNode);
            //最后的那个根节点一定是有左孩子的。右孩子则不一定
            int rightIndex=leftIndex+1;
            if(rightIndex<=len-1){
                Node rightNode=nodeList.get(rightIndex);
                root.setRight(rightNode);
            }

        }
    }

    //nonRecursion perOrder Traverse
    public static void preOrderStack(Node root){

        Stack<Node> stack=new Stack<Node>();
        Node p=root;
        if(p!=null){
            stack.push(p);
            while(!stack.isEmpty()){
                p=stack.pop();
                visit(p);
                if(p.getRight()!=null)stack.push(p.getRight());
                if(p.getLeft()!=null)stack.push(p.getLeft());
            }
        }
    }
    //nonRecursion inOrder Traverse
    public static void inOrderStack(Node p){
        Stack<Node> stack=new Stack<Node>();
        while(p!=null||!stack.isEmpty()){
            //push all LeftChild,when p has no LeftChild,that means it's root,it should be visited
            while(p!=null){
                stack.push(p);
                p=p.getLeft();
            }
            if(!stack.isEmpty()){
                p=stack.pop();
                visit(p);
                p=p.getRight();
            }
        }
    }

    //nonRecursion postOrder Traverse
    public static void postOrderStack(Node p){
        Stack<Node> stack=new Stack<Node>();
        Node q=p;//q,is the latest Node that has been visited
        while(p!=null){
            while(p.getLeft()!=null){
                stack.push(p);
                p=p.getLeft();
            }
			/*
			 while(p!=null){//wrong.when 'while' ends,p=null
				stack.push(p);
				p=p.getLeft();
			}
			 */
            while(p!=null&&(p.getRight()==null||p.getRight()==q)){
                visit(p);
                q=p;
                if(stack.isEmpty())return;
                p=stack.pop();
            }
            stack.push(p);
            p=p.getRight();
        }
    }
    //level order
    public static void levelOrderStack(Node p){
        if(p==null)return;
        List<Node> queue=new LinkedList<Node>();
        queue.add(p);
        while(!queue.isEmpty()){
            Node temp=queue.remove(0);
            System.out.print(temp.data+" ");
            if(temp.left!=null){
                queue.add(temp.left);
            }
            if(temp.right!=null){
                queue.add(temp.right);
            }
        }
        System.out.println();
    }

    public static void preOrder(Node root){
        if(root==null){return;}
        System.out.print(root.getData()+" ");
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }
    public static void inOrder(Node root){
        if(root==null){return;}
        inOrder(root.getLeft());
        System.out.print(root.getData()+" ");
        inOrder(root.getRight());
    }
    public static void postOrder(Node root){
        if(root==null){return;}
        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root.getData()+" ");
    }

    private static class Node{
        private Node left;
        private Node right;
        private int data;
        Node(int iData){
            data=iData;
            left=null;
            right=null;
        }
        public void setLeft(Node leftNode){
            this.left=leftNode;
        }
        public void setRight(Node rightNode){
            this.right=rightNode;
        }
        public Node getLeft(){
            return left;
        }
        public Node getRight(){
            return right;
        }
        public int getData(){
            return data;
        }

    }

}