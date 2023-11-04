package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.util.LottoParser;

public class LottoGenerator {
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;
    private static final int RANGE = 6;

    public Lotto generateUserLotto(){
        return new Lotto(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, RANGE));
    }

    public Lotto generateWinningLotto(){
        return new Lotto(LottoParser.parseWinningInputs(Console.readLine()));
    }

    public List<Lotto> generateMultipleLottoByBudget(Budget budget){
        int countOfLottoLine = budget.getCountOfLottoLines();
        List<Lotto> lottos = new ArrayList<>();
        for(int i=0; i< countOfLottoLine; i++){
            lottos.add(generateUserLotto());
        }
        return lottos;
    }
}
