package lotto.model.dto;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import lotto.model.Lotto;

public class PurchasedLottoResponse {

    private List<List<Integer>> lottos;

    private PurchasedLottoResponse(final List<List<Integer>> lottos) {
        this.lottos = lottos;
    }

    public static PurchasedLottoResponse from(final List<Lotto> lottos) {
        return new PurchasedLottoResponse(convertLottoToIntegerList(lottos));
    }

    private static List<List<Integer>> convertLottoToIntegerList(final List<Lotto> lottos) {
        return lottos.stream()
                .map(Lotto::getNumbers)
                .toList();
    }

    public List<List<Integer>> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
