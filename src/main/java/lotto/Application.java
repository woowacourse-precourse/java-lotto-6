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
        depositMoney();
        createLotteryTicket();
        checkMyLotteryTicket();
        makeWinningTicket();
        claculateMyRate();
        printer.printResult(calc.getRank(), money);
    }

    private static void depositMoney() {
        money = user.enterAmount();
        numberOfLotto = user.getNumberOfLotto();
    }

    private static void createLotteryTicket() {
        lottos = publisher.publishLotto(numberOfLotto);
    }

    private static void checkMyLotteryTicket() {
        printer = new Printing(lottos);
        printer.printLotto(lottos);
    }

    private static void makeWinningTicket() {
        answer = user.enterWinningNumber();
        bonusNumber = user.enterBonusNumber();
    }

    private static void claculateMyRate() {
        calc = new Calculate(lottos, answer, bonusNumber);
        calc.countAll();
    }
}
