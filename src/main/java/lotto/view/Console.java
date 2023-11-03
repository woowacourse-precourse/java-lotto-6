package lotto.view;

import java.util.List;

public interface Console {
    // 구입금액을 입력해 주세요.\n,
    String inputPayment();

    // n개를 구매했습니다.\n
    void displayPurchasedLotteryCount(int lotteryCount);

    void displayPurchasedLottery(List<Integer> lottery);

    // 당첨 번호를 입력해 주세요.\n
    String inputWinningNumbers();

    // 보너스 번호를 입력해 주세요.\n
    String inputBonusNumber();

    // 당첨 통계\n
    // ---\n
    // n개 일치 (m원) - k개\n
    // 총 수익률은 t%입니다.
    void displayResult(List<Integer> matchResult, double rateOfReturn);
}
