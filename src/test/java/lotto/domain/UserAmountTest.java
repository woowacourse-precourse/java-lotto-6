package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserAmountTest {

    @ParameterizedTest
    @ValueSource(strings = {"one", "two", "three", "yoon", "su"})
    void 로또_굳입_금액이_숫자가_아니면_IllegalArgumentException_발생_검증(String userAmount) {
        assertThatThrownBy(() ->UserAmount.from(userAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 구입 금액은 숫자여야 합니다.");
    }
}
