package lotto.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.dto.LottoDto;
import lotto.dto.LottosDto;
import lotto.dto.ResultDto;

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
        printMessage(toMessage(lottosDto.getCountOfPurchase()));
        lottosDto.getLottoDtos().forEach(OutputView::printLottoNumbers);
    }

    public static void printResult(ResultDto resultDto) {
        
    }

    private static String toMessage(Integer numberOfPurchase) {
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
}
