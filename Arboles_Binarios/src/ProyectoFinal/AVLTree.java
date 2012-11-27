package ProyectoFinal;
public class AVLTree extends SearchBinaryTree{
    public AVLTree() {
        super();
    }

    public void rotLeft(Node node){
        Node parent, grand, son;
        parent = node.getParent();
        grand = parent.getParent();
        if(grand == null){   // Si el abuelo es la raiz
            this.root = (Node)parent.getRigth();
            this.root.setParent(null);
        }else{
            if(parent == grand.getLeft()){   
                son = (Node)parent.getRigth();
                grand.setLeft(son);
                if(son!=null)
                    son.setParent(grand);
            }else{
                son = (Node)parent.getRigth();
                grand.setRigth(son);
                if(son!=null)
                    son.setParent(grand);
            }
        }
        son = (Node)node.getLeft();
        parent.setRigth(son);
        if(son!=null)
            son.setParent(parent);
        node.setLeft(parent);
        parent.setParent(node);
    }

    public void rotRight(Node node){
        Node parent, grand, son;
        parent = node.getParent();
        grand = parent.getParent();
        if(grand == null){
            this.root = (Node)parent.getLeft();
            this.root.setParent(null);
        }else{
            if(parent == grand.getRigth()){
                son = (Node)parent.getLeft();
                grand.setRigth(son);
                if(son!=null)
                    son.setParent(grand);
            }else{
                son = (Node)parent.getLeft();
                grand.setLeft(son);
                if(son!=null)
                    son.setParent(grand);
            }
        }

        son = (Node)node.getRigth();
        parent.setLeft(son);
        if(son!=null)
            son.setParent(parent);
        node.setRigth(parent);
        parent.setParent(node);
    }

    @Override
    public void insert(Object info) throws Exception{
        super.insert(info);
        this.update();
    }

    private void update(){
        Node node = getSeek(), parent = (Node)node.getParent();
        
        while(parent != null){ // Mientras no llegue a la raiz
            // Modificacion del factor de balanceo
            if(node == parent.getLeft()){
                parent.setFactor(parent.getFactor() + 1);
            }else{
                parent.setFactor(parent.getFactor() - 1);
            }
            // Deteccion del desbalanceo
            if(Math.abs(parent.getFactor())==2){
                this.balancear(parent, node);
                break;
            }
            node = parent;
            parent = (Node)node.getParent();
        }
    }
    
    private void balancear(Node desv_node, Node desv_son){
        Node node = null;
        if(desv_node.getFactor() == 2 && desv_son.getFactor() == 1){
            rotRight(desv_son);
            desv_son.setFactor(0);
        }
        if(desv_node.getFactor() == 2 && desv_son.getFactor() == -1){
            node = (Node)desv_son.getRigth();
            rotLeft(node);
            rotRight(node);
            desv_son.setFactor(0);
            node.setFactor(0);
         }
        if(desv_node.getFactor() == -2 && desv_son.getFactor() == -1){
            rotLeft(desv_son);
            desv_son.setFactor(0);
        }
        if(desv_node.getFactor() == -2 && desv_son.getFactor() == 1){
            node = (Node)desv_son.getLeft();
            rotRight(node);
            rotLeft(node);
            desv_son.setFactor(0);
            node.setFactor(0);
         }
        
        desv_node.setFactor(0);        
    }
    
    private void calculateFactor(Node node){
        if(node != null){
            node.setFactor(getHigh((Node)node.getLeft()) - getHigh((Node)node.getRigth()));
        }
    }

    private int getHigh(Node node){
        if(node==null){
            return 0;
        }else{
            return Math.max(getHigh((Node)node.getLeft()), getHigh((Node)node.getRigth())) + 1;
        }
    }

}
