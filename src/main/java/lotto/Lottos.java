package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Lottos {
    static final int NUMBER_OF_NUMBERS = 6;
    static final int MIN_OF_NUMBER = 1;
    static final int MAX_OF_NUMBER = 45;
    
    List<Lotto> lottos = new ArrayList<>();
    
    Lottos(int number){
        for (int i = 0; i < number; i++) {
            addLotto(makeLotto());
        }
    }
    
    Lotto makeLotto() {
        List<Integer> immutableNumbers = Randoms.pickUniqueNumbersInRange(MIN_OF_NUMBER, MAX_OF_NUMBER, NUMBER_OF_NUMBERS);
        List<Integer> numbers = new ArrayList<>(immutableNumbers);
        Collections.sort(numbers);
        Lotto lotto = new Lotto(numbers);
        return lotto;
    }
    
    void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }
    
    void printLottos() {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
