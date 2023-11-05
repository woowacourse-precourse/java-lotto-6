package lotto.view;

import java.util.List;

public class OutputView {

    public void printLottoCount(int lottoCount) {
        System.out.printf("%d개를 구매했습니다.\n", lottoCount);
    }
    public void printLottoNumbers(List<Integer> lottoNumbers) {
        System.out.println(lottoNumbers);
    }
}
