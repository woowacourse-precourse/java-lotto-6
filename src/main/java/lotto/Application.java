package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        Computer computer = new Computer();
        List<Lotto> lottos;

        String input = computer.getPriceFromUser();
        computer.validatePrice(input);
        int money = computer.changeInputToInt(input);

        System.out.println("");

        computer.announcePurchase(money);
        lottos = computer.buyLotto(money);
        computer.printLottos(lottos);

        System.out.println("");

        WinLotto winLotto = computer.getWinningNumber();
        int bonusNumber = computer.getBonusNumber();
        //computer.validateBonusNumber(bonusNumber, winLotto);

    }
}
