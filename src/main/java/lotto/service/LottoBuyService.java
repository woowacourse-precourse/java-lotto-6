package lotto.service;

import lotto.domain.BuyLotto;
import lotto.domain.LottoMachine;
import lotto.dto.BuyLottoDTO;

public final class LottoBuyService {
    private final LottoMachine lottoMachine;

    public LottoBuyService(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public BuyLottoDTO.Output getBuyLottoDto(Long buyPrice) {
        BuyLotto buyLotto = lottoMachine.generateForPrice(buyPrice);
        return new BuyLottoDTO.Output(buyLotto);
    }
}
