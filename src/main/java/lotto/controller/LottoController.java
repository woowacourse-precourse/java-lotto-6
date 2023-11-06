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
    private boolean success;
    private String input;
    private List<Lotto> userLotto;
    private final User user;
    private final LottoCompany lottoCompany;

    public LottoController(User user, LottoCompany lottoCompany) {
        this.user = user;
        this.lottoCompany = lottoCompany;
    }

    public void run() {
        inputMoney();
        printLottos();
        inputPrizeNumbers();
        inputBonusNumber();
        matchLottoByCompany();
        printRateOfReturn();
    }

    private void inputMoney() {
        success = false;
        while (!success) {
            tryInputMoney();
        }
    }

    private void tryInputMoney() {
        try {
            input = InputView.inputMoney();
            int money = changeStringToInt(input);
            user.purchaseLotto(money);
            success = true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void printLottos() {
        userLotto = user.getMyLotto();
        OutputView.printPurchase(userLotto.size());
        OutputView.printLottos(userLotto);
    }

    private void inputPrizeNumbers() {
        success = false;
        while (!success) {
            tryInputPrizeNumbers();
        }
    }

    private void tryInputPrizeNumbers() {
        try {
            input = InputView.inputPrizeNumber();
            setPrizeNumbers(input);
            success = true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void setPrizeNumbers(String input) {
        List<String> splitString = StringUtil.splitWithComma(input);
        List<Integer> prizeNumbers = new ArrayList<Integer>();
        for(String string : splitString) {
            prizeNumbers.add(changeStringToInt(string));
        }
        lottoCompany.setPrizeNumbers(prizeNumbers);
    }

    private void inputBonusNumber() {
        success = false;
        while (!success) {
            tryInputBonusNumber();
        }
    }

    private void tryInputBonusNumber() {
        try {
            input = InputView.inputBonusNumber();
            setBonusNumber(input);
            success = true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void setBonusNumber(String input) {
        int bonusNumber = changeStringToInt(input);
        lottoCompany.setBonusNumber(bonusNumber);
    }

    private void matchLottoByCompany() {
        for(Lotto lotto : userLotto) {
            int rank = lottoCompany.matchPrize(lotto.getNumbers());
            receivePrize(rank);
        }
    }

    private void receivePrize(int rank) {
        if(rank != INT_NULL){
            user.plusPrizeCount(rank);
        }
    }

    private void printRateOfReturn() {
        user.calcRateOfReturn();
        OutputView.printPrizeStatistics(user.getPrizeCounts());
        OutputView.printRateOfReturn(user.getRateOfReturn());
    }

    private int changeStringToInt(String input) {
        NumberValidator.validateChangeNumber(input);
        return StringUtil.convertStringToInt(input);
    }
}
