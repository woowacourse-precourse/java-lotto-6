package lotto.domain;

import java.util.Collections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("[Unit] Lotto에 관한 테스트")
@DisplayNameGeneration(ReplaceUnderscores.class)
class LottoTest {

    @Nested
    class 생성자_테스트 {

        @Test
        void 로또_번호의_개수가_6개가_넘어가면_예외가_발생() {
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 로또_번호에_중복된_숫자가_있으면_예외가_발생() {
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 로또_번호가_1부터_45_까지의_숫자가_아니라면_예외가_발생() {
            assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 5)))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 리스트가_빈_배열이라면_예외가_발생() {
            assertThatThrownBy(() -> new Lotto(Collections.emptyList()))
                    .isInstanceOf(IllegalArgumentException.class);
        }

    }

    @Nested
    class matches_테스트 {

        Lotto lotto;

        @BeforeEach
        void setUp() {
            lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        }

        @Test
        void 로또_번호의_개수가_6개가_넘어가면_예외가_발생() {
            assertThatThrownBy(() -> lotto.matches(List.of(1, 2, 3, 4, 5, 6, 7)))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 로또_번호에_중복된_숫자가_있으면_예외가_발생() {
            assertThatThrownBy(() -> lotto.matches(List.of(1, 2, 3, 4, 5, 5)))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 로또_번호가_1부터_45_까지의_숫자가_아니라면_예외가_발생() {
            assertThatThrownBy(() -> lotto.matches(List.of(0, 1, 2, 3, 4, 5)))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 리스트가_빈_배열이라면_예외가_발생() {
            assertThatThrownBy(() -> lotto.matches(Collections.emptyList()))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    void getNumbers_불변값을_반환한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> {
            List<Integer> numbers = lotto.getNumbers();
            numbers.set(0, 123);
        })
                .isInstanceOf(UnsupportedOperationException.class);
    }
}