package lotto.view;


import static lotto.utility.Constants.BUY_MESSAGE_AFTER;
import static lotto.utility.Constants.BUY_MESSAGE_BEFORE;
import static lotto.utility.Constants.INPUT_BONUS_NUMBER_MESSAGE;
import static lotto.utility.Constants.INPUT_WINNING_NUMBERS_MESSAGE;
import static lotto.utility.Constants.LINE;
import static lotto.utility.Constants.WINNING_STATISTIC;

import java.util.List;
import lotto.model.Lotto;

public class UserView {
    public UserView() {}
    public void printBuyMessageBefore() {
        System.out.println(BUY_MESSAGE_BEFORE);
    }
    public void printBuyMessageAfter(Integer purchaseLottoNumber) {
        System.out.println(purchaseLottoNumber + BUY_MESSAGE_AFTER);
    }
    public void printInputWinningNumbersMessage() {
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
    }
    public void printInputBonusNumberMessage() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
    }
    public void printWinningStatistic() {
        System.out.println(WINNING_STATISTIC);
        System.out.println(LINE.repeat(3));
        // 당첨 통계 메시지 출력 코드 구현 예정
    }
    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getSortedNumbers());
        }
    }
}
