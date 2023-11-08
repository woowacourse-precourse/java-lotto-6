package lotto.controller;

import lotto.dto.LottoRepositoryDto;
import lotto.dto.Money;
import lotto.service.LottoService;
import lotto.view.LottoView;

public class LottoController {
    private final LottoService lottoService = new LottoService();

    private final LottoView lottoView = new LottoView();

    public LottoController(){
    }

    public void buyLotto(){
        Money money = lottoView.requestBuyLotto();
        LottoRepositoryDto lottoRepositoryDto = lottoService.buyLotto(money);
        lottoView.printLottoRepository(lottoRepositoryDto);

    }
}
