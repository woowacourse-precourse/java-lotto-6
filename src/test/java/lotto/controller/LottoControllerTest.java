package lotto.controller;

import lotto.constant.LottoRank;
import lotto.domain.dto.LottoAnswer;
import lotto.domain.dto.LottoNumbers;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoControllerTest {
    @Test
    void calculateLottoMatch_테스트() {
        List<Integer> inputAnswer = List.of(1, 2, 3, 4, 5, 6);
        int inputBonus = 9;
        List<Integer> inputLotto = List.of(2, 3, 4, 5, 6, 9);

        LottoAnswer answer = new LottoAnswer(new LottoNumbers(inputAnswer), inputBonus);
        LottoNumbers lotto = new LottoNumbers(inputLotto);

        LottoRank result = LottoController.calculateLottoRank(answer, lotto);

        assertEquals(LottoRank.SECOND, result);
    }
}
