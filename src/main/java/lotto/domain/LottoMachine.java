package lotto.domain;

import lotto.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private Lotto createLotto() {
        return new Lotto(RandomUtil.createRandomNumbers());
    }
}
