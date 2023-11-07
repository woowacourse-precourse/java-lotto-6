package lotto.model;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UserLottoTest {
    UserLotto userLotto;
    String buyPrice;
    String userLottoNumber;
    @BeforeEach
    public void userLottoTest(){

        //given


    }
    @Test
    @DisplayName("로또 구매 금액 1000원 단위 확인 테스트")
    public void lottoPriceTest() {
        //given
        buyPrice = "1300";
        userLottoNumber = "1,2,3,4,5,6";
        //when,then
        Assertions.assertThatThrownBy(() -> new UserLotto(buyPrice,userLottoNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");

    }
    @ParameterizedTest
    @DisplayName("로또 번호 6개 확인 테스트")
    @ValueSource(strings = {"1,2,3,4,5","1,2,3,4,5,6,7"})
    public void lottoLengthTest(String userLottoNumber){
        //given
        buyPrice = "1000";
        //when,then
        Assertions.assertThatThrownBy(() -> new UserLotto(buyPrice,userLottoNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");

    }
    @ParameterizedTest
    @DisplayName("로또 번호 범위 확인 테스트")
    @ValueSource(strings = {"1,2,3,4,0","1,2,3,4,5,6,45"})
    public void lottoRangeTest(String userLottoNumber){
        //given
        buyPrice = "1000";
        //when,then
        Assertions.assertThatThrownBy(() -> new UserLotto(buyPrice,userLottoNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");

    }

    @Test
    @DisplayName("로또 번호 ,분리 테스트")
    public void lottoSplitTest(){
        //given
        buyPrice = "1000";
        userLottoNumber = "1,2,3,4,5,6,";

        //when
        userLotto = new UserLotto(buyPrice,userLottoNumber);
        // then
        Assertions.assertThat(userLotto.getUserLotto()).isEqualTo(Arrays.asList(1,2,3,4,5,6));
    }
    @Test
    @DisplayName("로또 번호 중복입력 오류확인 테스트")
    public void lottoDuplicateTest(){
        //given
        buyPrice = "1000";
        userLottoNumber = "1,2,3,4,5,5,";

        //when,then
        Assertions.assertThatThrownBy(() -> new UserLotto(buyPrice,userLottoNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");

    }

}
