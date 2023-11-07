package lotto.service;

import lotto.domain.WinningNumbers;

public class WinningNumbersService {

    public WinningNumbers generateWinningNumbers(String WinningNum) {
        validateWinningNumbers(WinningNum);
        return new WinningNumbers(WinningNum);
    }

    public void setBonusNumber(WinningNumbers winningNumbers, String bunsNum) {
        validateBonusNumber(bunsNum);
        winningNumbers.setBonusNumber(Integer.parseInt(bunsNum));
    }

    private void validateWinningNumbers(String str) {
        // 당첨 번호 유효성 검사

    }

    private void validateBonusNumber(String str) {
        // 보너스 번호 유효성 검사

    }

}