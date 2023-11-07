package lotto.model;

import static lotto.util.LottoNumbersGenerator.generateLottoNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    private final List<List<Integer>> lottoNumbers = new ArrayList<>();

    private List<Integer> sortedLottoNumbers() {
        return generateLottoNumbers().stream()
                .sorted()
                .collect(Collectors.toList());
    }

}
