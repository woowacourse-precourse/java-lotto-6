package lotto.view;

import lotto.Lotto;

import java.util.List;

import static lotto.constant.LottoMessage.LOTTO_COUNT;

public class LottoOutputView {

    public void printLottoNumbers(int count, List<Lotto> numbers) {
        printNewLine();
        printMessage(String.format(LOTTO_COUNT, count));
        for (Lotto lotto : numbers) {
            printMessage(lotto.getNumbers().toString());
        }
    }

    public void printMessage(String text) {
        System.out.println(text);
    }

    public void printNewLine() {
        System.out.println();
    }
}
