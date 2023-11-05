package lotto.domain.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoDtoTest {
    private LottoDto lottoDto;

    @BeforeEach
    void beforeEach() {
        lottoDto = new LottoDto(List.of(4, 8, 17, 26, 39, 40));
    }

    @Nested
    @DisplayName("matchWinningLottoCount 메소드 test")
    class MatchWinningLottoCount {
        @DisplayName("당첨 번호와 발행된 로또를 비교하여 일치하는 숫자가 있다면 일치하는 개수를 반환한다.")
        @Test
        void matching_numbers_present() {
            // given
            WinningLottoDto winningLottoDto = new WinningLottoDto(List.of(4, 8, 17, 30, 41, 45));

            // when
            int matchedWinningLottoCount = lottoDto.matchWinningLottoCount(winningLottoDto);

            // then
            assertThat(matchedWinningLottoCount).isEqualTo(3);
        }

        @DisplayName("당첨 번호와 발행된 로또를 비교하여 일치하는 숫자가 없다면 0을 반환한다")
        @Test
        void matching_numbers_not_present() {
            // given
            WinningLottoDto winningLottoDto = new WinningLottoDto(List.of(1, 19, 23, 33, 42, 45));

            // when
            int matchedWinningLottoCount = lottoDto.matchWinningLottoCount(winningLottoDto);

            // then
            assertThat(matchedWinningLottoCount).isEqualTo(0);
        }
    }

    @Nested
    @DisplayName("hasBonusNumber 메소드 test")
    class HasBonusNumber {
        @DisplayName("발행된 로또에 보너스 숫자가 있다면 true 반환")
        @Test
        void Lotto_contain_bonus_number() {
            // given
            BonusNumberDto bonusNumberDto = new BonusNumberDto(45);

            // when
            boolean hasBonusNumber = lottoDto.hasBonusNumber(bonusNumberDto);

            // then
            assertThat(hasBonusNumber).isEqualTo(false);
        }

        @DisplayName("발행된 로또에 보너스 숫자가 없다면 false 반환")
        @Test
        void Lotto_not_contain_bonus_number() {
            // given
            BonusNumberDto bonusNumberDto = new BonusNumberDto(4);

            // when
            boolean hasBonusNumber = lottoDto.hasBonusNumber(bonusNumberDto);

            // then
            assertThat(hasBonusNumber).isEqualTo(true);
        }
    }
}