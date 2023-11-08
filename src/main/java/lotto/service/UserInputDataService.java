package lotto.service;

import lotto.domain.User;
import lotto.view.InputView;
import lotto.view.OutputView;

public class UserInputDataService {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public User inputUserData() {
        User user = new User(inputBuyingPrice());
        setUserLotto(user);
        printLottoNumbers(user);
        return user;
    }
}
