package lotto.view.output;

import lotto.domain.lotto.Lottos;

import java.util.List;

public class LottoBuyOutputView {

    private final String PURCHASED_LOTTO_COUNT_MESSAGE = "%s개를 구매했습니다.";

    public void printPurchaseLottoCountMessage(Lottos lottos) {
        System.out.println(String.format(PURCHASED_LOTTO_COUNT_MESSAGE, lottos.size()));
    }

    public void printAllLottoNumbers(Lottos lottos) {
        List<String> allLottoNumbers = lottos.allLottoNumbersAsString();
        allLottoNumbers.stream()
                .forEach(this::printLottoNumbers);
    }

    private void printLottoNumbers(String lottoNumbers) {
        System.out.println(lottoNumbers);
    }

}
