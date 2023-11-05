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
    static LottoMessageConverter messageConverter = new LottoMessageConverter();

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
        List<Lotto> lottos = purchaseLottos(lottoMachine, money);

        outputView.println(messageConverter.convertLottoNumberMessage(lottos));

        // 당첨 번호 입력
        Lotto winningLotto = createWinningLotto();
    }

    private static Money inputMoneyAmount() {
        try {
            int amount = inputView.readLottoPurchaseMoney();
            return new Money(amount);
        } catch (IllegalArgumentException error) {
            outputView.printError(error);
            return inputMoneyAmount();
        }
    }

    private static List<Lotto> purchaseLottos(LottoMachine lottoMachine, Money money) {
        return lottoMachine.purchaseLottos(money);
    }

    private static Lotto createWinningLotto() {
        try {
            List<Integer> winningNumbers = inputView.readWinningNumbers();
            return new Lotto(winningNumbers);
        } catch (IllegalArgumentException error) {
            outputView.printError(error);
            return createWinningLotto();
        }
    }
}
