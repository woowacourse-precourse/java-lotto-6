package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.WinningLotto;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoPurchaseInfo;
import lotto.domain.Wallet;
import lotto.message.ViewMessage;
import lotto.view.InputView;
import lotto.view.OutputView;

public class MainController {
    public static void run() {
        LottoPurchaseInfo lottoInfo = purchaseLottos();
        OutputView.printLottoPurchaseInfo(lottoInfo);
        WinningLotto answerLotto = initAnswerLotto();
        OutputView.printResult(answerLotto, lottoInfo);
    }


    private static LottoPurchaseInfo purchaseLottos() {
        try {
            Wallet wallet = new Wallet(InputView.readInteger(ViewMessage.INPUT_PURCHASE_MONEY));
            List<Lotto> lottoList = new ArrayList<>();
            while (wallet.canPurchaseLotto()) {
                Lotto newLotto = Lotto.createRandomLotto(wallet);
                lottoList.add(newLotto);
            }
            return new LottoPurchaseInfo(lottoList, lottoList.size());
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return purchaseLottos();
        }
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
