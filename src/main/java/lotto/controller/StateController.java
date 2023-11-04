package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class StateController {


    private Money money;
    private Lottos lottos;
    private Lotto answerLotto;
    private int bonus;


    public void run() {
        enterMoney();
        purchaseLotto();
        enterAnswer();
        enterBonus();
    }

    private void enterMoney() {
        try {
            money = new Money(Integer.parseInt(InputView.readMoney().trim()));
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            enterMoney();
        }
    }

    private void purchaseLotto() {
        lottos = new Lottos(IntStream
                .range(0, money.lottoCount())
                .mapToObj(i -> new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)))
                .toList());
        OutputView.printLottoCount(money.lottoCount());
        lottos.getLotto().forEach(lotto -> OutputView.printLotto(lotto.getNumbers()));
    }

    private void enterAnswer() {
        List<Integer> answerLotto = Stream
                .of(InputView.readAnswer().trim().split(","))
                .map(Integer::parseInt)
                .toList();
        try {
            this.answerLotto = new Lotto(answerLotto);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            enterAnswer();
        }
    }

    private void enterBonus() {
        try {
            int bonus = Integer.parseInt(InputView.readBonus().trim());
            validateBonus(bonus);
            this.bonus = bonus;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            enterBonus();
        }
    }

    private void validateBonus(int number) {
        if (number > 45 || number < 1) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호의 숫자 범위는 1~45까지입니다.");
        }
        if (answerLotto.getNumbers().contains(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 로또 번호와 중복될 수 없습니다.");
        }
    }
}
