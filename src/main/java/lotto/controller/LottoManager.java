package lotto.controller;

import static lotto.utility.Constants.LOTTO_LENGTH;
import static lotto.utility.Constants.MAX_LOTTO_NUMBER;
import static lotto.utility.Constants.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.User;
import lotto.view.UserView;

public class LottoManager {
    private UserView userView;
    private User user;
    public LottoManager() {
        userView = new UserView();
        user = new User();
    }

    public void start() {
        userView.printBuyMessageBefore();
        user.setPurchaseAmount(UserInput.PurchaseAmount());
        user.setPurchaseLottoNumber(UserInput.calculatePurchaseLottoNumber(user.getPurchaseAmount()));
        userView.printBuyMessageAfter(user.getPurchaseLottoNumber());

        Lotto temp = generateLotto();
        System.out.println(temp.getSortedNumbers());
    }

    private Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_LENGTH);
        Lotto newLotto = new Lotto(numbers);
        return newLotto;
    }
}
