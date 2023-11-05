package lotto.controller;

import java.util.List;
import lotto.domain.WinningManager;
import lotto.service.BuyingLottoService;
import lotto.service.WinningNumberService;
import lotto.view.InputView;

public class WinningNumberController {

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
            String inputBonusNumber = InputView.inputWinningNumberMessage();
            bonusNumber = winningNumberService.validateBonusNumber(inputBonusNumber);
        }while(0>bonusNumber);

        manager = new WinningManager(winningNumber,bonusNumber);
        return manager;
    }
}
