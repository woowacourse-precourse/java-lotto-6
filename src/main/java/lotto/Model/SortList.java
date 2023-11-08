package lotto.Model;


import java.util.List;

public class SortList {


    public List<Integer> sortAsc(List<Integer> numbers){
        int n = numbers.size();

        for(int i=0;i<n-1;i++){
            int minIndex = findMinIndex(numbers,i,n);

            if(minIndex !=i){
                int temp = numbers.get(i);
                numbers.set(i,numbers.get(minIndex));
                numbers.set(minIndex,temp);
            }
        }
        return numbers;
    }

    private int findMinIndex(List<Integer> numbers, int startIndex, int endIndex){
        int minIndex = startIndex;

        for(int i= startIndex +1;i<endIndex;i++){
            if(numbers.get(i)<numbers.get(minIndex)){
                minIndex = i;
            }
        }

        return minIndex;
    }
}
