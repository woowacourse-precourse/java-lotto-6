package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class LottoRankTest {

    @Test
    @DisplayName("로또번호와 당첨번호를 입력받아서 1등을 반환")
    void getFirstPlaceRank() {
        Lotto lotto = new Lotto(List.of(8, 21, 23, 41, 42, 43));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(8, 21, 23, 41, 42, 43), 1);

        LottoRank lottoRank = LottoRank.valueOf(lotto, winningNumbers);

        Assertions.assertThat(lottoRank).isInstanceOf(lottoRank.getClass()).isEqualTo(LottoRank.FIRST_PLACE);
    }

    @Test
    @DisplayName("로또번호와 당첨번호를 입력받아서 2등을 반환")
    void getSecondPlaceRank() {
        Lotto lotto = new Lotto(List.of(8, 21, 23, 41, 42, 43));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(7, 21, 23, 41, 42, 43), 8);

        LottoRank lottoRank = LottoRank.valueOf(lotto, winningNumbers);

        Assertions.assertThat(lottoRank).isInstanceOf(lottoRank.getClass()).isEqualTo(LottoRank.SECOND_PLACE);

    }

    @Test
    @DisplayName("로또번호와 당첨번호를 입력받아서 3등을 반환")
    void getThirdPlaceRank() {
        Lotto lotto = new Lotto(List.of(8, 21, 23, 41, 42, 43));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(7, 21, 23, 41, 42, 43), 1);

        LottoRank lottoRank = LottoRank.valueOf(lotto, winningNumbers);

        Assertions.assertThat(lottoRank).isInstanceOf(lottoRank.getClass()).isEqualTo(LottoRank.THIRD_PLACE);
    }

    @Test
    @DisplayName("로또번호와 당첨번호를 입력받아서 4등을 반환")
    void getFourthPlaceRank() {
        Lotto lotto = new Lotto(List.of(8, 21, 23, 41, 42, 43));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(7, 9, 23, 41, 42, 43), 1);

        LottoRank lottoRank = LottoRank.valueOf(lotto, winningNumbers);

        Assertions.assertThat(lottoRank).isInstanceOf(lottoRank.getClass()).isEqualTo(LottoRank.FOURTH_PLACE);
    }

    @Test
    @DisplayName("로또번호와 당첨번호를 입력받아서 5등을 반환")
    void getFifthPlaceRank() {
        Lotto lotto = new Lotto(List.of(8, 21, 23, 41, 42, 43));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(7, 9, 10, 41, 42, 43), 1);

        LottoRank lottoRank = LottoRank.valueOf(lotto, winningNumbers);

        Assertions.assertThat(lottoRank).isInstanceOf(lottoRank.getClass()).isEqualTo(LottoRank.FIFTH_PLACE);
    }

    @Test
    @DisplayName("로또번호와 당첨번호를 입력받아서 그외 등수 반환")
    void getNonePlaceRank() {
        Lotto lotto = new Lotto(List.of(8, 21, 23, 41, 42, 43));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(7, 9, 10, 11, 42, 43), 1);

        LottoRank lottoRank = LottoRank.valueOf(lotto, winningNumbers);

        Assertions.assertThat(lottoRank).isInstanceOf(lottoRank.getClass()).isEqualTo(LottoRank.NONE);
    }
}