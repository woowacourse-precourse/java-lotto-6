package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.Model.Price;
import lotto.Model.RandomLottos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomLottosTest {
    private RandomLottos randomLottos;

    @BeforeEach
    void set() {
        Price price = new Price("8000");
        randomLottos = new RandomLottos(price);
    }

    @DisplayName("Price의 값에 따라 생성할 랜덤로또 개수 구하는 테스트")
    @Test
    void countingRandomLottos() {
        int actualCounting = randomLottos.getCounting();
        int expectedCounting = 8;

        assertThat(actualCounting).isEqualTo(expectedCounting);
    }

    @DisplayName("랜덤로또가 개수대로 잘 생성 되는지 테스트")
    @Test
    void createRandomLottos() {
        int actualRandomLottosSize = randomLottos.getRandomLottos().size();
        int expectedRandomLottosSize = 8;

        assertThat(actualRandomLottosSize).isEqualTo(expectedRandomLottosSize);
    }
}
