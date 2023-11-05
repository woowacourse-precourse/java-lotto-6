package lotto.domain;

import java.util.List;

public record LottoData(List<Integer> winningNumbers, int bonusNumber) {

    public LottoData(List<Integer> winningNumbers, int bonusNumber) {
        validatewinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validatewinningNumbers(List<Integer> winningNumbers) {
        // TODO: 6개의 숫자가 아니면 예외 발생
        // TODO: 1~45 사이의 숫자가 아니면 예외 발생
        // TODO: 중복된 숫자가 있으면 예외 발생
    }

    private void validateBonusNumber(int bonusNumber) {
        // TODO: 1~45 사이의 숫자가 아니면 예외 발생
        // TODO: 당첨 번호에 포함되는 숫자면 예외 발생
    }
}
