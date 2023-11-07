package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoResult {
    private final int LottoPurchaseCnt;
    private final List<Integer> numbers;
    private final List<List<Integer>> RandomNumbers;
    private final List<Integer> LottoResult;

    public LottoResult(List<Integer> numbers, List<List<Integer>> RandomNumbers, int LottoPurchaseCnt) {
        this.LottoPurchaseCnt =LottoPurchaseCnt;
        this.numbers = numbers;
        this.RandomNumbers = RandomNumbers;
        this.LottoResult = cmpLotto();
    }

    private List<Integer> cmpLotto() {
        List<Integer> LottoResult = new ArrayList<>();

        for(int i = 0; i < LottoPurchaseCnt; i++) {
            int result = 0;
            for (int j = 0; j < 6; j++) {
                if (Objects.equals(numbers.get(j), RandomNumbers.get(i).get(j))) {
                    result++;
                }
            }
            LottoResult.add(result);
        }

        return LottoResult;
    }

}
