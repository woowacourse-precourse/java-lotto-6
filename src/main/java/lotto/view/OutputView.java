package lotto.view;

import java.util.List;
import lotto.dto.LottoResponse;

public class OutputView {
    private static final String LOTTO_RESULT_TITLE = "\n당첨 통계";
    private static final String LOTTO_PURCHASED_MESSAGE = "개를 구매했습니다.";
    private static final String LOTTO_TOTAL_RETURN_MESSAGE = "총 수익률은 %f%입니다.";
    private static final int LOTTO_RESULT_CHARACTER_REPEAT_COUNT = 3;

    private static final int FIRST_PLACE_WINNING_AMOUNT = 2000000000;
    private static final int SECOND_PLACE_WINNING_AMOUNT = 30000000;
    private static final int THIRD_PLACE_WINNING_AMOUNT = 1500000;
    private static final int FORTH_PLACE_WINNING_AMOUNT = 50000;
    private static final int FIFTH_PLACE_WINNING_AMOUNT = 5000;

    private static final String DASH = "-";
    private static final String OPEN_SQUARE_BRACKETS = "[";
    private static final String CLOSE_SQUARE_BRACKETS = "[";

    public static void printIssuedLottoCountAndNumbers(List<LottoResponse> lottoResponses) {
        printIssuedLottoCount(lottoResponses.size());
        lottoResponses.forEach(OutputView::printIssuedLotto);
    }

    public static void printLottoResultTitle() {
        System.out.println(LOTTO_RESULT_TITLE);
        System.out.println(DASH.repeat(LOTTO_RESULT_CHARACTER_REPEAT_COUNT));
    }

    public static void printLottoWinningResult() {

    }

    public static void printTotalReturn(int rank) {
        double totalReturn = 0;
        switch (rank) {
            case 5 -> totalReturn = FIFTH_PLACE_WINNING_AMOUNT / 1000.0 / 100.0;
            case 4 -> totalReturn = FORTH_PLACE_WINNING_AMOUNT / 1000.0 / 100.0;
            case 3 -> totalReturn = THIRD_PLACE_WINNING_AMOUNT / 1000.0 / 100.0;
            case 2 -> totalReturn = SECOND_PLACE_WINNING_AMOUNT / 1000.0 / 100.0;
            case 1 -> totalReturn = FIRST_PLACE_WINNING_AMOUNT / 1000.0 / 100.0;
        }
        System.out.printf(LOTTO_TOTAL_RETURN_MESSAGE, Math.round(totalReturn) / 10.0);
    }

    private static void printIssuedLottoCount(int lottoCount) {
        System.out.println(lottoCount + LOTTO_PURCHASED_MESSAGE);
    }

    private static void printIssuedLotto(LottoResponse lottoResponse) {
        System.out.println(OPEN_SQUARE_BRACKETS);
        lottoResponse.getLottoNumbers().forEach(System.out::println);
        System.out.println(CLOSE_SQUARE_BRACKETS);
    }
}
