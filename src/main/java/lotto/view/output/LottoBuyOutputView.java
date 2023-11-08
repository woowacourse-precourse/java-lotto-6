package lotto.view.output;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;

import java.util.List;

import static java.util.stream.Collectors.joining;
import static lotto.view.output.message.LottoOutputMessage.PURCHASED_LOTTO_COUNT_MESSAGE_FORMAT;

public class LottoBuyOutputView {

    public void printPurchaseLottoCountMessage(Lottos lottos) {
        System.out.printf(PURCHASED_LOTTO_COUNT_MESSAGE_FORMAT.getMessage(), lottos.size());
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

        //도메인 로직에서 처리하는거 보다는 View의 연산이라서 getter로 꺼내와서 처리
        return numbers.stream()
                .map(String::valueOf)
                .collect(joining(", ", "[", "]"));
    }

    private void printLottoNumbers(String lottoNumbers) {
        System.out.println(lottoNumbers);
    }

}
