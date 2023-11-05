package lotto.view;

import lotto.dto.LottoNumbers;

import java.util.List;

public class DisplayFormatter {

    public static String formatLottoNumbers(LottoNumbers lottoNumbers) {
        List<Integer> numbers = lottoNumbers.numbers();
        List<String> sortedNumbers = numbers.stream()
                .sorted()
                .map(String::valueOf)
                .toList();
        return "[" + String.join(", ", sortedNumbers) + "]";
    }
}
