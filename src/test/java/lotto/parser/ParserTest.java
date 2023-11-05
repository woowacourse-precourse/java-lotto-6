package lotto.parser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ParserTest {
    @ParameterizedTest
    @CsvSource(textBlock = """
            '1,2,3,4,5,6',
            '19,24,32,12,1,9'
            """)
    void 로또를_배열로_반환하라 (final String input) {
        //given
        List<Integer> lottoNumber = Parser.parseLotto(input);

        //when, then
        assertThat(lottoNumber).hasSize(6);
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "5000:5", "10000:10"}, delimiter = ':')
    void 구입_금액만큼의_개수를_반환하라(final String input, final int expected) {
        // when
        int result = Parser.parseLottoCount(input);
        // then
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource(value = {"5", "3", "25"})
    void 보너스_번호를_숫자로_반환해라 (final String input) {
        //when
        int bonusNumber = Parser.parseBonusNumber(input);

        //then
        assertEquals(bonusNumber, Integer.parseInt(input));
    }
}
