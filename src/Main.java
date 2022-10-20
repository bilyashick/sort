class main {
    public static void main(String[] args) {

        int [] a = createArray(6);
        System.out.print("1st array: ");
        displayArray(a);
        System.out.println();

        int [] b = createArray(4);
        System.out.print("2nd array: ");
        displayArray(b);
        System.out.println();

        int [] c = mergeArrays(a,b);
        System.out.print("combiantion: ");
        displayArray(c);
        System.out.println();

        int [] d = new int[10];
        for (int i=0; i<d.length; i++){
            d [i] = c[i];
        }


        System.out.print("3rd array sorted by bubble: ");
        Bubble(c);
        displayArray(c);
        System.out.println();

        System.out.print("3rd array sorted by quicksort: ");
        quickSort(d,0,9);
        displayArray(d);
        System.out.println();

    }
    public static int [] createArray (int length) {
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 15);
        }
        return array;
    }
    public static int [] displayArray (int [] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            System.out.print(" ");
        }
        return array;
    }
    public static int [] mergeArrays (int [] arr1, int [] arr2){
        int [] arr3 =  new int[arr1.length+arr2.length];
        for (int i=0; i<arr1.length; i++){
            arr3[i]=arr1[i];
        }
        for (int i=0; i<arr2.length; i++) {
            arr3[i + arr1.length] = arr2[i];
        }
        return arr3;
    }
    public static void  Bubble (int [] array ){
        for (int i = 0; i < array.length; i++){
            int min = array[i];
            int min_i = i;
            for ( int j = i + 1 ; j < array.length; j++){
                if (array[j] < min){
                    min = array[j];
                    min_i = j;
                }
            }
            if(i != min_i){
                int tmp = array[i];
                array[i] = array[min_i];
                array[min_i] = tmp;
            }
        }
    }
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
}
