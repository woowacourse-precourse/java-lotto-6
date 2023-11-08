package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.utils.ErrorMessage;
import lotto.utils.LottoPlace;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mockStatic;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호_범위_예외() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Lotto(List.of(1, 2, 3, 4, 5, 47));
        }, ErrorMessage.NON_LOTTO_NUMBER.getErrorMessage());
    }

    @Test
    void toString_출력_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        String expectedToStringResult = "[1, 2, 3, 4, 5, 6]";

        assertThat(lotto.toString()).contains(expectedToStringResult);
    }

    @Test
    void 로또_생성_테스트() {
        try (MockedStatic<Randoms> mockedRandoms = mockStatic(Randoms.class)) {
            given(Randoms.pickUniqueNumbersInRange(anyInt(), anyInt(), anyInt()))
                    .willReturn(List.of(6, 5, 4, 3, 2, 1));

            org.assertj.core.api.Assertions.assertThat(Lotto.createLotto().toString())
                    .contains("[1, 2, 3, 4, 5, 6]");
        }
    }

    @Test
    void 로또_결과_테스트_1등() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = WinningNumbers.createWinningNumbers(new String[]{"1", "2", "3", "4", "5", "6"});
        BonusNumber bonusNumber = BonusNumber.createBonusNumber(new WinningNumber(7), winningNumbers);

        org.assertj.core.api.Assertions.assertThat(lotto.calLottoResult(winningNumbers, bonusNumber))
                .isEqualTo(LottoPlace.FIRST);
    }

    @Test
    void 로또_결과_테스트_미당첨() {
        Lotto lotto = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        WinningNumbers winningNumbers = WinningNumbers.createWinningNumbers(new String[]{"1", "2", "3", "4", "5", "6"});
        BonusNumber bonusNumber = BonusNumber.createBonusNumber(new WinningNumber(7), winningNumbers);

        org.assertj.core.api.Assertions.assertThat(lotto.calLottoResult(winningNumbers, bonusNumber))
                .isEqualTo(LottoPlace.NONE);
    }

    @Test
    void 로또_결과_테스트_2등() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        WinningNumbers winningNumbers = WinningNumbers.createWinningNumbers(new String[]{"1", "2", "3", "4", "5", "6"});
        BonusNumber bonusNumber = BonusNumber.createBonusNumber(new WinningNumber(7), winningNumbers);

        org.assertj.core.api.Assertions.assertThat(lotto.calLottoResult(winningNumbers, bonusNumber))
                .isEqualTo(LottoPlace.SECOND);
    }

}