package lotto;

import static lotto.Enum.InputMessage.BUY_HOW_MANY;
import static lotto.Enum.InputMessage.INPUT_PURCHASE_AMOUNT;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String input;
        int money;
        int countLotto;
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

        countLotto = money / 1000;
        System.out.println("\n" + countLotto + BUY_HOW_MANY.getMessage());
        lottos = LottoProcess.publishLotto(countLotto);
        LottoProcess.printLotto(lottos, countLotto);

    }
}
