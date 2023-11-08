package lotto.controller;

import lotto.WinningNumberDTO;
import lotto.validator.InputValidator;

public class LottoController {
    private InputValidator inputValidator;
    private LottoIOController ioController;
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
        ioController.setPurchasePrice();
        winningNumberDTO.setWinningNumbers(ioController.setWinningNumber());
        winningNumberDTO.setBonusNumber(ioController.setBonusNumber(winningNumberDTO.getWinningNumbers()));
    }



}
