package lotto;

import java.util.List;

public class OutputView {

    public void printPurchasedLottoAmount(int amount) {
        System.out.println();
        System.out.println(amount + "개를 구매했습니다.");
    }

    public void printPurchasedLottos(List<LottoDTO> lottoDTOSs) {
        lottoDTOSs.stream()
                .map(LottoDTO::getNumbers)
                .forEach(System.out::println);
    }
}