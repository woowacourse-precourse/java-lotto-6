package lotto.service;

import java.util.List;
import lotto.domain.Customer;
import lotto.domain.lotto.Lotto;

public class LottoDto {
    private final List<Lotto> lottos;

    private LottoDto(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoDto from(Customer customer) {
        return new LottoDto(customer.getIssuedLottos());
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
