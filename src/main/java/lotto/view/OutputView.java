package lotto.view;

import static lotto.domain.lotto.LottoCriteria.FIFTH_PLACE;
import static lotto.domain.lotto.LottoCriteria.FIRST_PLACE;
import static lotto.domain.lotto.LottoCriteria.FOURTH_PLACE;
import static lotto.domain.lotto.LottoCriteria.SECOND_PLACE;
import static lotto.domain.lotto.LottoCriteria.THIRD_PLACE;
import static lotto.view.OutputMessage.BONUS_RESULT;
import static lotto.view.OutputMessage.PURCHASE_RESULT;
import static lotto.view.OutputMessage.RESULT;
import static lotto.view.OutputMessage.SEPARATOR;
import static lotto.view.OutputMessage.TOTAL_RETURN;
import static lotto.view.OutputMessage.WINNING_STATISTICS;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoCriteria;

public class OutputView {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printPurchaseResult(int number) {
        System.out.printf(PURCHASE_RESULT.getMessage(), number);
    }

    public void printWinningStatistics() {
        System.out.println(WINNING_STATISTICS.getMessage());
        System.out.println(SEPARATOR.getMessage());
    }

    public void printIssuedLottos(List<Lotto> issuedLottos) {
        issuedLottos.stream().forEach(lotto -> System.out.println(ListToStringWithBracket(lotto.getNumbers())));
    }

    private String ListToStringWithBracket(List<Integer> lottoNumbers) {
        StringBuilder stringBuilder = new StringBuilder();

        String lotto = lottoNumbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));

        stringBuilder.append("[").append(lotto).append("]");

        return stringBuilder.toString();
    }

    public void printWinningDetails(Map<LottoCriteria, Long> result) {
        printResult(FIFTH_PLACE.getMatchNumber(), getFormatAmount(FIRST_PLACE.getAmount()), result.get(FIRST_PLACE));
        printResult(FOURTH_PLACE.getMatchNumber(), getFormatAmount(FIRST_PLACE.getAmount()), result.get(FIRST_PLACE));
        printResult(THIRD_PLACE.getMatchNumber(), getFormatAmount(FIRST_PLACE.getAmount()), result.get(FIRST_PLACE));
        printBonusResult(SECOND_PLACE.getMatchNumber(), getFormatAmount(FIRST_PLACE.getAmount()),
                result.get(FIRST_PLACE));
        printResult(FIRST_PLACE.getMatchNumber(), getFormatAmount(FIRST_PLACE.getAmount()), result.get(FIRST_PLACE));
    }

    private String getFormatAmount(Long amount) {
        return String.format("%,d", amount);
    }

    private void printResult(int getMatchNumber, String amount, Long count) {
        System.out.printf(RESULT.getMessage(), getMatchNumber, amount, count);
    }

    private void printBonusResult(int getMatchNumber, String amount, Long count) {
        System.out.printf(BONUS_RESULT.getMessage(), getMatchNumber, amount, count);
    }

    public void printTotalReturn(float totalReturn) {
        System.out.printf(TOTAL_RETURN.getMessage(), totalReturn);
    }
}
