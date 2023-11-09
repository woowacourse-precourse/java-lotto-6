package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoResult {
    private final int lottoPurchaseCnt;
    private final List<Integer> numbers;
    private final List<List<Integer>> randomNumbers;



    private final List<Integer> lottoResult;

    private final List<Boolean> bonusCheck;


    public List<Integer> getLottoResult() {
        return lottoResult;
    }

    public List<Boolean> getBonusCheck() {
        return bonusCheck;
    }

    private final int bonusNumber;

    public LottoResult(List<Integer> numbers, List<List<Integer>> randomNumbers, int lottoPurchaseCnt, int bonusNumber) {
        this.lottoPurchaseCnt = lottoPurchaseCnt;
        this.numbers = numbers;
        this.randomNumbers = randomNumbers;
        this.bonusNumber = bonusNumber;

        this.lottoResult = cmpLotto();
        this.bonusCheck = bounusNumberCheck();
    }

    private List<Integer> cmpLotto() {
        List<Integer> lottoResult = new ArrayList<>();

        for(int i = 0; i < lottoPurchaseCnt; i++) {
            int result = 0;
            for (int j = 0; j < 6; j++) {
                if (randomNumbers.get(i).contains(numbers.get(j))) {
                    result++;
                }
            }
            if (result >= 3)
                lottoResult.add(result);
        }

        return lottoResult;
    }

    private List<Boolean> bounusNumberCheck() {
        List<Boolean> bonusCheck = new ArrayList<>();

        for(int i = 0; i < lottoPurchaseCnt; i++) {
            boolean result = false;
            for (int j = 0; j < 6; j++) {
                if (Objects.equals(bonusNumber, randomNumbers.get(i).get(j))) {
                    result = true;
                }
            }
            bonusCheck.add(result);
        }

        return bonusCheck;
    }

}
