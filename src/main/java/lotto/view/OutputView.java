package lotto.view;

import java.util.List;

public class OutputView {

    public void printToPrizeDetails() {
    }

    public void printToEarningRate() {

    }

    public void printToBuyLotto(List<List<Integer>> buyLottoNumbers, int buyCount) {
        System.out.println("\n" + buyCount + "개를 구매했습니다.");
        for (List<Integer> lottoNumbers : buyLottoNumbers) {
            System.out.println(lottoNumbers);
        }
    }
}
