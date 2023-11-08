package lotto.domain;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {
    private static final Integer LOTTO_5ST_PLACE = 3;
    private static final Integer LOTTO_4ST_PLACE = 4;
    private static final Integer LOTTO_3ST_PLACE = 5;
    private static final Integer LOTTO_2ST_PLACE = 51;
    private static final Integer LOTTO_1ST_PLACE = 6;
    List<Lotto> lottoList;

    @BeforeEach
    void setup() {
        Lotto lotto1 = new Lotto(Arrays.asList(6, 9, 19, 23, 31, 41));
        Lotto lotto2 = new Lotto(Arrays.asList(9, 10, 12, 24, 25, 29));
        Lotto lotto3 = new Lotto(Arrays.asList(13, 24, 26, 27, 38, 42));
        Lotto lotto4 = new Lotto(Arrays.asList(2, 4, 8, 9, 19, 40));
        Lotto lotto5 = new Lotto(Arrays.asList(3, 6, 9, 27, 36, 40));
        Lotto lotto6 = new Lotto(Arrays.asList(9, 10, 12, 24, 25, 44));

        lottoList = Arrays.asList(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6);
    }

    @DisplayName("당첨 내역의 총 수익률은 소수점 둘째 자리에서 반올림하여 계산한다")
    @Test
    void 당첨_내역의_총_수익률은_소수점_둘째_자리에서_반올림하여_계산한다() {
        //given
        Lotto winLotto = new Lotto(Arrays.asList(9, 10, 12, 1, 2, 3));
        LottoMachine lottoMachine = new LottoMachine(winLotto, lottoList, 44);

        //when
        //System.out.println(String.format("%.1f",lottoMachine.getProfitRate()));
        System.out.println(lottoMachine.getProfitRate());

        //then
        assertThat(lottoMachine.compareProfitRate(166.7)).isEqualTo(true);
    }

    @DisplayName("당첨된 로또의 5등 개수를 확인합니다")
    @Test
    void 당첨된_로또의_5등_개수를_확인합니다() {
        //given
        Lotto winLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 9, 6));
        LottoBonusNumber lottoBonusNumber = new LottoBonusNumber("19", winLotto);
        //when
        LottoMachine lottoMachine = new LottoMachine(winLotto, lottoList, lottoBonusNumber.getLottoBonusNumber());

        //then
        assertThat(lottoMachine.compareRankingWinningDetails(LOTTO_5ST_PLACE)).isEqualTo(2);
    }

    @DisplayName("당첨된 로또의 4등 개수를 확인합니다")
    @Test
    void 당첨된_로또의_4등_개수를_확인합니다() {
        //given
        Lotto winLotto = new Lotto(Arrays.asList(3, 6, 9, 27, 24, 10));
        LottoBonusNumber lottoBonusNumber = new LottoBonusNumber("19", winLotto);
        //when
        LottoMachine lottoMachine = new LottoMachine(winLotto, lottoList, lottoBonusNumber.getLottoBonusNumber());

        //then
        assertThat(lottoMachine.compareRankingWinningDetails(LOTTO_4ST_PLACE)).isEqualTo(1);
    }

    @DisplayName("당첨된 로또의 3등 개수를 확인합니다")
    @Test
    void 당첨된_로또의_3등_개수를_확인합니다() {
        //given
        Lotto winLotto = new Lotto(Arrays.asList(3, 6, 9, 27, 36, 10));
        LottoBonusNumber lottoBonusNumber = new LottoBonusNumber("19", winLotto);
        //when
        LottoMachine lottoMachine = new LottoMachine(winLotto, lottoList, lottoBonusNumber.getLottoBonusNumber());

        //then
        assertThat(lottoMachine.compareRankingWinningDetails(LOTTO_3ST_PLACE)).isEqualTo(1);
    }

    @DisplayName("당첨된 로또의 2등 개수를 확인합니다")
    @Test
    void 당첨된_로또의_2등_개수를_확인합니다() {
        //given
        Lotto winLotto = new Lotto(Arrays.asList(3, 6, 9, 27, 36, 10));
        LottoBonusNumber lottoBonusNumber = new LottoBonusNumber("40", winLotto);

        //when
        LottoMachine lottoMachine = new LottoMachine(winLotto, lottoList, lottoBonusNumber.getLottoBonusNumber());

        //then
        assertThat(lottoMachine.compareRankingWinningDetails(LOTTO_2ST_PLACE)).isEqualTo(1);
    }

    @DisplayName("당첨된 로또의 1등 개수를 확인합니다")
    @Test
    void 당첨된_로또의_1등_개수를_확인합니다() {
        //given
        Lotto winLotto = new Lotto(Arrays.asList(2, 4, 8, 9, 19, 40));
        LottoBonusNumber lottoBonusNumber = new LottoBonusNumber("45", winLotto);
        //when
        LottoMachine lottoMachine = new LottoMachine(winLotto, lottoList, lottoBonusNumber.getLottoBonusNumber());

        //then
        assertThat(lottoMachine.compareRankingWinningDetails(LOTTO_1ST_PLACE)).isEqualTo(1);
    }
}