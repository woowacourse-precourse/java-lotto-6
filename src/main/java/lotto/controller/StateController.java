package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.stream.IntStream;


public class StateController {

    private static final int LOTTO_PRICE = 1000;
    private Lottos lottos;
    private int money;

    public void run() {
        enterMoney();
        purchaseLotto();
    }

    private void enterMoney() {
        int money = Integer.parseInt(InputView.readMoney());
        try {
            validateMoney(money);
            this.money = money;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            enterMoney();
        }
    }

    private void purchaseLotto() {
        lottos = new Lottos(IntStream
                .range(0, lottos.getLottoCount())
                .mapToObj(i -> new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)))
                .toList());
        OutputView.printLottoCount(lottos.getLottoCount());
        lottos.getLotto().forEach(lotto -> OutputView.printLotto(lotto.getNumbers()));
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
