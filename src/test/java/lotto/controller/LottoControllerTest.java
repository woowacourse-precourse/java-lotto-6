package lotto.controller;

import lotto.constant.LottoRanking;
import lotto.domain.Lotto;
import lotto.domain.dto.LottoAnswer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoControllerTest {
    @Test
    void calculateLottoMatch_테스트() {
        LottoAnswer inputAnswer = new LottoAnswer(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                9
        );
        Lotto inputLotto = new Lotto(
                List.of(2, 3, 4, 5, 6, 9)
        );

        LottoRanking result = LottoController.calculateLottoRank(inputAnswer, inputLotto);

        assertEquals(LottoRanking.SECOND, result);
    }

    @Test
    void calculateLottoResult_테스트() {
        LottoAnswer inputAnswer = new LottoAnswer(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                7
        );
        List<Lotto> inputLottos = new ArrayList<>();
        inputLottos.add(new Lotto(
                List.of(1, 2, 3, 4, 5, 6)
        ));
        inputLottos.add(new Lotto(
                List.of(1, 2, 3, 4, 5, 7)
        ));
        inputLottos.add(new Lotto(
                List.of(1, 2, 3, 10, 11, 12)
        ));
        inputLottos.add(new Lotto(
                List.of(10, 11, 12, 1, 2, 3)
        ));

        Map<LottoRanking, Integer> result = LottoController.calculateLottoResult(inputAnswer, inputLottos);

        assertEquals(1, result.get(LottoRanking.FIRST));
        assertEquals(1, result.get(LottoRanking.SECOND));
        assertEquals(2, result.get(LottoRanking.FIFTH));
    }

    @Test
    void calculateTotalPrize_테스트() {
        Map<LottoRanking, Integer> input = new HashMap<>();
        input.put(LottoRanking.SECOND, 1);
        input.put(LottoRanking.FIFTH, 5);
        int expected = LottoRanking.SECOND.getPrize() + LottoRanking.FIFTH.getPrize() * 5;

        int result = LottoController.calculateTotalPrize(input);

        assertEquals(expected, result);
    }
}
