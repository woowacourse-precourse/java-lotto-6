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
            throw new IllegalArgumentException();
        }
        String[] numbersStr = winningNumbers.split(",");
        for (String numberStr : numbersStr) {
            try {
                Integer.parseInt(numberStr.trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateBonusNumbers(String bonusNumbers) {
        try {
            Integer.parseInt(bonusNumbers.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

}
