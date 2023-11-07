package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;
    private MatchNumber matchType;
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        Set<Integer> uniqueNumber = new HashSet<>(numbers);
        if(uniqueNumber.size() != numbers.size()){
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

        if(cnt == 6){
            cnt++;
        }
        matchType = MatchNumber.getMatchNumber(cnt);

        if(numbers.contains(bonusNumber) && cnt == 5){
            matchType = MatchNumber.getMatchNumber(6);
        }

        return cnt;
    }
}
