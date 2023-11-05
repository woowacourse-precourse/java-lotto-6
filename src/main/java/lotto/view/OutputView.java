package lotto.view;

import java.text.DecimalFormat;
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
        System.out.println("당첨 통계\n---");
        for (Result value : Result.values()) {
            DecimalFormat decimalFormat = new DecimalFormat("###,###,###,###");
            String formattedNum = decimalFormat.format(value.getMoney());
            if (value.isBonus()) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n", value.getSameCount(),
                    formattedNum, value.getResultCount());
                continue;
            }
            System.out.printf("%d개 일치 (%s원) - %d개\n", value.getSameCount(), formattedNum,
                value.getResultCount());
        }
    }

    public void printBeforeInputWinNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printYield(double v1) {
        System.out.printf("총 수익률은 %.1f%%입니다.", v1);
    }
}

