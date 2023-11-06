package lotto.domain;

import lotto.global.utils.generator.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
