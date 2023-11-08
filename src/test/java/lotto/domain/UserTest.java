package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @DisplayName("[기능]User_지불하기__전체_예산이_지불된다")
    @Test
    void userPayAllTest() {
        BigDecimal initBudget = new BigDecimal(4000);
        User user = User.createByBudget(initBudget);

        user.pay();
        assertThat(user.getBudget()).isEqualTo(BigDecimal.ZERO);
    }

    @DisplayName("[검증]User_불변검증__갖고있는_로또는_셀러가_준_로또와_다른_인스턴스")
    @Test
    void notSameLottoPaper() {
        LottoSeller lottoSeller = LottoSeller.create();
        User user = User.createByBudget(new BigDecimal(5000));
        LottoPaper lottoPaper = lottoSeller.sellLottos(user.getBudget());
        user.setLottoPaper(lottoPaper);

        assertThat(user.getLottoPaper()).isNotSameAs(lottoPaper);
    }
}