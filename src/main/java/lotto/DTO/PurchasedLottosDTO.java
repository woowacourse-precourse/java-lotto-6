package lotto.DTO;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.PurchasedLottos;

public class PurchasedLottosDTO {

    private List<List<Integer>> purchasedLottos;

    public PurchasedLottosDTO(PurchasedLottos purchasedLottos) {
        this.purchasedLottos = convertLottosToNumbers(purchasedLottos.getLottos());
    }

    private static List<List<Integer>> convertLottosToNumbers(List<Lotto> lottos) {
        return lottos.stream()
                .map(Lotto::getNumbers)
                .collect(Collectors.toList());
    }

    public List<List<Integer>> getPurchasedLottos() {
        return purchasedLottos;
    }
}
