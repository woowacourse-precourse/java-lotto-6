package lotto.view;

import static lotto.domain.lotto.LottoCriteria.FIFTH_PLACE;
import static lotto.domain.lotto.LottoCriteria.FIRST_PLACE;
import static lotto.domain.lotto.LottoCriteria.FOURTH_PLACE;
import static lotto.domain.lotto.LottoCriteria.SECOND_PLACE;
import static lotto.domain.lotto.LottoCriteria.THIRD_PLACE;
import static lotto.view.OutputMessage.BONUS_RESULT;
import static lotto.view.OutputMessage.DELIMITER;
import static lotto.view.OutputMessage.LEFT_SQUARE_BRACKET;
import static lotto.view.OutputMessage.NUMBER_FORMAT;
import static lotto.view.OutputMessage.PURCHASE_RESULT;
import static lotto.view.OutputMessage.RESULT;
import static lotto.view.OutputMessage.RIGHT_SQUARE_BRACKET;
import static lotto.view.OutputMessage.SEPARATOR;
import static lotto.view.OutputMessage.TOTAL_RETURN;
import static lotto.view.OutputMessage.WINNING_STATISTICS;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoCriteria;

public class OutputView {

    public void printMessage(final String message) {
        System.out.println(message);
    }

    public void printPurchaseResult(final int number) {
        System.out.println();
        System.out.printf(PURCHASE_RESULT.getMessage(), number);
    }

    public void printWinningStatistics() {
        System.out.println(WINNING_STATISTICS.getMessage());
        System.out.println(SEPARATOR.getMessage());
    }

    public void printIssuedLottos(final List<Lotto> issuedLottos) {
        issuedLottos.stream().forEach(lotto ->
                System.out.println(listToStringWithBracket(lotto.getNumbers())));
    }

    private String listToStringWithBracket(final List<Integer> lottoNumbers) {
        StringBuilder stringBuilder = new StringBuilder();
        String lotto = joiningDelimiter(lottoNumbers);

        stringBuilder.append(LEFT_SQUARE_BRACKET.getMessage())
                .append(lotto)
                .append(RIGHT_SQUARE_BRACKET.getMessage());

        return stringBuilder.toString();
    }

    private String joiningDelimiter(final List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(DELIMITER.getMessage()));
    }

    public void printWinningDetails(final Map<LottoCriteria, Integer> result) {
        printResult(FIFTH_PLACE.getMatchNumber(), getFormat(FIFTH_PLACE.getAmount()), result.get(FIFTH_PLACE));
        printResult(FOURTH_PLACE.getMatchNumber(), getFormat(FOURTH_PLACE.getAmount()), result.get(FOURTH_PLACE));
        printResult(THIRD_PLACE.getMatchNumber(), getFormat(THIRD_PLACE.getAmount()), result.get(THIRD_PLACE));
        printBonusResult(SECOND_PLACE.getMatchNumber(), getFormat(SECOND_PLACE.getAmount()), result.get(SECOND_PLACE));
        printResult(FIRST_PLACE.getMatchNumber(), getFormat(FIRST_PLACE.getAmount()), result.get(FIRST_PLACE));
    }

    private String getFormat(final Long amount) {
        return String.format(NUMBER_FORMAT.getMessage(), amount);
    }

    private void printResult(final int getMatchNumber, final String amount, final int count) {
        System.out.printf(RESULT.getMessage(), getMatchNumber, amount, count);
    }

    private void printBonusResult(final int getMatchNumber, final String amount, final int count) {
        System.out.printf(BONUS_RESULT.getMessage(), getMatchNumber, amount, count);
    }

    public void printTotalReturn(final float totalReturn) {
        System.out.printf(TOTAL_RETURN.getMessage(), totalReturn);
    }
}
