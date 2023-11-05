package lotto.controller;

import lotto.domain.InputPurchaseAmount;
import lotto.domain.InputWinningNum;
import lotto.views.Exceptions;

import java.util.List;

public class ReadWinningNum {
    public static boolean isWinningNumTypeOfInput(String winningNum) {
        try {
            InputWinningNum.inputWinningNumNotInt(winningNum);
            return false;
        } catch (IllegalArgumentException e) {
            Exceptions.exceptionNotTypeOfWinningInput();
            return true;
        }
    }

}
