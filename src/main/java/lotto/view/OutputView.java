package lotto.view;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.dto.LottoDto;
import lotto.dto.LottosDto;
import lotto.dto.ResultDto;
import lotto.view.message.Prompt;
import lotto.view.message.Rank;

public class OutputView {
    private static final String PURCHASE_COUNT_FORMAT = "%d개를 구매했습니다.";
    private static final String RESULT_FORMAT = "%s - %d개\n";
    private static final String DECIMAL_FORMAT = "0.#";
    private static final String RETURN_RATE_FORMAT = "총 수익률은 %s%%입니다.";
    private static final String COMMA_DELIMITER = ", ";
    private static final String LEFT_SQUARE_BRACKET = "[";
    private static final String RIGHT_SQUARE_BRACKET = "]";
    private static final String NEW_LINE = "\n";

    public static void printMessage(String outputValue) {
        System.out.println(outputValue);
    }

    public static void printLottos(LottosDto lottosDto) {
        printLottoCount(lottosDto.getCountOfPurchase());
        lottosDto.getLottoDtos().forEach(OutputView::printLottoNumbers);
    }

    public static void printResult(ResultDto resultDto) {
        printMessage(Prompt.WINNING_STATISTIC.getMessage());
        printMessage(Prompt.SEPERATOR_LINE.getMessage());
        printLottoResults(resultDto.getPrizeResult());
        printLottoReturnRate(resultDto.getReturnRate());
    }

    private static void printLottoCount(Integer numberOfPurchase) {
        System.out.println(NEW_LINE + String.format(PURCHASE_COUNT_FORMAT, numberOfPurchase));
    }

    private static void printLottoNumbers(LottoDto lottoDto) {
        String lottoMessage = sortLottoNumbers(lottoDto.getLottoNumbers()).stream()
                .map(String::valueOf)
                .collect(Collectors.joining(COMMA_DELIMITER));
        System.out.println(LEFT_SQUARE_BRACKET + lottoMessage + RIGHT_SQUARE_BRACKET);
    }

    private static List<Integer> sortLottoNumbers(List<Integer> lottoNumbers) {
        List<Integer> sortedLottoNumbers = new ArrayList<>(lottoNumbers);
        Collections.sort(sortedLottoNumbers);
        return sortedLottoNumbers;
    }

    public static void printLottoResults(List<Integer> lottoResult) {
        for (Rank rank : Rank.values()) {
            System.out.printf(String.format(RESULT_FORMAT, rank.getDescription(), lottoResult.get(rank.getIndex())));
        }
    }

    private static void printLottoReturnRate(Double returnRate) {
        DecimalFormat format = new DecimalFormat(DECIMAL_FORMAT);
        System.out.printf(RETURN_RATE_FORMAT, format.format(returnRate));
    }
}
