package lotto.controller.input;

import lotto.model.BonusNumber;
import lotto.model.Price;
import lotto.model.WinningNumber;

import java.util.List;

import static lotto.controller.input.InputConverter.convertDigit;
import static lotto.controller.input.InputConverter.convertWinningNum;
import static lotto.controller.input.InputHandler.*;
import static lotto.exception.BonusException.bonusException;
import static lotto.exception.PriceException.priceException;
import static lotto.exception.WinningException.winningException;
import static lotto.view.Message.*;

public class createObject {
    public static Price createPrice() {
        while(true) {
            messageAboutPrice();
            String tmpPrice = inputPrice();
            try {
                return priceException(convertDigit(tmpPrice));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static WinningNumber createWinningNumber() {
        while(true) {
            messageAboutUserLottoNumber();
            String tmpWinningNumbers = inputWinningNumbers();
            try {
                return winningException(convertWinningNum(tmpWinningNumbers), tmpWinningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static BonusNumber createBonusNumber(List<Integer> numbers) {
        System.out.println();
        while(true) {
            messageAboutUserBonusNumber();
            String tmpBonusNumber = inputBonusNumber();
            try {
                return bonusException(numbers, convertDigit(tmpBonusNumber));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
