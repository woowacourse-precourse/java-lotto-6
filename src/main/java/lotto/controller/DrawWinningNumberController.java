package lotto.controller;

import java.util.List;
import lotto.domain.WinningManager;
import lotto.service.BuyingLottoService;
import lotto.service.WinningNumberService;
import lotto.view.InputView;

public class DrawWinningNumberController {

    private static final int STOP_FLAG = -1;
    private WinningManager manager;
    private WinningNumberService winningNumberService = new WinningNumberService();

    public WinningManager drawWinningNumber(){
        List<Integer> winningNumber;
        int bonusNumber;

        do {
            String inputWinningNumber = InputView.inputWinningNumberMessage();
            winningNumber = winningNumberService.validateWinningNumber(inputWinningNumber);
        }while(winningNumber==null);

        do {
            String inputBonusNumber = InputView.inputBonusNumberMessage();
            bonusNumber = winningNumberService.validateBonusNumber(inputBonusNumber,winningNumber);
        }while(bonusNumber==STOP_FLAG);

        manager = new WinningManager(winningNumber,bonusNumber);
        return manager;
    }
}
