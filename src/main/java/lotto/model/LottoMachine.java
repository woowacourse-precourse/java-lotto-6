package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.NumberConstant;

public class LottoMachine {
    private final List<Lotto> lottos;

    public LottoMachine(int money){
        validPositive(money);
        validMoney(money);
        this.lottos = new ArrayList<>();
    }

    private void validMoney(int money){
        if (money % NumberConstant.LOTTO_PRICE != NumberConstant.DEFAULT_VALUE){
            throw new IllegalArgumentException();
        }
    }

    private void validPositive(int money){
        if (money < NumberConstant.DEFAULT_VALUE){
            throw new IllegalArgumentException();
        }
    }
}
