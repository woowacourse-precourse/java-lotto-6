package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    private static int START_NUMBER = 1;
    private static int LAST_NUMBER = 45;
    private static int LOTTO_SIZE = 6;

    public Lottos(int numberOfLotto){
        for(int i=0;i<numberOfLotto;i++){
            List<Integer> oneLotto = createLotto();
            lottos.add(new Lotto(oneLotto));
        }
        differentCountValidate(numberOfLotto);
    }

    private List<Integer> createLotto(){
        return Randoms.pickUniqueNumbersInRange(START_NUMBER, LAST_NUMBER, LOTTO_SIZE);
    }

    private void differentCountValidate(Integer numberOfLotto){
        if(lottos.size()!=numberOfLotto){
            throw new IllegalArgumentException("[ERROR] 구입한 로또의 갯수와 생성된 로또의 갯수가 다릅니다.");
        }
    }
}
