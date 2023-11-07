package lotto;

import lotto.controller.LottosController;
import lotto.domain.NumberGenerator;
import lotto.controller.MoneyController;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

import static lotto.configuration.Constants.*;

public class GameManager {
    private final InputView inputView;
    private final OutputView outputView;

    private final NumberGenerator numberGenerator;

    private final MoneyController moneyController;
    private final LottosController lottosController;


    public GameManager(InputView inputView,
                       OutputView outputView,
                       NumberGenerator numberGenerator,
                       MoneyController moneyController,
                       LottosController lottosController) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberGenerator = numberGenerator;
        this.moneyController = moneyController;
        this.lottosController = lottosController;
    }

    public void play() {
        Money money = getMoney();
        Lottos lottos = getLottos(money.getLottoCount());
    }

    private Money getMoney() {
        while (true) {
            try {
                outputView.println(Message.NEED_PURCHASE_MONEY);
                String input = inputView.readOne();
                int money = numberGenerator.createOne(input);
                return moneyController.create(money);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lottos getLottos(int lottoCount) {
        List<List<Integer>> randomNumberLists = numberGenerator.createRandomNumberLists(lottoCount);
        Lottos lottos = lottosController.create(randomNumberLists);
        outputView.println(lottos);
        return lottos;
    }

}
