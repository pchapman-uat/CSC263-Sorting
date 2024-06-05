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

    public static void main(String[] args) {
        Integer[] numbers = selectionSort(5,6,7,1,3,76,7,52);
        for (Integer integer : numbers) {
            System.out.println(integer);
        }
    }
}