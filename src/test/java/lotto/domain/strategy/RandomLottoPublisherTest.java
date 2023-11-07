package lotto.domain.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RandomLottoPublisherTest {

    @Test
    void 지정한_숫자의_랜덤한_로또가_만들어집니다() {
        var numbers = List.of(1, 2, 3, 4, 5, 6);
        final var randomLottoPublisher = new RandomLottoPublisher(() -> numbers);
        final var lotto = randomLottoPublisher.publish();
        assertThat(lotto.getNumbers()).isEqualTo(numbers);
    }

}