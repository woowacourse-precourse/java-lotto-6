package lotto.controller;

import static lotto.constant.GeneralConstant.INT_NULL;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoCompany;
import lotto.domain.User;
import lotto.util.NumberValidator;
import lotto.util.StringUtil;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private static boolean success;
    private static String input;
    private static List<Lotto> userLotto;
    public static void run() {
        inputMoney();
        printLottos();
        inputPrizeNumbers();
        inputBonusNumber();
        matchLottoByCompany();
        printRateOfReturn();
    }

    private static void inputMoney() {
        success = false;
        while (!success) {
            tryInputMoney();
        }
    }

    private static void tryInputMoney() {
        try {
            input = InputView.inputMoney();
            int money = changeStringToInt(input);
            User.purchaseLotto(money);
            success = true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printLottos() {
        userLotto = User.getMyLotto();
        OutputView.printPurchase(userLotto.size());
        OutputView.printLottos(userLotto);
    }

    private static void inputPrizeNumbers() {
        success = false;
        while (!success) {
            tryInputPrizeNumbers();
        }
    }

    private static void tryInputPrizeNumbers() {
        try {
            input = InputView.inputPrizeNumber();
            setPrizeNumbers(input);
            success = true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void setPrizeNumbers(String input) {
        List<String> splitString = StringUtil.splitWithComma(input);
        List<Integer> prizeNumbers = new ArrayList<Integer>();
        for(String string : splitString) {
            prizeNumbers.add(changeStringToInt(string));
        }
        LottoCompany.setPrizeNumbers(prizeNumbers);
    }

    private static void inputBonusNumber() {
        success = false;
        while (!success) {
            tryInputBonusNumber();
        }
    }

    private static void tryInputBonusNumber() {
        try {
            input = InputView.inputBonusNumber();
            setBonusNumber(input);
            success = true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void setBonusNumber(String input) {
        int bonusNumber = changeStringToInt(input);
        LottoCompany.setBonusNumber(bonusNumber);
    }

    private static void matchLottoByCompany() {
        for(Lotto lotto : userLotto) {
            int rank = LottoCompany.matchPrize(lotto.getNumbers());
            receivePrize(rank);
        }
    }

    private static void receivePrize(int rank) {
        if(rank != INT_NULL){
            User.plusPrizeCount(rank);
        }
    }

    private static void printRateOfReturn() {
        User.calcRateOfReturn();
        OutputView.printPrizeStatistics(User.getPrizeCounts());
        OutputView.printRateOfReturn(User.getRateOfReturn());
    }

    private static int changeStringToInt(String input) {
        NumberValidator.validateChangeNumber(input);
        return StringUtil.convertStringToInt(input);
    }
}
