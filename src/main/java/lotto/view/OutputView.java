package lotto.view;

import lotto.dto.LottoNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OutputView {

    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] ";
    private static final String PRINT_BOUGHT_LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String PRINT_BOUGHT_LOTTO_NUMBER_START_BOX = "[";
    private static final String PRINT_BOUGHT_LOTTO_NUMBER_END_BOX = "]";
    private static final String LOTTO_NUMBERS_DELIMITER = ", ";

    public static void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_MESSAGE_FORMAT + errorMessage);
    }

    public static void printBuyLottoResultMessage(List<LottoNumbers> lottoNumbers) {
        printBuyLottoCount(lottoNumbers.size());
        lottoNumbers.forEach(numbers -> printLottoNumbers(numbers.numbers()));
    }

    private static void printBuyLottoCount(int buyLottoCount) {
        System.out.println(buyLottoCount + PRINT_BOUGHT_LOTTO_COUNT_MESSAGE);
    }

    private static void printLottoNumbers(List<Integer> lottoNumbers) {
        System.out.print(PRINT_BOUGHT_LOTTO_NUMBER_START_BOX
                + convertNumberToOutputValue(lottoNumbers)
                + PRINT_BOUGHT_LOTTO_NUMBER_END_BOX
        );
        System.out.println();
    }

    private static String convertNumberToOutputValue(List<Integer> numbers) {
        Collections.sort(new ArrayList<>(numbers));
        List<String> convertValues = numbers.stream()
                .map(String::valueOf)
                .toList();

        return String.join(LOTTO_NUMBERS_DELIMITER, convertValues);
    }
}
