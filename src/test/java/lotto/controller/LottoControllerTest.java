package lotto.controller;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoControllerTest extends NsTest {
    @DisplayName("잘못된 LottoCount를 입력했을 때 메시지를 출력하고, 재입력받는지 확인한다.")
    @Test
    void printErrorMessageAndReInputLottoCount() {
        //given
        //when
        runException("8000j", "8000k", "8000k", "8000k");
        //then
        assertThat(output()).contains("[ERROR]");
    }

    @DisplayName("잘못된 Lotto를 입력했을 때 메시지를 출력하고, 재입력받는지 확인한다.")
    @Test
    void printErrorMessageAndReInputLotto() {
        //given
        //when
        runException("8000",
                "1,2", "111,1,1,1,1,1", "1,2,2,3,4,5", "", " ");
        //then
        assertThat(output()).contains("[ERROR]");
    }

    @DisplayName("잘못된 Bonus를 입력했을 때 메시지를 출력하고, 재입력받는지 확인한다.")
    @Test
    void printErrorMessageAndReInputBonus() {
        //given
        //when
        runException("8000",
                "1,2,3,4,5,6",
                "0", "-1", "j");
        //then
        assertThat(output()).contains("[ERROR]");
    }

    @DisplayName("잘못된 WinLotto를 입력했을 때 메시지를 출력하고, 재입력받는지 확인한다.")
    @Test
    void printErrorMessageAndReInputWinLotto() {
        //given
        //when
        runException("8000",
                "1,2,3,4,5,6",
                "1",
                "1,2,3,4,5,6",
                "1");
        //then
        assertThat(output()).contains("[ERROR]");
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
