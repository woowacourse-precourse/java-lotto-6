package lotto.domain.generator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberGeneratorTest {

    @DisplayName("입력된 문자열 형태의 숫자들을 정렬된 숫자 리스트로 변환하는지 확인합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "1,3,4,2,5,6", "2,3,4,6,5,1"})
    void createByInput(String input) {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);

        assertThat(lottoNumberGenerator.createByInput(input)).isEqualTo(expected);
    }
}