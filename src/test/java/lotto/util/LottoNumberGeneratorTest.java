package lotto.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberGeneratorTest {

    @DisplayName("로또 번호 랜덤 생성이 제대로 되는지 확인한다.")
    @Test
    void generateRandomLottoNumberTest() {
        // given
        List<Integer> lotto = LottoNumberGenerator.generateNumbers();

        // when, then
        System.out.println(lotto);
        Assertions.assertThat(lotto.size()).isEqualTo(6);
    }
}