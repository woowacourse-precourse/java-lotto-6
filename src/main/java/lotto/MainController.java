package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.message.ViewMessage;
import lotto.view.InputView;
import lotto.view.OutputView;

public class MainController {
    public static void run() {
        LottoPurchaseInfo lottoInfo = purchaseLottos();
        OutputView.printLottoPurchaseInfo(lottoInfo);
        AnswerLotto answerLotto = initAnswerLotto();

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

    private static AnswerLotto initAnswerLotto() {
        String lottoNumberString = InputView.readString(ViewMessage.INPUT_ANSWER_LOTTO);
        List<String> strings = Utils.splitStringToList(lottoNumberString, ",");
        Lotto answerLotto = new Lotto(Utils.convertListStringToListInteger(strings));
        int bonus = InputView.readInteger(ViewMessage.INPUT_BONUS_NUMBER);
        return new AnswerLotto(answerLotto, bonus);
    }
}
