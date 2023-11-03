package lotto.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Model.Lotto;
import lotto.Model.Lottos;
import lotto.View.PrintView;

import java.util.ArrayList;
import java.util.List;

public class LottoGeneratorController {
    PrintView view;

    public LottoGeneratorController(){
        view = new PrintView();
    }

    public Lottos lottoGenerate(int money){
        Lottos lottos = new Lottos();
        int lotto_cnt = money / 1000;
        for(int i = 0; i < lotto_cnt; i++){
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottos.addLotto(lotto);
        }

        view.generatedLottosPrint(lottos);

        return lottos;
    }

}
