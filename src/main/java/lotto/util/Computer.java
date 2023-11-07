package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Lotto;
import lotto.enums.LottoNumberRange;
import lotto.model.Result;

public class Computer {
    Result result = new Result();

    public void getLottoNumber() {
        while (true) {
            try {
                List<Integer> numbers = getRandomNumber();
                Lotto lotto = new Lotto(numbers);
                result.addLottoTicket(lotto);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> getRandomNumber() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(LottoNumberRange.MIN_NUMBER.getValue(),
                LottoNumberRange.MAX_NUMBER.getValue(), LottoNumberRange.MIN_SELECT_COUNT.getValue()));
        return sortNumber(numbers);
    }

    public List<Integer> sortNumber(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }
}
