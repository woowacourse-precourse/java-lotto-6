package lotto.Domain;

import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class VerifierTest {


    @Test
    void inputNoting() {
        assertThatThrownBy(() -> Verifier.inputNoting(null)).
                isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void onlyNumberConsist() {
        assertThatThrownBy(() -> Verifier.onlyNumberConsist("1aa"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void underOneThousand() {
        assertThatThrownBy(() -> Verifier.underOneThousand(100L))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void moduloExist() {
        assertThatThrownBy(() -> Verifier.moduloExist(1001L))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void onlyNumberAndComma() {
        assertThatThrownBy(() -> Verifier.onlyNumberAndComma("1,a,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void fiveCommas() {
        assertThatThrownBy(() -> Verifier.fiveCommas("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void sixBalls() {
        assertThatThrownBy(() -> Verifier.sixBalls(List.of(1,2,3,4,5,6,7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void numberRange() {
        assertThatThrownBy(() -> Verifier.numberRange(List.of(1,2,3,4,5,47)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void sameNumberExist() {
        assertThatThrownBy(() -> Verifier.sameNumberExist(List.of(1,2,3,4,5,5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void bonusNumber() {
        assertThatThrownBy(() -> Verifier.bonusNumber(1,List.of(1,2,3,4,5,6)))
                .isInstanceOf(IllegalArgumentException.class);

    }
}