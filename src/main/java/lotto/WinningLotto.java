package lotto;

import java.util.Optional;

public class WinningLotto {

    private static final String ERROR_BONUS_NUMBER_IN_WINNING_NUMBERS = "[ERROR] 보너스 번호는 당첨 번호와 중복되면 안됩니다.";
    private final Lotto winningLottoTicket;
    private final int bonusNumber;

    public WinningLotto(Lotto winningLottoTicket, int bonusNumber) {
        LottoCondition.validateIsInRange(bonusNumber);
        validateIsBonusNumberNotInWinningNumbers(winningLottoTicket, bonusNumber);
        this.winningLottoTicket = winningLottoTicket;
        this.bonusNumber = bonusNumber;
    }

    public Optional<LottoRank> calculateRank(Lotto lottoTicket) {
        int matchCount = winningLottoTicket.countMatchNumber(lottoTicket);
        boolean isMatchBonusNumber = lottoTicket.contains(bonusNumber);
        return LottoRank.valueOf(matchCount, isMatchBonusNumber);
    }

    private void validateIsBonusNumberNotInWinningNumbers(Lotto winningLottoTicket, int bonusNumber) {
        if (winningLottoTicket.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_BONUS_NUMBER_IN_WINNING_NUMBERS);
        }
    }
}
