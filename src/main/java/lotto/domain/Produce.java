package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static lotto.domain.RandomNumber.getUniqueNumbers;

public class Produce {
    private static final User USER = User.getInstance();
    private static final Statistics STATISTICS = Statistics.getInstance();
    private static final Printer PRINTER = Printer.getInstance();

    public void start() {
        proceed();
    }

    private void proceed() {
        // 구입금액, count 가져오기
        int purchaseAmount = getPurchaseAmount();
        int count = USER.injectCount(purchaseAmount);

        //회차별 로또번호 randomNumbers 담기
        List<RandomNumber> randomNumbers = new ArrayList<>();
        IntStream.range(0, count).forEach(i -> randomNumbers.add(new RandomNumber(getUniqueNumbers())));
        PRINTER.printCount(count);
        randomNumbers.forEach(i -> System.out.println(i.toString()));

        // 당첨 번호 입력
        Lotto lotto = getLotto();

        // 보너스 번호 입력
        int bonusNumber = getBonusNumber();

        //통계 로직
        STATISTICS.getResult(randomNumbers, lotto, bonusNumber);
        int totalReward = STATISTICS.getTotalReward();
        float rateOfReturn = STATISTICS.getRateOfReturn(totalReward, purchaseAmount);

        //통계출력로직
        PRINTER.printStatistics(rateOfReturn);
    }

    private static int getPurchaseAmount() {
        int purchaseAmount = 0;
        PRINTER.printPurchaseAmount();
        try {
            purchaseAmount = USER.inputPurchaseAmount();
        } catch (IllegalArgumentException e) {
            PRINTER.printErrorMessage(e.getMessage());
            purchaseAmount = getPurchaseAmount();
        }
        return purchaseAmount;
    }

    private static Lotto getLotto() {
        Lotto lotto = null;
        try {
            PRINTER.printLottoNumber();
            lotto = USER.inputLottoNumbers();
        } catch (IllegalArgumentException e) {
            PRINTER.printErrorMessage(e.getMessage());
            lotto = getLotto();
        }
        return lotto;
    }

    private static int getBonusNumber() {
        int bonusNumber = 0;
        PRINTER.printBonusNumber();
        try {
            bonusNumber = USER.inputBonusNumber();
        } catch (IllegalArgumentException e) {
            PRINTER.printErrorMessage(e.getMessage());
            bonusNumber = getBonusNumber();
        }
        return bonusNumber;
    }
}