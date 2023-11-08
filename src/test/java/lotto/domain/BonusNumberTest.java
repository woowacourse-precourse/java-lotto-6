package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Collections;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayName("[Unit] BonusNumber에 관한 테스트")
@DisplayNameGeneration(ReplaceUnderscores.class)
public class BonusNumberTest {
    @Test
    void constructor_1부터_45_사이의_수가_아니라면_예외를_발생() {
        assertThatThrownBy(() ->
                new BonusNumber(46)
        )
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void matches_빈_배열을_입력_받으면_예외를_발생() {
        BonusNumber number = new BonusNumber(1);

        assertThatThrownBy(() ->
                number.matches(Collections.emptyList())
        )
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void matches_null_값이면_예외를_발생() {
        BonusNumber number = new BonusNumber(1);

        assertThatThrownBy(() -> number.matches(null))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
