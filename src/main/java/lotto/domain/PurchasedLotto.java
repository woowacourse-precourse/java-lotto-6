package lotto.domain;

import static lotto.config.LottoConfig.SECOND_PRIZE_MATCH_COUNT;

import java.util.List;
import lotto.dto.PurchasedLottoDto;
import lotto.dto.WinningLottoDto;
import lotto.observer.Observer;
import lotto.service.LottoRank;

public class PurchasedLotto extends Lotto implements Observer {
    private LottoRank rank;
    public PurchasedLotto(List<Integer> numbers) {
        super(numbers);
    }

    public PurchasedLottoDto toDto() {
        return new PurchasedLottoDto(getNumbers(), rank);
    }

    private int countMatches(List<Integer> winningNumber, List<Integer> numbers) {
        return (int) winningNumber.stream()
                .filter(numbers::contains)
                .count();
    }

    private boolean matchBonus(int matchCount, int bonusNumber, List<Integer> numbers) {
        if (matchCount == SECOND_PRIZE_MATCH_COUNT.getValue()) {
            return numbers.stream()
                    .anyMatch(number -> number == bonusNumber);
        }
        return false;
    }

    @Override
    public void compare(WinningLottoDto dto) {
        int matchCount = countMatches(dto.numbers(), getNumbers());
        boolean hasBonusMatched = matchBonus(matchCount, dto.bonusNumber(), getNumbers());

        rank = LottoRank.valueOf(matchCount, hasBonusMatched);
    }
}
