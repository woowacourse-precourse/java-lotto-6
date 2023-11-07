package lotto.service;

import lotto.dto.MoneyDTO;

public interface OrderLottoService {
    public Integer order(MoneyDTO moneyDTO);
    public String getOrderList();
}
