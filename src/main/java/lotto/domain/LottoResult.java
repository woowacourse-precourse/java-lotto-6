package lotto.domain;

import static lotto.global.common.GameMessage.COUNT_MESSAGE;
import static lotto.global.common.GameMessage.FIRST_PRIZE_MESSAGE;
import static lotto.global.common.GameMessage.FIVETH_PRIZE_MESSAGE;
import static lotto.global.common.GameMessage.FOURTH_PRIZE_MESSAGE;
import static lotto.global.common.GameMessage.MY_ROI_MESSAGE;
import static lotto.global.common.GameMessage.PERCENTAGE_MESSAGE;
import static lotto.global.common.GameMessage.SECOND_PRIZE_MESSAGE;
import static lotto.global.common.GameMessage.THIRD_PRIZE_MESSAGE;
import static lotto.global.common.GameMessage.WINNING_HISTORY_MESSAGE;
import static lotto.global.common.LottoConstant.BONUS_NUMBER_INDEX;
import static lotto.global.common.LottoConstant.CONVERT_INTO_PERCENTAGE;
import static lotto.global.common.LottoConstant.FIRST_PRIZE_MONEY;
import static lotto.global.common.LottoConstant.FIVETH_PRIZE;
import static lotto.global.common.LottoConstant.FIVETH_PRIZE_MONEY;
import static lotto.global.common.LottoConstant.FOURTH_PRIZE;
import static lotto.global.common.LottoConstant.FOURTH_PRIZE_MONEY;
import static lotto.global.common.LottoConstant.SECOND_PRIZE_MONEY;
import static lotto.global.common.LottoConstant.SECOND_PRIZE_OR_FIRST_PRIZE;
import static lotto.global.common.LottoConstant.THIRD_PRIZE;
import static lotto.global.common.LottoConstant.THIRD_PRIZE_MONEY;

import java.text.DecimalFormat;
import java.util.List;

public class LottoResult {
    private final static String FIRST_DEMICAL_PLACE_PATTERN = "#.#";

    private final List<Lotto> lottos;
    private int fivethPrizeCount = 0;
    private int fourthPrizeCount = 0;
    private int thirdPrizeCount = 0;
    private int secondPrizeCount = 0;
    private int firstPrizeCount = 0;

    public LottoResult(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void configurePrizeCount(List<Integer> winningNumbers) {
        for (Lotto lotto : this.lottos) {
            int matchedCount = lotto.compareWinningNumbers(winningNumbers);

            if (checkWinning(matchedCount)) {
                compareBonusNumber(lotto, winningNumbers.get(BONUS_NUMBER_INDEX));
            }
        }
    }

    public void printWinningHistory() {
        System.out.print(WINNING_HISTORY_MESSAGE.message);
        System.out.print(FIVETH_PRIZE_MESSAGE.message + this.fivethPrizeCount + COUNT_MESSAGE.message);
        System.out.print(FOURTH_PRIZE_MESSAGE.message + this.fourthPrizeCount + COUNT_MESSAGE.message);
        System.out.print(THIRD_PRIZE_MESSAGE.message + this.thirdPrizeCount + COUNT_MESSAGE.message);
        System.out.print(SECOND_PRIZE_MESSAGE.message + this.secondPrizeCount + COUNT_MESSAGE.message);
        System.out.print(FIRST_PRIZE_MESSAGE.message + this.firstPrizeCount + COUNT_MESSAGE.message);
    }

    public void printMyROI() {
        DecimalFormat decimalFormat = new DecimalFormat(FIRST_DEMICAL_PLACE_PATTERN);
        System.out.print(MY_ROI_MESSAGE.message + decimalFormat.format(calculateROI()) + PERCENTAGE_MESSAGE.message);
    }

    private double calculateROI() {
        double myReturn = ((this.fivethPrizeCount * FIVETH_PRIZE_MONEY) + (this.fourthPrizeCount * FOURTH_PRIZE_MONEY)
                + (this.thirdPrizeCount * THIRD_PRIZE_MONEY) + (this.secondPrizeCount * SECOND_PRIZE_MONEY)
                + (this.firstPrizeCount * FIRST_PRIZE_MONEY)) * CONVERT_INTO_PERCENTAGE;
        double myInvestment = lottos.size();

        return myReturn / myInvestment;
    }

    private boolean checkWinning(int matchedCount) {
        if (matchedCount == FIVETH_PRIZE) {
            this.fivethPrizeCount++;
        }
        if (matchedCount == FOURTH_PRIZE) {
            this.fourthPrizeCount++;
        }
        if (matchedCount == THIRD_PRIZE) {
            this.thirdPrizeCount++;
        }

        return matchedCount == SECOND_PRIZE_OR_FIRST_PRIZE;
    }

    private void compareBonusNumber(Lotto lotto, int bonusNumber) {
        if (lotto.compareNumber(bonusNumber)) {
            this.secondPrizeCount++;
        }

        this.firstPrizeCount++;
    }
}
