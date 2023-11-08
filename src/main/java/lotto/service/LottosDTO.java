package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottosDTO {
    List<List<Integer>> numbers;

    public static LottosDTO from(Lottos lottos) {
        return new LottosDTO(lottos);
    }

    public LottosDTO(Lottos lottos) {
        this.numbers = lottos.getLottos()
                .stream()
                .map(Lotto::getNumbers)
                .collect(Collectors.toList());
    }

    public List<List<Integer>> getNumbers() {
        return numbers;
    }
}
