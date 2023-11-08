package lotto.controller;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.utils.Utils;

public class LottoController {

    public Lotto GenerateLotto() {
        List<Integer> numbersForLotto = new ArrayList<>(Utils.generateRandomNumber());
        Collections.sort(numbersForLotto);
        return new Lotto(numbersForLotto);
    }

}
