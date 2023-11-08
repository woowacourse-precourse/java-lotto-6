package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.config.ConstantNum.LOTTO_BONUS_NUMBER_CNT;
import static lotto.config.ConstantNum.LOTTO_NUMBER_MIN;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import static org.mockito.Mockito.mockStatic;

class BonusNumbersTest {
    private List<Integer> bonus;
    private List<Integer> wrongBonus;
    private BonusNumbers bonusNumbers;

    @BeforeEach
    void setUp() {
        // given
        bonus = new ArrayList<>();
        for (int i = LOTTO_NUMBER_MIN.getNum(); i < LOTTO_NUMBER_MIN.getNum() + LOTTO_BONUS_NUMBER_CNT.getNum(); i++) {
            bonus.add(i);
        }
        wrongBonus = new ArrayList<>(bonus);
    }

    @Test
    @DisplayName("주어진 번호의 개수, 범위가 일치할 경우 정상적으로 BonusNumbers 객체 리턴")
    void Should_Success_When_ValidBonusNumberCntAndRange() {
        // when
        ThrowingCallable throwingCallable = () -> new BonusNumbers(bonus);

        // then
        assertThatCode(throwingCallable).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("주어진 보너스 번호의 개수가 일치하지 않을 경우 예외 처리하고 재입력 동작")
    void Should_ReEnter_When_BonusNumberCntIsNotMatch() {
        // given
        wrongBonus.add(LOTTO_NUMBER_MIN.getNum());

        // when
        try (final MockedStatic<Console> consoleMock = mockStatic(Console.class)) {
            consoleMock.when(() -> readLine()).thenReturn(
                    bonus.toString().substring(1, bonus.toString().length() - 1).replaceAll("\\s", ""));
            bonusNumbers = new BonusNumbers(bonus);
        }

        // then
        assertThat(bonusNumbers.getNumbers()).usingRecursiveComparison().isEqualTo(bonus);
    }
}