package ProyectoFinal;

public class BinaryTree{
    protected Node root;        // Raiz del arbol
    protected Node seek;        // Localizador

    public BinaryTree(){
        this.root = null;
        this.seek = null;
    }

    /** Crea el nodo raiz con el objeto enviado
    * pre: se presume que el arbol debe estar vacio
    */
    public Node setRoot(Object info)
    {
        if(this.empty()){
            this.root = new Node(info);
            this.seek = this.root;
        }
        return this.root;
    }

    /**
     *  Inserta a la izquierda del nodo apuntado por seek
     */
    public void insertLeft(Object info){
        insertLeft(this.seek, info);
    }

    protected void insertLeft(Node subtree, Object info) {
        Node tmp;
        if(subtree!=null){
            tmp = new Node(info);
            subtree.setLeft(tmp);
            this.seek = tmp;
        }
    }

    /**
     *  Inserta a la derecha del nodo apuntado por seek
     */
    public void insertRigth(Object info) 
    {
        insertRigth(this.seek, info);
    }

    protected void insertRigth(Node subtree, Object info) {
        Node tmp;
        if(subtree!=null){
            tmp = new Node(info);
            subtree.setRigth(tmp);
            this.seek = tmp;
        }
    }

    /**
     *  Recorre el arbol en preorden es decir: raiz - subarbol izq - subarbol der
     *  A partir del nodo raiz
     */
    public void preorder()
    {
        if(this.root!=null){
            preorder(this.root);
        }
    }

    /**
     *   Recorre el subarbol en preorden es decir: raiz - subarbol izq - subarbol der
     *   A partir del nodo entregado.
     */
    public void preorder(Node node)
    {
        if(node != null){
            System.out.println(node);
            preorder((Node)node.getLeft());
            preorder((Node)node.getRigth());
        }
    }

    /**
     * Recorre el arbol en inorden es decir: subarbol izq - raiz - subarbol der
     * A partir del nodo raiz.
     */
    public void inorder()
    {
        if(this.root!=null){
            this.inorder(this.root);
        }
    }

    /**
     *  Recorre el arbol en inorden es decir: subarbol izq - raiz - subarbol der
     *  A partir del nodo entregado.
     */
    public void inorder(Node node)
    {
        if(node!=null){
            inorder((Node)node.getLeft());
            System.out.println(node);
            inorder((Node)node.getRigth());
        }
    }

    /**
     *  Recorre el arbol en posorden es decir: subarbol izq - subarbol der - raiz
     *  A partir del nodo raiz.
     */
    public void postorder()
    {
        if(this.root!=null){
            this.postorder(this.root);
        }
    }

    /**
     * Recorre el arbol en posorden es decir: subarbol izq - subarbol der - raiz
     *   A partir del nodo recibido
     * @param node
     */
    public void postorder(Node node)
    {
        if(node!=null){
            postorder((Node)node.getLeft());            
            postorder((Node)node.getRigth());
            System.out.println(node);
        }
    }

    /**
     * Pregunta si el arbol esta vacio
     * pre: se espera que la raiz tenga el valor valido null
     * @return boolean - verdadero si la raiz es null
     */
    protected boolean empty()
    {
        return root == null;
    }

    /**
     *  Devuelve el nodo al cual esta apuntando la referencia seek
     *  @return
     */
    public Node getSeek()
    {
        return seek;
    }

    /**
     * Busca la informacion en todo el arbol, deja el seek referenciando al nodo
     *   encontrado.
     * @param info  - referencia al bloque de informacion
     * @return Object - referencia al bloque de información encontrado o a null
     */
    public Node search(Object info)
    {
        Node find = null;
        Node tmp = this.seek;
        find = search(this.root, new Node(info));
        if(find==null){
           this.seek = tmp;
        }
        return find;
    }

    /**
     * Busca la informacion a partir del subarbol entregado
     * @param subtree
     * @param node
     * @return
     */
    public Node search(Node subtree, Node node)
    {
        Node find = null;
        if(subtree != null){
            if(node.compareTo(subtree) == 0){
                find = subtree;
                this.seek = subtree;
            }else{
                find = search((Node)subtree.getLeft(), node);
                find = (find == null)?search((Node)subtree.getRigth(), node):find;
            }
        }
        return find;
    }

    /**
     * Confirma si el nodo entregado es la raiz
     * @param node - nodo del cual se desea saber si es la raiz
     * @return
     */
    protected boolean isRoot(Node node){
        return node == this.root;
    }

    /**
     * Elimina un nodo hoja
     * @param node - nodo a ser eliminado
     */
    protected void delLeaf(Node node){
        Node parent = null;
        if(this.isRoot(node)){
            this.setRoot(null);
        }else{
            parent = (Node)node.getParent();
            if(parent.getLeft()==node){
                parent.setLeft(null);
            }else{
                parent.setRigth(null);
            }
        }
    }

    /*public void insert(Object info){

        if(this.root==null){
            setRoot(info);
        }
        else if(seek.getLeft()==null){
           insertLeft(info);
        }
        else if(seek.getRigth()==null){
          insertRigth(info);
        }
    }*/
}
