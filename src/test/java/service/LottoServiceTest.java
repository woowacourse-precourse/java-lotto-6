package service;

import camp.nextstep.edu.missionutils.test.NsTest;
import domain.Lotto;
import lotto.Application;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest extends NsTest {
    public static final double FIFTH_PRICE = 5000;
    public static final double FOURTH_PRICE = 50000;
    public static final double SECOND_PRICE = 30000000;
    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 0, 3})
    void 로또_구매_장수_테스트(int input) {
        //when
        List<Lotto> lottos = lottoService.buyLotto(input);

        //then
        Assertions.assertEquals(lottos.size(), input);
    }

    @Test
    void 당첨번호_설정_중복_예외_테스트() {
        //given
        lottoService.generatePlayer(1000);

        //when && then
        assertThatThrownBy(() -> lottoService.setPlayerWinningNumbers(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호_설정_범위_예외_테스트() {
        //given
        lottoService.generatePlayer(1000);

        //when && then
        assertThatThrownBy(() -> lottoService.setPlayerWinningNumbers(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> lottoService.setPlayerWinningNumbers(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스번호_중복_설정_예외_테스트() {
        //given
        lottoService.generatePlayer(1000);
        lottoService.setPlayerWinningNumbers(List.of(1, 2, 3, 4, 5, 6));

        //when && then
        assertThatThrownBy(() -> lottoService.setPlayerBonusMatchNumber(1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스번호_중복_범위_예외_테스트() {
        //given
        lottoService.generatePlayer(1000);
        lottoService.setPlayerWinningNumbers(List.of(1, 2, 3, 4, 5, 6));

        //when && then
        assertThatThrownBy(() -> lottoService.setPlayerBonusMatchNumber(0))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> lottoService.setPlayerBonusMatchNumber(46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 결과_예측_테스트() {
        //given
        lottoService.generatePlayer(3000);
        lottoService.setPlayerWinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        lottoService.setPlayerBonusMatchNumber(7);
        lottoService.addLotto(new Lotto(List.of(1, 2, 3, 10, 20, 30)));
        lottoService.addLotto(new Lotto(List.of(1, 2, 3, 4, 20, 30)));
        lottoService.addLotto(new Lotto(List.of(1, 2, 3, 4, 5, 7)));

        //when
        HashMap winningResult = lottoService.getWinningResult();

        //then
        assertEquals(1, winningResult.get(3));
        assertEquals(1, winningResult.get(4));
        assertEquals(1, winningResult.get(7));
    }

    @Test
    void 수익률_예측_테스트() {
        //given
        lottoService.generatePlayer(3000);
        lottoService.setPlayerWinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        lottoService.setPlayerBonusMatchNumber(7);
        lottoService.addLotto(new Lotto(List.of(1, 2, 3, 10, 20, 30)));
        lottoService.addLotto(new Lotto(List.of(1, 2, 3, 4, 20, 30)));
        lottoService.addLotto(new Lotto(List.of(1, 2, 3, 4, 5, 7)));

        //when
        lottoService.getWinningResult();
        double result = lottoService.getEarnRatio();
        double earnRatio = ((FIFTH_PRICE + FOURTH_PRICE + SECOND_PRICE) / 3000) * 100.0;

        //then
        assertEquals(earnRatio, result);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}