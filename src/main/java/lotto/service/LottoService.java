package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.NumericConstant.LOTTO_NUMBER_COUNT;
import static lotto.constant.NumericConstant.LOTTO_PRICE;
import static lotto.constant.NumericConstant.MAX_LOTTO_NUMBER;
import static lotto.constant.NumericConstant.MIN_LOTTO_NUMBER;

public class LottoService {
    public List<Lotto> buyLotto(int money) {
        int count = money / LOTTO_PRICE;
        return createLottos(count);
    }

    private List<Lotto> createLottos(int count) {
        List<Lotto> createdLottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> numbers =
                    Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_COUNT);

            createdLottos.add(new Lotto(numbers));
        }

        return createdLottos;
    }
}
