package lotto;

import lotto.Publishing;
import lotto.User;
import lotto.Printing;

import java.util.List;

public class Application {
    private static User user = new User();
    private static Publishing publisher = new Publishing();
    private static Printing printer;
    private static Calculate calc;

    private static int money;
    private static int numberOfLotto;
    private static List<Lotto> lottos;
    private static List<Integer> answer;
    private static int bonusNumber;

    public static void main(String[] args) {
        money = user.enterAmount();
        numberOfLotto = user.getNumberOfLotto();
        lottos = publisher.publishLotto(numberOfLotto);
        printer = new Printing(lottos);
        printer.printLotto(lottos);

        answer = user.enterWinningNumber();
        bonusNumber = user.enterBonusNumber();

        calc = new Calculate(lottos, answer, bonusNumber);
        calc.countAll();

        printer.printResult(calc.getRank(), money);
    }
}
