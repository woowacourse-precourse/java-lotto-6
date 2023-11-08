package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public LottoResult getResult(List<Integer> luckyNumbers, Integer bonusNumber) {
        int hitCount = 0;

        validate(luckyNumbers);

        for (Integer luckyNumber : luckyNumbers) {
            if (numbers.contains(luckyNumber)) {
                hitCount++;
            }
        }

        if(hitCount == 6) {
            return LottoResult.FIRST;
        }
        if(hitCount == 5 && numbers.contains(bonusNumber)) {
            return LottoResult.SECOND;
        }
        if(hitCount == 5) {
            return LottoResult.THIRD;
        }
        if(hitCount == 4) {
            return LottoResult.FOURTH;
        }
        if(hitCount == 3) {
            return LottoResult.FIFTH;
        }
        return LottoResult.FAIL;
    }
}
