package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class InputProcessor {
    private static final int LOTTO_PRICE = 1000;

    public int calculateLottoCount(int purchaseAmount) {
      return purchaseAmount / LOTTO_PRICE;
    }

}

