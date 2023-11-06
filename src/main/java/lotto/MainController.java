package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.message.ViewMessage;
import lotto.view.InputView;
import lotto.view.OutputView;

public class MainController {
    public static void run() {
        List<Lotto> lottoList = purchaseLottos();

        AnswerLotto answerLotto = initAnswerLotto();

//
//        OutputView.printResult(answerLotto.getResult(lottos));
    }

    private static List<Lotto> purchaseLottos() {
        Wallet wallet = new Wallet(InputView.readInteger(ViewMessage.INPUT_PURCHASE_MONEY));
        List<Lotto> lottoList = new ArrayList<>();
        while (wallet.canPurchaseLotto()) {
            List<Integer> pickedNumbers = Randoms.pickUniqueNumbersInRange(
                    LottoOption.LOTTO_START_INCLUSIVE,
                    LottoOption.LOTTO_END_INCLUSIVE,
                    LottoOption.LOTTO_SIZE);
            Lotto newLotto = new Lotto(pickedNumbers);
            OutputView.printLotto(newLotto);
            lottoList.add(newLotto);
        }
        return lottoList;
    }

    private static AnswerLotto initAnswerLotto() {
        String lottoNumberString = InputView.readString(ViewMessage.INPUT_ANSWER_LOTTO);
        List<String> strings = Utils.splitStringToList(lottoNumberString, ",");
        Lotto answerLotto = new Lotto(Utils.convertListStringToListInteger(strings));
        int bonus = InputView.readInteger(ViewMessage.INPUT_BONUS_NUMBER);
        return new AnswerLotto(answerLotto, bonus);
    }
}
