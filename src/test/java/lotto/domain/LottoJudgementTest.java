package lotto.domain;

import lotto.constant.LottoRanking;
import lotto.domain.dto.LottoAnswer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LottoJudgementTest {
    private static LottoAnswer answer;
    private static LottoJudgement judgement;

    @BeforeAll
    static void setUp() {
        answer = new LottoAnswer(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        judgement = new LottoJudgement(answer);
    }

    @Test
    void calculateLottoRanking_로또_리스트가_주어졌을_때() {
        List<Lotto> input = new ArrayList<>();
        input.add(new Lotto(List.of(1, 2, 3, 4, 5, 6))); // 1등
        input.add(new Lotto(List.of(1, 2, 3, 4, 5, 7))); // 2등
        input.add(new Lotto(List.of(1, 2, 3, 4, 8, 9))); // 4등
        input.add(new Lotto(List.of(1, 2, 3, 4, 9, 10))); // 4등

        Map<LottoRanking, Integer> result = judgement.calculateLottoRanking(input);

        assertEquals(1, result.get(LottoRanking.FIRST));
        assertEquals(1, result.get(LottoRanking.SECOND));
        assertEquals(0, result.get(LottoRanking.THIRD));
        assertEquals(2, result.get(LottoRanking.FOURTH));
        assertEquals(0, result.get(LottoRanking.FIFTH));
    }

    @Test
    void calculateLottoRanking_로또가_주어졌을_때() {
        Lotto input = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        LottoRanking result = judgement.calculateLottoRanking(input);

        assertEquals(LottoRanking.FIRST, result);
    }

    @Test
    void calculateTotalPrize() {
        Map<LottoRanking, Integer> input = new HashMap<>();
        input.put(LottoRanking.FIRST, 1);
        input.put(LottoRanking.SECOND, 2);
        input.put(LottoRanking.THIRD, 3);
        input.put(LottoRanking.FOURTH, 4);
        input.put(LottoRanking.FIFTH, 5);

        int expected = LottoRanking.FIRST.getPrize() +
                LottoRanking.SECOND.getPrize() * 2 +
                LottoRanking.THIRD.getPrize() * 3 +
                LottoRanking.FOURTH.getPrize() * 4 +
                LottoRanking.FIFTH.getPrize() * 5;

        int result = LottoJudgement.calculateTotalPrize(input);

        assertEquals(expected, result);
    }
}