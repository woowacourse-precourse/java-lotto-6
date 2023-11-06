package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoCollectionGeneratorTest {
    @DisplayName("generate는 수량만큼 로또 객체를 생성해 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 10})
    void check_generate(int lottoCount) {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        LottoCollectionGenerator lottoCollectionGenerator = new LottoCollectionGenerator(lottoCount, numberGenerator);
        assertThat(lottoCollectionGenerator.generate())
                .hasSize(lottoCount)
                .allSatisfy(lotto -> assertThat(lotto).isInstanceOf(Lotto.class));
    }
}
