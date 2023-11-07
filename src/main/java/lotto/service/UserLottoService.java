package lotto.service;

import lotto.domain.User;
import lotto.view.InputView;
import lotto.view.OutputView;


public class UserLottoService {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public User inputUserData() {
        User user = new User(inputBuyingPrice());
        setUserLotto(user);
        printLottoNumbers(user);
        return user;
    }

    public int inputBuyingPrice() {
        outputView.askBuyingPriceView();
        int price = inputView.inputPriceView();
        return price;
    }

    public void setUserLotto(User user) {
        outputView.responseBuyingQuantity(user);
        user.setLottos(getPrice(user));
    }

    public void printLottoNumbers(User user) {
        outputView.responseUserLottoNumber(user);
    }

    public int getPrice(User user) {
        return user.getBuyingPrice();
    }
}
