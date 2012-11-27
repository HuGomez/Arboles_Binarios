package ProyectoFinal;

class minHeap {
    SearchBinaryTree tree = new SearchBinaryTree();
    int[] datos;
    int size;
    public minHeap(int maxSize){
        this.datos = new int[maxSize];
        this.size = 0;
    }

    void heapU(int i){
        int p=0;
        while(i>0){
            p = (i-1)/2;
            if(datos[p] <= datos[i]) break;
            int tmp = datos[p]; //
            datos[p] = datos[i];// Swap
            datos[i] = tmp;     //
            i = p;
            //heapd(i);
        }
    }
    void insert (int x){
        datos[size++] = x;
        heapU(size-1);
    }
    void heapd(int i){
        int l = 2*(i+1), r = 2*(i+2);
        if(l >= size) return;
        if(datos[i] > datos[l]){
            int tmp = datos[i]; //
            datos[i] = datos[l];// Swap
            datos[l] = tmp;     //
            return;
        }
        if(datos[l] < datos[r]){
            if(datos[i] > datos[l]){
                int tmp = datos[i]; //
                datos[i] = datos[l];// Swap
                datos[l] = tmp;     //
                heapd(l);
            }
        }else{
            if(datos[r] > datos[i]){
                int tmp = datos[r]; //
                datos[r] = datos[i];// Swap
                datos[i] = tmp;     //
                heapd(r);
            }
        }
    }

    public int pop(){
        int x = datos[0];
        datos[0] = datos[--size];
        heapd(0);
        return x;
    }


}

