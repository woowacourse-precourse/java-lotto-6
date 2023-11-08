package lotto.service;

import lotto.model.Result;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class LottoMachineTest {

    @Test
    void getScore() {
        LottoMachine lottoMachine = new LottoMachine();
        HashMap<Result, Integer> resultMap = new HashMap<>();
        resultMap.put(Result.FOURTH, 1);
        resultMap.put(Result.FALSE, 99);
        double score = lottoMachine.getScore(resultMap);

        Assertions.assertThat(score).isEqualTo(50);
    }

    @Test
    void test() {
        LottoMachine lottoMachine = new LottoMachine();
        HashMap<Result, Integer> resultMap = new HashMap<>();
        resultMap.put(Result.FIRST, 1);
        double score = lottoMachine.getScore(resultMap);

        Assertions.assertThat(score).isEqualTo(200000000);
    }

}