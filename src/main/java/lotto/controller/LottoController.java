package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigDecimal;
import java.util.List;
import lotto.service.LottoService;
import lotto.util.Validator;
import lotto.view.PrintView;


public class LottoController {

    LottoService lottoService;


    public LottoController() {
        this.lottoService = new LottoService();
    }

    public void run() {
        initData();
        processingRank();
    }

    public void initData() {
        initUserData();
        initWinningNumbersData();
        initBonusNumberData();
    }


    public void initUserData() {
        boolean checkException = true;
        int count = 0;

        while (checkException) {
            PrintView.inputMoneyView();
            String inputMoney = Console.readLine();

            try {
                count = lottoService.initMoneyToCount(inputMoney);
                checkException = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        lottoService.initUser(count);
        PrintView.printLottos(lottoService.user);
    }

    public void initWinningNumbersData() {
        boolean checkException = true;
        List<Integer> winningNumbers = null;

        while (checkException) {
            PrintView.inputWinningNumbersView();
            String inputWinningNumbers = Console.readLine();

            try {
                winningNumbers = lottoService.parseAndValidateWinningNumbers(inputWinningNumbers);
                checkException = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        lottoService.initWinningNumbers(winningNumbers);
    }

    public void initBonusNumberData() {
        boolean checkException = true;
        int bonusNumber = 0;

        while (checkException) {
            PrintView.inputBonusNumberView();
            String inputBonusNumber = Console.readLine();
            try {
                bonusNumber = Validator.validateSingleNumber(inputBonusNumber);
                checkException =false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        lottoService.initBonusNumber(bonusNumber);
    }

    public void processingRank() {
        int[] winningCount = lottoService.calculateLottoRanks();
        BigDecimal result = lottoService.rateOfReturn();

        PrintView.printWinningResult(winningCount, result);
    }


}
