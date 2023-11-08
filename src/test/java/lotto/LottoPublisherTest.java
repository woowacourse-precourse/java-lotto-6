package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.helper.FixedNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPublisherTest {
    List<List<Integer>> numbers;
    FixedNumberGenerator fixedNumberGenerator;
    LottoPublisher lottoPublisher;

    @BeforeEach
    void setUp() {
        fixedNumberGenerator = new FixedNumberGenerator();
        lottoPublisher = new LottoPublisher(fixedNumberGenerator);
    }

    @DisplayName("생성된 로또 번호로 로또 발행 시 예외가 발생하면 다시 발행한다.")
    @Test
    void publishLottoByException() {
        numbers = List.of(
                List.of(0, 0, 0, 0, 0, 0),
                List.of(1, 2, 3, 4, 5, 6));
        fixedNumberGenerator.setNumbers(numbers);

        lottoPublisher.publishBundle(1);

        assertThat(fixedNumberGenerator.getCounter()).isEqualTo(2);
    }
}
