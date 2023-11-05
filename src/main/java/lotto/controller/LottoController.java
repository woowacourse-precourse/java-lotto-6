package lotto.controller;

import lotto.service.AdminLottoService;
import lotto.service.UserLottoService;
import lotto.view.UserInputMessage;
import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Admin;
import lotto.domain.User;
import java.util.List;
import java.util.ArrayList;

public class LottoController {
    private final AdminLottoService adminLottoService = new AdminLottoService();
    private final UserLottoService userLottoService = new UserLottoService();
    private User user;
    private Admin admin;

    public void run() {
        initLotto();
        compareLottoNumbers();
        printStats();
    }

    public void initLotto() {
        initInputPurchaseAmount();
        initInputWinningNumberAndBonusNumber();
    }

    public void initInputPurchaseAmount() {
        String purchaseAmountStr = InputPurchaseAmount();
        int purchaseAmount = userLottoService.parseIntPurchaseAmount(purchaseAmountStr);
        int createLottoNumbers = userLottoService.createLottoCount(purchaseAmount);
        userLottoService.createLottos(createLottoNumbers);
    }

    public void initInputWinningNumberAndBonusNumber() {
        String winningNumber = InputWinningNumber();
        String bonusNumberStr = InputBonusNumber();
        ArrayList<Integer> winningNumbers = adminLottoService.parseIntWinningNumber(winningNumber);
        int bonusNumber = adminLottoService.parseIntBonusNumber(bonusNumberStr);
        adminLottoService.setAdmin(winningNumbers, bonusNumber);
    }

    public String InputPurchaseAmount() {
        System.out.println(UserInputMessage.INPUT_LOTTO_PURCHASE_AMOUNT_MSG);
        return Console.readLine();
    }

    public String InputWinningNumber() {
        System.out.println(UserInputMessage.INPUT_LOTTO_WINNING_NUMBER);
        return Console.readLine();
    }

    public String InputBonusNumber() {
        System.out.println(UserInputMessage.INPUT_LOTTO_BONUS_NUMBER);
        return Console.readLine();
    }

    public void compareLottoNumbers() {
        adminLottoService.compareCorrectLottoNumbers();
    }

    public void printStats() {
        printMatchResult();
        printProfit();
    }

    public void printMatchResult(){

    }

    public void printProfit(){

    }
}
