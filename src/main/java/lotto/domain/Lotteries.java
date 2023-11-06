package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
        return IntStream.range(0, purchaseCount)
                .mapToObj(i -> this.generateLotto())
                .collect(Collectors.toList());
    }

    private Lotto generateLotto() {
        return new Lotto(generateLottoNumbers());
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
}
