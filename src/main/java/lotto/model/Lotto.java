package lotto.model;


import java.util.*;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;


public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers
                .stream().
                map(number -> new LottoNumber(number))
                .collect(Collectors.toList());
    }


    public Lotto() {
        List<Integer> randomLottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
       
        this.numbers = randomLottoNumbers
                .stream()
                .map(number -> new LottoNumber(number))
                .collect(Collectors.toList());
    }


}
