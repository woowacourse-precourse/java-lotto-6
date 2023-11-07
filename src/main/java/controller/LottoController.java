package controller;

import model.LottoService;
import model.WinningNumber;
import view.InputView;
import view.OutputView;

public class LottoController {

    LottoService lottoService = new LottoService();
    WinningNumber winningNumber;
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public LottoController(){
        startLotto();
        createWinningNumber();
        matchLotto();
    }

    public void startLotto(){
        // 컨트롤러에서 input, outputView로 요청하고
        // model 로 넘겨주는 방식으로 리팩토링 할 것
        outputView.printRequirelottoCost();
        int lottoPaper = lottoService.buyLotto();
        outputView.printNewLine();
        outputView.printPublishedLotto(lottoPaper);
        lottoService.getLottoNumber();
    }

    public void createWinningNumber(){
        outputView.printRequireWinningNumber();
        winningNumber = new WinningNumber(inputView.getWinningNumber());
        outputView.printRequireBonusNumber();
        winningNumber.setBonusNumber(inputView.getBonusNumber());
    }

    public void matchLotto(){
        outputView.printMatchResult();

    }

}
