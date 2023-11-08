package lotto.controller;

import java.util.List;
import lotto.Lotto;
import lotto.WinningNumberDTO;
import lotto.model.LottoMachine;
import lotto.validator.InputValidator;

public class LottoController {
    private InputValidator inputValidator;
    private LottoIOController ioController;
    private LottoMachine lottoMachine = new LottoMachine();
    private List<Lotto> lottos;
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
        lottoCount = ioController.setPurchasePrice()/1000;
        ioController.getIntroducePurchaseNum(lottoCount);
        lottos = lottoMachine.makeLottosByPurchaseAmount(lottoCount);
        ioController.notifyLottoNums(lottos);
        makeWinningNumber();
        ioController.notifyResult();
        LottoRaffle();
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



}
