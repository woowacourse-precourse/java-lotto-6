package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.NumberConstant;

public class LottoMachine {
    private final List<Lotto> lottos;
    public LottoMachine(int money){
        this.lottos = new ArrayList<>();
    }
}
