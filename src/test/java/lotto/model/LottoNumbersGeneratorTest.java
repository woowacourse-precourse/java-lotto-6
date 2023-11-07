package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import java.util.List;
import lotto.fixture.LottoFixture;
import lotto.helper.TestLottoNumbersGenerator;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class LottoNumbersGeneratorTest {

    @Test
    void 중복되지_않는_6자리_로또_번호를_생성한다() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<LottoNumber> lottoNumbers = LottoFixture.createLottoNumbers(numbers);
        NumbersGenerator<LottoNumber> numberNumbersGenerator = new TestLottoNumbersGenerator(numbers);

        // when
        List<LottoNumber> generateNumbers = numberNumbersGenerator.generate();

        // then
        assertSoftly(softly -> {
            softly.assertThat(generateNumbers).hasSize(6);
            softly.assertThat(generateNumbers).isEqualTo(lottoNumbers);
            softly.assertThat(generateNumbers).allSatisfy(
                    number -> assertThat(number.getNumber()).isBetween(1, 45)
            );
        });
    }
}
