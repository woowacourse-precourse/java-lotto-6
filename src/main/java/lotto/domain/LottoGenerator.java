package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.util.LottoParser;

public class LottoGenerator {
    private LottoGenerateStrategy lottoGenerateStrategy;

    public LottoGenerator(LottoGenerateStrategy lottoGenerateStrategy){
        this.lottoGenerateStrategy = lottoGenerateStrategy;
    }

    public Lotto generateLotto(){
        return this.lottoGenerateStrategy.generate();
    }

    public Lottos generateLottosByBudget(Budget budget){
        int countOfLottoLine = budget.getCountOfLottoLines();
        List<Lotto> lottos = new ArrayList<>();
        for(int i=0; i< countOfLottoLine; i++){
            lottos.add(generateLotto());
        }
        return Lottos.from(lottos);
    }
}
