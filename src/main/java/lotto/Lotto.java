package lotto;

import java.util.*;

import static constants.Constant.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Collections.sort(numbers);
        validateLengthLotto(numbers);
        validateRangeLotto(numbers);
        validateOrderLotto(numbers);
        this.numbers = numbers;
    }

    public Integer getNumber(int idx){
        return numbers.get(idx);
    }

    private void validateLengthLotto(List<Integer> numbers) {
        if (numbers.size() != Lotto_LENGTH) {
            throw new IllegalArgumentException(ERROR_STRING+
                    "\nExpected length : " + Lotto_LENGTH + "\nInput length : " + numbers.size());
        }
    }

    private void validateRangeLotto(List<Integer> numbers){
        for(Integer num: numbers){
            if(num<Lotto_BEGIN_RANGE || num>Lotto_END_RANGE){
                throw new IllegalArgumentException(ERROR_STRING+
                        "\nExpect : 1~45 범위 숫자" + "\nInput : " + num);
            }
        }
    }

    private void validateOrderLotto(List<Integer> numbers){
        for(int i=1; i<numbers.size();i++){
            if(numbers.get(i) < numbers.get(i - 1)){
                throw new IllegalArgumentException(ERROR_STRING+
                        "\nExpect : 오름 차순이 아닙니다.");

            }
        }
    }

    public String convertToString(){
        List<String>numbersString = new ArrayList<>();
        for(Integer num : numbers){
            numbersString.add(num.toString());
        }
        return String.join(", ", numbersString);
    }

}
