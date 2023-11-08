package lotto;

import java.net.InterfaceAddress;
import java.util.List;
import lotto.constants.Prize;
import lotto.util.Validator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplicate(numbers);
        checkValidRange(numbers);

        this.numbers = numbers;
    }

    public String getLottoString(){
        String LottoStr = numbers.toString().replaceAll("[^0-9\\[\\] ]","");
        LottoStr = LottoStr.replace(" ", ", ");
        return LottoStr;
    }

    public Prize getLottoResult(List<Integer> winninNumber, int bonusNumber){
        int correct=0;
        int bonus=0;
        for (int i=0; i<winninNumber.size(); i++){
            if (numbers.contains(winninNumber.get(i))){
                correct++;
            }
        }
        if(correct==5 && numbers.contains(bonusNumber)){
            bonus++;
        }

        return checkPrizeType(correct, bonus);
    }

    private Prize checkPrizeType(int correct, int bonus){
        if (correct==3) {
            return Prize.FIFTH;
        }
        if (correct==4){
            return Prize.FOURTH;
        }
        if (correct==5 && bonus==0){
            return Prize.THIRD;
        }
        if (correct==5 && bonus==1){
            return Prize.SECOND;
        }
        if (correct==6){
            return Prize.FIRST;
        }
        return Prize.NONE;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicate(List<Integer> numbers){
        Validator.isIntListDuplicate(numbers);
    }

    private void checkValidRange(List<Integer> numbers) {
        numbers.forEach((num)->{
            Validator.isValidRange(num);
        });
    }
}
