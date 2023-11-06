package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.PrintMessage;

import java.util.List;

public class OutputView {

    private OutputView() {
    }

    public static void printLottoList(List<Lotto> lottoList, int numberOfLotto) {;
        printMessage("\n" + numberOfLotto + PrintMessage.PRINT_NUMBER_OF_PURCHASES);
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
