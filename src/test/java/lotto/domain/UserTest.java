package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import lotto.domain.utils.FixedRandom;
import lotto.domain.utils.TestLotteryRanking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayName("[Unit] User에 관한 테스트")
@DisplayNameGeneration(ReplaceUnderscores.class)
public class UserTest {
    @Test
    void takeReceipt_receipt가_null이면_예외를_발생시킨다() {
        User user = new User();
        assertThatThrownBy(() -> user.takeReceipt(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getReceipts_반환된_값은_수정이_불가능하다() {
        User user = new User();
        LotteryOperator operator = new LotteryOperator(new LotteryRound(1), List.of(TestLotteryRanking.values()), 1000);
        LottoRandom random = new FixedRandom();
        user.takeReceipt(LotteryReceipt.createLotteryReceipt(operator, 10, random));
        List<LotteryReceipt> receipts = user.getReceipts();
        assertThatThrownBy(() -> {
            receipts.set(0, LotteryReceipt.createLotteryReceipt(operator, 20, random));
        }).isInstanceOf(UnsupportedOperationException.class);
    }
}
