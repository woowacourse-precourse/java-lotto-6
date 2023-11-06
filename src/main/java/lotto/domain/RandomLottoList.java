package lotto.domain;

import lotto.global.utils.generator.RandomNumberGenerator;

import java.util.List;

public class RandomLottoList {

    private final List<Integer> randomLottoList;

    public RandomLottoList(RandomNumberGenerator randomNumberGenerator) {
        List<Integer> randomList = randomNumberGenerator.generate();
        this.randomLottoList = randomList.stream()
                .sorted()
                .toList();
    }

    public List<Integer> getRandomLottoList() {
        return randomLottoList;
    }
}
