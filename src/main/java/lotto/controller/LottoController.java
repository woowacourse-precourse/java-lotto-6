package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import lotto.dto.LottoRepositoryDto;
import lotto.dto.LottoResultDto;
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
    public void runLotto(){
        try {
            buyLotto();
            getWinningNumbers();
            getResult();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
    private void buyLotto(){
        Money money = lottoView.requestBuyLotto();
        LottoRepositoryDto lottoRepositoryDto = lottoService.buyLotto(money);
        lottoView.printLottoRepository(lottoRepositoryDto);
    }

    private void getWinningNumbers(){
        try {
            Lotto winningLotto = new Lotto(Validation.validateList(lottoView.requestWinningLotto()));
            int BonusNum = Validation.validateInt(lottoView.requestBonusNum());
            winningNumber = new WinningNumber(winningLotto,BonusNum);
        }catch (IllegalArgumentException e){
            throw e;
        }
    }
    private void getResult(){
        LottoResultDto lottoResultDto = lottoService.getResult(winningNumber);
        lottoView.printResultMsg(lottoResultDto);
    }


}
