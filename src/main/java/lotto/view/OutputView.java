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

public class OutputView {
    private static final String PURCHASE_COUNT_FORMAT = "%d개를 구매했습니다.";
    private static final String COMMA_DELIMITER = ", ";
    private static final String LEFT_SQUARE_BRACKET = "[";
    private static final String RIGHT_SQUARE_BRACKET = "]";
    private static final String NEW_LINE = "\n";

    public static void printMessage(String outputValue) {
        System.out.println(outputValue);
    }

    public static void printLottos(LottosDto lottosDto) {
        printMessage(lottoToMessage(lottosDto.getCountOfPurchase()));
        lottosDto.getLottoDtos().forEach(OutputView::printLottoNumbers);
    }

    public static void printResult(ResultDto resultDto) {
        printMessage(Prompt.WINNING_STATISTIC.getMessage());
        printMessage(Prompt.SEPERATOR_LINE.getMessage());
        printLottoResult(resultDto.getPrizeResult());
        printLottoReturnRate(resultDto.getReturnRate());
    }

    private static String lottoToMessage(Integer numberOfPurchase) {
        return NEW_LINE + String.format(PURCHASE_COUNT_FORMAT, numberOfPurchase);
    }

    private static void printLottoNumbers(LottoDto lottoDto) {
        String lottoMessage = sortLottoNumbers(lottoDto.getLottoNumbers()).stream()
                .map(String::valueOf)
                .collect(Collectors.joining(COMMA_DELIMITER));
        printMessage(LEFT_SQUARE_BRACKET + lottoMessage + RIGHT_SQUARE_BRACKET);
    }

    private static List<Integer> sortLottoNumbers(List<Integer> lottoNumbers) {
        List<Integer> sortedLottoNumbers = new ArrayList<>(lottoNumbers);
        Collections.sort(sortedLottoNumbers);
        return sortedLottoNumbers;
    }

    private static void printLottoResult(List<Integer> lottoResult) {
        System.out.printf("3개 일치 (5,000원) - %d개\n", lottoResult.get(4));
        System.out.printf("4개 일치 (50,000원) - %d개\n", lottoResult.get(3));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", lottoResult.get(2));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", lottoResult.get(1));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", lottoResult.get(0));
    }

    private static void printLottoReturnRate(Double returnRate) {
        DecimalFormat format = new DecimalFormat("0.##");
        System.out.printf("총 수익률은 %s%%입니다.", format.format(returnRate));
    }
}
