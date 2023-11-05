package lotto.view;


import static lotto.utility.Constants.BUY_MESSAGE_AFTER;
import static lotto.utility.Constants.BUY_MESSAGE_BEFORE;
import static lotto.utility.Constants.COUNT_WORD;
import static lotto.utility.Constants.EARNING_RATE_MESSAGE_1;
import static lotto.utility.Constants.EARNING_RATE_MESSAGE_2;
import static lotto.utility.Constants.INPUT_BONUS_NUMBER_MESSAGE;
import static lotto.utility.Constants.INPUT_WINNING_NUMBERS_MESSAGE;
import static lotto.utility.Constants.LINE;
import static lotto.utility.Constants.WINNING_STATISTIC;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.User;
import lotto.utility.Rank;

public class UserView {
    public UserView() {}

    public void printBuyMessageBefore() {
        System.out.println();
        System.out.println(BUY_MESSAGE_BEFORE);
    }

    public void printBuyMessageAfter(Integer purchaseLottoNumber) {
        System.out.println();
        System.out.println(purchaseLottoNumber + BUY_MESSAGE_AFTER);
    }

    public void printInputWinningNumbersMessage() {
        System.out.println();
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
    }

    public void printInputBonusNumberMessage() {
        System.out.println();
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
    }

    public void printWinningStatistic(User user) {
        System.out.println();
        System.out.println(WINNING_STATISTIC);
        System.out.println(LINE.repeat(3));
        // 당첨 통계 출력
        System.out.println(Rank.FIFTH.getMessage() + user.getFifthRank() + COUNT_WORD);
        System.out.println(Rank.FOURTH.getMessage() + user.getFourthRank() + COUNT_WORD);
        System.out.println(Rank.THIRD.getMessage() + user.getThirdRank() + COUNT_WORD);
        System.out.println(Rank.SECOND.getMessage() + user.getSecondRank() + COUNT_WORD);
        System.out.println(Rank.FIRST.getMessage() + user.getFirstRank() + COUNT_WORD);
    }

    public void printLottos(List<Lotto> lottos) {
        System.out.println();
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getSortedNumbers());
        }
    }

    public void printEarningRate(User user) {
        System.out.println(EARNING_RATE_MESSAGE_1 + user.getEarningRate() + EARNING_RATE_MESSAGE_2);
    }
}
