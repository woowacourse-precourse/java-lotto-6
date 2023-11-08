package lotto.service;

import static lotto.utils.LottoConstant.LOTTO_END_NUMBER;
import static lotto.utils.LottoConstant.LOTTO_NUMBERS_SIZE;
import static lotto.utils.LottoConstant.LOTTO_START_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.lotto.Lotto;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    @Test
    void 로또를_여러개_생성하여_정렬하여_반환한다() {
        //Arrange
        int lottoSize = 10;
        LottoGenerator generator = LottoGenerator.of(lottoSize);

        //Act
        List<Lotto> lottos = generator.generate();

        //Assert
        assertThat(lottos).hasSize(lottoSize);

        for (Lotto lotto : lottos) {
            assertThat(lotto.getNumbers()).hasSize(LOTTO_NUMBERS_SIZE)
                    .doesNotHaveDuplicates()
                    .isSorted()
                    .allMatch(number -> (LOTTO_START_NUMBER <= number) && (number <= LOTTO_END_NUMBER));
        }
    }
}