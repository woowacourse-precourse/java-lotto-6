package lotto.lotto;

import java.util.List;

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
            int count = 0;
            for (Integer num2 : numbers) {
                if(num1 == num2) count++;
            }
            if(num1 < 0 || num1 > 45) throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            if(count != 1) throw new IllegalArgumentException("[ERROR] 로또 번호가 중복됩니다");
        }
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
