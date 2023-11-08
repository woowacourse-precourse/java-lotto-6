package lotto;

import lotto.domain.*;
import lotto.validator.BonusValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 0원일 경우, 로또 티켓 개수는 0이어야 한다.")
    @Test
    void generateLottoCountWithZeroMoney() {
        Counter counter = new Counter();
        int lottoCount = counter.generateLottoCount(0);
        assertThat(lottoCount).isZero();
    }

    @DisplayName("구입 금액이 1000원일 경우, 로또 티켓 개수는 1이어야 한다.")
    @Test
    void generateLottoCountWith1000Won() {
        Counter counter = new Counter();
        int lottoCount = counter.generateLottoCount(1000);
        assertThat(lottoCount).isEqualTo(1);
    }

    @DisplayName("구입 금액이 2000원일 경우, 로또 티켓 개수는 2이어야 한다.")
    @Test
    void generateLottoCountWith2000Won() {
        Counter counter = new Counter();
        int lottoCount = counter.generateLottoCount(2000);
        assertThat(lottoCount).isEqualTo(2);
    }

    @DisplayName("구입 금액이 1500원일 경우, 로또 티켓 개수는 1이어야 한다.")
    @Test
    void generateLottoCountWith1500Won() {
        Counter counter = new Counter();
        int lottoCount = counter.generateLottoCount(1500);
        assertThat(lottoCount).isEqualTo(1);
    }

    @DisplayName("로또 번호 일치를 판단하는 테스트")
    @Test
    void determineWinningResultTest() {
        Judge judge = new Judge();
        List<Integer> winNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        assertThat(judge.determineWinningResult(6, false)).isEqualTo(WinningResult.MATCH_6);
        assertThat(judge.determineWinningResult(5, false)).isEqualTo(WinningResult.MATCH_5);
        assertThat(judge.determineWinningResult(5, true)).isEqualTo(WinningResult.MATCH_5_WITH_BONUS);
        assertThat(judge.determineWinningResult(4, false)).isEqualTo(WinningResult.MATCH_4);
        assertThat(judge.determineWinningResult(3, false)).isEqualTo(WinningResult.MATCH_3);
        assertThat(judge.determineWinningResult(2, false)).isNull();
    }

    @DisplayName("로또 번호 생성 테스트")
    @Test
    void createLotto() {
        List<Integer> validNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(validNumbers);
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @DisplayName("로또 번호에 중복된 숫자 체크 테스트")
    @Test
    void checkForDuplicateNumbers() {
        List<Integer> duplicateNumbers = Arrays.asList(1, 2, 3, 4, 5, 5);
        assertThatThrownBy(() -> new Lotto(duplicateNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호에 중복된 숫자가 있습니다.");
    }

    @DisplayName("로또 번호 개수 체크 테스트")
    @Test
    void checkLottoSize() {
        List<Integer> moreNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        assertThatThrownBy(() -> new Lotto(moreNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 6개여야 합니다.");
    }

    @DisplayName("로또 번호 일치 여부 확인")
    @Test
    void checkIfLottoContainsNumber() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        for (int number : numbers) {
            assertThat(lotto.contains(number)).isTrue();
        }
        assertThat(lotto.contains(7)).isFalse();
    }

    @DisplayName("LottoResult 객체 생성 및 접근자 테스트")
    @Test
    void createLottoResult() {
        boolean isWinner = true;
        int matchingCount = 3;
        WinningResult winningResult = WinningResult.MATCH_3;
        LottoResult lottoResult = new LottoResult(isWinner, matchingCount, winningResult);
        assertThat(lottoResult.isWinner()).isEqualTo(isWinner);
        assertThat(lottoResult.getMatchingCount()).isEqualTo(matchingCount);
        assertThat(lottoResult.getWinningResult()).isEqualTo(winningResult);
    }

    @DisplayName("WinningResult의 메시지와 상금 확인")
    @Test
    void checkWinningResultMessageAndPrize() {
        WinningResult match3 = WinningResult.MATCH_3;
        WinningResult match4 = WinningResult.MATCH_4;
        WinningResult match5 = WinningResult.MATCH_5;
        WinningResult match5WithBonus = WinningResult.MATCH_5_WITH_BONUS;
        WinningResult match6 = WinningResult.MATCH_6;

        assertThat(match3.getMessage()).isEqualTo("3개 일치 (5,000원)");
        assertThat(match3.getPrize()).isEqualTo(5000);

        assertThat(match4.getMessage()).isEqualTo("4개 일치 (50,000원)");
        assertThat(match4.getPrize()).isEqualTo(50000);

        assertThat(match5.getMessage()).isEqualTo("5개 일치 (1,500,000원)");
        assertThat(match5.getPrize()).isEqualTo(1500000);

        assertThat(match5WithBonus.getMessage()).isEqualTo("5개 일치, 보너스 볼 일치 (30,000,000원)");
        assertThat(match5WithBonus.getPrize()).isEqualTo(30000000);

        assertThat(match6.getMessage()).isEqualTo("6개 일치 (2,000,000,000원)");
        assertThat(match6.getPrize()).isEqualTo(2000000000);
    }

    @DisplayName("보너스 번호의 형식이 올바르지 않으면 예외가 발생한다")
    @Test
    void validateInvalidBonusNumberFormat() {
        assertThatThrownBy(() -> BonusValidator.validateBonusNumber("haha"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 한 개의 숫자로만 입력해야 합니다.");
    }

    @DisplayName("보너스 번호의 범위가 유효하지 않으면 예외가 발생한다")
    @Test
    void validateInvalidBonusNumberRange() {
        assertThatThrownBy(() -> BonusValidator.validateBonusNumber("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1에서 45 사이의 숫자여야 합니다.");

        assertThatThrownBy(() -> BonusValidator.validateBonusNumber("46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1에서 45 사이의 숫자여야 합니다.");
    }


}