package lotto.Domain;

import static lotto.Util.InputValidator.checkDivisibleBy1000;
import static lotto.Util.InputValidator.isEmpty;
import static lotto.Util.InputValidator.isNumber;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Lotto;

public class LottoStore {
    public List<Lotto> generateLotto(String lottoQuantity) { // System으로 옮겨도 될 듯
        int quantity = 0;

        checkDivisibleBy1000(lottoQuantity);
        quantity = Integer.parseInt(lottoQuantity) / 1000;

        List<Lotto> lotto = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            lotto.add(new Lotto(numbers));
        }
        return lotto;
    }
}
