package lotto.domain;

import static lotto.domain.LottoRank.FIFTH;
import static lotto.domain.LottoRank.FIRST;
import static lotto.domain.LottoRank.FOURTH;
import static lotto.domain.LottoRank.NOTHING;
import static lotto.domain.LottoRank.SECOND;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("LottoNumber 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LottoResultTest {

    @Test
    void create_정적_팩토리_메소드는_당첨등수를_갖는_자료구조를_초기화한다() {
        LottoResult lottoResult = LottoResult.create();

        Assertions.assertTrue(isEquals(lottoResult.getResult()));
    }

    private boolean isEquals(Map<LottoRank, Integer> result) {
        return Arrays.stream(LottoRank.values())
                .filter(LottoRank::isNotNothing)
                .allMatch(result::containsKey);
    }


}
