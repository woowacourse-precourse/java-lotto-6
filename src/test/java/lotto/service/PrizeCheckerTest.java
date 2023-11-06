package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.wrapper.BonusNumber;
import lotto.utils.LottoConstant;
import lotto.utils.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PrizeCheckerTest {

    @DisplayName("당첨 번호와 로또 번호를 비교하여 등수를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5,6:FIRST",
            "1,2,3,4,5,7:SECOND",
            "1,2,3,4,5,8:THIRD",
            "1,2,3,4,7,8:FOURTH",
            "1,2,3,7,8,9:FIFTH",
            "1,2,7,8,9,10:NO_PRIZE"
    }, delimiter = ':')
    void calculatePrize(String inputNumbers, String expectedPrize) {
        // given
        List<Integer> numbers = Arrays.stream(inputNumbers.split(LottoConstant.DELIMITER.get()))
                .map(Integer::parseInt)
                .toList();
        Lotto playerLotto = new Lotto(numbers);
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7, winningLotto);
        PrizeChecker prizeChecker = new PrizeChecker(winningLotto, bonusNumber);
        // when
        Prize prize = prizeChecker.calculatePrize(playerLotto);
        // then
        assertThat(prize.name()).isEqualTo(expectedPrize);
    }
}