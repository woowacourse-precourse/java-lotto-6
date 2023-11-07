package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.constant.Constants.WINNING_LOTTO_DELIMITER;

public class WinningLotto {

    private Lotto lotto;
    private BonusNumber bonusNumber;

    public void createLotto(String lotto) {
        this.lotto = parseLottoNumber(lotto);
    }

    public void createBonusNumber(String bonusNumber) {
        this.bonusNumber = new BonusNumber(bonusNumber);
    }

    private static Lotto parseLottoNumber(String lotto) {
        List<Integer> parseLotto = new ArrayList<>();

        for (String s : lotto.split(WINNING_LOTTO_DELIMITER)) {
            parseLotto.add(Integer.parseInt(s));
        }
        Collections.sort(parseLotto);

        return new Lotto(parseLotto);
    }

    public Lotto getLotto() {
        return lotto;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }

}
