package lotto.domain.policy;

import lotto.policy.LottoNumberGeneratePolicy;
import lotto.policy.NumberGeneratePolicy;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.RepeatedTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(ReplaceUnderscores.class)
class LottoNumberGeneratePolicyTest {

    @RepeatedTest(value = 10, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    void 로또_번호_생성_정책에_따라_1부터_45까지의_랜덤_번호를_생성한다() {
        // given
        NumberGeneratePolicy policy = new LottoNumberGeneratePolicy();

        // when
        List<Integer> numbers = policy.generate();

        // then
        numbers.forEach(
                number -> assertThat(number).isBetween(1, 45)
        );
    }

}
