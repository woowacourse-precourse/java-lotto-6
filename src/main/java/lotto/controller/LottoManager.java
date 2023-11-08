package lotto.controller;

import static lotto.view.LottoNumbersDisplay.displayLottos;

import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.controller.UserInputController;
import lotto.view.LottoNumbersDisplay;
import lotto.view.MessageDisplay;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {
    User user;
    List<Integer> winNumbers;
    int bonusNumber;
    public LottoManager() {
        getUserLotto();
        displayLottos(user.getUserLottos());
        winNumbers = new ArrayList<>();
        setWinNumbers();
        setBonusNumber();
    }
    private void getUserLotto() {
        MessageDisplay.enterBuyingPrice();
        int buyingPrice = UserInputController.getLottoBuyingPrice();
        user = new User(buyingPrice);
        MessageDisplay.writeBuyingPrice(buyingPrice);
    }
    private void setWinNumbers() {
        MessageDisplay.enterWinNumber();
        this.winNumbers = UserInputController.getWinNumbers();
        System.out.print("\n");
    }
    private void setBonusNumber() {
        MessageDisplay.enterBonusNumber();
        this.bonusNumber = UserInputController.getBonusNumbers();
        System.out.print("\n");
    }
}
