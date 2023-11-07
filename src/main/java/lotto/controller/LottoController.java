package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lotto.model.User;
import lotto.service.LottoService;
import lotto.service.RankService;
import lotto.view.PrintView;


public class LottoController {

    LottoService lottoService;
    RankService rankService;


    public LottoController() {
        this.lottoService = new LottoService();
    }

    public void run() {
        User user = initInputUser();
        List<Integer> winningNumbers = getInputWinningNumbers();
        int bonusNum = getInputBonusNumber(winningNumbers);

        processingRank(user, winningNumbers, bonusNum);
    }


    public User initInputUser() {
        int count = getInputMoney();
        User user = lottoService.initUser(count);

        PrintView.printLottos(user);
        return user;
    }


    public int getInputMoney() {
        int count = 0;
        boolean checkException = true;

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

        return count;
    }

    public List<Integer> getInputWinningNumbers() {
        List<Integer> numbers = new ArrayList<>();
        boolean checkException = true;

        while (checkException) {
            PrintView.inputWinningNumbersView();
            String inputWinningNumbers = Console.readLine();
            try {
                numbers = lottoService.initWinningNumbers(inputWinningNumbers);
                checkException = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return numbers;
    }

    public int getInputBonusNumber(List<Integer> winningNumbers) {
        int bonusNumber = 0;
        boolean checkException = true;

        while (checkException) {
            PrintView.inputBonusNumberView();
            String inputBonusNumber = Console.readLine();
            try {
                bonusNumber = lottoService.initBonusNumber(winningNumbers, inputBonusNumber);
                checkException =false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return bonusNumber;
    }

    public void processingRank(User user, List<Integer> winningNumbers, int bonusNum) {
        rankService = new RankService(user, winningNumbers, bonusNum);

        int[] winningCount = rankService.calculateLottoRanks();
        BigDecimal result = rankService.rateOfReturn();
        PrintView.printWinningResult(winningCount, result);
    }


}
