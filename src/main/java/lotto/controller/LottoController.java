package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.view.UserOutput;

public class LottoController {
    private final List<Lotto> lottoInventory;
    private final UserOutput userOutput;

    public LottoController() {
        lottoInventory = new ArrayList<>();
        userOutput = new UserOutput();
    }
    public List<Lotto> lottoIndexGenerate(int money){
        int num = money/1000;

        userOutput.outputCount(num);
        for(int i=0; i<num; i++){
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6));
            lottoInventory.add(lotto);
        }
        userOutput.outputGenerateNumber(lottoInventory);
        return lottoInventory;
    }
}
