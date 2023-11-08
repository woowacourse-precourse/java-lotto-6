package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    List <Lotto> lottos = new ArrayList<>();

    public List<Lotto> print(int numberOfLotto){

        for(int i=0;i<numberOfLotto;i++){
            List<Integer> pickNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(pickNumber);
            lottos.add(lotto);
        }

        return lottos;
    }

    public void showLottos(){
        for(Lotto lotto: lottos){
            System.out.println(lotto.toString());
        }
    }
}
