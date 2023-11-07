package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoPurchase {
    private final int LottoPurchaseCnt;
    private final List<List<Integer>> RandomNumbers;

    public LottoPurchase(int LottoPurchaseCnt){
        validate(LottoPurchaseCnt);
        this.LottoPurchaseCnt = LottoPurchaseCnt;
        this.RandomNumbers = generateRandomNumbers();
    }

    private void validate(int LottoPurchaseCnt) {
        return;
    }

    private List<List<Integer>> generateRandomNumbers() {
        List<List<Integer>> RandomNumbers = new ArrayList<>();

        for(int i = 0; i < this.LottoPurchaseCnt; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            RandomNumbers.add(numbers);
        }
        return RandomNumbers;

    }

}
