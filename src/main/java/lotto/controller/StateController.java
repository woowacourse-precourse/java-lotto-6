package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class StateController {

    private static final int LOTTO_PRICE = 1000;

    private Lottos lottos;
    private int money;
    private int lottoCount;
    private Lotto answerLotto;
    private int bonus;


    public void run() {
        enterMoney();
        purchaseLotto();
        enterAnswer();
        enterBonus();
    }

    private void enterMoney() {
        int money = Integer.parseInt(InputView.readMoney());
        try {
            validateMoney(money);
            this.money = money;
            this.lottoCount = money/LOTTO_PRICE;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            enterMoney();
        }
    }

    private void purchaseLotto() {
        lottos = new Lottos(IntStream
                .range(0, lottoCount)
                .mapToObj(i -> new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)))
                .toList());
        OutputView.printLottoCount(lottoCount);
        lottos.getLotto().forEach(lotto -> OutputView.printLotto(lotto.getNumbers()));
    }

    private void enterAnswer() {
        List<Integer> answerLotto = Stream
                .of(InputView.readAnswer().split(","))
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
        this.bonus = Integer.parseInt(InputView.readBonus());
    }

    private void validateMoney(int money) {
        if (money == 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000 원 이상이여야 합니다.");
        }
        if ((money % LOTTO_PRICE) != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000 원 단위로 입력해주셔야 합니다.");
        }
    }
}
