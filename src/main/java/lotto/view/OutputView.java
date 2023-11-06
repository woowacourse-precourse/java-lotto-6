package lotto.view;

import java.util.List;

public class OutputView {

    public void purchasePieces(int pieces) {
        System.out.println("\n" + pieces + "개를 구매했습니다.");
    }

    public void purchaseNum(List<Integer> lottoNum) {
        System.out.println(lottoNum);
    }

    public void errorMessage(String e) {
        System.out.println(e);
    }
}
