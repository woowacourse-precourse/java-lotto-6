package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

import static lotto.domain.OutputEnum.LOTTO_AMOUNT;
import static lotto.domain.OutputEnum.LOTTO_COUNT;

public class OutputView {

    public void printLottoAmount() {
        System.out.println(LOTTO_AMOUNT.getOutput());
    }

    public void printLottoCount(Integer price) {
        System.out.printf(String.valueOf(LOTTO_COUNT.getOutput()), price);
    }

    public void printLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }
}
