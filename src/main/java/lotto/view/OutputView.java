package lotto.view;

import java.util.List;

public class OutputView {

    private static final String LOTTO_BUY_FORMAT = String.format("%d개를 구매했습니다.\n");
    public void printLottoNumbers(List<List<Integer>> lottoNumbers) {
        System.out.printf(LOTTO_BUY_FORMAT, lottoNumbers.size());

        lottoNumbers.forEach(System.out::println);
    }
}
