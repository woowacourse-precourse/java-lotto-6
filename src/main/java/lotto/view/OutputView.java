package lotto.view;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;

public class OutputView {
    private static final String ENTER_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
    private static final String ENTER_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String ENTER_BONUS_MESSAGE = "보너스 번호를 입력해 주세요.";

    public void printEnterAmountMessage() {
        System.out.println(ENTER_AMOUNT_MESSAGE);
    }

    public void printLottoPurchases(final List<List<Integer>> lottoNumbers) {
        System.out.println();
        System.out.println(lottoNumbers.size() + PURCHASE_MESSAGE);
        for (List<Integer> lottoNumber : lottoNumbers) {
            Collections.sort(lottoNumber);
            printLottoNumber(lottoNumber);
        }
    }

    private void printLottoNumber(final List<Integer> lottoNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        List<String> strings = lottoNumber.stream()
                .map(String::valueOf)
                .toList();
        String joined = String.join(", ", strings);
        stringBuilder.append(joined);

        stringBuilder.append("]");
        System.out.println(stringBuilder);
    }

    public void printEnterWinningNumbersMessage() {
        System.out.println();
        System.out.println(ENTER_WINNING_NUMBERS_MESSAGE);
    }

    public void printEnterBonusMessage() {
        System.out.println();
        System.out.println(ENTER_BONUS_MESSAGE);
    }

    public void printStatsTitle() {
        System.out.println();
        System.out.println("당첨 통계\n---");
    }

    public void printStats(final String description, final int amount, final int number) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        System.out.println(description + " (" + decimalFormat.format(amount) + "원) - " + number + "개");
    }

    public void printRateOfReturn(final double rateOfReturn) {
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        System.out.println("총 수익률은 " + decimalFormat.format(rateOfReturn * 100) + "%입니다.");
    }

    public void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }
}
