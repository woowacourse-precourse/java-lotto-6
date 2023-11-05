package lotto.controller;

import static lotto.utility.Constants.LOTTO_LENGTH;
import static lotto.utility.Constants.MAX_LOTTO_NUMBER;
import static lotto.utility.Constants.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.view.UserView;

public class LottoManager {
    private User user;
    private UserView userView;
    public LottoManager() {
        user = new User();
        userView = new UserView();
    }

    public void start() {
        userView.printBuyMessageBefore();
    }

    private Lotto generateLotto() {
        List<Integer> numbers = new ArrayList<>();
        numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_LENGTH);
        Lotto newLotto = new Lotto(numbers);
        return newLotto;
    }
}
