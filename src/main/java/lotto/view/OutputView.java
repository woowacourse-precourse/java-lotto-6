package lotto.view;

import java.util.List;

public class OutputView {
    private static final String OUTPUT_PURCHASE_NUMBER = "\n%d개를 구매했습니다.\n";

    public void outputPurchaseNumber(int number) {
        System.out.printf(OUTPUT_PURCHASE_NUMBER, number);
    }

    public void outputLottoNumber(List<Integer> list) {
        System.out.println(list);
    }
}
