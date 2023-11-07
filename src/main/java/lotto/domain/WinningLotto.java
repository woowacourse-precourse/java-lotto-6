package lotto.domain;

import java.util.List;
import java.util.Map;
import lotto.message.ExceptionMessage;

public record WinningLotto(Lotto lotto, BonusNumber bonus) {
    public WinningLotto {
        validateDuplicate(lotto, bonus.number());
    }

    private void validateDuplicate(Lotto lotto, int bonus) {
        if (lotto.hasNumber(bonus)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_LOTTO_NUMBER);
        }
    }

    public ResultSheet calculateResult(List<Lotto> lottos) {
        Map<Rank, Integer> sheet = Rank.createNewSheet();
        lottos.stream()
                .map(this::calculateLottoRank)
                .forEach(rank -> addCountByRank(sheet, rank));
        return new ResultSheet(sheet);
    }

    private void addCountByRank(Map<Rank, Integer> resultSheet, Rank rank) {
        resultSheet.put(rank, resultSheet.get(rank) + 1);
    }

    public Rank calculateLottoRank(Lotto userLotto) {
        int matchCount = lotto.getMatchCount(userLotto);
        boolean matchBonus = userLotto.hasNumber(bonus.number());
        if (matchBonus) {
            matchCount += 1;
        }
        return Rank.findByMatchCountAndBonus(matchCount, matchBonus);
    }
}
