package lotto.domain;

import lotto.message.ExceptionMessage;

public record AnswerLotto(Lotto lotto, BonusNumber bonus) {
    public AnswerLotto {
        validate(lotto, bonus.number());
    }

    private void validate(Lotto lotto, int bonus) {
        validateDuplicate(lotto, bonus);
    }


    private void validateDuplicate(Lotto lotto, int bonus) {
        if (lotto.hasNumber(bonus)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_LOTTO_NUMBER);
        }
    }

    public Rank calculateRank(Lotto userLotto) {
        int matchCount = lotto.getMatchCount(userLotto);
        boolean matchBonus = userLotto.hasNumber(bonus.number());
        if (matchBonus) {
            matchCount += 1;
        }
        return Rank.findByMatchCountAndBonus(matchCount, matchBonus);
    }
}
