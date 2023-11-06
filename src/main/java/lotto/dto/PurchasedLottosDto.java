package lotto.dto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class PurchasedLottosDto {

    List<List<Integer>> purchasedLottos;

    private PurchasedLottosDto(List<List<Integer>> lottos) {
        purchasedLottos = new ArrayList<>(lottos);
    }

    public static PurchasedLottosDto from(List<Lotto> lottos) {
        List<List<Integer>> purchasedLottos = lottos.stream()
                                                    .map(Lotto::showNumbersByIntegers)
                                                    .toList();
        return new PurchasedLottosDto(purchasedLottos);
    }

    public List<List<Integer>> show() {
        return purchasedLottos;
    }

}
