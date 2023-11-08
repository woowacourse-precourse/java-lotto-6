package lotto;

import lotto.domain.*;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Generator generator = new Generator();
        WinningNumber winningNumber = new WinningNumber();
        BonusNumber bonusNumber = new BonusNumber();
        Judge judge = new Judge();

        List<Lotto> generatedLottery = generator.getAmountOfMoney();

        winningNumber.createWinningNumber();
        bonusNumber.createBonusNumber(winningNumber.getWinningNumbers());

        judge.calculateResult(generatedLottery, winningNumber.getWinningNumbers(), bonusNumber.getBONUS_NUMBER());
        judge.calculateProfit();
    }
}
