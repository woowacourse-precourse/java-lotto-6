package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.Optional;

class LottoResultTest {

    @DisplayName("로또결과 생성 테스트 : 로또 당첨에 해당하지 않는다면 빈 값을 반환한다.")
    @ParameterizedTest(name = "당첨번호와 일치개수가 {0}개라면 반환되는 당첨 결과는 없다.")
    @ValueSource(ints = {0, 1, 2})
    void create(int matchingNumbers) {
        Optional<LottoResult> result = LottoResult.create(matchingNumbers, true);

        assertThat(result.isEmpty()).isTrue();
    }

    @DisplayName("로또결과 생성 테스트 : 로또 당첨에 해당하지 않는다면 빈 값을 반환한다.")
    @ParameterizedTest(name = "당첨번호와 일치개수가 {0}개라면 반환되는 당첨 결과는 없다.")
    @ValueSource(ints = {0, 1, 2})
    void createEmptyResult(int matchingNumbers) {
        Optional<LottoResult> result = LottoResult.create(matchingNumbers, true);

        assertThat(result.isEmpty()).isTrue();
    }
}