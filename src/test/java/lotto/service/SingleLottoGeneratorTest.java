package lotto.service;

import static lotto.utils.LottoConstant.LOTTO_END_NUMBER;
import static lotto.utils.LottoConstant.LOTTO_NUMBER_COUNT;
import static lotto.utils.LottoConstant.LOTTO_START_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Lotto;
import org.junit.jupiter.api.RepeatedTest;

class SingleLottoGeneratorTest {

    @RepeatedTest(10)
    void 중복되지_않은_여섯개의_숫자를_생성하여_오름차순으로_정렬하여_반환한다() {
        //Arrange
        SingleLottoGenerator generator = new SingleLottoGenerator();

        //Act
        Lotto lotto = generator.generate();

        //Assert
        assertThat(lotto.getNumbers()).hasSize(LOTTO_NUMBER_COUNT)
                .doesNotHaveDuplicates()
                .allMatch(number -> (LOTTO_START_NUMBER <= number) && (number <= LOTTO_END_NUMBER))
                .isSorted();
    }
}