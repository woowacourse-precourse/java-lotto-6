package lotto.view;

import java.util.Map;
import lotto.model.LottoPlayer;
import lotto.model.LottoRank;
import org.w3c.dom.ls.LSOutput;

public class OutputView {
    private static final String LOTTO_START_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_BUY_MESSAGE = "개를 구매했습니다.";
    private static final String EMPTY_LINE = "\n";
    private static final String ASK_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String ASK_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String LOTTO_RESULT_MESSAGE = "당첨 통계 \n---";

    public void askForPurchaseAmount() {
        System.out.println(LOTTO_START_MESSAGE);
    }

    public void answerForPurchase(int lottoCount, String lottoNumbers) {
        System.out.print(EMPTY_LINE);
        System.out.printf("%d" + LOTTO_BUY_MESSAGE, lottoCount);
        System.out.print(EMPTY_LINE);
        System.out.println(lottoNumbers);
    }

    public void askForWinningNumbers() {
        System.out.print(EMPTY_LINE);
        System.out.println(ASK_WINNING_NUMBER_MESSAGE);
    }

    public void askForBonusNumber() {
        System.out.print(EMPTY_LINE);
        System.out.println(ASK_BONUS_NUMBER_MESSAGE);
    }

    public void printLottoResult(String lottoResult) {
        System.out.print(EMPTY_LINE);
        System.out.println(LOTTO_RESULT_MESSAGE);
        System.out.println(lottoResult);
    }
}
