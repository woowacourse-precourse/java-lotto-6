package lotto.view;

import java.util.List;

public class OutputView {

    private static OutputView instance;

    private OutputView() {
    }

    public static OutputView getInstance() {
        if (instance == null) {
            instance = new OutputView();
        }
        return instance;
    }


    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printBeforeInputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printTicket(List<Integer> lottos) {
        System.out.println(lottos.toString());
    }

    public void printBeforeBuyLotto(long count) {
        System.out.printf("%d개를 구매했습니다.\n", count);
    }
}
