package lotto.model;

import static lotto.model.constants.Prize.SECOND;
import static lotto.model.constants.Prize.THIRD;
import static lotto.view.exception.InputException.BONUS_NUMBER_ALREADY_USE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

public class LottoCompanyTest {

    @Test
    @DisplayName("정답 번호와 보너스 번호가 서로 독립적이면 정상 생성된다.")
    void allNumberUniqueTest() {
        // given
        GoalNumbers goalNumbers = GoalNumbers.from("1,2,3,4,5,6");
        BonusNumber bonusNumber = BonusNumber.from("7");

        // when & then
        assertDoesNotThrow(() -> LottoCompany.of(goalNumbers, bonusNumber));
    }

    @Test
    @DisplayName("정답 번호와 보너스 번호가 겹치면 예외가 발생한다.")
    void bonusNumberAlreadyUsedExceptionTest() {
        // given
        GoalNumbers goalNumbers = GoalNumbers.from("1,2,3,4,5,6");
        BonusNumber bonusNumber = BonusNumber.from("6");

        // when & then
        assertThatThrownBy(() -> LottoCompany.of(goalNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BONUS_NUMBER_ALREADY_USE.getMessage());
    }

    @Test
    @DisplayName("로또 계산 테스트 - 5등 갯수 계산")
    void calculateMatchLottoTest() {
        // given
        List<Lotto> lottos = List.of(
            new Lotto(List.of(1, 2, 3, 4, 5, 6)),
            new Lotto(List.of(7, 8, 9, 10, 11, 12)),
            new Lotto(List.of(13, 14, 15, 16, 17, 18))
        );
        GoalNumbers goalNumbers = GoalNumbers.from("1,2,3,10,11,12");
        BonusNumber bonusNumber = BonusNumber.from("14");
        LottoCompany lottoCompany = LottoCompany.of(goalNumbers, bonusNumber);
        int expectedMatchLottos = 2;

        // when
        List<Lotto> matchedLottos = lottoCompany.collectLottosWithSizeExceptBonus(lottos, THIRD.getMatch());

        // then
        assertThat(matchedLottos.size()).isEqualTo(expectedMatchLottos);
    }

    @Test
    @DisplayName("로또 계산 테스트 - 2등 갯수 계산")
    void calculateMatchLottoWithBonusTest() {
        // given
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12)),
                new Lotto(List.of(13, 14, 15, 16, 17, 18))
        );
        GoalNumbers goalNumbers = GoalNumbers.from("1,2,3,4,5,12");
        BonusNumber bonusNumber = BonusNumber.from("6");
        LottoCompany lottoCompany = LottoCompany.of(goalNumbers, bonusNumber);
        int expectedMatchLottos = 1;

        // when
        List<Lotto> matchedLottos = lottoCompany.collectLottosWithSizeIncludeBonus(lottos, SECOND.getMatch());

        // then
        assertThat(matchedLottos.size()).isEqualTo(expectedMatchLottos);
    }
}
