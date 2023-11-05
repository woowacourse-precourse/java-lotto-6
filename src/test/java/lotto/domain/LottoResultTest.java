package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.config.Message;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @Test
    void 올바르게_로또_결과_문자열_생성() {
        // Given
        List<Integer> firstLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> secondLottoNumbers = List.of(7, 8, 9, 10, 11, 12);
        List<Lotto> lottos = List.of(Lotto.from(firstLottoNumbers), Lotto.from(secondLottoNumbers));
        String expectedResult = firstLottoNumbers + Message.NEW_LINE + secondLottoNumbers;

        // When
        LottoResult lottoResult = LottoResult.from(lottos);
        String actualResult = lottoResult.getLottoResult();

        // Then
        assertEquals(expectedResult, actualResult);
    }
}