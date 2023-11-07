package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    private final List<List<Lotto>> lottoNumbers = new ArrayList<>();

    private List<Integer> createLottoNumbers() {
        return Lotto.generateLotto().stream()
                .sorted()
                .collect(Collectors.toList());
    }

}
