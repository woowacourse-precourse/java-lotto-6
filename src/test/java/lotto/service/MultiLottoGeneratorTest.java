package lotto.service;

import static lotto.io.message.OutputMessage.LOTTO_PURCHASE_AMOUNT_MESSAGE;
import static lotto.service.LottoConstant.LOTTO_END_NUMBER;
import static lotto.service.LottoConstant.LOTTO_NUMBER_COUNT;
import static lotto.service.LottoConstant.LOTTO_START_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
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
        MultiLottoGenerator generator = new MultiLottoGenerator(new SingleLottoGenerator(), lottoCount);

        //Act
        List<List<Integer>> lottos = generator.generate();

        //Assert
        assertThat(outputStreamCaptor.toString())
                .contains(String.format("%d%s", lottoCount, LOTTO_PURCHASE_AMOUNT_MESSAGE.getMessage()));

        assertThat(lottos).hasSize(lottoCount);

        for (List<Integer> lotto : lottos) {
            assertThat(lotto).hasSize(LOTTO_NUMBER_COUNT)
                    .doesNotHaveDuplicates()
                    .allMatch(number -> (LOTTO_START_NUMBER <= number) && (number <= LOTTO_END_NUMBER))
                    .isSorted();
        }
    }

    @Test
    void 생성한_로또들을_출력한다() {
        //Arrange
        int lottoCount = 10;
        MultiLottoGenerator generator = new MultiLottoGenerator(new SingleLottoGenerator(), lottoCount);

        //Act
        List<List<Integer>> lottos = generator.generate();

        //Assert
        String output = outputStreamCaptor.toString();
        assertThat(lottos).hasSize(lottoCount);

        assertThat(output).contains(String.format("%d%s\n", lottoCount, LOTTO_PURCHASE_AMOUNT_MESSAGE.getMessage()));

        lottos.forEach(lotto ->
                assertThat(output).contains(lottoToString(lotto))
        );
    }

    private String lottoToString(List<Integer> lotto) {
        return "[" + String.join(", ", lotto.stream().map(String::valueOf).toArray(String[]::new)) + "]";
    }

}