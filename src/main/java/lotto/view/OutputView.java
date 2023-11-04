package lotto.view;

import java.util.stream.Collectors;
import lotto.dto.LottoDto;
import lotto.dto.LottosDto;

public class OutputView {
    private static final String PURCHASE_COUNT_FORMAT = "%d개를 구매했습니다.";
    private static final String COMMA_DELIMETER = ", ";
    private static final String LEFT_SQUARE_BRACKET = "[";
    private static final String RIGHT_SQUARE_BRACKET = "]";
    private static final String NEW_LINE = "\n";

    public static void printMessage(String outputValue) {
        System.out.println(outputValue);
    }

    public static void printLottos(LottosDto lottosDto) {
        printMessage(getPurchaseCount(lottosDto.getCountOfPurchase()));
        lottosDto.getLottoDtos().forEach(OutputView::printLottoNumbers);
    }

    private static String getPurchaseCount(Integer numberOfPurchase) {
        return NEW_LINE + String.format(PURCHASE_COUNT_FORMAT, numberOfPurchase);
    }

    private static void printLottoNumbers(LottoDto lottoDto) {
        String lottoNumbers = lottoDto.getLottoNumbers().stream()
                .map(String::valueOf)
                .collect(Collectors.joining(COMMA_DELIMETER));
        printMessage(LEFT_SQUARE_BRACKET + lottoNumbers + RIGHT_SQUARE_BRACKET);
    }
}
