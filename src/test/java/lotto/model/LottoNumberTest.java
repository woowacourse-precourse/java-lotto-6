package lotto.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoNumberTest {

    @Test
    @DisplayName("로또 번호의 숫자 범위에 어긋나는 경우 예외를 발생한다.")
    void validRange(){
        Assertions.assertAll(
                () -> assertThatThrownBy(() -> new LottoNumber(0))
                        .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR]"),
                () -> assertThatThrownBy(() -> new LottoNumber(46))
                        .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR]")
        );
    }

}