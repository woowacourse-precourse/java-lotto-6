package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {

    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public static List<Lotto> createLotto(LottoBuyPrice lottoBuyPrice) {
        List<Lotto> lottos = new ArrayList<>();
        int createLottoCount = lottoBuyPrice.getAvailableLottoBuyCount();

        for (int i = 0; i < createLottoCount; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(
                    LOTTO_START_NUMBER,
                    LOTTO_END_NUMBER,
                    LOTTO_NUMBER_COUNT
            );
            lottos.add(new Lotto(lottoNumbers));
        }

        return lottos;
    }
}
