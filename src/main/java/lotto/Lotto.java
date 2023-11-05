package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.controller.MessageManager;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Boolean validate() {
        return checkLottoSize() && checkNumberRange() && checkDuplicateNumber();
    }

    private Boolean checkLottoSize(){
        try{
            if (numbers.size() != 6) {
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException e){
            System.out.println(MessageManager.ERROR_IS_NOT_CORRECT_SIZE);
            return false;
        }
        return true;
    }

    private Boolean checkDuplicateNumber(){
        try{
            Set<Integer> numSet = new HashSet<>(numbers);
            if(numSet.size()!= numbers.size()) {
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException e){
            System.out.println(MessageManager.ERROR_IS_ALREADY_CONTAIN);
            return false;
        }
        return true;
    }
    private Boolean checkNumberRange(){
        try{
            for(int i=0; i<numbers.size(); i++){
                if(numbers.get(i) < MessageManager.LOTTO_MIN || numbers.get(i) > MessageManager.LOTTO_MAX){
                    throw new IllegalArgumentException();
                }
            }
        }catch (IllegalArgumentException e){
            System.out.println(MessageManager.ERROR_OUT_OF_RANGE);
            return false;
        }
        return true;
    }

    public Boolean checkContainNumber(int number){
        if(numbers.contains(number)){
            System.out.println(MessageManager.ERROR_IS_ALREADY_CONTAIN);
            return false;
        }
        return true;
    }

    public void showNumbers(){
        System.out.println(numbers.toString());
    }
}
