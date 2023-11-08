package lotto;

import lotto.Publishing;
import lotto.User;
import lotto.Printing;

import java.util.List;

public class Application {
    private static User user = new User();
    private static Publishing publisher = new Publishing();
    private static Printing printer;

    private static int numberOfLotto;
    private static List<Lotto> lottos;
    public static void main(String[] args) {
        user.enterAmount();
        numberOfLotto = user.getNumberOfLotto();
        lottos = publisher.publishLotto(numberOfLotto);
        printer = new Printing(lottos);
        printer.printLotto(lottos);

        user.enterWinningNumber();
        user.enterBonusNumber();


    }
}
