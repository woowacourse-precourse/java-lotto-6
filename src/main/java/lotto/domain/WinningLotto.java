package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.message.ExceptionMessage;

public record WinningLotto(Lotto lotto, BonusNumber bonus) {
    public WinningLotto {
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

    public Map<Rank, Integer> calculateResult(List<Lotto> lottos) {
        Map<Rank, Integer> result = new HashMap<>();
        result.put(Rank.NO_RANK, 0);
        result.put(Rank.FIFTH, 0);
        result.put(Rank.FOURTH, 0);
        result.put(Rank.THIRD, 0);
        result.put(Rank.SECOND, 0);
        result.put(Rank.FIRST, 0);
        lottos.stream()
                .map(this::match)
                .forEach(rank -> result.put(rank, result.get(rank) + 1));
        return result;
    }

    public Rank match(Lotto userLotto) {
        int matchCount = lotto.getMatchCount(userLotto);
        boolean matchBonus = userLotto.hasNumber(bonus.number());
        if (matchBonus) {
            matchCount += 1;
        }
        return Rank.findByMatchCountAndBonus(matchCount, matchBonus);
    }
}
