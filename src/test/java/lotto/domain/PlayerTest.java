package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {
    private Player player;
    private NumberGenerator numberGenerator;

    @BeforeEach
    void setUp() {
        numberGenerator = new MockNumberGenerator();
        player = new Player(numberGenerator);
    }

    @DisplayName("주어진 금액으로 로또를 1,000원에 1개씩 임의의 번호로 정렬되게 발행한다.")
    @Test
    void generateLottos() {
        Money money = new Money(1000L);

        List<Lotto> actual = player.generateLottos(money);

        List<Integer> pickedNumbers = numberGenerator.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> sortedNumbers = pickedNumbers.stream().sorted().toList();
        assertThat(actual).hasSize(1);
        assertThat(actual.get(0).numbers()).isEqualTo(sortedNumbers);
    }
}
