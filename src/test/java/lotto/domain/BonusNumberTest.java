package lotto.domain;

import lotto.utils.Converter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @Test
    void 중복_예외_테스트() {
        String numbers = "1,2,3,4,5,6";
        Lotto lotto = Converter.stringToLotto(numbers);
        int inputBonusNumber = 5;

        Assertions.assertThatThrownBy(() -> new BonusNumber(inputBonusNumber, lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복");
    }


    @Test
    void 번호_범위_예외_테스트() {
        String numbers = "1,2,3,4,5,6";
        Lotto lotto = Converter.stringToLotto(numbers);
        int inputBonusNumber = -1;

        Assertions.assertThatThrownBy(() -> new BonusNumber(inputBonusNumber, lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1부터 45");
    }

}