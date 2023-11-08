package lotto;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Set;
import lotto.Validator.LottoValidator;

public class Player {
    private final List<Lotto> lottos;

    public Player() {
        this.lottos = new ArrayList<>();
    }
    public int getLottoSize(){
        return this.lottos.size();
    }

    private List<Integer> getRandomNumbers(int numberCount){
        return Randoms.pickUniqueNumbersInRange(1,45, numberCount);
    }

    public void makeLotto(int lottoCount){
        for(int count = 0; count < lottoCount; count++){
            this.lottos.add(new Lotto((getRandomNumbers(LottoValidator.getLottoSize()))));
        }
    }
}
