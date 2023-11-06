package lotto.view;

import static lotto.domain.LottoCriteria.FIFTH_PLACE;
import static lotto.domain.LottoCriteria.FIRST_PLACE;
import static lotto.domain.LottoCriteria.FOURTH_PLACE;
import static lotto.domain.LottoCriteria.SECOND_PLACE;
import static lotto.domain.LottoCriteria.THIRD_PLACE;
import static lotto.view.OutputMessage.BONUS_RESULT;
import static lotto.view.OutputMessage.PURCHASE_RESULT;
import static lotto.view.OutputMessage.RESULT;
import static lotto.view.OutputMessage.SEPARATOR;
import static lotto.view.OutputMessage.TOTAL_RETURN;
import static lotto.view.OutputMessage.WINNING_STATISTICS;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoCriteria;

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
        stringBuilder.append("[");
        String lotto = lottoNumbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        stringBuilder.append(lotto);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void printResult(Map<LottoCriteria, Long> result) {
        System.out.printf(RESULT.getMessage(), FIFTH_PLACE.getCount(), String.format("%,d", FIFTH_PLACE.getAmount()),
                result.get(FIFTH_PLACE));
        System.out.printf(RESULT.getMessage(), FOURTH_PLACE.getCount(), String.format("%,d", FOURTH_PLACE.getAmount()),
                result.get(FOURTH_PLACE));
        System.out.printf(RESULT.getMessage(), THIRD_PLACE.getCount(), String.format("%,d", THIRD_PLACE.getAmount()),
                result.get(THIRD_PLACE));
        System.out.printf(BONUS_RESULT.getMessage(), SECOND_PLACE.getCount(),
                String.format("%,d", SECOND_PLACE.getAmount()),
                result.get(SECOND_PLACE));
        System.out.printf(RESULT.getMessage(), FIRST_PLACE.getCount(), String.format("%,d", FIRST_PLACE.getAmount()),
                result.get(FIRST_PLACE));
    }

    public void printTotalReturn(float totalReturn) {
        System.out.printf(TOTAL_RETURN.getMessage(), totalReturn);
    }
}
