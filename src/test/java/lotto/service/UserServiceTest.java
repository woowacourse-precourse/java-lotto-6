package lotto.service;

import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserServiceTest {
    private UserService userService;

    @BeforeEach
    void setUp() {
        this.userService = new UserService();
    }

    @DisplayName("구입 금액 예외처리 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1", "100", "240", "a"})
    void getPrice(String price) {
        assertThatThrownBy(() -> userService.getPrice(price)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력 예외처리 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1,2", "1,1,2,3,4,5", "a,1,2,3,4,5", "0,1,2,3,4,5", "1,2,3,4,5,46"})
    void getWinningLotto(String winningNumber) {
        assertThatThrownBy(() -> userService.getWinningLotto(winningNumber)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력 예외처리 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "46", "a", "5"})
    void getBonusNumber(String bonusNumber) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> userService.getBonusNumber(bonusNumber, lotto)).isInstanceOf(IllegalArgumentException.class);
    }
}