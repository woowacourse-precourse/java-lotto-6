package lotto.service;

import lotto.domain.User;
import lotto.view.InputView;
import lotto.view.ResultView;

public class UserInputDataService {
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public User inputUserData() {
        User user = new User(inputBuyingPrice());
        setUserLotto(user);
        printLottoNumbers(user);
        return user;
    }

    public int inputBuyingPrice() {
        resultView.askBuyingPriceView();
        int buyingPrice = inputView.inputBuyingPriceView();
        return buyingPrice;
    }

    public void setUserLotto(User user) {
        resultView.responseBuyingQuantity(user);
        user.setLottos(getBuyingPrice(user));
    }

    public void printLottoNumbers(User user) {
        resultView.responseUserLottoNumber(user);
    }

    public int getBuyingPrice(User user) {
        return user.getBuyingPrice();
    }
}