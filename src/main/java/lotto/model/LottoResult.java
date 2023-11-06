package lotto.model;

import java.util.List;

public class LottoResult {
    private static final int MIN_CORRECT_COUNT = 3;
    private static final int SECOND_GRADE_NUMBER_COUNT = 5;
    private static final String BONUS_GRADE = "+";
    private final Lotto winningLottoTicket;
    private final int bonusNumber;

    public LottoResult(final List<Integer> numbers, final int inputBonusNumber, final LottoManager lottoManager) {
        winningLottoTicket = lottoManager.createWinningLottoTicket(numbers);
        bonusNumber = lottoManager.createBonusNumber(winningLottoTicket, inputBonusNumber);
    }

    public LottoGrade calculateGrade(final Lotto lottoTicket) {
        final long winningNumberCount = lottoTicket.winningNumberCount(winningLottoTicket);
        if (isNotValidWinningNumberCount(winningNumberCount)) {
            return null;
        }
        final String grade = generateGrade(lottoTicket, winningNumberCount);
        return LottoGrade.from(grade);
    }

    private boolean isNotValidWinningNumberCount(final long winningNumberCount) {
        return winningNumberCount < MIN_CORRECT_COUNT;
    }

    private String generateGrade(final Lotto lottoTicket, final long winningNumberCount) {
        final StringBuilder sb = new StringBuilder();
        sb.append(winningNumberCount);
        if (isSecondGrade(lottoTicket, winningNumberCount)) {
            sb.append(BONUS_GRADE);
        }
        return sb.toString();
    }

    private boolean isSecondGrade(final Lotto lottoTicket, final long winningNumberCount) {
        return (winningNumberCount == SECOND_GRADE_NUMBER_COUNT) && (lottoTicket.isContainsNumber(bonusNumber));
    }
}
