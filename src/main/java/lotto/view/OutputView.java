package lotto.view;

import static lotto.constants.OutputMessage.ASK_AMOUNT_COMMENT;
import static lotto.constants.OutputMessage.ASK_BONUS_LOTTO_NUMBER_COMMENT;
import static lotto.constants.OutputMessage.ASK_WIN_LOTTO_NUMBER_COMMENT;
import static lotto.constants.OutputMessage.FIFTH_PRIZE_COMMENT;
import static lotto.constants.OutputMessage.FIRST_PRIZE_COMMENT;
import static lotto.constants.OutputMessage.FOURTH_PRIZE_COMMENT;
import static lotto.constants.OutputMessage.LOTTO_BUY_QUANTITY_COMMENT;
import static lotto.constants.OutputMessage.RESULT_START_COMMENT;
import static lotto.constants.OutputMessage.SECOND_PRIZE_COMMENT;
import static lotto.constants.OutputMessage.THIRD_PRIZE_COMMENT;
import static lotto.constants.OutputMessage.TOTAL_PROFIT_RATE_COMMENT;

import java.util.List;

public class OutputView {

    private OutputView() {
    }

    /**
     * 줄 바꿈
     */
    public static void newLineOutput() {
        System.out.println();
    }

    /**
     * 구입 금액 입력
     */
    public static void amountOutput() {
        System.out.println(ASK_AMOUNT_COMMENT.getComment());
    }

    /**
     * 로또 구입 갯수
     *
     * @param quantity
     */
    public static void lottoBuyQuantityOutput(int quantity) {
        System.out.printf(LOTTO_BUY_QUANTITY_COMMENT.getComment(), quantity);
    }

    /**
     * 로또 정보
     *
     * @param lottoNumber
     */
    public static void lottoNumberOutput(String lottoNumber) {
        System.out.println(lottoNumber);
    }

    /**
     * 로또 당첨 번호
     */
    public static void winLottoNumberOutput() {
        System.out.println(ASK_WIN_LOTTO_NUMBER_COMMENT.getComment());
    }

    /**
     * 보너스 당첨 번호
     */
    public static void bonusLottoNumberOutput() {
        System.out.println(ASK_BONUS_LOTTO_NUMBER_COMMENT.getComment());
    }

    /**
     * 당첨 통계
     */
    public static void lottoResultOutput(List<Integer> prizeResults, String profitRate) {
        System.out.println(RESULT_START_COMMENT.getComment());
        System.out.printf(FIFTH_PRIZE_COMMENT.getComment(), prizeResults.get(4));
        System.out.printf(FOURTH_PRIZE_COMMENT.getComment(), prizeResults.get(3));
        System.out.printf(THIRD_PRIZE_COMMENT.getComment(), prizeResults.get(2));
        System.out.printf(SECOND_PRIZE_COMMENT.getComment(), prizeResults.get(1));
        System.out.printf(FIRST_PRIZE_COMMENT.getComment(), prizeResults.get(0));
        System.out.printf(TOTAL_PROFIT_RATE_COMMENT.getComment(), profitRate);
    }

    /**
     * 예외
     *
     * @param message
     */
    public static void errorMessageOutput(String message) {
        System.out.println(message);
    }
}
