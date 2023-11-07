package lotto.service;

import lotto.model.domain.WinningNumber;

public class WinningNumberService {

    public WinningNumber getWinningNumberIfValid(String winningNumbers) {
        try {
            return new WinningNumber(winningNumbers);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
