package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoService {


    public void createLottoNumber(){
        Lotto lotto = new Lotto(createNonDuplicateNumbers());
    }

    public List<Integer> createNonDuplicateNumbers(){
        Set<Integer> numbers = new HashSet<>();
        while(numbers.size()<6){
            numbers.add(Randoms.pickNumberInRange(1,45));
        }
        return numbers.stream().toList();
    }
}
