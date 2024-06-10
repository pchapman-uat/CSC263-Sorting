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
    }
}