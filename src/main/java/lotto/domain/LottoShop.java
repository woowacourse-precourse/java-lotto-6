package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.constant.ExceptionMessage;
import lotto.constant.NumberRange;

public class LottoShop {

    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_AMOUNT = 1000;

    public static List<Lotto> createLottosBy(PurchaseAmount purchaseAmount) {
        return IntStream.range(0, changeAmountToLottos(purchaseAmount))
                .mapToObj(i -> new Lotto(createRandomLottoNumbers()))
                .collect(Collectors.toList());
    }

    private static List<Integer> createRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(NumberRange.MIN_NUMBER.getNumber(),
                NumberRange.MAX_NUMBER.getNumber(), LOTTO_SIZE);
    }

    private static int changeAmountToLottos(PurchaseAmount purchaseAmount) {
        validateAmountDivisible(purchaseAmount);
        return purchaseAmount.changeBy(LOTTO_AMOUNT);
    }

    public static int countLottoTicket(PurchaseAmount purchaseAmount) {
        return changeAmountToLottos(purchaseAmount);
    }

    public static void validateAmountDivisible(PurchaseAmount purchaseAmount) {
        if (!purchaseAmount.divisible(LOTTO_AMOUNT)) {
            throw new IllegalArgumentException(ExceptionMessage.UNDIVISIBLE_AMOUNT.getMessage());
        }
    }
}
