package lotto.model;

import java.util.List;

public class AnswerLotto extends Lotto {
    private final LottoNo bonusNo;

    public AnswerLotto(List<Integer> numbers, int bonusNo) {
        super(numbers);
        validate(bonusNo);
        this.bonusNo = new LottoNo(bonusNo);
    }

    private void validate(int bonusNo) {
        if (super.contains(new LottoNo(bonusNo))) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
        }
    }

    @Override
    public boolean isAnswerLotto() {
        return true;
    }

    @Override
    public Score contains(Lotto lotto) {
        return super.contains(lotto)
                .canSecond(lotto.contains(bonusNo));
    }
}
