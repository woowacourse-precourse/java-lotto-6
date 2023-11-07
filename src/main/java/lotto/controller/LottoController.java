package lotto.controller;

import lotto.service.LottoService;
import lotto.utils.Prizes;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.HashMap;

public class LottoController {

    private InputView inputView;
    private OutputView outputView;
    private LottoService lottoService;

    public void playLotto(){
        lottoService.setMoney(inputView.getMoney());
        lottoService.buyLotto();
        outputView.printLotto(lottoService.getUser());
        lottoService.setWinningNumbers(inputView.getWinningNumbers());
        lottoService.setBonusNumber(inputView.getBonusNumber());
        HashMap<Prizes, Integer> matches = lottoService.getNumberMatches();
        double earnedPerPayed = lottoService.calculatePercentage(matches);
        outputView.printPrizes(matches, earnedPerPayed);
    }
}
