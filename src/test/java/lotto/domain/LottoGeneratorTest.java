package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoGeneratorTest {


    @DisplayName("로또 개수만큼 로또를 생성해주는 메서드")
    @ParameterizedTest
    @ValueSource(ints = {1, 10, 8})
    void createLottos(int lottoCount) {
        assertThat(LottoGenerator.createLottos(lottoCount).size()).isEqualTo(lottoCount);
    }



}