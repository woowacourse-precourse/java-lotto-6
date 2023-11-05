package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import lotto.constant.NumberConstant;

public class Lotteries {

    private final List<Lotto> lotteries;

    private Lotteries(int purchaseCount) {
        this.lotteries = generateLotteries(purchaseCount);
    }

    public static Lotteries from(int purchaseCount) {
        return new Lotteries(purchaseCount);
    }

    private List<Lotto> generateLotteries(int purchaseCount) {
        for (int i = 0; i < purchaseCount; i++) {
            lotteries.add(new Lotto(generateLottoNumbers()));
        }
        return lotteries;
    }

    private List<Integer> generateLottoNumbers() {
        List<Integer> randomNumbers =  Randoms.pickUniqueNumbersInRange(
                NumberConstant.LOTTO_MIN_NUMBER.getNumber(),
                NumberConstant.LOTTO_MAX_NUMBER.getNumber(),
                NumberConstant.LOTTO_COUNT.getNumber()
        );
        Collections.sort(randomNumbers);
        return randomNumbers;
    }

    public List<Lotto> getLotteries() {
        return lotteries;
    }
}
