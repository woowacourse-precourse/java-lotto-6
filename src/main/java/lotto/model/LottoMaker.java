package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static lotto.validator.Validation.*;
import static lotto.constant.LottoConstant.*;

public class LottoMaker { // 입력받은 금액으로 로또 생성
    private final int money;

    public LottoMaker(String money) {
        validate(money);
        this.money = Integer.parseInt(money);
    }

    private void validate(String money) {
        checkEnter(money);
        checkDigit(money);
        checkZero(money);
        checkAvailableDivide(money);
    }

    public int calculateAmount() {
        return money / LOTTO_MONEY_UNIT;
    }

    public List<Lotto> makeLotto(int amount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(LOTTO_RANGE_START, LOTTO_RANGE_END, LOTTO_NUMBERS_COUNT)));
        }
        return lottos;
    }

    public int getMoney() {
        return money;
    }

}