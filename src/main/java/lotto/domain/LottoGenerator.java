package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;
    private static final int RANGE = 6;

    public Lotto generateUserLotto(){
        return new Lotto(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, RANGE));
    }

    public void generateWinningLotto(String input){
        // TODO: 당첨 구현 로또 생성
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
