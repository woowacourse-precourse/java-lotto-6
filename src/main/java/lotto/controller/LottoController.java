package lotto.controller;

import camp.nextstep.edu.missionutils.Console;

import lotto.service.AdminLottoService;
import lotto.service.UserLottoService;
import lotto.view.AdminInputOutputMessage;
import lotto.view.UserInputMessage;
import lotto.domain.Admin;
import lotto.domain.Lotto;
import lotto.domain.Stat;
import lotto.domain.User;

import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

public class LottoController {
    private final AdminLottoService adminLottoService = new AdminLottoService();
    private final UserLottoService userLottoService = new UserLottoService();
    private List<Integer> winningNumber = new ArrayList<Integer>();
    private User user;
    private Admin admin;
    private Stat stat;
    private int createLottoNumbers;

    public void run() {
        initLotto();
        initStats();
        printStats();
    }

    public void initLotto() {
        initInputPurchaseAmount();
        printUserLottoNumbers();
        initInputWinningNumber();
        initInputBonusNumber();
    }

    public void initInputPurchaseAmount() {
        int purchaseAmount;
        while (true) {
            try {
                String purchaseAmountStr = InputPurchaseAmount();
                purchaseAmount = userLottoService.parseIntPurchaseAmount(purchaseAmountStr);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        createLottoNumbers = userLottoService.createLottoCount(purchaseAmount);
        user = userLottoService.setUser(createLottoNumbers, purchaseAmount);
        user.setLotto();
    }

    public void initInputWinningNumber() {
        while (true) {
            try {
                String winningNumberStr = InputWinningNumber();
                String[] winningNumbersStr = adminLottoService.splitWinningNumbers(winningNumberStr);
                winningNumber = adminLottoService.initWinningNumber(winningNumbersStr);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void initInputBonusNumber() {
        while (true) {
            try {
                String bonusNumberStr = InputBonusNumber();
                int bonusNumber = adminLottoService.parseIntBonusNumber(bonusNumberStr);
                admin = adminLottoService.setAdmin(winningNumber, bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public String InputPurchaseAmount() {
        System.out.println(UserInputMessage.INPUT_LOTTO_PURCHASE_AMOUNT_MSG);
        return Console.readLine();
    }

    public String InputWinningNumber() {
        System.out.println(AdminInputOutputMessage.INPUT_LOTTO_WINNING_NUMBER);
        return Console.readLine();
    }

    public String InputBonusNumber() {
        System.out.println(AdminInputOutputMessage.INPUT_LOTTO_BONUS_NUMBER);
        return Console.readLine();
    }

    public void initStats() {
        stat = new Stat();
        for (int index = 0; index < user.getLottoList().size(); index++) {
            adminLottoService.compareCorrectLottoNumbers(user.getLottoList(), admin.getWinnerNumber(), index, stat,
                    admin.getBonusNumber());
        }
    }

    public void printStats() {
        printMatchResult();
        printProfit();
    }

    public void printUserLottoNumbers() {
        List<Lotto> userLottoList = user.getLottoList();
        System.out.println();
        System.out.println(createLottoNumbers + AdminInputOutputMessage.OUTPUT_BUY_TICKETS);
        for (Lotto lotto : userLottoList) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public void printMatchResult() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + stat.getlottoCorrectStat().get("THREE") + "개");
        System.out.println("4개 일치 (50,000원) - " + stat.getlottoCorrectStat().get("FOUR") + "개");
        System.out.println("5개 일치 (1,500,000원) - " + stat.getlottoCorrectStat().get("FIVE") + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + stat.getlottoCorrectStat().get("BONUS") + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + stat.getlottoCorrectStat().get("SIX") + "개");
    }

    public void printProfit() {
        double profit = stat.calculateProfit(user.getPurchaseAmount());
        String roundProfit = String.format("%.1f", profit);
        System.out.print("총 수익률은 ");
        System.out.print(roundProfit);
        System.out.println("%입니다.");
    }
}
