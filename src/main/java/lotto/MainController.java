package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.WinningLotto;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.message.ViewMessage;
import lotto.view.InputView;
import lotto.view.OutputView;

public class MainController {
    public static void run() {
        Lottos purchasedLotto = initLottos();
        OutputView.printLottos(purchasedLotto);
        WinningLotto answerLotto = initAnswerLotto();
        OutputView.printResult(answerLotto, purchasedLotto);
    }

    private static Lottos initLottos() {
        try {
            Money money = new Money(InputView.readInteger(ViewMessage.INPUT_PURCHASE_MONEY));
            List<Lotto> lottoItems = purchaseLotto(money);
            return new Lottos(lottoItems, lottoItems.size());
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return initLottos();
        }
    }

    private static List<Lotto> purchaseLotto(Money wallet) {
        List<Lotto> lottoItems = new ArrayList<>();
        while (wallet.canPurchaseLotto()) {
            Lotto newLotto = Lotto.createRandomLotto(wallet);
            lottoItems.add(newLotto);
        }
        return lottoItems;
    }

    private static WinningLotto initAnswerLotto() {
        Lotto answerLotto = initLotto();
        BonusNumber bonus = initBonus();
        return new WinningLotto(answerLotto, bonus);
    }

    private static Lotto initLotto() {
        try {
            String lottoNumberString = InputView.readString(ViewMessage.INPUT_ANSWER_LOTTO);
            List<String> strings = Utils.splitStringToList(lottoNumberString, ",");
            Lotto answerLotto = new Lotto(Utils.convertListStringToListInteger(strings));
            return answerLotto;
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return initLotto();
        }
    }

    private static BonusNumber initBonus() {
        try {
            return new BonusNumber(InputView.readInteger(ViewMessage.INPUT_BONUS_NUMBER));
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return initBonus();
        }
    }


}
