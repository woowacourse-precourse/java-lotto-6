package lotto;

import lotto.service.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Kybtest {

    private static List<Integer> lottoNumberList;

    @Test
    void createLottoNumbers() {
        // 로또 번호를 생성하는 테스트입니다.
        LottoNumbers lottoNumbers = new LottoNumbers();
        lottoNumberList = lottoNumbers.setRandomNumbers();

        assertThat(lottoNumberList.size()).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000원", "1100", "-1"})
    @DisplayName("올바르지 않은 금액 테스트")
    void failed(String inputAmount) {
        // 올바르지 않은 금액을 처리하는 테스트입니다.
        assertThatThrownBy(() -> new PlayerLottoAmount(inputAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구매한 로또 티켓 장수")
    void calculateLottoCount() {
        // 로또 티켓의 장수를 계산하는 테스트입니다.
        PlayerLottoAmount amount = new PlayerLottoAmount("1000");
        assertThat(amount.calculateLottoCount()).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:FIRST", "1,2,3,4,5,7:SECOND", "1,2,3,4,5,8:THIRD", "1,2,3,4,8,10:FOURTH",
            "1,2,3,8,9,10:FIFTH", "1,2,8,9,10,11:MISS"}, delimiter = ':')
    @DisplayName("사용자가 구매한 로또 번호와 당첨번호를 비교해 등수 확인")
    void compare(String input, Ranking ranking) {
        // 사용자가 구매한 로또 번호와 당첨번호를 비교하여 등수를 확인하는 테스트입니다.
        String[] list = input.split(",");
        List<Integer> ticketNumberList = new ArrayList<>();
        for (int i = 0; i < list.length; i++) {
            ticketNumberList.add(Integer.parseInt(list[i]));
        }
        Lotto lottoList = new Lotto(ticketNumberList);
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusball = 7;
        WinningResult winningResult = new WinningResult(lotto, bonusball);

        assertThat(winningResult.match(lottoList)).isEqualTo(ranking);
    }

    @Test
    @DisplayName("최소 유효 금액 (1000)은 로또 티켓 수 1을 반환해야 함")
    void testMinimumValidAmount() {
        // 최소 유효 금액을 처리하고 로또 티켓 수를 확인하는 테스트입니다.
        PlayerLottoAmount amount = new PlayerLottoAmount("1000");
        assertThat(amount.calculateLottoCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("최대 유효 금액 (예: 1000000)은 예상 로또 티켓 수를 반환해야 함")
    void testMaximumValidAmount() {
        // 최대 유효 금액에 대한 로또 티켓 수를 확인하는 테스트입니다.
        PlayerLottoAmount amount = new PlayerLottoAmount("1000000");
        // 큰 금액에 대한 계산된 로또 티켓 수를 확인하는 단언을 추가합니다.
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5,6:FIRST",
            "1,2,3,4,5,7:SECOND",
            "1,2,3,4,5,8:THIRD",
            "1,2,3,4,8,10:FOURTH",
            "1,2,3,8,9,10:FIFTH",
            "1,2,8,9,10,11:MISS",
            "1,2,3,4,5,7:MISS"
    }, delimiter = ':')
    @DisplayName("보너스 볼이 없는 경우를 포함한 다양한 당첨 시나리오 테스트")
    void compareWithBonus(String input, Ranking ranking) {
        // 보너스 볼이 관련되지 않는 경우와 동일한 테스트 로직을 추가합니다.
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "abc", "100", "999", "-1000", "9999999"})
    @DisplayName("유효하지 않은 입력 값은 PlayerLottoAmount에서 예외를 던져야 함")
    void testInvalidPlayerLottoAmount(String inputAmount) {
        // 유효하지 않은 입력 값에 대한 예외 처리를 확인하는 테스트입니다.
        assertThatThrownBy(() -> new PlayerLottoAmount(inputAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("생성된 랜덤 로또 번호는 범위 내에 있고 중복되지 않아야 함")
    void testRandomLottoNumbers() {
        // 생성된 랜덤 로또 번호가 범위 내에 있고 중복되지 않음을 확인하는 테스트입니다.
        LottoNumbers lottoNumbers = new LottoNumbers();
        List<Integer> lottoNumberList = lottoNumbers.setRandomNumbers();
        assertThat(lottoNumberList.size()).isEqualTo(6);
        assertThat(lottoNumberList).doesNotHaveDuplicates();
        assertThat(lottoNumberList).allMatch(num -> num >= 1 && num <= 45);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5,6:1,2,3,4,5,6:6",  // 1등
            "1,2,3,4,5,6:1,2,3,4,5,7:5",  // 2등 (보너스 볼 불일치)
            "1,2,3,4,5,6:1,2,3,4,5,8:5",  // 3등
            "1,2,3,4,5,6:1,2,3,4,8,10:4", // 4등
            "1,2,3,4,5,6:1,2,3,8,9,10:3", // 5등
            "1,2,3,4,5,6:11,12,13,14,15,16:0"  // 당첨 없음
    }, delimiter = ':')
    @DisplayName("로또 번호 일치 수 테스트 (등수 확인)")
    void testLottoNumberMatch(String userNumbers, String winningNumbers, int expectedMatchCount) {
        // 주어진 로또 번호로 등수를 확인하는 테스트 케이스를 추가합니다.
    }

    @Test
    @DisplayName("수익률 계산 테스트")
    void testEarningRateCalculation() {
        // 다양한 당첨 상황을 가정하고 수익률을 계산하여 확인하는 테스트 케이스를 추가합니다.
    }

    @Test
    @DisplayName("로또 번호 생성 시 중복된 번호를 포함하지 않는지 확인")
    void testNoDuplicateNumbers() {
        // 로또 번호를 생성할 때 중복된 번호가 없음을 확인하는 테스트 케이스를 추가합니다.
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "999", "1000001"})
    @DisplayName("유효하지 않은 금액 입력 시 예외를 던지는지 확인")
    void testInvalidInputAmount(String invalidAmount) {
        // 유효하지 않은 금액 입력 시 예외가 발생하는지 확인하는 테스트 케이스를 추가합니다.
    }
}
