package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void validateDuplicate(List<Integer> winNum){
        Set<Integer> removeDuplicate = new HashSet<>(winNum);
        if(winNum.size() != removeDuplicate.size()){
            throw new IllegalArgumentException();
        }
    }

    public void printLotto(){
        System.out.println(numbers);
    }

    public boolean isExistNumber(int number){
        return numbers.contains(number);
    }

    public int countExistNumber(Lotto l){
        int count = 0;
        for(int i=0;i<5;i++){
            if(numbers.contains(l.numbers.get(i))){
                count++;
            }
        }
        return count;
    }
}
