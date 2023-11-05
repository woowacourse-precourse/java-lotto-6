package lotto.view;

import java.util.List;

public class OutputView {
    private static final String LOTTO_AMOUNT_MESSAGE = "%d개를 구매했습니다.";

    public void showLottoAmount(int lottoAmount) {
        System.out.println(String.format(LOTTO_AMOUNT_MESSAGE, lottoAmount));
    }

    public void showLottoNumbers(List<String> lottoNumbers) {
        lottoNumbers.stream().forEach(System.out::println);
    }

    public void showLottoResult() {

    }

    public void showProfitRate() {

    }
}
