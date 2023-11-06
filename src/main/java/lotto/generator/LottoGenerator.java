package lotto.generator;

import lotto.model.Lotto;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    public LottoGenerator(){}

    private static Lotto makeOneLotto(List<Integer> choiceNumbers){
        Lotto lotto = new Lotto(choiceNumbers);
        return lotto;
    }

    public static List<Lotto> buyLottos(int quantity){
        List<Lotto> lottos = new ArrayList<>();
        for(int i=0; i<quantity; i++){
            lottos.add(makeOneLotto(InputView.choiceNumbers()));
        }
        return lottos;
    }
}
