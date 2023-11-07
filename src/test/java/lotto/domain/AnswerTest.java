package lotto.domain;

import static lotto.condition.LottoCondition.LOTTO_COUNT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.dto.AnswerResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("당첨 번호 생성 테스트")
class AnswerTest {

    @Test
    void 입력받은_당첨번호를_정렬하여_리스트로_반환하라 () {
        List<Integer> input = List.of(1,32,45,12,7,22);
        Answer answer = Answer.create(input);
        AnswerResponse answerResponse = answer.generateAnswerResponse();
        List<Integer> answerNumbers = answerResponse.getResponse();
        assertEquals(LOTTO_COUNT.getValue(), answerNumbers.size());

        Set<Integer> numberSet = new HashSet<>(answerNumbers);
        assertEquals(answerNumbers.size(), numberSet.size(), "중복된 숫자가 있습니다.");

        for (int number : answerNumbers) {
            assertTrue(number >= 1 && number <= 45, "숫자가 범위를 벗어납니다.");
        }
    }
}
