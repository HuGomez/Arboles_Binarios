package ProyectoFinal;

import java.io.InputStream;
import java.util.Scanner;

public class Heap2 extends BinaryTree{

    public Heap2(){
        super();
    }

    public void insert(Object info){
        if(this.root==null){
            setRoot(info);
            return;
        }
        else if(seek.getLeft()==null){
           insertLeft(info);
           return;
        }
        else if(seek.getRigth()==null){
          insertRigth(info);
          return;
        }
        seek=root;
        while(seek.getLeft()!=null){
            seek=(Node) seek.getLeft();
        }
    }

    @Override
    public void insertLeft(Object info) {
        super.insertLeft(info);
    }

    @Override
    protected void insertLeft(Node subtree, Object info) {
        subtree.setLeft(new Node(info));
    }

    @Override
    public void insertRigth(Object info) {
        super.insertRigth(info);
    }

    @Override
    protected void insertRigth(Node subtree, Object info) {
        subtree.setRigth(new Node(info));
        if(seek!=root){
            if(seek.getParent().getRigth()!=seek){
                seek=(Node) seek.getParent().getRigth();
            }else{
                seek=root;
                while(seek.getLeft()!=null){
                    seek=(Node) seek.getLeft();
                }
            }
        }
    }

    public static void main(String[] args){
        Heap2 hola = new Heap2();
        Scanner cin = new Scanner(System.in);
        int t;
        while(true){
            t=cin.nextInt();
            if(t==0)break;
            hola.insert(t);
        }
        System.out.println("Solution below or problem above :D");
        //System.out.println(hola.root);
        //System.out.println(hola.seek);
        hola.inorder();

    }
}
