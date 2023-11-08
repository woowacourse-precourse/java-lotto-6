package lotto.service;

import java.util.List;
import lotto.dto.MoneyDTO;
import lotto.model.Lotto;

public interface OrderLottoService {
    Integer order(MoneyDTO moneyDTO);
    List<Lotto> getOrderList();
}
