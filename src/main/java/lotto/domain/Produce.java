package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static lotto.domain.RandomNumber.*;

public class Produce {
    private static final User user = User.getInstance();
    private static final Statistics statistics = Statistics.getInstance();
    private static final Printer printer = Printer.getInstance();

    public void start() {
        //TODO 메세지 메소드 입력
        proceed();
    }

    private void proceed() {
        // 구입금액, count 가져오기
        int purchaseAmount = getPurchaseAmount();
        int count = user.injectCount(purchaseAmount);

        //회차별 로또번호 lottos에 담기
        List<RandomNumber> randomNumbers = new ArrayList<>();
        IntStream.range(0, count).forEach(i -> randomNumbers.add(new RandomNumber(getUniqueNumbers())));
        printer.printCount(count);
        randomNumbers.forEach(i -> System.out.println(i.toString()));

        // 당첨 번호 입력
        Lotto lotto = getLotto();

        // 보너스 번호 입력
        int bonusNumber = getBonusNumber();

        //통계 로직
        statistics.getResult(randomNumbers, lotto, bonusNumber);
        int totalReward = statistics.getTotalReward();
        float rateOfReturn = statistics.getRateOfReturn(totalReward, purchaseAmount);

        //통계출력로직
        printer.printStatistics(rateOfReturn);
    }

    private static int getPurchaseAmount() {
        int purchaseAmount = 0;
        printer.printPurchaseAmount();
        try {
            purchaseAmount = user.inputPurchaseAmount();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.out.println("[ERROR]");
            purchaseAmount = getPurchaseAmount();
        }
        return purchaseAmount;
    }

    private static Lotto getLotto() {
        Lotto lotto = null;
        try {
            printer.printWinningNumber();
            lotto = user.inputWinningNumbers();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            lotto = getLotto();
        }
        return lotto;
    }

    private static int getBonusNumber() {
        int bonusNumber = 0;
        try {
            printer.printBonusNumber();
            bonusNumber = user.inputBonusNumber();
        } catch (IllegalArgumentException e) {
            bonusNumber = getBonusNumber();
        }
        return bonusNumber;
    }
}