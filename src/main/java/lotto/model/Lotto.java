package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.ErrorMessage;
import lotto.constant.NumberConstant;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(){
        numbers = Randoms.pickUniqueNumbersInRange(NumberConstant.LOTTO_NUMBER_MIN,
                NumberConstant.LOTTO_NUMBER_MAX, NumberConstant.LOTTO_NUMBER_COUNT);
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.NOT_SIX_COUNT_WINNING_NUMBER);
        }
    }

    public List<Integer> getSortedNumbers(){
        return numbers.stream().sorted().toList();
    }
}
