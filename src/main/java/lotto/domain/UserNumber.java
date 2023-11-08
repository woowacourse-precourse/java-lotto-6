package lotto.domain;

import static lotto.view.InputView.inputBonusNumber;
import static lotto.view.InputView.inputLottoNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.Lotto;

public class UserNumber {
    public static List<Integer> userLotto = new ArrayList<>();
    public static int bonus = 0;

    public static List<Integer> userNumber() {
        List<String> stringLotto = Arrays.asList(inputLottoNumber().split(","));
        for (int i = 0; i < stringLotto.size(); i++) {
            userLotto.add(Integer.parseInt(stringLotto.get(i)));
        }
        Lotto.validateLottoNumber(userLotto);
        return userLotto;
    }

}
