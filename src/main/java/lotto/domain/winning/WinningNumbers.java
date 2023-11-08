package lotto.domain.winning;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.rank.Rank;
import lotto.domain.winning.validator.WinningNumbersValidator;
import lotto.dto.WinningNumbersDto;

public class WinningNumbers {

    private final Lotto lotto;
    private final int bonusNumber;

    public WinningNumbers(final List<Integer> numbers, final int bonusNumber) {
        WinningNumbersValidator.validateWinningNumbers(numbers, bonusNumber);
        this.lotto = new Lotto(numbers);
        this.bonusNumber = bonusNumber;
    }

    public WinningNumbersDto getWinningNumbersStatus() {
        return new WinningNumbersDto(lotto.getNumbers(), bonusNumber);
    }

    public List<Rank> calculateRanks(final Lottos lottos) {
        return lottos.calculateRanks(this.lotto, this.bonusNumber);
    }
}
