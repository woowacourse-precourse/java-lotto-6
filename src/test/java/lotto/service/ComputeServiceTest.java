package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.MatchResult;
import lotto.domain.constant.NumberConstant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.domain.constant.NumberConstant.*;
import static lotto.domain.constant.StringConstant.*;
import static lotto.service.ComputeService.*;
import static org.assertj.core.api.Assertions.assertThat;

class ComputeServiceTest {
    @DisplayName("사용자 입력 받아서 금액을 로또 티켓 수로 변환")
    @Test
    void computeLottoTicketNumFromExpense() {
        // GIVEN
        System.setIn(new ByteArrayInputStream(TEST_COMPUTE_EXPENSE.getBytes()));

        // WHEN, THEN
        assertThat(computeLottoTicketNum()).isEqualTo(1);
    }

    @DisplayName("발행 로또와 당첨 로또, 보너스 번호를 가지고 전체 매칭 결과 반환")
    @Test
    void computeResultFromLottoAndBonusNum() {
        // GIVEN
        List<Lotto> randomLottos = new ArrayList<>();
        randomLottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        randomLottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        randomLottos.add(new Lotto(List.of(11, 12, 13, 14, 15, 16)));

        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        int bonusNum = 7;

        // WHEN
        Map<MatchResult, Integer> result = computeResult(randomLottos, winningLotto, bonusNum);

        // THEN
        assertThat(result.get(MatchResult.NONE)).isEqualTo(1);
        assertThat(result.get(MatchResult.BONUS)).isEqualTo(1);
        assertThat(result.get(MatchResult.SIX)).isEqualTo(1);
    }

    @DisplayName("발행 로또 티켓 수와 전체 당첨 금액을 가지고 수익률을 반환")
    @Test
    void computeMarginFromLottoTicketNumAndTotalPrize() {
        // GIVEN
        Map<MatchResult, Integer> result = new HashMap<>();
        result.put(MatchResult.THREE, 1);
        result.put(MatchResult.BONUS, 1);
        result.put(MatchResult.SIX, 1);

        long totalPrize = THREE_PRIZE_MONEY + BONUS_PRIZE_MONEY + SIX_PRIZE_MONEY;
        int lottoTicketNum = 100;

        // WHEN
        double margin = computeMargin(result, lottoTicketNum);

        // THEN
        assertThat(margin).isEqualTo((double) totalPrize /  (lottoTicketNum * LOTTO_PRICE) * PERCENT_MULTIPLIER);
    }
}