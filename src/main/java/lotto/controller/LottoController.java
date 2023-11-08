package lotto.controller;

import java.util.HashMap;
import java.util.List;
import lotto.Lotto;
import lotto.WinningNumberDTO;
import lotto.model.LottoMachine;
import lotto.model.LottoRefree;
import lotto.validator.InputValidator;
import lotto.view.PrizeMessage;

public class LottoController {
    private InputValidator inputValidator;

    private int purchasePrice;
    private LottoIOController ioController;
    private LottoMachine lottoMachine = new LottoMachine();
    private List<Lotto> lottos;

    private LottoRefree lottoRefree = new LottoRefree();
    private int lottoCount;
    private WinningNumberDTO winningNumberDTO;

    private LottoController() {
        this.inputValidator = new InputValidator();
        this.ioController = new LottoIOController();
    }
    private static class LazyHolder {
        public static final LottoController INSTANCE = new LottoController();
    }

    public static LottoController getInstance() {
        return LazyHolder.INSTANCE;
    }

    public void LottoGameStart(){
        ioController.introOutput();
        purchasePrice = ioController.setPurchasePrice();
        lottoCount=purchasePrice/1000;

        ioController.getIntroducePurchaseNum(lottoCount);
        lottos = lottoMachine.makeLottosByPurchaseAmount(lottoCount);
        ioController.notifyLottoNums(lottos);
        makeWinningNumber();
        ioController.notifyResult();
        LottoRaffle();
        lottoResult();
    }

    public void makeWinningNumber(){
        ioController.notifySetWinningNumber();
        List<Integer> winningNumber = ioController.setWinningNumber();
        ioController.notifySetBonusNumber();
        int bonusNum = ioController.setBonusNumber(winningNumber);
        winningNumberDTO = new WinningNumberDTO(winningNumber,bonusNum);
    }

    public void LottoRaffle(){
        lottos=lottoMachine.makeLottosByPurchaseAmount(lottoCount);
    }

    public void lottoResult(){
        HashMap<String,Integer> prizeNum=lottoRefree.makePrizeNum(winningNumberDTO,lottos);
        double winningRate=lottoRefree.calcWinningRate(purchasePrice);
        ioController.printPrizeNum(prizeNum);
        ioController.printWinningRate(winningRate);
    }



}
