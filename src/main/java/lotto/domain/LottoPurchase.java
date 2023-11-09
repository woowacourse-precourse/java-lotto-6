package lotto.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoPurchase {


    private final int LottoPurchaseCnt;
    private final List<List<Integer>> randomNumbers;


    public List<List<Integer>> getRandomNumbers() {
        return randomNumbers;
    }

    public int getLottoPurchaseCnt() {
        return LottoPurchaseCnt;
    }

    public LottoPurchase(int LottoPurchase){
        validate(LottoPurchase);
        this.LottoPurchaseCnt = LottoPurchase / 1000;
        this.randomNumbers = generateRandomNumbers();
    }

    private void validate(int LottoPurchaseCnt) {
        return;
    }

    private List<List<Integer>> generateRandomNumbers() {
        List<List<Integer>> randomNumbers = new ArrayList<>();

        for(int i = 0; i < this.LottoPurchaseCnt; i++) {
            List<Integer> numbers =  new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            numbers.sort(Comparator.naturalOrder());
            randomNumbers.add(numbers);
        }
        return randomNumbers;

    }

}
