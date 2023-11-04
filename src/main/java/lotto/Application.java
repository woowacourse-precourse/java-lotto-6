package lotto;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoMachine;
import lotto.domain.lotto.converter.LottoMessageConverter;
import lotto.domain.money.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    static OutputView outputView = new OutputView();
    static InputView inputView = new InputView(outputView);

    public static void main(String[] args) {

        // money 입력 기능
        Money money;
        try {
            money = inputMoneyAmount();
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            money = inputMoneyAmount();
        }

        // lotto 구매 기능
        LottoMachine lottoMachine = new LottoMachine();
        LottoMessageConverter lottoMessageConverter = new LottoMessageConverter();
        List<Lotto> lottos = lottoMachine.purchaseLottos(money);

        outputView.println(lottoMessageConverter.convertLottoNumberMessage(lottos));


    }

    private static Money inputMoneyAmount() {
        int amount = inputView.readLottoPurchaseMoney();
        return new Money(amount);
    }
}
