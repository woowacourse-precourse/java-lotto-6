package lotto.util;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static lotto.util.Validator.*;

class ValidatorTest {

    @Test
    void 로또_구매_금액_검증_예외_테스트() {

        assertThatThrownBy(()->{
            Validator.validateAmount("1000g");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]")
                .hasMessageContaining("숫자만");

        assertThatThrownBy(()->{
            Validator.validateAmount("34800");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]")
                .hasMessageContaining("1000단위로");
    }

    @Test
    void 로또_당첨번호_검증_예외_테스트_1(){
        String lottoNumbers = "1,2,3,49,32,25";

        assertThatThrownBy(()->{
            Validator.validateWinningNumber(lottoNumbers);
        }).hasMessageContaining("[ERROR]")
                .hasMessageContaining("1~45까지만");
    }

    @Test
    void 로또_당첨번호_검증_예외_테스트_2(){
        String lottoNumbers = "1,2,3,49,32,25,41";

        assertThatThrownBy(()->{
            Validator.validateWinningNumber(lottoNumbers);
        }).hasMessageContaining("[ERROR]")
                .hasMessageContaining("6자리로");
    }

    @Test
    void 로또_당첨번호_검증_예외_테스트_3(){
        String lottoNumbers = "1,2,3,49,32,32";

        assertThatThrownBy(()->{
            Validator.validateWinningNumber(lottoNumbers);
        }).hasMessageContaining("[ERROR]")
                .hasMessageContaining("중복이 허용되지");
    }

    @Test
    void 로또_보너스번호_검증_예외_테스트(){
        assertThatThrownBy(()->{
            Validator.validateBonusNumber("81");
        }).hasMessageContaining("[ERROR]")
                .hasMessageContaining("1~45까지만");
    }





}