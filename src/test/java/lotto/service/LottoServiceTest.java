package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.domain.WinningResult;
import lotto.domain.WinningType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {
    LottoService lottoService;
    List<Lotto> lottos;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
        lottos = new ArrayList<>();
    }

    @DisplayName("로또 1등 당첨 확인 테스트")
    @Test
    void testGetLottoResultFirstCondition() {
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(7, 8, 9, 10, 11, 12)));
        WinningLotto winningLotto = getWinningLotto(List.of(1, 2, 3, 4, 5, 6), 45);
        WinningResult lottoResult = lottoService.getLottoResult(lottos, winningLotto);

        int firstCount = lottoResult
                .getWinningCountOfType(WinningType.FIRST);
        Assertions.assertThat(firstCount).isEqualTo(1);
    }

    @DisplayName("로또 2등 당첨 확인 테스트")
    @Test
    void testGetLottoResultSecondCondition() {
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(7, 8, 9, 10, 11, 12)));
        WinningLotto winningLotto = getWinningLotto(List.of(1, 2, 3, 4, 5, 45), 6);
        WinningResult lottoResult = lottoService.getLottoResult(lottos, winningLotto);

        int firstCount = lottoResult
                .getWinningCountOfType(WinningType.SECOND);
        Assertions.assertThat(firstCount).isEqualTo(1);
    }

    @DisplayName("로또 3등 당첨 확인 테스트")
    @Test
    void testGetLottoResultThirdCondition() {
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(7, 8, 9, 10, 11, 12)));
        WinningLotto winningLotto = getWinningLotto(List.of(1, 2, 3, 4, 5, 45), 43);
        WinningResult lottoResult = lottoService.getLottoResult(lottos, winningLotto);

        int firstCount = lottoResult
                .getWinningCountOfType(WinningType.THIRD);
        Assertions.assertThat(firstCount).isEqualTo(1);
    }

    @DisplayName("로또 4등 당첨 확인 테스트")
    @Test
    void testGetLottoResultFourthCondition() {
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(7, 8, 9, 10, 11, 12)));
        WinningLotto winningLotto = getWinningLotto(List.of(1, 2, 3, 4, 44, 45), 43);
        WinningResult lottoResult = lottoService.getLottoResult(lottos, winningLotto);

        int firstCount = lottoResult
                .getWinningCountOfType(WinningType.FOURTH);
        Assertions.assertThat(firstCount).isEqualTo(1);
    }

    @DisplayName("로또 5등 당첨 확인 테스트")
    @Test
    void testGetLottoResultFifthCondition() {
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(7, 8, 9, 10, 11, 12)));
        WinningLotto winningLotto = getWinningLotto(List.of(4, 5, 6, 7, 8, 9), 45);
        WinningResult lottoResult = lottoService.getLottoResult(lottos, winningLotto);

        int firstCount = lottoResult
                .getWinningCountOfType(WinningType.FIFTH);
        Assertions.assertThat(firstCount).isEqualTo(2);
    }

    @DisplayName("로또 무당첨 확인 테스트")
    @Test
    void testGetLottoResultNoneCondition() {
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(7, 8, 9, 10, 11, 12)));
        WinningLotto winningLotto = getWinningLotto(List.of(40, 41, 42, 43, 44, 45), 1);
        WinningResult lottoResult = lottoService.getLottoResult(lottos, winningLotto);

        for (WinningType type : WinningType.values()) {
            int count = lottoResult.getWinningCountOfType(type);
            Assertions.assertThat(count).isEqualTo(0);
        }
    }

    private WinningLotto getWinningLotto(List<Integer> numbers, int bonus) {
        return new WinningLotto(new Lotto(numbers), bonus);
    }
}