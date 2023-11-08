package lotto.dto;

import java.util.List;
import lotto.domain.Lotto;

public class IssuedLottoDetails {

    private final int quantity;
    private final List<String> lottos;

    private IssuedLottoDetails(List<Lotto> lottos) {
        this.quantity = lottos.size();
        this.lottos = toList(lottos);
    }

    private List<String> toList(List<Lotto> lottos) {
        return lottos.stream()
                .map(Lotto::toString)
                .toList();
    }

    public static IssuedLottoDetails createIssuedLottoDetails(List<Lotto> lottos) {
        return new IssuedLottoDetails(lottos);
    }

    public int getLottosQuantity() {
        return quantity;
    }

    public List<String> getLottos() {
        return lottos;
    }
}
