package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int LOTTO_NUMBER_LENGTH = 6;

    public List<Lotto> generateLottos(int quantity){
        List<Lotto> lottos = new ArrayList<>();
        for(int i =0; i < quantity; i++){
            lottos.add(generateLotto());
        }
        return lottos;
    }

    private Lotto generateLotto(){
        List<Integer> lottoNumbers = sortRandomNumbers(generateRandomNumbers());
        return new Lotto(lottoNumbers);
    }

    private List<Integer> generateRandomNumbers(){
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_NUMBER_LENGTH);
    }

    private List<Integer> sortRandomNumbers(List<Integer> numbers) {
        return numbers.stream().sorted().collect(Collectors.toList());
    }
}
