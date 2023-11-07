package lotto;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class OutputView {

    public void printPurchasedLottoAmount(int amount) {
        System.out.println();
        System.out.println(amount + "개를 구매했습니다.");
    }

    public void printPurchasedLottos(List<LottoDTO> lottoDTOs) {
        lottoDTOs.stream()
                .map(LottoDTO::getNumbers)
                .forEach(System.out::println);
    }
}