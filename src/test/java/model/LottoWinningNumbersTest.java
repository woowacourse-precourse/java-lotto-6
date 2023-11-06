package model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoWinningNumbersTest {
    @DisplayName("범위가 벗어난 당첨번호 생성 예외 테스트")
    @Test
    void LottoWinningNumbersByOutLange() {
        assertThatThrownBy(() -> new LottoWinningNumbers("0,1,2,3,4,5", "7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 당첨번호 생성 예외 테스트")
    @Test
    void LottoWinningNumbersByDuplication() {
        assertThatThrownBy(() -> new LottoWinningNumbers("1,1,2,3,4,5", "7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스번호와 중복된 당첨번호 생성 예외 테스트")
    @Test
    void LottoWinningNumbersByDuplicationBonusNumber() {
        assertThatThrownBy(() -> new LottoWinningNumbers("1,7,2,3,4,5", "5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 6자리 초과인 경우 예외 테스트")
    @Test
    void LottoWinningNumbersByOverLength(){
        assertThatThrownBy(() -> new LottoWinningNumbers("1,7,2,3,4,5,9", "5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1자리 초과인 경우 예외 테스트")
    @Test
    void LottoWinningNumbersByBonusOverLength(){
        assertThatThrownBy(() -> new LottoWinningNumbers("1,7,2,3,4,5", "6,8"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1~45범위를 벗어난 경우 예외 테스트")
    @Test
    void LottoWinningNumbersByBonusOutRange(){
        assertThatThrownBy(() -> new LottoWinningNumbers("1,7,2,3,4,5", "46"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
