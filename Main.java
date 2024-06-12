public class Main {
    private static Integer[] selectionSort(Integer... numbers){
        int len = numbers.length;

        for(int i=0; i<len-1;i++){
            int minIndex = i;
            for(int j=i+1;j<len;j++){
                if(numbers[j]<numbers[minIndex]) minIndex = j;
            }

            int tmp = numbers[minIndex];
            numbers[minIndex] = numbers[i];
            numbers[i] = tmp;
        }

        return numbers;
    }

    private static Integer[] insertionSort(Integer... numbers){

        for (int i = 0; i < numbers.length; i++) {
            int key = numbers[i];
            int j = i-1;
            
            while(j>=0 && numbers[j]> key){
                numbers[j+1] = numbers[j];
                j -= 1;
            }
            numbers[j+1] = key;
        }

        return numbers;
    }

    private static int[] mergeSort(Integer left, Integer right, int... numbers){
        if(left == null) left = 0;
        if(right == null) right = numbers.length -1;
        if(left<right) {
            int middle = (left+right)/2;
            mergeSort(left, middle, numbers);
            mergeSort(middle+1, right, numbers);

            merge(left, middle, right, numbers);
        }
        return numbers;
    }

    private static int[] merge(int left, int middle, int right, int... numbers){
        int n1 = middle - left + 1;
        int n2 = right - middle;
        int[] L = new int[n1];
        int[] R = new int[n2];
        
        System.arraycopy(numbers, left, L, 0, n1);
        System.arraycopy(numbers, middle+1, R, 0, n2);

        int i=0, j=0, k=left;
        while(i<n1 && j<n2){
            if(L[i] <= R[j]){
                numbers[k] = L[i];
                i++;
            } else {
                numbers[k] = R[j];
                j++;
            } k++;
        }
        while(i<n1){
            numbers[k] = L[i];
            i++;
            k++;
        }
        while (j<n2) {
            numbers[k] = R[j];
            j++;
            k++;
        }
        return numbers;
    }

    private static Integer[] quickSort(Integer low, Integer high, Integer... numbers){
        if(low==null)low = 0;
        if(high==null) high=numbers.length-1;

        if(low<high){
            int pi = partiton(numbers, low, high);
            quickSort(low, pi-1, numbers);
            quickSort(low+1, high, numbers);
        }
        return numbers;
    }

    private static int partiton(Integer[] numbers, int low, int high){
        int pivot = numbers[high];
        int i = (low -1);
        for (int j = low; j <high; j++) {
            if(numbers[j]<=pivot){
                i++;
                int tmp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = tmp;
            }
        }
        int tmp = numbers[i+1];
        numbers[i+1] = numbers[high];
        numbers[high] = tmp;
        return i+1;
    }
    public static void main(String[] args) {
        Integer[] numbers = selectionSort(5,6,7,1,3,76,7,52);
        for (Integer integer : numbers) {
            System.out.println(integer);
        }
        System.out.println("Insertion Sort");
        Integer[] numbers2 = insertionSort(5,424,5,15,12,66,24,42,4,1);
        for (Integer integer : numbers2) {
            System.out.println(integer);
        }

        System.out.println("Merge Sort");
        int[] numbers3 = mergeSort(null, null, 55,55,41,24,3,441,22,45,66,6,2,33,1,2);
        for(Integer integer : numbers3){
            System.out.println(integer);
        }

        System.out.println("Smart Sort");
        Integer[] numbers4 = quickSort(null, null, 5,6,5,2,3,4,5,6,1,1,23,53,26,2);
        for (Integer integer : numbers4) {
            System.out.println(integer);   
        }
    }
}