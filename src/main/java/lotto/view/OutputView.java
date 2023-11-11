package lotto.view;

import lotto.domain.Constants;

public class OutputView {
    public void printLottos(String lottoList, Integer lottoSize) {
        System.out.printf((Constants.PRINT_LOTTO_LIST) + "\n", lottoSize);
        System.out.println(lottoList + "\n");
    }

    public void printWinningStatic(String winningStatic) {
        System.out.println(Constants.PRINT_WINNING_STATIC);
        System.out.println(winningStatic);
    }

    public void printRateOfReturn(Double makeOfReturn) {
        System.out.printf(Constants.PRINT_RATE_OF_RETURN, makeOfReturn);
    }

    public void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }
}
