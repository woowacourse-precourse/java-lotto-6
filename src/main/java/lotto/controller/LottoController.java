package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
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
        int bonusNum = getInputBonusNumber();

        processingRank(user, winningNumbers, bonusNum);
    }


    public User initInputUser() {
        int count = getInputMoney();
        User user = lottoService.initUser(count);

        PrintView.printLottos(user);
        return user;
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

    public void processingRank(User user, List<Integer> winningNumbers, int bonusNum) {
        rankService = new RankService(user, winningNumbers, bonusNum);

        int[] winningCount = rankService.calculateLottoRanks();
        double result = rankService.rateOfReturn();
        PrintView.printWinningResult(winningCount, result);
    }


}
