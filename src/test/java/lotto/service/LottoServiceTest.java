package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    @AfterEach
    void closeConsole() {
        Console.close();
    }


    @DisplayName("지불한 금액에 만큼 로또를 생성해서 반환한다.")
    @Test
    void buyLotto() {
        //given
        LottoService lottoService = new LottoServiceImpl();
        System.setIn(input("2000"));

        //when
        List<List<Integer>> myLottos = lottoService.buyLotto();

        //then
        assertThat(myLottos).hasSize(2);
    }

    @DisplayName("지불한 금액이 1000원단위가 아니면 예외가 발생한다.")
    @Test
    void test(){
        //given
        LottoService lottoService = new LottoServiceImpl();
        System.setIn(input("2500"));

        //when //then
        assertThatThrownBy(()->lottoService.buyLotto())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1000 단위여야 한다.");
    }

    InputStream input(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

}