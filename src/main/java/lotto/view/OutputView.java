package lotto.view;

import java.util.List;
import lotto.domain.Result;

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

    public void printBeforeInputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printResult() {
        Result[] values = Result.values();
        for (Result value : values) {
            System.out.printf("%d개 일치(%s), ");
        }
    }
//    3개 일치 (5,000원) - 1개
//4개 일치 (50,000원) - 0개
//5개 일치 (1,500,000원) - 0개
//5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
//6개 일치 (2,000,000,000원) - 0개
//    총 수익률은 62.5%입니다.
}

