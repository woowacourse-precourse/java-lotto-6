package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 숫자가_2개_일치_보너스_숫자_0개_일치하면_NONE_을_반환한다() throws Exception {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(List.of(1, 2, 11, 12, 13, 14));
        LottoBonusNumber lottoBonusNumber = new LottoBonusNumber(lottoWinningNumber, 45);

        // when
        LottoPrize prize = lotto.prize(lottoWinningNumber, lottoBonusNumber);

        //then
        assertThat(prize).isEqualTo(LottoPrize.NONE);
    }

    @Test
    public void 숫자가_2개_일치_보너스_숫자_1개_일치하면_NONE_을_반환한다() throws Exception {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(List.of(1, 2, 11, 12, 13, 14));
        LottoBonusNumber lottoBonusNumber = new LottoBonusNumber(lottoWinningNumber, 6);

        // when
        LottoPrize prize = lotto.prize(lottoWinningNumber, lottoBonusNumber);

        //then
        assertThat(prize).isEqualTo(LottoPrize.NONE);
    }

    @Test
    public void 숫자가_3개_일치_보너스_숫자_0개_일치하면_5등을_반환한다() throws Exception {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(List.of(1, 2, 3, 11, 12, 13));
        LottoBonusNumber lottoBonusNumber = new LottoBonusNumber(lottoWinningNumber, 45);

        // when
        LottoPrize prize = lotto.prize(lottoWinningNumber, lottoBonusNumber);

        //then
        assertThat(prize).isEqualTo(LottoPrize.FIFTH_PRIZE);
    }

    @Test
    public void 숫자가_3개_일치_보너스_숫자_1개_일치하면_5등을_반환한다() throws Exception {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(List.of(1, 2, 3, 11, 12, 13));
        LottoBonusNumber lottoBonusNumber = new LottoBonusNumber(lottoWinningNumber, 4);

        // when
        LottoPrize prize = lotto.prize(lottoWinningNumber, lottoBonusNumber);

        //then
        assertThat(prize).isEqualTo(LottoPrize.FIFTH_PRIZE);
    }

    @Test
    public void 숫자가_4개_일치_보너스_숫자_0개_일치하면_4등을_반환한다() throws Exception {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(List.of(1, 2, 3, 4, 12, 13));
        LottoBonusNumber lottoBonusNumber = new LottoBonusNumber(lottoWinningNumber, 45);

        // when
        LottoPrize prize = lotto.prize(lottoWinningNumber, lottoBonusNumber);

        //then
        assertThat(prize).isEqualTo(LottoPrize.FOURTH_PRIZE);
    }

    @Test
    public void 숫자가_4개_일치_보너스_숫자_1개_일치하면_4등을_반환한다() throws Exception {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(List.of(1, 2, 3, 4, 12, 13));
        LottoBonusNumber lottoBonusNumber = new LottoBonusNumber(lottoWinningNumber, 5);

        // when
        LottoPrize prize = lotto.prize(lottoWinningNumber, lottoBonusNumber);

        //then
        assertThat(prize).isEqualTo(LottoPrize.FOURTH_PRIZE);
    }

    @Test
    public void 숫자가_5개_일치_보너스_숫자_0개_일치하면_3등을_반환한다() throws Exception {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(List.of(1, 2, 3, 4, 5, 13));
        LottoBonusNumber lottoBonusNumber = new LottoBonusNumber(lottoWinningNumber, 45);

        // when
        LottoPrize prize = lotto.prize(lottoWinningNumber, lottoBonusNumber);

        //then
        assertThat(prize).isEqualTo(LottoPrize.THIRD_PRIZE);
    }

    @Test
    public void 숫자가_5개_일치_보너스_숫자_1개_일치하면_2등을_반환한다() throws Exception {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(List.of(1, 2, 3, 4, 5, 13));
        LottoBonusNumber lottoBonusNumber = new LottoBonusNumber(lottoWinningNumber, 6);

        // when
        LottoPrize prize = lotto.prize(lottoWinningNumber, lottoBonusNumber);

        //then
        assertThat(prize).isEqualTo(LottoPrize.SECOND_PRIZE);
    }

    @Test
    public void 숫자가_6개_일치_보너스_숫자_0개_일치하면_1등을_반환한다() throws Exception {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(List.of(1, 2, 3, 4, 5, 6));
        LottoBonusNumber lottoBonusNumber = new LottoBonusNumber(lottoWinningNumber, 45);

        // when
        LottoPrize prize = lotto.prize(lottoWinningNumber, lottoBonusNumber);

        //then
        assertThat(prize).isEqualTo(LottoPrize.FIRST_PRIZE);
    }
}