package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WinningNumberServiceTest {
    private final WinningNumberService winningNumberService = new WinningNumberService();
    private final IOConfig ioConfig = new IOConfig();

    @BeforeEach
    void setUp() {
        ioConfig.setUpOutput();
    }

    @AfterEach
    void tearDown() {
        ioConfig.restoreInputOutput();
    }

    @DisplayName("당첨 숫자를 ,로 구분하지 않으면 예외 메세지 출력")
    @Test
    void inputWinningNumbersWithSpace() {
        // given
        ioConfig.mockInput("1 2 3 4 5 6\n1,2,3,4,5,6\n");

        // when
        Lotto lotto = winningNumberService.inputWinningNumbers();

        // then
        assertTrue(ioConfig.getOutput().contains("잘못된 형식입니다. 숫자 구분은 오직 ,(comma)로만 해주세요."));
        assertThat(lotto).isEqualTo(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("당첨 숫자를 6개 입력하지 않으면 예외 메세지 출력")
    @Test
    void inputWinningNumberNotSix() {
        // given
        ioConfig.mockInput("1,2,3,4,5,6,7\n1,2,3,4,5,6\n");

        // when
        Lotto lotto = winningNumberService.inputWinningNumbers();

        // then
        assertTrue(ioConfig.getOutput().contains("6개의 숫자를 입력(생성)해주세요."));
        assertThat(lotto).isEqualTo(new Lotto("1,2,3,4,5,6"));
    }

    @DisplayName("당첨 숫자를 중복으로 입력하면 예외 메세지 출력")
    @Test
    void inputWinningNumberWithDouble() {
        // given
        ioConfig.mockInput("1,2,3,4,5,5\n1,2,3,4,5,6\n");

        // when
        Lotto lotto = winningNumberService.inputWinningNumbers();

        // then
        assertTrue(ioConfig.getOutput().contains("중복된 원소가 존재합니다."));
        assertThat(lotto).isEqualTo(new Lotto("1,2,3,4,5,6"));
    }

    @DisplayName("보너스 숫자를 숫자가 아닌 문자로 입력")
    @Test
    void inputBonusNumberWithNoNumbers() {
        // given
        ioConfig.mockInput("1bc\n10\n");
        Lotto lotto = new Lotto("1,2,3,4,5,6");

        // when
        BonusNumber bonusNumber = winningNumberService.inputBonusNumber(lotto);

        // then
        assertTrue(ioConfig.getOutput().contains("보너스 숫자는 숫자로 입력해주세요."));
    }

    @DisplayName("보너스 숫자가 당첨 숫자에 있음 입력")
    @Test
    void inputBonusNumberDoubledWithWinningNumbers() {
        // given
        ioConfig.mockInput("1\n10\n");
        Lotto lotto = new Lotto("1,2,3,4,5,6");

        // when
        BonusNumber bonusNumber = winningNumberService.inputBonusNumber(lotto);

        // then
        assertTrue(ioConfig.getOutput().contains("보너스 숫자는 당첨 숫자에 포함될 수 없습니다."));
    }

    @DisplayName("보너스 숫자가 당첨 숫자에 있음 입력")
    @Test
    void inputBonusNumberOutBounded() {
        // given
        ioConfig.mockInput("100\n10\n");
        Lotto lotto = new Lotto("1,2,3,4,5,6");

        // when
        BonusNumber bonusNumber = winningNumberService.inputBonusNumber(lotto);

        // then
        assertTrue(ioConfig.getOutput().contains("1~45 사이 숫자를 입력해주세요."));
    }
}
