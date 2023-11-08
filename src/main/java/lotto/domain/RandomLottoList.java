package lotto.domain;

import lotto.global.utils.generator.NumberGenerator;

import java.util.List;

public class RandomLottoList {

    private final List<Integer> randomLottoList;

    public RandomLottoList(NumberGenerator numberGenerator) {
        List<Integer> randomList = numberGenerator.generate();
        this.randomLottoList = randomList.stream()
                .sorted()
                .toList();
    }

    public List<Integer> getRandomLottoList() {
        return randomLottoList;
    }
}
