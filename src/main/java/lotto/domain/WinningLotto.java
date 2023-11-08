package lotto.domain;

import lotto.message.ExceptionMessage;

public record WinningLotto(Lotto answerLotto, BonusNumber bonus) {
    public WinningLotto {
        validateDuplicate(answerLotto, bonus.number());
    }

    private void validateDuplicate(Lotto lotto, int bonus) {
        if (lotto.hasNumber(bonus)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_LOTTO_NUMBER);
        }
    }

    public ResultSheet calculateResult(Lottos lottos) {
        ResultSheet sheet = new ResultSheet(Rank.createRankRepository());
        lottos.lottoItems()
                .stream()
                .map(this::calculateLottoRank)
                .forEach(sheet::addCountByRank);
        return sheet;
    }

    public Rank calculateLottoRank(Lotto userLotto) {
        int matchCount = answerLotto.getMatchCount(userLotto);
        boolean matchBonus = userLotto.hasNumber(bonus.number());
        if (matchBonus) {
            matchCount += 1;
        }
        return Rank.findByMatchCountAndBonus(matchCount, matchBonus);
    }
}
