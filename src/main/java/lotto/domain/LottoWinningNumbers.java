package lotto.domain;

import lotto.dto.LottoTickets;
import lotto.dto.WinningMatchResult;
import java.util.List;
import java.util.Optional;

public class LottoWinningNumbers {
    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    private LottoWinningNumbers(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static LottoWinningNumbers createWinningNumbers(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        validateDuplicateBonusNumber(winningNumbers, bonusNumber);
        return new LottoWinningNumbers(winningNumbers, bonusNumber);
    }

    private static void validateDuplicateBonusNumber(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        bonusNumber.exceptionIfDuplicate(winningNumbers);
    }

    public List<LottoWinningTier> calculateWinningStatistics(LottoTickets lottoTickets) {
        return lottoTickets.getLottoTickets()
                .stream()
                .map(this::calculateWinningMatchResult)
                .map(LottoWinningTier::calculateTier)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }

    private WinningMatchResult calculateWinningMatchResult(Lotto lotto) {
        int matchCount = winningNumbers.calculateMatchCount(lotto);
        boolean matchBonus = bonusNumber.isMatch(lotto);
        return new WinningMatchResult(matchCount, matchBonus);
    }
}
