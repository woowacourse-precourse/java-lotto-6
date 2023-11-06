package lotto;

import static lotto.Enum.InputMessage.BUY_HOW_MANY;
import static lotto.Enum.InputMessage.INPUT_BONUS_NUMBER;
import static lotto.Enum.InputMessage.INPUT_PURCHASE_AMOUNT;
import static lotto.Enum.InputMessage.INPUT_WINNING_NUMBER;
import static lotto.Enum.Number.UNIT;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String input;
        int money;
        int countLotto;
        List<Integer> winningNumber;
        List<Lotto> lottos;

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

        countLotto = money / UNIT.getNumber();
        System.out.println("\n" + countLotto + BUY_HOW_MANY.getMessage());
        lottos = LottoProcess.publishLotto(countLotto);
        LottoProcess.printLotto(lottos, countLotto);

        while (true) {
            try {
                System.out.println(INPUT_WINNING_NUMBER.getMessage());
                input = Console.readLine();
                winningNumber = Exception.checkWinningNumber(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println(INPUT_BONUS_NUMBER.getMessage());
                input = Console.readLine();
                Exception.checkBonusNumber(winningNumber, input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
