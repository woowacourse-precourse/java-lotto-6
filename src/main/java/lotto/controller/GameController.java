package lotto.controller;

import lotto.Service.PurchaseService;
import lotto.Service.RandomLottoCreService;
import lotto.Service.ResultService;
import lotto.Service.ReturnCalcService;
import lotto.Util.PurchasePriceUtil;
import lotto.Util.WinningLottoNumberUtil;
import lotto.model.LottoGame;
import lotto.model.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;


public class GameController {
    PurchaseService purchaseService = new PurchaseService();
    RandomLottoCreService randomLottoCreService = new RandomLottoCreService();
    ResultService resultService = new ResultService();
    ReturnCalcService returnCalcService = new ReturnCalcService();

    PurchasePriceUtil purchasePriceValidUtil = new PurchasePriceUtil();
    WinningLottoNumberUtil winningLottoNumberValidUtil = new WinningLottoNumberUtil();

    LottoGame game = new LottoGame();

    public void purchaseLotto(){
        int checkedPurchasePrice = 0;
        while(true){
            try{
                String purchasePrice = InputView.inputPurcasePrice();
                checkedPurchasePrice = purchasePriceValidUtil.validPurchasePrice(purchasePrice);
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
        game.setPurchasePrice(checkedPurchasePrice);
        game.setBuyingLottoCount(purchaseService.calculateLottoCount(checkedPurchasePrice));
    }

    public void createLotto(){
        List<Lotto> purchaseLotto = randomLottoCreService.createRandomLottos(game.getBuyingLottoCount());
        game.setPurchaseLotto(purchaseLotto);
        OutputView.printLottos(purchaseLotto);
    }


    public void inputWinningLottoNumbers(){
        List<Integer> checkedWinningLotto;
        while(true){
            try{
                String winningLotto = InputView.inputWinningNumber();
                checkedWinningLotto = winningLottoNumberValidUtil.validLotto(winningLotto);
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
        game.setWinningLotto(new Lotto(checkedWinningLotto));
    }

    public void inputBonusNumber(){
        int checkedBonusNumber = 0;
        while(true){
            try{
                String winningBonusNumber = InputView.inputBonusNumber();
                checkedBonusNumber = winningLottoNumberValidUtil.validBonusNumber(winningBonusNumber, game.getWinningLotto().getLotto());
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
        game.setBonusNumber(checkedBonusNumber);
    }

    public void makeGameResult(){
        game.setMatchCounts(resultService.compareLottosNumbers(
                game.getPurchaseLotto(),
                game.getWinningLotto(),
                game.getBonusNumber()
        ));
        game.setRanks(resultService.calculateRankingResult(
                game.getMatchCounts()
        ));
    }

    public void printGameResult(){
        OutputView.printResult();
        OutputView.printEachMatchResult(game.getRanks());
        game.setTotalPrize(returnCalcService.calculateTotalPrize(game.getRanks()));
        String returnRate = returnCalcService.calculateReturnRate(game.getPurchasePrice(), game.getTotalPrize());
        OutputView.printReturnRate(returnRate);
    }


}
