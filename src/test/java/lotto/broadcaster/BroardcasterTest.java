package lotto.broadcaster;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BroardcasterTest {

    void provideRemoteInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @DisplayName("당첨 번호를 입력 받는다. 당첨 번호는 쉼표(,)를 기준으로 구분한다.")
    @Test
    void 당첨번호_입력() throws Exception {
        //given
        Broardcaster broadcaster = new Broardcaster();
        String input = "1,2,3,4,5,6";
        String[] expected = {"1", "2", "3", "4", "5", "6"};

        //when
        provideRemoteInput(input);
        String[] pickedNumbers = broadcaster.pickLotteryNumber();

        //then
        assertThat(pickedNumbers).isEqualTo(expected);
    }

    @DisplayName("당첨 번호 입력 - 예외처리 1. 숫자가 아닌 입력의 경우 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,a2,4,5,6", "1,2,asdfm,4,5", "ㅋ,ㅁㄴㅇㄹ,234,1,asdf,%%,!@#"})
    void 당첨번호_입력_예외처리_숫자가_아닌_입력의_경우(String input) throws Exception {
        //given
        Broardcaster broadcaster = new Broardcaster();
        provideRemoteInput(input);

        //when & then
        assertThatThrownBy(() -> broadcaster.pickLotteryNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력 - 예외처리 2. 6개의 숫자를 입력하지 않은 경우")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1,2,3,4,5", "1,2,3,4,5,6,7"})
    void 당첨번호_입력_예외처리_숫자가_6개가_아닌_경우(String input) throws Exception {
        //given
        Broardcaster broadcaster = new Broardcaster();
        provideRemoteInput(input);

        //when & then
        assertThatThrownBy(() -> broadcaster.pickLotteryNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력 - 예외처리 3. 숫자 범위(1~45)를 넘어서는 경우")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,55,200", "0,2,3,4,5,6", "1,2,3,4,5,0"})
    void 당첨번호_입력_예외처리_숫자_범위를_넘어서는_경우(String input) throws Exception {
        //given
        Broardcaster broadcaster = new Broardcaster();
        provideRemoteInput(input);

        //when & then
        assertThatThrownBy(() -> broadcaster.pickLotteryNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력 - 예외처리 4. 중복 숫자를 입력한 경우")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,4,4", "1,2,3,4,5,5"})
    void 당첨번호_입력_예외처리_중복_숫자를_입력한_경우(String input) throws Exception {
        //given
        Broardcaster broadcaster = new Broardcaster();
        provideRemoteInput(input);

        //when & then
        assertThatThrownBy(() -> broadcaster.pickLotteryNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

}