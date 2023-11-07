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
    public List<Lotto> generateLotto(String lottoQuantity) {
        int quantity = 0;

        checkDivisibleBy1000(lottoQuantity);
        quantity = Integer.parseInt(lottoQuantity) / 1000;

        List<Lotto> lotto = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> mutableList = new ArrayList<>(numbers);

            // 가변 리스트를 오름차순으로 정렬
            Collections.sort(mutableList);
            lotto.add(new Lotto(numbers));
        }
        return lotto;
    }
}
