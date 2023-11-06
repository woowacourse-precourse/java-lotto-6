package lotto.domain;

import java.util.List;

public class WinningLotto extends Lotto {

    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;
    
    private static final String LOTTO_RANGE_ERROR_MESSAGE = "보너스 번호의 숫자 범위는 1~45까지 입니다.";
    private static final String BONUS_NUMBER_IN_WINNING_NUMBERS_ERROR_MESSAGE = "보너스 번호는 당첨 번호에 없는 수여야 합니다.";

    private List<Integer> winningNumbers;
    private int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        super(winningNumbers);
        validateBonusNumberInRange(bonusNumber);
        validateBonusNumberInWinningNumbers(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Rank getRank(Lotto playerLotto) {
        int matchNumber = playerLotto.compareWinningLottoNumbers(winningNumbers);
        boolean isCorrectBonusNumber = playerLotto.isCorrectBonusNumber(bonusNumber);

        return Rank.getRank(matchNumber, isCorrectBonusNumber);
    }

    private void validateBonusNumberInRange(int bonusNumber) {
        if (bonusNumber > MAX_NUMBER || bonusNumber < MIN_NUMBER)
            throw new IllegalArgumentException(LOTTO_RANGE_ERROR_MESSAGE);
    }

    private void validateBonusNumberInWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber))
            throw new IllegalArgumentException(BONUS_NUMBER_IN_WINNING_NUMBERS_ERROR_MESSAGE);
    }
}