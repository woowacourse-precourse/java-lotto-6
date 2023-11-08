package lotto.view;

import lotto.model.Lotto;

import java.util.ArrayList;

public class OutputView {
    private static OutputView outputView;

    private OutputView() {
    }

    public static OutputView getInstance() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    public void println(String message) {
        System.out.println(message);
    }


    public void printLottoCount(int count) {
        println(count + "개를 구매했습니다.");
    }

    public void printLottoNumbers(ArrayList<Lotto> lottoBundle) {
        lottoBundle.forEach(lotto -> println(lotto.toString()));
    }

    public void notifyInputAmount() {
        println("구입금액을 입력해 주세요.");
    }
}
