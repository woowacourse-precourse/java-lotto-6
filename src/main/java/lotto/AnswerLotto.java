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
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE_LOTTO_NUMBER);
        }
    }

    private void validateDuplicate(Lotto lotto, int bonus) {
        if (lotto.hasNumber(bonus)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_LOTTO_NUMBER);
        }
    }

    public Rank calculateRank(Lotto userLotto) {
        int matchCount = lotto.getMatchCount(userLotto);
        boolean matchBonus = userLotto.hasNumber(bonus);
        if (matchBonus) {
            matchCount += 1;
        }
        return Rank.findByMatchCountAndBonus(matchCount, matchBonus);
    }
}
