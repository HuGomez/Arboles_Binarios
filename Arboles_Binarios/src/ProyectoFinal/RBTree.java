package ProyectoFinal;

public class RBTree<K extends Comparable<K>,V> {
    public static final byte RED = 0;
    public static final byte BLACK = 1;

    public static class Nodo<K extends Comparable<K>,V> {
        Nodo left, right;
        Nodo p;
        byte color;
        K key;
        V val;
    }
    
    Nodo<K,V> nil;
    Nodo<K,V> root;
    
    public RBTree() {
        nil = new Nodo<K,V>();
        nil.color = RBTree.BLACK;
        root = nil;
    }
    
    Nodo<K,V> find(K key) {
        Nodo<K,V> x = this.root;
        while (x!=this.nil && x.key.compareTo(key)!=0) {
            if (key.compareTo(x.key) < 0) x = x.left;
            else x = x.right;
        }
        return x;
    }
    
    void LeftRotate(Nodo<K,V> x) {
        Nodo<K,V> y = x.right;
        x.right = y.left;
        if (y.left != this.nil)
            y.left.p = x;
        y.p = x.p;
        if (x.p == this.nil)
            this.root = y;
        else if (x == x.p.left)
            x.p.left = y;
        else
            x.p.right = y;
        y.left = x;
        x.p = y;
    }
    
    void RightRotate(Nodo<K,V> x) {
        Nodo<K,V> y = x.left;
        x.left = y.right;
        if (y.right != this.nil)
            y.right.p = x;
        y.p = x.p;
        if (x.p == this.nil)
            this.root = y;
        else if (x == x.p.right)
            x.p.right = y;
        else
            x.p.left = y;
        y.right = x;
        x.p = y;
    }
    
    void RBInsert(Nodo<K,V> z) {
        Nodo<K,V> y = this.nil;
        Nodo<K,V> x = this.root;
        while (x != this.nil) {
            y = x;
            if (z.key.compareTo(x.key) < 0)
                x = x.left;
            else
                x = x.right;
        }
        z.p = y;
        if (y == this.nil) {
            this.root = z;
        } else if (z.key.compareTo(y.key) < 0) {
            y.left = z;
        } else {
            y.right = z;
        }
        z.left = this.nil;
        z.right = this.nil;
        z.color = RBTree.RED;
        RBInsertFixup(z);
    } 
    
    private void RBInsertFixup(Nodo<K, V> z) {
        while (z.p.color == RBTree.RED) {
            if (z.p == z.p.p.left) {
                Nodo<K,V> y = z.p.p.right;
                if (y.color == RBTree.RED) {
                    z.p.color = RBTree.BLACK; //CASO 1
                    y.color = RBTree.BLACK; //CASO 1
                    z.p.p.color = RBTree.RED; //CASO 1
                    z = z.p.p; //CASO 1
                } else if (z == z.p.right) {
                    z = z.p; //CASO 2
                    LeftRotate(z); //CASO 2
                } else {
                    z.p.color = RBTree.BLACK; //CASO 3
                    z.p.p.color = RBTree.RED; //CASO 3
                    RightRotate(z.p.p); //CASO 3
                }
            } else {
                Nodo<K,V> y = z.p.p.left;
                if (y.color == RBTree.RED) {
                    z.p.color = RBTree.BLACK; //CASO 1
                    y.color = RBTree.BLACK; //CASO 1
                    z.p.p.color = RBTree.RED; //CASO 1
                    z = z.p.p; //CASO 1
                } else if (z == z.p.left) {
                    z = z.p; //CASO 2
                    RightRotate(z); //CASO 2
                } else {
                    z.p.color = RBTree.BLACK; //CASO 3
                    z.p.p.color = RBTree.RED; //CASO 3
                    LeftRotate(z.p.p); //CASO 3
                }
            }
        }
        this.root.color = RBTree.BLACK;
    }
    
    void insert(K key, V value) {
        Nodo<K,V> x = new Nodo<K, V>();
        x.key = key; x.val = value;
        RBInsert(x);
    }
    
}
