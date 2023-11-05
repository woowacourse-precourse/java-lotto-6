package lotto.view;

import java.text.NumberFormat;
import java.util.List;
import lotto.domain.Prize;
import lotto.dto.IssuedLottoResponse;
import lotto.dto.WinningResultResponse;

public class OutputView {
    private static final String LOTTO_RESULT_TITLE = "\n당첨 통계";
    private static final String LOTTO_PURCHASED_MESSAGE = "개를 구매했습니다.";
    private static final String BONUSBALL_MATCHING_MESSAGE = ", 보너스 볼 일치";
    private static final String LOTTO_WINNING_RESULT_MESSAGE = "%d개 일치%s (%s원) - %d개";
    private static final String LOTTO_TOTAL_RETURN_MESSAGE = "총 수익률은 %s%%입니다.";
    private static final int LOTTO_RESULT_CHARACTER_REPEAT_COUNT = 3;
    private static final int LOTTO_ONE_PRICE = 1_000;

    private static final String DASH = "-";
    private static final String OPEN_SQUARE_BRACKETS = "[";
    private static final String CLOSE_SQUARE_BRACKETS = "]";

    public static void printIssuedLottoCountAndNumbers(List<IssuedLottoResponse> lottoResponses) {
        printIssuedLottoCount(lottoResponses.size());
        lottoResponses.forEach(OutputView::printIssuedLotto);
    }

    public static void printLottoResultTitle() {
        System.out.println(LOTTO_RESULT_TITLE);
        System.out.println(DASH.repeat(LOTTO_RESULT_CHARACTER_REPEAT_COUNT));
    }

    public static void printFullWinningResult(WinningResultResponse winningResultResponse) {
        winningResultResponse.getWinningResult().forEach(OutputView::printOneWinningResult);
    }

    private static void printOneWinningResult(Prize prize, int count) {

        if (prize.equals(Prize.NONE)) {
            return;
        }

        String bonusballMessage = "";
        if (prize.equals(Prize.SECOND)) {
            bonusballMessage = BONUSBALL_MATCHING_MESSAGE;
        }

        NumberFormat numberFormat = NumberFormat.getInstance();
        String winningAmount = numberFormat.format(prize.getWinningAmount());

        System.out.printf(LOTTO_WINNING_RESULT_MESSAGE, prize.getMatchingCount(), bonusballMessage, winningAmount,
                count);
        System.out.println();
    }

    public static void printTotalReturn(WinningResultResponse winningResultResponse, int lottoQuantity) {
        double totalWinningAmount = winningResultResponse.getTotalWinningPrice();
        double totalReturn = totalWinningAmount / (LOTTO_ONE_PRICE * lottoQuantity) * 100;

        System.out.printf(LOTTO_TOTAL_RETURN_MESSAGE, String.format("%.1f", totalReturn));
        System.out.println();
    }

    private static void printIssuedLottoCount(int lottoCount) {
        System.out.println(lottoCount + LOTTO_PURCHASED_MESSAGE);
    }

    private static void printIssuedLotto(IssuedLottoResponse lottoResponse) {
        String output = OPEN_SQUARE_BRACKETS;

        for (int number : lottoResponse.getLottoNumbers()) {
            output += (number + ", ");
        }
        output = output.substring(0, output.length() - 2);

        output += CLOSE_SQUARE_BRACKETS;
        System.out.println(output);
    }
}