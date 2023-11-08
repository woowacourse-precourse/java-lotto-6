package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;

class UserMoneyTest {
    @Test
    @DisplayName("양수 금액 입력 시, 정상 동작")
    void Should_Success_When_EnterPositiveMoney() {
        // given
        int money = 10000;

        // when
        UserMoney userMoney = UserMoney.createMoney(money);

        // then
        assertThat(userMoney.getMoney()).isEqualTo(money);
    }

    @Test
    @DisplayName("음수인 금액이 입력될 경우 예외 처리 후 재입력 동작")
    void Should_ReEnter_When_EnterNegativeMoney() {
        // given
        int money = -10000;
        UserMoney userMoney;

        // when
        try (final MockedStatic<Console> consoleMock = mockStatic(Console.class)) {
            consoleMock.when(() -> Console.readLine()).thenReturn("1000");
            userMoney = UserMoney.createMoney(money);
        }

        // then
        assertThat(userMoney.getMoney()).isEqualTo(1000);
    }
}