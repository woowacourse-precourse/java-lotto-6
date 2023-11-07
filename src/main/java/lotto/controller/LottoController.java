package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.User;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private static final int LOTTO_SIZE = 6;
    private static final int MIN_LOTTO_NUM = 1;
    private static final int MAX_LOTTO_NUM = 45;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        Money money = getMoney();
        Lottos lottos = makeLotto(money);
        outputView.showLottos(lottos, money);

        Lotto userLotto = getLotto();
        User user = getBonus(userLotto);
        outputView.showLottoStatistics(lottos, user, money);
    }

    private Money getMoney() {
        try {
            return new Money(inputView.inputPrice());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getMoney();
        }
    }

    private Lotto getLotto() {
        try {
            String inputLotto = inputView.inputLottoNumber();
            return new Lotto(inputLotto);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getLotto();
        }
    }

    private User getBonus(Lotto userLotto) {
        try {
            String inputBonus = inputView.inputBonusNumber();
            return new User(userLotto, inputBonus);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonus(userLotto);
        }
    }

    private Lottos makeLotto(Money money) {
        return new Lottos(generateLottos(money.calNumberOfLotto()));
    }

    private List<Lotto> generateLottos(int number) {
        List<Lotto> lottos = new ArrayList<>();
        IntStream.range(0, number).forEach(count -> lottos.add(new Lotto(generateLotto())));
        return lottos;
    }

    private List<Integer> generateLotto() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUM, MAX_LOTTO_NUM, LOTTO_SIZE);
    }

}
