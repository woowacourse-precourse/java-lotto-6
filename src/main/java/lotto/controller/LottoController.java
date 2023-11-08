package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import lotto.dto.LottoRepositoryDto;
import lotto.dto.Money;
import lotto.service.LottoService;
import lotto.util.Validation;
import lotto.view.LottoView;

public class LottoController {
    private final LottoService lottoService = new LottoService();

    private final LottoView lottoView = new LottoView();
    private WinningNumber winningNumber;

    public LottoController(){
    }

    public void buyLotto(){
        Money money = lottoView.requestBuyLotto();
        LottoRepositoryDto lottoRepositoryDto = lottoService.buyLotto(money);
        lottoView.printLottoRepository(lottoRepositoryDto);
    }

    public void getWinningNumbers(){
        Lotto winningLotto = new Lotto(Validation.validateList(lottoView.requestWinningLotto()));
        int BonusNum = Validation.validateInt(lottoView.requestBonusNum());
        winningNumber = new WinningNumber(winningLotto,BonusNum);
    }

}
