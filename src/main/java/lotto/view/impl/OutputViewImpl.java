package lotto.view.impl;

import lotto.constants.CommonLetter;
import lotto.constants.ErrorMessages;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.view.OutputView;

public class OutputViewImpl implements OutputView {

    @Override
    public void printLottos(Lottos lottos) {
        System.out.println(
            CommonLetter.NEW_LINE.getLetter() + lottos.getLottos().size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos.getLottos()) {
            lotto.print();
        }
    }

    @Override
    public void printGameResult() {

    }

    @Override
    public void printProfit() {

    }

    @Override
    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}
