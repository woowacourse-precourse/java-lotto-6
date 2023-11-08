package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers,String[] errorCode) {
        validate(numbers,errorCode);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers,String[] errorCode) {
        if (numbers.size() != 6) {
            errorCode[0] = "[ERROR]번호의 개수는 6개 이어야 합니다.";
            throw new IllegalArgumentException();
        }

        Set<Integer> uniqueNumber = new HashSet<>(numbers);
        if(uniqueNumber.size() != numbers.size()){
            errorCode[0] = "[ERROR]번호는 서로 중복되지 않아야 합니다.";
            throw new IllegalArgumentException();
        }
    }

    public void printNumber(){
        System.out.println(numbers);
    }

    public Integer getElement(int i){
        return this.numbers.get(i);
    }

    public int compareNumber(Lotto catchNumbers,int bonusNumber){
        int cnt = 0;
        for(int i = 0; i < 6; i++){
            if(numbers.contains(catchNumbers.getElement(i))){
                cnt++;
            }
        }

        if(cnt == 6) cnt++;
        if(numbers.contains(bonusNumber) && cnt == 5) cnt++;

        return cnt;
    }
}
