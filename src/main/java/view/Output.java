package view;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Lotto;

public class Output {
    private static final String PURCHASE_AMOUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String LOTTO_NUMBERS_SEPARATOR = "[%s]";
    private static final String LOTTO_NUMBERS_JOIN_SEPARATOR = ", ";
    private static final String LINE_BREAK = "\n";

    public static void getLottoNumbers(List<Lotto> lottoList) {
        System.out.printf(LINE_BREAK + PURCHASE_AMOUNT_MESSAGE + LINE_BREAK, lottoList.size());
        lottoList.forEach(lotto -> {
            List<Integer> numbers = lotto.getNumbers();
            String lottoNumbers = formatLottoNumbers(numbers);
            System.out.printf(LOTTO_NUMBERS_SEPARATOR + LINE_BREAK, lottoNumbers);
        });
    }

    private static String formatLottoNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(LOTTO_NUMBERS_JOIN_SEPARATOR));
    }
}
