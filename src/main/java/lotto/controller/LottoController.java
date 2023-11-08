package lotto.controller;

import lotto.domain.LottoGame;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    LottoService lottoService = new LottoService();

    public void playGame(){
        getBuyAmount();
        buyLotto();
        getWinNumbers();
        getBonusNumber();
        calculateWinLotto();
    }

    public void getBuyAmount(){
        while (true){
            try {
                String input = InputView.getBuyAmount(); // 입력
                lottoService.getBuyAmount(input); // 서비스
                break;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void buyLotto(){
        LottoGame lottoGame = lottoService.buyLotto(); // 서비스
        OutputView.printBuyLotto(lottoGame.getBuyCount(), lottoGame.getLottos());
    }

    public void getWinNumbers(){
        while (true){
            try {
                String input = InputView.getWinNumbers(); // 입력
                lottoService.getWinNumbers(input); // 서비스
                break;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void getBonusNumber(){
        while (true){
            try {
                String input = InputView.getBonusNumber(); // 입력
                lottoService.getBonusNumbers(input); // 서비스
                break;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private void calculateWinLotto() {
        lottoService.calculateWinLotto();
    }
}
