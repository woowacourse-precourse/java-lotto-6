package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Lottos {
    List<Lotto> lottos = new ArrayList<>();
    
    Lottos(int number){
        for (int i = 0; i < number; i++) {
            addLotto(makeLotto());
        }
    }
    
    Lotto makeLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        Lotto lotto = new Lotto(numbers);
        return lotto;
    }
    
    void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }
    
    void printLottos() {
        for (Lotto e : lottos) {
            System.out.println(e);
        }
    }
}
