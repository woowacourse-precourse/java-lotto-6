package lotto.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.util.message.OutputMessage;


import static lotto.util.Constant.LOTTO_LENGTH;
import static lotto.util.Constant.LOTTO_PRICE;
import static lotto.util.Constant.MAX_LOTTO_NUMBER;
import static lotto.util.Constant.MIN_LOTTO_NUMBER;

public class Generator {

    public List<Lotto> getLotto(int purchasedPrice) {
        List<Lotto> lottoList = generateLottoNumbers(purchasedPrice);
        OutputMessage.purchaseLotto(lottoList);
        return lottoList;
    }

    public List<Lotto> generateLottoNumbers(int purchasedPrice) {
        int purchasedAmount = purchasedPrice / LOTTO_PRICE;
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < purchasedAmount; i++) {
            lottoList.add(generateLotto());
        }
        return lottoList;
    }

    private Lotto generateLotto() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_LENGTH));
        Collections.sort(numbers);
        return new Lotto(numbers);
    }
}
