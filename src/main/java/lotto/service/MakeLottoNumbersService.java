package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MakeLottoNumbersService {

    List<HashSet<Integer>> makeLottoNumbers(Integer lottoCount){
        List<HashSet<Integer>> lottoNumbersArray = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoNumbersArray.add(new HashSet<>(numbers));
        }
        return lottoNumbersArray;
    }
}
