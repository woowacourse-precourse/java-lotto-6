package lotto.view;

import static lotto.constant.message.LottoMessage.LOTTO_NUMBERS_PREFIX_MESSAGE;
import static lotto.constant.message.LottoMessage.LOTTO_NUMBERS_SUFFIX_MESSAGE;
import static lotto.constant.message.LottoMessage.LOTTO_PURCHASE_FIXMESSAGE;
import static lotto.constant.message.LottoMessage.SEPARATION;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public void printLottos(List<Lotto> lottos) {
        printLottoCount(lottos);
        for (int i = 0; i < lottos.size(); i++) {
            printLottoNumbers(lottos.get(i));
        }
    }

    private void printLottoCount(List<Lotto> lottos) {
        System.out.println(lottos.size() + LOTTO_PURCHASE_FIXMESSAGE);
    }

    private void printLottoNumbers(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();

        System.out.print(LOTTO_NUMBERS_PREFIX_MESSAGE);
        for (int number : lottoNumbers) {
            System.out.print(number + SEPARATION);
        }
        System.out.println(LOTTO_NUMBERS_SUFFIX_MESSAGE);
    }
}
