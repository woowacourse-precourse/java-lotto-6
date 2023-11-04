package lotto.utils.validator;

import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BonusNumberValidatorTest {


    @Test
    void 숫자_포맷_테스트(){
        String testInput = "a";
        Assertions.assertThatThrownBy(()->BonusNumberValidator.validate(testInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만");
    }
}