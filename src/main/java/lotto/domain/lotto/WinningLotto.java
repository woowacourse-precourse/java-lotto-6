package lotto.domain.lotto;

import lotto.domain.number.LottoNumber;
import lotto.domain.number.LottoNumbers;
import lotto.domain.Result;

import java.util.List;

public class WinningLotto {

    private final LottoNumbers numbers;
    private final LottoNumber bonus;

    public WinningLotto(LottoNumbers numbers, LottoNumber bonus) {
        this.validateDuplicate(numbers, bonus);
        this.numbers = numbers;
        this.bonus = bonus;
    }

    private void validateDuplicate(LottoNumbers numbers, LottoNumber bonus) {
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException("보너스 번호는 중복될 수 없음");
        }
    }

    public Result evaluateLottoResult(List<Integer> numbers) {
        int hitCount = this.numbers.getHitCount(numbers);
        boolean isHitBonus = bonus.isHit(numbers);

        return Result.matchFrom(hitCount, isHitBonus);
    }
}
