package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;

public class LottoController {
    private final List<Lotto> lottoInventory;

    public LottoController() {
        lottoInventory = new ArrayList<>();
    }
    public List<Lotto> lottoIndexGenerate(int money){
        int num = money/1000;

        for(int i=0; i<num; i++){
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6));
            lottoInventory.add(lotto);
        }

        return lottoInventory;
    }
}
