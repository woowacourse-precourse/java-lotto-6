package lotto.view;

import java.util.List;

public class OutputView {
    private static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
    private static final String NEW_LINE = "\n";

    public void printPurchaseMessage(int quantity){
        System.out.println(quantity + PURCHASE_MESSAGE);
    }

    public void printLotto(List<List<Integer>> lottos) {
        StringBuilder sb = new StringBuilder();

        for (List<Integer> lotto : lottos) {
            sb.append(NEW_LINE).append(lotto);
        }

        System.out.println(sb);
    }
}
