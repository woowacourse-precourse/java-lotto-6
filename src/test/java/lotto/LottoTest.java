package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.GameNumbers;
import lotto.model.Lotto;
import lotto.model.Result;
import lotto.model.WinningNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    // 아래에 추가 테스트 작성 가능
    @DisplayName("번호가 6개 모두 일치하면 1등이다.")
    @Test
    void 로또_결과_1등_확인_기능() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(2, 3, 4, 5, 6, 1));
        GameNumbers gameNumbers = new GameNumbers(winningNumbers);
        gameNumbers.addBonusNumber(new BonusNumber(8));

        //when
        Result result = lotto.checkResult(gameNumbers);

        //when
        Assertions.assertThat(result).isEqualTo(Result.SIX);
    }

    @DisplayName("5개의 당첨번호와 보너스번호가 일치하면 2등이다.")
    @Test
    void 로또_결과_2등_확인_기능() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(2, 3, 4, 5, 6, 8));
        GameNumbers gameNumbers = new GameNumbers(winningNumbers);
        gameNumbers.addBonusNumber(new BonusNumber(1));

        //when
        Result result = lotto.checkResult(gameNumbers);

        //when
        Assertions.assertThat(result).isEqualTo(Result.BONUS);
    }

    @DisplayName("번호가 5개 일치하고 보너스번호가 다르면 3등이다.")
    @Test
    void 로또_결과_3등_확인_기능() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(2, 3, 4, 5, 6, 11));
        GameNumbers gameNumbers = new GameNumbers(winningNumbers);
        gameNumbers.addBonusNumber(new BonusNumber(8));

        //when
        Result result = lotto.checkResult(gameNumbers);

        //when
        Assertions.assertThat(result).isEqualTo(Result.FIVE);
    }

    @DisplayName("번호가 4개 일치하면 4등이다.")
    @Test
    void 로또_결과_4등_확인_기능() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 44, 43));
        GameNumbers gameNumbers = new GameNumbers(winningNumbers);
        gameNumbers.addBonusNumber(new BonusNumber(8));

        //when
        Result result = lotto.checkResult(gameNumbers);

        //when
        Assertions.assertThat(result).isEqualTo(Result.FOUR);
    }

    @DisplayName("번호가 3개 일치하면 5등이다.")
    @Test
    void 로또_결과_5등_확인_기능() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(2, 3, 4, 15, 16, 11));
        GameNumbers gameNumbers = new GameNumbers(winningNumbers);
        gameNumbers.addBonusNumber(new BonusNumber(8));

        //when
        Result result = lotto.checkResult(gameNumbers);

        //when
        Assertions.assertThat(result).isEqualTo(Result.THREE);
    }

    @DisplayName("일치하는 번호가 2개 이하면 실패다.")
    @Test
    void 로또_결과_실패_확인_기능() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(2, 3, 14, 15, 16, 11));
        GameNumbers gameNumbers = new GameNumbers(winningNumbers);
        gameNumbers.addBonusNumber(new BonusNumber(8));

        //when
        Result result = lotto.checkResult(gameNumbers);

        //when
        Assertions.assertThat(result).isEqualTo(Result.FAIL);
    }
}
