package lotto.view;

import java.util.List;
import lotto.Lotto;

public class OutputView {
    private OutputView() {

    }

    public static void printBuyGames(int inputNumber) {
        System.out.println(inputNumber + "개를 구매했습니다.");
    }

    public static void printLottoList(List<Lotto> lottoList) {

        for (Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
    }
}
