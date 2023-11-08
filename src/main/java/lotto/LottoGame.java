package lotto;

import util.Converter;
import util.Input;
import util.InputValidator;
import util.Output;

import java.util.List;

public class LottoGame {
    public void run() {
        Money money = inputUserMoney();
        Lotteries lotteries = buyLotteriesWithMoney(money);

        WinNumbers winNumbers = inputWinNumbers();

        LottoResult lottoResult = lotteries.countMatchNumbers(winNumbers);
        Output.printWinningStatistics(lottoResult);

        Yield yield = new Yield(lottoResult, money);
        Output.printProfit(yield.ceilYield());
    }

    private Money inputUserMoney() {
        while (true) {
            try {
                String purchaseAmount = Input.purchaseAmount();

                InputValidator.validateDigits(purchaseAmount);
                int money = Integer.parseInt(purchaseAmount);
                InputValidator.validateMinimumMoney(money);

                return new Money(money);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lotteries buyLotteriesWithMoney(Money money) {
        while (true) {
            try {
                int lottoCount = money.calculateLottoCount();
                Output.printCountOfLotteries(lottoCount);

                List<Lotto> lottoList = LottoFactory.newLottoList(lottoCount);
                Lotteries lotteries = new Lotteries(lottoList);
                Output.printAllLotteries(lotteries);

                return lotteries;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private WinNumbers inputWinNumbers() {
        while (true) {
            try {
                List<Integer> winningNumbers = inputWinningNumbers();
                InputValidator.validateDuplicateWinningNumbers(winningNumbers);

                int bonusNumber = inputBonusNumber();
                InputValidator.validateDuplicateBonusNumber(winningNumbers, bonusNumber);

                return new WinNumbers(winningNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<Integer> inputWinningNumbers() {
        while (true) {
            try {
                String inputWinningNumbers = Input.getWinningNumbers();
                List<Integer> winningNumbers = Converter.splitFromString(inputWinningNumbers);

                InputValidator.validateSplitSize(winningNumbers);
                InputValidator.validateWinningNumbersRange(winningNumbers);

                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int inputBonusNumber() {
        while (true) {
            try {
                String inputBonusNumber = Input.getBonusNumber();
                InputValidator.validateDigits(inputBonusNumber);

                int bonusNumber = Integer.parseInt(inputBonusNumber);
                InputValidator.validateBonusNumberRange(bonusNumber);

                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
