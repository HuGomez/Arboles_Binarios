package ProyectoFinal;

/**
 * Estructura de datos árbol binario de búsqueda
 * @author isok
 */
public class SearchBinaryTree extends BinaryTree {

    public SearchBinaryTree() {
        super();
    }

    /**
     * @param info: referencia a la información del nodo
     * @throws Exception
     */
    public void insert(Object info) throws Exception {
        if( this.empty() )
            this.setRoot(info);
        else
            this.insert(root, info);
    }

    private void insert(Node subtree, Object info) throws Exception {
        
        if(subtree != null)
        {
            if( ((Comparable)info).compareTo(subtree.getInfo()) < 0 )
            {
                if(subtree.getLeft() == null)
                    insertLeft(subtree, info);
                else
                    insert((Node) subtree.getLeft(), info);
            }
            else if( ((Comparable)info).compareTo(subtree.getInfo()) > 0 || ((Comparable)info).compareTo(subtree.getInfo()) == 0)
            {
                if(subtree.getRigth() == null)
                    insertRigth(subtree, info);
                else
                    insert((Node)subtree.getRigth(), info);
            }
        }
    }

    @Override
    public Node search(Object info) {
        return search(this.root,  info);
    }

    public Node search(Node subtree, Object info) {
        if(subtree != null){
           if(((Comparable)(subtree.getInfo())).compareTo(info)==0){
               this.seek = subtree;
               return this.seek;
           }else{
              if(((Comparable)(subtree.getInfo())).compareTo(info)<0){
                   return search((Node)subtree.getRigth(), info);
              }else{
                   return search((Node)subtree.getLeft(), info);
              }
           }
        }
        return null;
    }

    private Node maxleft(Node node){
        Node tmp = (Node)node.getLeft();
        if(tmp != null){
            while(tmp.getRigth() != null){
                tmp = (Node)tmp.getRigth();
            }
        }
        return tmp;
    }

    private Node minusRight(Node node){
        Node tmp = (Node)node.getRigth();
        if(tmp != null){
            while(tmp.getLeft() != null){
                tmp = (Node)tmp.getLeft();
            }
        }
        return tmp;
    }

    public void delete(Object info){
        Node node = this.search(info);
        Node tmp = null;
        if(node != null){
            tmp = this.maxleft(node);
            if(tmp != null && tmp != node.getLeft()){
                tmp.swap(node);
                if(tmp.getLeft() != null)
                    ((Node)tmp.getLeft()).setParent(node.getParent());
                tmp.getParent().setRigth((Node)tmp.getLeft());
                return;
            }
            if(tmp != null && tmp == node.getLeft()){
                tmp.swap(node);
                node.setLeft((Node)tmp.getLeft());                
                return;
            }
            tmp = this.minusRight(node);
            if(tmp != null && tmp != node.getRigth()){                
                tmp.swap(node);
                if(tmp.getRigth()!=null)
                    ((Node)tmp.getRigth()).setParent(node.getParent());
                tmp.getParent().setLeft((Node)tmp.getRigth());
                return;
            }
            if(tmp != null && tmp == node.getRigth()){
                tmp.swap(node);
                node.setRigth((Node)tmp.getRigth());                
                return;
            }
            if(this.isRoot(node)){
                this.setRoot(null);
            }else{
                this.delLeaf(node);
            }
        }
    }// End of delete method

    
}// End of class SearchBinaryTree