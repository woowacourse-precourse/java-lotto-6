package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.util.LottoConstant.*;

public class NumberGenerator {

    private List<Integer> NumberGenerator() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER.getValue(),
                LOTTO_MAX_NUMBER.getValue(),
                LOTTO_NUMBER_COUNT.getValue());
    }

    private int createBonusNumber() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER.getValue(),
                LOTTO_MAX_NUMBER.getValue(),
                LOTTO_BONUS_NUMBER_COUNT.getValue()).get(0);
    }

    private boolean isDuplicatedNumber(List<Integer> numbers , int number) {
        return numbers.contains(number);
    }

    private int getBonusNumber(List<Integer> numbers) {
        while(true) {
            int bonusNumber = createBonusNumber();

            if(!isDuplicatedNumber(numbers , bonusNumber)) {
                return bonusNumber;
            }
        }
    }

    private LottoNumber createLottoNumber() {
        List<Integer> numbers = NumberGenerator();
        int bonusNumber = getBonusNumber(numbers);

        return new LottoNumber(new Lotto(numbers) , bonusNumber);
    }

}
