package lotto.Domain;

import static lotto.Validator.InputValidator.checkDivisibleBy1000;
import static lotto.Validator.InputValidator.isEmpty;
import static lotto.Validator.InputValidator.isNumber;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Lotto;

public class LottoStore {
    public List<Lotto> generateLotto(String lottoQuantity) {
        int quantity = 0;
        if (isEmpty(lottoQuantity) && isNumber(lottoQuantity)) {
            checkDivisibleBy1000(lottoQuantity);
            quantity = Integer.parseInt(lottoQuantity) / 1000;
        }
        List<Lotto> lotto = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            lotto.add(new Lotto(numbers));
        }
        return lotto;
    }
}
