package lotto.model.service;

import lotto.model.Profit;
import lotto.model.Validator;
import lotto.view.Input;
import lotto.view.Output;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {
    Profit profit = new Profit();
    Input input = new Input();
    Output output = new Output();
    Validator validator = new Validator();
    LottoService lottoService = new LottoService(profit,input,output,validator);

    @DisplayName("추가 숫자 잘못 입력한 경우")
    @Test
    void Invalid8(){
        String userInput = "-1,2,3,4,5,46";
        assertThatThrownBy(()->validator.validatePickSixNumber(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}