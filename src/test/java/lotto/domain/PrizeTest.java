package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import lotto.dto.ResultResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("당첨 여부를 확인하고 당첨 개수를 증가시키는 테스트")
class PrizeTest {

    @Test
    void 당첨_여부를_확인하고_당첨_개수를_증가시켜라 () {
        //given
        List<Integer> answerNumbers = List.of(1,4,18,21,35,44);
        List<List<Integer>> allLotto = List.of(
                List.of(1,12,14,21,35,43), // 3개 일치
                List.of(4,9,18,21,35,44), //5개 일치 + 보너스 볼 일치
                List.of(3,15,18,29,38,44), //2개 일치
                List.of(1,4,18,21,35,44) //6개 일치
        );
        int bonusNumber = 9;

        //when
        Prize prize = Prize.create(allLotto, answerNumbers, bonusNumber);
        ResultResponse resultResponse = prize.generateResultResponse();
        Map<Integer, Integer> prizeResult = resultResponse.getResponse();

        //then
        assertEquals(1, prizeResult.get(2_000_000_000));
        assertEquals(1, prizeResult.get(30_000_000));
        assertEquals(0, prizeResult.get(1_500_000));
        assertEquals(0, prizeResult.get(50_000));
        assertEquals(1, prizeResult.get(5_000));
    }
}
