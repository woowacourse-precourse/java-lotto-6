package lotto;

import camp.nextstep.edu.missionutils.Console;
import utils.InputView;
import utils.Printer;

import java.util.HashMap;
import java.util.List;

public class LottoManager {


    private LottoSeller lottoSeller;

    private WinningNumber winningNumber;

    private User user;


    public LottoManager(LottoSeller lottoSeller) {
        this.lottoSeller = lottoSeller;
    }

    public void run() {
        int money = purchaseLotto();

        List<Integer> winningNumbers = createWinningNumbers();

        createBonus(winningNumbers);

        HashMap<Rank, Integer> rankIntegerHashMap = user.statisticRank(winningNumber);

        Printer.statisticRank(rankIntegerHashMap,money);
    }

    private int purchaseLotto() {
        while (true) {
            try {
                Printer.inputMoney();
                int money = InputView.inputMoney(Console.readLine());

                user = new User(money);
                user.purchaseLotto(lottoSeller);
                user.printLotto();

                return money;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> createWinningNumbers() {
        while (true) {
            try {
                Printer.inputWinningNumbers();
                List<Integer> winningNumbers = InputView.inputWinningNumbers(Console.readLine());

                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void createBonus(List<Integer> winningNumbers) {
        while (true) {
            try {
                Printer.inputBonus();
                int bonus = InputView.inputBonus(Console.readLine());

                winningNumber = new WinningNumber(winningNumbers, bonus);

                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
