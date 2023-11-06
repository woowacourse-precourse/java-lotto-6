package lotto.lotto;

import java.util.List;

import static lotto.constants.ErrorConstants.*;
import static lotto.constants.NumConstant.DIGIT;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또의 숫자는 " + DIGIT.getValue() + "개 입니다");
        }
        for (Integer num1 : numbers) {
            validateNumber(num1);
        }
    }

    private void validateNumber(Integer num1){
        int count = 0;
        for (Integer num2 : numbers) {
            if(num1 == num2) count++;
        }
        if(num1 < 0 || num1 > 45) throw new IllegalArgumentException(NOTINARRANGEERROR.toString());
        if(count != 1) throw new IllegalArgumentException(DUPLICATEDERROR.toString());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public String getLottoInfo(){
        String lottoInfo = "";
        lottoInfo += "[";
        for (Integer number : numbers) {
            lottoInfo += number.toString() + ", ";
        }
        lottoInfo = lottoInfo.substring(0, lottoInfo.length() - 2);
        lottoInfo += "]";
        return lottoInfo;
    }
}
