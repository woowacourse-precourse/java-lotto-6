package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    @Test
    void Lotto_발급_테스트() {
        Lotto lotto = LottoService.createLotto();
        assertThat(lotto).isInstanceOf(Lotto.class);
    }

    @Test
    void _6개가_모두_일치할_경우_1등이_당첨된다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        assertThat(LottoService.getResult(lotto, winningNumber, bonusNumber)).isEqualTo(Prize.FIRST);
    }

    @Test
    void _5개가_일치하고_보너스_번호가_일치하면_2등이_당첨된다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 7);
        int bonusNumber = 6;
        assertThat(LottoService.getResult(lotto, winningNumber, bonusNumber)).isEqualTo(Prize.SECOND);
    }

    @Test
    void _5개가_일치할_경우_3등이_당첨된다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 7);
        int bonusNumber = 8;
        assertThat(LottoService.getResult(lotto, winningNumber, bonusNumber)).isEqualTo(Prize.THIRD);
    }

    @Test
    void _4개가_일치할_경우_4등이_당첨된다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 7, 8);
        int bonusNumber = 6;
        assertThat(LottoService.getResult(lotto, winningNumber, bonusNumber)).isEqualTo(Prize.FOURTH);
    }
    @Test
    void _3개가_일치할_경우_5등이_당첨된다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumber = List.of(1, 2, 3, 7, 8, 9);
        int bonusNumber = 6;
        assertThat(LottoService.getResult(lotto, winningNumber, bonusNumber)).isEqualTo(Prize.FIFTH);
    }

    @Test
    void _2개_이하로_일치할_경우_아무것도_당첨되지_않는다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumber = List.of(1, 2, 7, 8, 9, 10);
        int bonusNumber = 6;
        assertThat(LottoService.getResult(lotto, winningNumber, bonusNumber)).isEqualTo(Prize.None);
    }
}