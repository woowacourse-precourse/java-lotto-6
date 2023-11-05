package lotto;

public record AnswerLotto(Lotto lotto, int bonus) {
    public AnswerLotto {
        validate(lotto, bonus);
    }

    private void validate(Lotto lotto, int bonus) {
        validateBonusInRange(bonus);
        validateDuplicate(lotto, bonus);
    }

    private void validateBonusInRange(int bonus) {
        if (bonus < LottoOption.LOTTO_MIN_NUMBER ||
                bonus > LottoOption.LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(Lotto lotto, int bonus) {
        if (lotto.hasNumber(bonus)) {
            throw new IllegalArgumentException();
        }
    }
}
