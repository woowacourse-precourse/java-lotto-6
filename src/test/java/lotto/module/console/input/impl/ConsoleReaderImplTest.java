package lotto.module.console.input.impl;

import lotto.module.console.input.ConsoleReader;
import lotto.module.console.input.validation.InputValidation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.close;
import static org.assertj.core.api.Assertions.assertThat;

class ConsoleReaderImplTest {
    private final ConsoleReader consoleReader = ConsoleReaderImpl.newInstance(InputValidation.newInstance());

    @AfterEach
    void consoleClose() {
        close();
    }

    @Test
    void 구입금액_입력_성공_테스트() {
        // given
        String inputPurchaseAmount = "8000";
        int expectedPurchaseAmount = 8000;
        System.setIn(new ByteArrayInputStream(inputPurchaseAmount.getBytes()));

        // when
        int payment = consoleReader.readPurchaseAmount();

        // then
        assertThat(payment).isEqualTo(expectedPurchaseAmount);
    }

    @Test
    void 로또_당첨_번호_입력_성공_테스트() {
        // given
        String inputLottoNumbers = "42,11,9,33,29,7";
        List<Integer> expectedResult = List.of(7, 9, 11, 29, 33, 42);
        System.setIn(new ByteArrayInputStream(inputLottoNumbers.getBytes()));

        // when
        List<Integer> numbers = consoleReader.readWinningLottoNumbers();

        // then
        assertThat(numbers).isEqualTo(expectedResult);
    }

    @Test
    void 로또_보너스_번호_입력_성공_테스트() {
        // given
        String inputLottoBonusNumber = "42";
        int expectedNumber = 42;
        System.setIn(new ByteArrayInputStream(inputLottoBonusNumber.getBytes()));

        // when
        int bonusNumber = consoleReader.readLottoBonusNumber();

        // then
        assertThat(bonusNumber).isEqualTo(expectedNumber);
    }

}