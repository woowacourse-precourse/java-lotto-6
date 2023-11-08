package lotto.view;

import static lotto.constant.OutputMessage.LOTTO_FORMAT;
import static lotto.constant.OutputMessage.LOTTO_NUMBERS_SEPARATOR;
import static lotto.constant.OutputMessage.LOTTO_RESULT_FORMAT;
import static lotto.constant.OutputMessage.NUMBER_OF_LOTTO;
import static lotto.constant.OutputMessage.RATE_OF_RETURN_FORMAT;
import static lotto.constant.OutputMessage.RESULT;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.Ranking;
import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final int HUNDRED_FOR_PERCENTAGE = 100;

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }

    public static void printLottos(Lottos userLottos) {
        List<Lotto> lottos = userLottos.getLottos();
        System.out.println(String.format(NUMBER_OF_LOTTO, lottos.size()));
        lottos.stream().forEach(OutputView::printLottoNumbers);
    }

    private static void printLottoNumbers(Lotto lotto) {
        String numbers = lotto.getNumbers().stream()
                .sorted().map(LottoNumber::toString)
                .collect(Collectors.joining(LOTTO_NUMBERS_SEPARATOR));
        System.out.println(String.format(LOTTO_FORMAT, numbers));
    }

    public static void printResult(EnumMap<Ranking, Integer> result, double rateOfReturn) {
        System.out.println(RESULT);
        result.entrySet().stream()
                .filter(entry -> entry.getKey() != Ranking.FAIL)
                .forEach(
                        entry -> {
                            Ranking ranking = entry.getKey();
                            Integer count = entry.getValue();
                            System.out.println(String.format(LOTTO_RESULT_FORMAT, ranking.getDescription(), count));
                        }
                );
        System.out.println(String.format(RATE_OF_RETURN_FORMAT, rateOfReturn * HUNDRED_FOR_PERCENTAGE));
    }
}
