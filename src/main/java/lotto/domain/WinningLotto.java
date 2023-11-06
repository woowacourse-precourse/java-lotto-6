package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    private static final String DELIMITER = ",";

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

        for (String s : lotto.split(DELIMITER)) {
            parseLotto.add(Integer.parseInt(s));
        }

        return new Lotto(parseLotto);
    }

    public Lotto getLotto() {
        return lotto;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }

}
