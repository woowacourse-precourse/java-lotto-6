package lotto.domain.strategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Objects;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.RepeatedTest;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RandomNumbersGeneratorTest {

    @RepeatedTest(100)
    void _1에서_45까지의_랜덤한_6자리의_숫자가_만들어_집니다() {
        final var numbers = new RandomNumbersGenerator().generate();

        Objects.requireNonNull(numbers);
        assertAll(
                () -> assertThat(numbers).hasSize(6),
                () -> numbers.forEach(number -> assertThat(number).isBetween(1, 45))
        );
    }

}