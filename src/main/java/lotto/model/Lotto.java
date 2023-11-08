package lotto.model;

import lotto.view.ExceptionMessage;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int BONUS_NUMBER_INDEX = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            ExceptionMessage.overNumberException();;
            throw new IllegalArgumentException();
        }
    }
    private void validateRange(List<Integer> numbers){
        for(int num : numbers){
            if(num<=0||num>45){
                ExceptionMessage.rangeException();
                throw new IllegalArgumentException();
            }
        }
    }
    private void validateDuplicate(List<Integer> numbers){
        List<Integer> tmp = numbers;
        if(tmp.stream().distinct().count()!=numbers.size()){
            ExceptionMessage.duplicateException();
            throw new IllegalArgumentException();
        }

    }
    public void setBonusNumber(int bonusNumber){
        if(numbers.contains(bonusNumber)){
            ExceptionMessage.duplicateException();
            throw new IllegalArgumentException();
        }
        numbers.add(bonusNumber);
    }
    public List<Integer>getNumbers(){
        return numbers;
    }
    public int getBonusNumber(){
        return numbers.get(BONUS_NUMBER_INDEX);
    }
    public int match(Lotto winningLotto){
        int cnt=0;
        List<Integer> winningLottoNumbers = winningLotto.getNumbers();
        for(int i=0; i<6; i++){
            if(numbers.contains((winningLottoNumbers.get(i)))){
                cnt++;
            }
        }
        return cnt;
    }
    public boolean containNumber(int number){
        return numbers.contains(number);
    }

}
