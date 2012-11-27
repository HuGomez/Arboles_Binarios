package ProyectoFinal;

/**
 *
 * @author isok
 */
public class Node implements Comparable
{
    private Object info;               // Objeto que contendra de informacion
    private Node left, rigth;          // Hijos izquierdo y derecho
    private Node parent;
    private int factor;

    public Node(Object xinfo)
    {
        this.info = xinfo;
        this.left = null;
        this.rigth = null;
        this.factor = 0;
    }

    public Object getInfo()
    // Obtiene el elemento que contiene la informacion
    {
        return info;
    }

    public void setInfo(Object info)
    // Establece el elemento con la informacion
    {
        this.info = info;
    }

    public Object getLeft()
    // Obtiene el hijo izquierdo del nodo actual
    {
        return left;
    }

    public void setLeft(Node left)
    // Establece el hijo izquierdo del nodo actual
    {
        this.left = left;
        if(left != null)
            left.setParent(this);
    }

    public Object getRigth()
    // Obtiene el hijo derecho del nodo actual
    {
        return rigth;
    }

    public void setRigth(Node rigth)
    // Establece el hijo derecho del nodo actual
    {
        this.rigth = rigth;
        if(rigth != null)
            rigth.setParent(this);
    }

    /**
     * @return the parent
     */
    public Node getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(Node parent) {
        this.parent = parent;
    }

    /**
     * @return the factor
     */
    public int getFactor() {
        return factor;
    }

    /**
     * @param factor the factor to set
     */
    public void setFactor(int factor) {
        this.factor = factor;
    }

    public int compareTo(Object o) {
        return ((Comparable)(this.info)).compareTo(((Node)o).getInfo());
    }

    @Override
    public String toString() {
        super.toString();
        return info.toString();
    }

    public void swap(Node node){
        Object tmp_info = node.getInfo();
        node.setInfo(this.getInfo());
        this.setInfo(tmp_info);
    }
}
