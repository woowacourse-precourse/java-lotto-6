package lotto.view.output;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class LottoBuyOutputView {

    private final String PURCHASED_LOTTO_COUNT_MESSAGE_FORMAT = "%s개를 구매했습니다.";

    public void printPurchaseLottoCountMessage(Lottos lottos) {
        System.out.println(String.format(PURCHASED_LOTTO_COUNT_MESSAGE_FORMAT, lottos.size()));
    }

    public void printAllLottoNumbers(Lottos lottos) {
        List<String> allLottoNumbers = allLottoNumbersAsString(lottos.getLottos());
        allLottoNumbers.stream()
                .forEach(this::printLottoNumbers);
        System.out.println();
    }
    private List<String> allLottoNumbersAsString(List<Lotto> lottos) {
        return lottos.stream()
                .map(this::getLottoNumbersAsString)
                .toList();
    }

    private String getLottoNumbersAsString(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();

        return numbers.stream()
                .map(String::valueOf)
                .collect(joining(", ", "[", "]"));
    }

    private void printLottoNumbers(String lottoNumbers) {
        System.out.println(lottoNumbers);
    }

}
