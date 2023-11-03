package lotto.Domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.Validator.InputValidator;

public class LottoStore {
    public List<Lotto> generateLotto(String lottoQuantity) {
        int quantity = 0;
        if (InputValidator.isNumeric(lottoQuantity)) {
            InputValidator.checkDivisibleBy1000(lottoQuantity);
            quantity = Integer.parseInt(lottoQuantity) / 1000;
        }
        List<Lotto> lotto = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lotto.add(new Lotto(numbers));
        }
        return lotto;
    }
}
