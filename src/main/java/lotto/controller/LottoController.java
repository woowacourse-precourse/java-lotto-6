package lotto.controller;

import lotto.service.LottoService;
import lotto.utils.Prizes;
import lotto.view.InputView;
import lotto.view.OutputView;
import java.util.HashMap;

public class LottoController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoService lottoService = new LottoService();

    public void initiateMoney(){
        while (true) {
            try {
                lottoService.setMoney(inputView.getMoney());
                break;
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void generateLotto(){
        while (true) {
            try {
                lottoService.buyLotto();
                outputView.printLotto(lottoService.getUser());
                break;
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void initiateWinningNumbers(){
        while (true) {
            try {
                lottoService.setWinningNumbers(inputView.getWinningNumbers());
                break;
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void initiateBonus(){
        while (true) {
            try {
                lottoService.setBonusNumber(inputView.getBonusNumber());
                break;
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void getResult(){
        HashMap<Prizes, Integer> matches = lottoService.getNumberMatches();
        double earnedPerPayed = lottoService.calculatePercentage(matches);
        outputView.printPrizes(matches, earnedPerPayed);
    }
}
