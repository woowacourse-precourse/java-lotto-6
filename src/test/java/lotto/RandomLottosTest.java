package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.Model.Price;
import lotto.Model.RandomLottos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomLottosTest {
    private RandomLottos randomLottos;
    private Price price;

    @BeforeEach
    void set() {
        price = new Price("8000");
        randomLottos = new RandomLottos(price);
    }

    @DisplayName("Price의 값에 따라 생성할 랜덤로또 개수 구하는 테스트")
    @Test
    void countRandomLottos() {
        int actual = randomLottos.getCount();
        int expected = 8;

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("랜덤로또가 개수대로 잘 생성 되는지 테스트")
    @Test
    void createRandomLottos() {
        int actualSize = randomLottos.getRandomLottos().size();
        int expectedSize = 8;

        assertThat(actualSize).isEqualTo(expectedSize);
    }
}
