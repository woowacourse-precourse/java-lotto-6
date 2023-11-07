package lotto.service;

import static lotto.utils.LottoConstant.LOTTO_END_NUMBER;
import static lotto.utils.LottoConstant.LOTTO_NUMBER_COUNT;
import static lotto.utils.LottoConstant.LOTTO_START_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import lotto.domain.number.Lotto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MultiLottoGeneratorTest {

    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }

    @Test
    void 로또를_여러개_생성하여_반환한다() {
        //Arrange
        int lottoCount = 10;
        MultiLottoGenerator generator = MultiLottoGenerator.of(new SingleLottoGenerator(), lottoCount);

        //Act
        List<Lotto> lottos = generator.generate();

        //Assert
        assertThat(lottos).hasSize(lottoCount);

        for (Lotto lotto : lottos) {
            assertThat(lotto.getNumbers()).hasSize(LOTTO_NUMBER_COUNT)
                    .doesNotHaveDuplicates()
                    .allMatch(number -> (LOTTO_START_NUMBER <= number) && (number <= LOTTO_END_NUMBER))
                    .isSorted();
        }
    }
}