package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.LottoWinningNumber;

public class WinningNumberService {
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private final LottoWinningNumber lottoWinningNumber;

    public WinningNumberService() {
        this.lottoWinningNumber = new LottoWinningNumber();
    }

    public void setWinningNumbers(String winningNumbers) {
        validateWinningNumbers(winningNumbers);

        this.winningNumbers = Arrays.stream(winningNumbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        lottoWinningNumber.setWinningNumbers(this.winningNumbers);
    }

    public void setBonusNumbers(String bonusNumber) {
        validateBonusNumbers(bonusNumber);

        this.bonusNumber = Integer.parseInt(bonusNumber.trim());

        lottoWinningNumber.setBonusNumber(this.bonusNumber);
    }

    public LottoWinningNumber getLottoWinningNumber() {
        return lottoWinningNumber;
    }

    private void validateWinningNumbers(String winningNumbers) {
        if (winningNumbers == null || winningNumbers.trim().isEmpty()) {
            throw new IllegalArgumentException("당첨 번호가 입력되지 않았습니다.");
        }
        String[] numbersStr = winningNumbers.split(",");
        for (String numberStr : numbersStr) {
            try {
                Integer.parseInt(numberStr.trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("로또 숫자는 정수만 입력 가능합니다.");
            }
        }
    }

    private void validateBonusNumbers(String bonusNumbers) {
        try {
            Integer.parseInt(bonusNumbers.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("보너스 숫자는 정수만 입력 가능합니다.");
        }
    }

}
