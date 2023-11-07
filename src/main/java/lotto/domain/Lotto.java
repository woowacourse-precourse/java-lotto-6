package lotto.domain;

import lotto.controller.MessageManager;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        validate();
    }

    public void validate() {
        checkLottoSize();
        checkNumberRange();
        checkDuplicateNumber();
    }

    private void checkLottoSize(){
        if (numbers.size() != 6) {
            System.out.println(MessageManager.ERROR_IS_NOT_CORRECT_SIZE);
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicateNumber(){
        Set<Integer> numSet = new HashSet<>(numbers);
        if(numSet.size()!= numbers.size()) {
            System.out.println(MessageManager.ERROR_IS_ALREADY_CONTAIN);
            throw new IllegalArgumentException();
        }
    }
    private void checkNumberRange(){
        for(int i=0; i<numbers.size(); i++){
            if(numbers.get(i) < MessageManager.LOTTO_MIN || numbers.get(i) > MessageManager.LOTTO_MAX){
                System.out.println(MessageManager.ERROR_OUT_OF_RANGE);
                throw new IllegalArgumentException();
            }
        }
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
}
