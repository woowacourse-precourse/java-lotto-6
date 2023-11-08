package lotto.model;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UserLottoTest {
    UserLotto userLotto;
    String userLottoNumber;
    String userBonusLotto;

    @BeforeEach
    public void userLottoTest() {

        //given
        userLottoNumber = "1,2,3,4,5,6";
        userBonusLotto = "22";

    }

    @ParameterizedTest
    @DisplayName("로또 번호 6개 확인 테스트")
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
    public void lottoLengthTest(String userLottoNumber) {
        //given
        //when,then
        Assertions.assertThatThrownBy(() -> new UserLotto(userLottoNumber, userBonusLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 6개만 입력 해주세요");

    }

    @ParameterizedTest
    @DisplayName("로또 번호 범위 확인 테스트")
    @ValueSource(strings = {"1,2,3,4,5,0", "1,2,3,4,5,46"})
    public void lottoRangeTest(String userLottoNumber) {
        //given
        //when,then
        Assertions.assertThatThrownBy(() -> new UserLotto(userLottoNumber, userBonusLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1~45 범위의 숫자만을 입력하세요");

    }

    @Test
    @DisplayName("로또 번호 ,분리 테스트")
    public void lottoSplitTest() {
        //given

        //when
        userLotto = new UserLotto(userLottoNumber, userBonusLotto);
        // then
        Assertions.assertThat(userLotto.getUserLotto()).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("로또 번호 중복입력 오류확인 테스트")
    public void lottoDuplicateTest() {
        //given
        userLottoNumber = "1,2,3,4,5,5,";

        //when,then
        Assertions.assertThatThrownBy(() -> new UserLotto(userLottoNumber, userBonusLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호를 중복해서 입력하지마세요");

    }

    @Test
    @DisplayName("로또 번호 글자 입력 테스트")
    public void lottoTypeTest() {
        //given
        userLottoNumber = "1,2,3,4,5,a,";

        //when,then
        Assertions.assertThatThrownBy(() -> new UserLotto(userLottoNumber, userBonusLotto))
                .isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("[ERROR]");

    }

    @Test
    @DisplayName("보너스 로또 번호 글자 입력 테스트")
    public void bonusLottoTypeTest() {
        //given
        userBonusLotto = "a";
        //when,then
        Assertions.assertThatThrownBy(() -> new UserLotto(userLottoNumber, userBonusLotto))
                .isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("[ERROR]숫자만을 입력해주세요");

    }

    @Test
    @DisplayName("보너스 로또 번호 중복확인 테스트")
    public void bonusLottoDuplicateTest() {
        //given
        userBonusLotto = "1";
        //when,then
        Assertions.assertThatThrownBy(() -> new UserLotto(userLottoNumber, userBonusLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호를 중복해서 입력하지마세요");

    }

    @Test
    @DisplayName("보너스 로또 번호 중복확인 테스트")
    public void bonusLottoRangeTest() {
        //given
        userBonusLotto = "46";
        //when,then
        Assertions.assertThatThrownBy(() -> new UserLotto(userLottoNumber, userBonusLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1~45 범위의 숫자만을 입력하세요");

    }

}
