package lotto.domain;

import lotto.global.utils.generator.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLottoList {

    private final List<Integer> randomLottoList;
    private final int bonusNumber;

    public RandomLottoList(RandomNumberGenerator randomNumberGenerator) {
        List<Integer> randomLottoListAndBonusNumber = randomNumberGenerator.generate();
        this.bonusNumber = randomLottoListAndBonusNumber.get(6);
        randomLottoListAndBonusNumber.remove(6);
        Collections.sort(randomLottoListAndBonusNumber);
        this.randomLottoList = randomLottoListAndBonusNumber;
    }

    public List<Integer> getRandomLottoList() {
        return randomLottoList;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
