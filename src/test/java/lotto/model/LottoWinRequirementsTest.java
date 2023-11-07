package lotto.model;

import lotto.model.lotto.LottoWinRequirements;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoWinRequirementsTest {
    @DisplayName("유효한 당첨 번호와 보너스 번호로 객체를 생성할 수 있다.")
    @Test
    void createValidLottoWinRequirements() {
        assertThatCode(() -> LottoWinRequirements.of(List.of(1, 2, 3, 4, 5, 6), 7))
                .doesNotThrowAnyException();
    }

    @DisplayName("당첨 번호와 보너스 번호가 중복되면 예외가 발생한다.")
    @Test
    void createLottoWinRequirementsWithDuplicateNumbers() {
        assertThatThrownBy(() -> LottoWinRequirements.of(List.of(1, 2, 3, 4, 5, 6, 7), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 보너스 번호가 중복되지 않으면 객체를 생성할 수 있다.")
    @Test
    void createLottoWinRequirementsWithNoDuplicateNumbers() {
        assertThatCode(() -> LottoWinRequirements.of(List.of(1, 2, 3, 4, 5, 6), 7))
                .doesNotThrowAnyException();
    }

    @DisplayName("당첨 번호와 보너스 번호를 올바르게 가져올 수 있다.")
    @Test
     void getWinningNumberAndBonusNumber() {
        LottoWinRequirements lottoWinRequirements = LottoWinRequirements.of(List.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(lottoWinRequirements.getWinningNumber()).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(lottoWinRequirements.getBonusNumber()).isEqualTo(7);
    }
}
