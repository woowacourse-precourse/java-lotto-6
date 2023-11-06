package lotto.controller;

import java.util.List;
import lotto.constant.GameConstant;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.Lottos;
import lotto.dto.LottosResponse;
import lotto.util.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Validator validator = new Validator();

    LottoGenerator generator = new LottoGenerator();
    public void play() {
        int payment = getPayment();
        Lottos lottos = buy(payment);
        List<Integer> numbers = getLuckyNumbers();
        int bonusNumber = getBonusNumber(numbers);
        lottos.match(numbers, bonusNumber);

    }

    private Lottos buy(int payment) {
        int count = payment/GameConstant.PAYMENT_UNIT;
        outputView.printBuyMessage(count);
        List<Lotto> lottos = generator.makeLotto(count);
        outputView.printLottos(new LottosResponse(lottos));
        return new Lottos(lottos);
    }

    private int getBonusNumber(List<Integer> numbers) {
        try {
            return validator.validate(inputView.getBonusNumber(), numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return getBonusNumber(numbers);
        }
    }

    private List<Integer> getLuckyNumbers() {
        try {
            return validator.validate(inputView.getLuckyNumbers());
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return getLuckyNumbers();
        }
    }

    private int getPayment() {
        try {
            return validator.validate(inputView.getPayment());
        } catch (IllegalArgumentException e) {
            System.out.println(e + "\n");
            return getPayment();
        }
    }
}
