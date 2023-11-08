package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class LottoGenerateService {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNTS = 6;


    public List<Lotto> generateMultipleLotto(int lottoAmount) {

        List<Lotto> userPurchasedLotto = new ArrayList<>();

        while (lottoAmount-- > 0) {
            userPurchasedLotto.add(generateSingleLotto());
        }

        return userPurchasedLotto;
    }


    private Lotto generateSingleLotto() {

        return new Lotto(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_COUNTS));
    }

}
