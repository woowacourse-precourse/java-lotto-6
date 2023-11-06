package lotto.controller;

import lotto.constant.LottoRank;
import lotto.domain.dto.LottoAnswer;
import lotto.domain.dto.LottoNumbers;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoControllerTest {
    @Test
    void calculateLottoMatch_테스트() {
        LottoAnswer inputAnswer = new LottoAnswer(
                new LottoNumbers(List.of(1, 2, 3, 4, 5, 6)),
                9
        );
        LottoNumbers inputLotto = new LottoNumbers(
                List.of(2, 3, 4, 5, 6, 9)
        );

        LottoRank result = LottoController.calculateLottoRank(inputAnswer, inputLotto);

        assertEquals(LottoRank.SECOND, result);
    }

    @Test
    void calculateLottoResult_테스트() {
        LottoAnswer inputAnswer = new LottoAnswer(
                new LottoNumbers(List.of(1, 2, 3, 4, 5, 6)),
                7
        );
        List<LottoNumbers> inputLottos = new ArrayList<>();
        inputLottos.add(new LottoNumbers(
                List.of(1, 2, 3, 4, 5, 6)
        ));
        inputLottos.add(new LottoNumbers(
                List.of(1, 2, 3, 4, 5, 7)
        ));
        inputLottos.add(new LottoNumbers(
                List.of(1, 2, 3, 10, 11, 12)
        ));
        inputLottos.add(new LottoNumbers(
                List.of(10, 11, 12, 1, 2, 3)
        ));

        Map<LottoRank, Integer> result = LottoController.calculateLottoResult(inputAnswer, inputLottos);

        assertEquals(1, result.get(LottoRank.FIRST));
        assertEquals(1, result.get(LottoRank.SECOND));
        assertEquals(2, result.get(LottoRank.FIFTH));
    }
}
