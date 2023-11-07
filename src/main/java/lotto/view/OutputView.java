package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.constant.LottoWinCategory;
import lotto.constant.UIConstant;

public class OutputView {

    private static final String REQUEST_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String REQUEST_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";

    private static final String WINNING_RATE_MESSAGE = "총 수익률은 ";

    private void printWithNewLine(String s) {
        System.out.println(s);
    }

    private void print(String s) {
        System.out.print(s);
    }

    public void printRequestPurchaseAmountMessage() {
        printWithNewLine(REQUEST_PURCHASE_AMOUNT_MESSAGE);
    }

    public void printRequestWinningNumberMessage() {
        printWithNewLine(REQUEST_WINNING_NUMBER_MESSAGE);
    }

    public void printRequestBonusNumberMessage() {
        printWithNewLine(REQUEST_BONUS_NUMBER_MESSAGE);
    }

    public void printLottoCount(int lottoCount) {
        printWithNewLine(lottoCount + LOTTO_COUNT_MESSAGE);
    }

    public void printLottoTicketNumbers(List<String> lottoNumbers) {
        lottoNumbers.forEach(System.out::print);
    }

    public void printWinningStatistics(Map<LottoWinCategory, Integer> winningResult) {
        printWithNewLine(WINNING_STATISTICS_MESSAGE);
        printWithNewLine(UIConstant.WINNING_STATISTICS_OPENING.toString());

        List<LottoWinCategory> lottoWinCategories = LottoWinCategory.getWinningValues();
        lottoWinCategories.stream().forEach(lottoWinCategory -> {
            printWithNewLine(lottoWinCategory.getMessage() + " - " + winningResult.get(lottoWinCategory) + "개");
        });
    }

    public void printErrorMessage(String message) {
        printWithNewLine(message);
    }

    public void printWinningRate(double winningRate) {
        printWithNewLine(WINNING_RATE_MESSAGE + winningRate + "%" + UIConstant.SENTENCE_ENDING);
    }
}
