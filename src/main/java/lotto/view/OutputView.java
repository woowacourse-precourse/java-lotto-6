package lotto.view;

import lotto.domain.*;

import java.text.DecimalFormat;

public class OutputView {

    private final DecimalFormat formatter;
    public OutputView() {
        formatter = new DecimalFormat("###,###");
    }

    public void printPurchasedLottos(Lottos lottos) {
        System.out.printf("%d개를 구매했습니다.", lottos.getCount());
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }




}
