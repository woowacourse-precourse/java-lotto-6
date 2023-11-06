package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.model.User;
import lotto.service.LottoService;
import lotto.view.PrintView;


public class LottoController {

    LottoService lottoService;


    public LottoController() {
        this.lottoService = new LottoService();
    }




    public int getInputMoney() {
        while (true) {
            PrintView.inputMoneyView();
            String inputMoney = Console.readLine();
            try {
                return lottoService.initMoneyToCount(inputMoney);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> getInputWinningNumbers() {
        while (true) {
            PrintView.inputWinningNumbersView();
            String inputWinningNumbers = Console.readLine();
            try {
                return lottoService.initWinningNumbers(inputWinningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getInputBonusNumber() {
        while (true) {
            PrintView.inputBonusNumberView();
            String inputBonusNumber = Console.readLine();
            try {
                return lottoService.initBonusNumber(inputBonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


}
