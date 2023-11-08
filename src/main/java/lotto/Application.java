package lotto;

import static lotto.Enum.InputMessage.INPUT_BONUS_NUMBER;
import static lotto.Enum.InputMessage.INPUT_PURCHASE_AMOUNT;
import static lotto.Enum.InputMessage.INPUT_WINNING_NUMBERS;
import static lotto.Enum.OutputMessage.WINNING_STATISTICS;
import static lotto.Enum.Number.THOUSAND;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.Enum.OutputMessage;

public class Application {
    public static void main(String[] args) {
        String input;
        int money;
        List<Integer> winningNumbers;
        List<Lotto> publishedLotto;

        while (true) {
            try {
                System.out.println(INPUT_PURCHASE_AMOUNT.getMessage());
                input = Console.readLine();
                Exception.checkIfNumber(input);
                money = Integer.parseInt(input);
                Exception.checkUnit(money);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        int howManyLotto = money / THOUSAND.getNumber();
        System.out.println(OutputMessage.printBuyHowManyLottoMessage(howManyLotto));
        publishedLotto = LottoProcess.publishLotto(howManyLotto);
        LottoProcess.printLotto(publishedLotto);

        while (true) {
            try {
                System.out.println(INPUT_WINNING_NUMBERS.getMessage());
                input = Console.readLine();
                winningNumbers = Exception.validateWinningNumbers(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println(INPUT_BONUS_NUMBER.getMessage());
                input = Console.readLine();
                Exception.validateBonusNumber(winningNumbers, input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println(WINNING_STATISTICS.getMessage());
        int bonusNumber = Integer.parseInt(input);
        Statistics statistics = new Statistics(publishedLotto, winningNumbers, bonusNumber);
        statistics.printStatisticResult();
        statistics.calculateTotalRateOfReturn(money);
    }
}
