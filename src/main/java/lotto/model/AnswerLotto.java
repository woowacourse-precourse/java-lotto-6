package lotto.model;

import java.util.List;

public class AnswerLotto extends Lotto {
    private static final String NO_DUPLICATE_BONUS_NUMBER_IN_WINNING_NUMBER = "보너스 번호는 당첨 번호와 중복되지 않아야 합니다.";
    private LottoNo bonusNo;

    public AnswerLotto(List<Integer> numbers) {
        super(numbers);
    }

    public void registerBonusNo(int bonusNo) {
        validate(bonusNo);
        this.bonusNo = new LottoNo(bonusNo);
    }

    private void validate(int bonusNo) {
        if (super.contains(new LottoNo(bonusNo))) {
            throw new IllegalArgumentException(NO_DUPLICATE_BONUS_NUMBER_IN_WINNING_NUMBER);
        }
    }

    @Override
    public boolean isAnswerLotto() {
        return true;
    }

    @Override
    public Score contains(Lotto lotto) {
        return super.contains(lotto)
                .convertSecondIfPossible(lotto.contains(bonusNo));
    }
}
