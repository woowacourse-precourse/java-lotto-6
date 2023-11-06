package lotto.view;

import static lotto.view.constant.OutputMessage.NEWLINE;
import static lotto.view.constant.OutputMessage.PURCHASED_COUNT;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class OutputView {

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public void printLottoNumbers(Lottos lottos) {
        StringBuilder lottoNumberResult = new StringBuilder();
        lottoNumberResult.append(NEWLINE.getMessage())
                .append(lottos.getLottos().size())
                .append(PURCHASED_COUNT.getMessage())
                .append(NEWLINE.getMessage());
        lottos.getLottos()
                .forEach(lotto -> createLottoStatus(lotto, lottoNumberResult));
        System.out.println(lottoNumberResult);
    }

    public void createLottoStatus(Lotto lotto, StringBuilder lottoNumberResult) {
        lottoNumberResult.append(lotto.getNumbers().toString())
                .append(NEWLINE.getMessage());
    }
}
