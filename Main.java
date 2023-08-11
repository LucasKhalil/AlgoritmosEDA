import java.util.Arrays;

class Main{

    public static void main(String[] args){
        int[] array = new int[] {5,4,6,3,2,1,8};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    static void bubbleSort(int[] arr) {  // Para a entrada teste: 193 execuções
        int n = arr.length;
        for(int i=0; i < n; i++){  
            for(int j=1; j < (n-i); j++){  
                if(arr[j-1] > arr[j]){  
                    swap(arr, j-1, j); 
                }                
            } 
        }
    }

    static void insertionSort(int[] arr){
        for(int i = 1; i < arr.length;i++){
            for(int j = i-1; j >=0; j--){
                if(arr[j]<arr[i]){
                    swap(arr, i, j);
                    continue;
                }
                break;
            }
        }
    }

    static void swap(int[] array,int i,int j){
        int aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }

    static int[] slice(int[] arr, int i ,int j){
        int[] sliced = new int[j-i +1];
        int idx = 0;
        for(int k = i; k<=j;k++){
            sliced[idx] = arr[k];
            idx ++;
        }
        return sliced;
    }
}