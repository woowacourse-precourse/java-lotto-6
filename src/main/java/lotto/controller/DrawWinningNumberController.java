package lotto.controller;

import java.util.List;
import lotto.domain.WinningManager;
import lotto.service.BuyingLottoService;
import lotto.service.WinningNumberService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class DrawWinningNumberController {

    private static final int STOP_FLAG = 0;

    private WinningNumberService winningNumberService = new WinningNumberService();

    private BuyingLottoService buyingLottoService = new BuyingLottoService();

    public WinningManager drawWinningNumber(){
        WinningManager manager;

        List<Integer> winningNumber;
        do {
            String inputWinningNumber = InputView.inputWinningNumberMessage();
            winningNumber = winningNumberService.validateWinningNumber(inputWinningNumber);

        }while(winningNumber==null);

        int bonusNumber;
        do {
            String inputBonusNumber = InputView.inputBonusNumberMessage();
            bonusNumber = winningNumberService.validateBonusNumber(inputBonusNumber);
        }while(STOP_FLAG>bonusNumber);

        OutputView.outputWinningStatisitcs();

        manager = new WinningManager(winningNumber,bonusNumber);
        return manager;
    }
}
