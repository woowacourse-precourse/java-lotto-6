package lotto.service;

import java.util.ArrayList;
import java.util.List;

public class LotterySeller {
    public List<List<Integer>> createLottoCount(int count) {
        List<List<Integer>> randomNumbers = new ArrayList<>();
        NumberGenerator numberGenerator = new NumberGenerator();

        for (int i = 0; i < count; i++) {
            randomNumbers.add(numberGenerator.creatRandomNumbers());
        }
        return randomNumbers;
    }
}
