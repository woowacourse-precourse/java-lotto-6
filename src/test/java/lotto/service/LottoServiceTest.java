package lotto.service;

import static lotto.constant.PrizeConstant.fifthPrizeCount;
import static lotto.constant.PrizeConstant.firstPrizeCount;
import static lotto.constant.PrizeConstant.fourthPrizeCount;
import static lotto.constant.PrizeConstant.secondPrizeCount;
import static lotto.constant.PrizeConstant.thirdPrizeCount;
import static lotto.service.InputService.winningNumberList;
import static lotto.service.OutputService.quantity;
import static lotto.view.InputView.bonusNumber;
import static lotto.view.InputView.inputMoney;
import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.model.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {

    @Test
    @DisplayName("로또 번호 리스트를 올바르게 생성하는지 확인")
    void validateGenerateLottoNumberLists() {
        // given
        quantity = 5; // 예시로 5개의 로또 번호 리스트를 생성한다고 가정
        LottoService.lottoNumberLists = new ArrayList<>();

        // when
        LottoService.generateLottoNumberLists();

        // then
        assertThat(LottoService.lottoNumberLists).hasSize(5); // 5개의 로또 번호 리스트가 생성되었는지 확인
    }

    @Test
    @DisplayName("로또 번호 일치 개수를 올바르게 계산하는지 확인")
    void validateCountMatches() throws Exception {
        // given
        List<Integer> lottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6); // 예시로 1, 2, 3, 4, 5, 6로 구성된 로또 번호 리스트
        winningNumberList = Arrays.asList(1, 2, 3, 4, 5, 6);

        // when
        Method countMatchesMethod = LottoService.class.getDeclaredMethod("countMatches", List.class);
        countMatchesMethod.setAccessible(true);
        int matchCount = (int) countMatchesMethod.invoke(null, lottoNumber);

        // then
        assertThat(matchCount).isEqualTo(6); // 당첨 번호와 일치하는 개수가 0인지 확인
    }

    @Test
    @DisplayName("보너스 번호가 일치하는 경우")
    void validateHasBonusTrue() throws Exception {
        // given
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6); // 예시로 1, 2, 3, 4, 5, 6로 구성된 로또 번호 리스트
        bonusNumber = 6;

        // when
        Method hasBonusMethod = LottoService.class.getDeclaredMethod("hasBonus", List.class);
        hasBonusMethod.setAccessible(true);
        boolean hasBonus = (boolean) hasBonusMethod.invoke(null, lottoNumbers);

        // then
        assertThat(hasBonus).isTrue();
    }

    @Test
    @DisplayName("보너스 번호가 일치하지 않는 경우")
    void validateHasBonusFalse() throws Exception {
        // given
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6); // 예시로 1, 2, 3, 4, 5, 6로 구성된 로또 번호 리스트
        bonusNumber = 7;

        // when
        Method hasBonusMethod = LottoService.class.getDeclaredMethod("hasBonus", List.class);
        hasBonusMethod.setAccessible(true);
        boolean hasBonus = (boolean) hasBonusMethod.invoke(null, lottoNumbers);

        // then
        assertThat(hasBonus).isFalse();
    }

    @Test
    @DisplayName("updatePrizeCounts() 메서드 테스트 - 보너스 일치")
    void validateUpdatePrizeCountsWithBonus() throws Exception {
        // given
        boolean hasBonus = true;

        // when
        Method updatePrizeCountsMethod = LottoService.class.getDeclaredMethod("updatePrizeCounts", int.class,
                boolean.class);
        updatePrizeCountsMethod.setAccessible(true);
        updatePrizeCountsMethod.invoke(null, 5, hasBonus); // 5개 일치, 보너스 볼 일치

        // then
        assertThat(secondPrizeCount).isEqualTo(1);
    }

    @Test
    @DisplayName("updatePrizeCounts() 메서드 테스트 - 보너스 불일치")
    void validateUpdatePrizeCountsWithoutBonus() throws Exception {
        // given
        boolean hasBonus = true;

        // when
        Method updatePrizeCountsMethod = LottoService.class.getDeclaredMethod("updatePrizeCounts", int.class,
                boolean.class);
        updatePrizeCountsMethod.setAccessible(true);
        updatePrizeCountsMethod.invoke(null, 5, !hasBonus); // 5개 일치, 보너스 볼 불일치

        // then
        assertThat(thirdPrizeCount).isEqualTo(1);
    }

    @Test
    @DisplayName("수익률 계산")
    void validateCalculateReturnRate() {
        // given
        firstPrizeCount = 0;
        secondPrizeCount = 0;
        thirdPrizeCount = 0;
        fourthPrizeCount = 0;
        fifthPrizeCount = 1;

        inputMoney = 8000;

        // when
        LottoService.calculateReturnRate();

        // then
        double expectedReturnRate = (
                (Prize.FIRST_PRIZE.getPrizeMoney() * firstPrizeCount) +
                        (Prize.SECOND_PRIZE.getPrizeMoney() * secondPrizeCount) +
                        (Prize.THIRD_PRIZE.getPrizeMoney() * thirdPrizeCount) +
                        (Prize.FOURTH_PRIZE.getPrizeMoney() * fourthPrizeCount) +
                        (Prize.FIFTH_PRIZE.getPrizeMoney() * fifthPrizeCount)
        ) / (double) inputMoney * 100;
        expectedReturnRate = Math.round(expectedReturnRate * 100.0) / 100.0;

        assertThat(LottoService.returnRate).isEqualTo(expectedReturnRate);
    }
}
