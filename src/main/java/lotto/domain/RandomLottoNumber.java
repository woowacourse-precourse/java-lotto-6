package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.type.ConstNumberType;

import java.util.List;

public class RandomLottoNumber {
    private List<Integer> numbers;

    public RandomLottoNumber() {
        this.numbers = null;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void initRandomNumber() {
        this.numbers = Randoms.pickUniqueNumbersInRange(
                ConstNumberType.LOTTO_START_NUMBER.number(),
                ConstNumberType.LOTTO_END_NUMBER.number(),
                ConstNumberType.LOTTO_SIZE.number()
        );
    }

    public void showRandomNumber() {
        System.out.println(numbers.toString());
    }
}
