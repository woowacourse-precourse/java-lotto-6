package lotto.service;

import java.util.List;
import lotto.dto.MoneyDTO;
import lotto.model.Lotto;

public interface OrderLottoService {
    public void order(MoneyDTO moneyDTO);
    public List<Lotto> getOrderList();
}
