package service;

import lotto.model.Lotto;
import lotto.model.LottoManager;
import lotto.model.LottoResult;
import lotto.service.LottoPrize;
import lotto.service.LottoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoResultServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @DisplayName("로또 당첨 번호,보너스 번호와 비교해서 당첨 결과를 계산한다.(1등일 경우)")
    @Test
    void calculateLottoResultTestOne() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumbers = 7;
        LottoManager lottoManager = new LottoManager(winningNumbers);
        lottoManager.addBonusNumber(bonusNumbers);

        List<Lotto> lottoList = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6))
        );
        LottoResult lottoResult = lottoService.calculateLottoResult(lottoManager, lottoList);
        LottoPrize lottoPrize = LottoPrize.FIRST_PRIZE;

        HashMap<LottoPrize, Integer> result = new HashMap<>();
        result.put(lottoPrize, 1);
        assertEquals(lottoResult.getResultMap(), result);
    }

    @DisplayName("로또 당첨 번호,보너스 번호와 비교해서 당첨 결과를 계산한다.(2등일 경우)")
    @Test
    void calculateLottoResultTestTwo() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumbers = 7;
        LottoManager lottoManager = new LottoManager(winningNumbers);
        lottoManager.addBonusNumber(bonusNumbers);

        List<Lotto> lottoList = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 7))
        );
        LottoResult lottoResult = lottoService.calculateLottoResult(lottoManager, lottoList);
        LottoPrize lottoPrize = LottoPrize.SECOND_PRIZE;

        HashMap<LottoPrize, Integer> result = new HashMap<>();
        result.put(lottoPrize, 1);
        assertEquals(lottoResult.getResultMap(), result);
    }

    @DisplayName("로또 당첨 번호,보너스 번호와 비교해서 당첨 결과를 계산한다.(3등일 경우)")
    @Test
    void calculateLottoResultTestThree() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumbers = 7;
        LottoManager lottoManager = new LottoManager(winningNumbers);
        lottoManager.addBonusNumber(bonusNumbers);

        List<Lotto> lottoList = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 8))
        );
        LottoResult lottoResult = lottoService.calculateLottoResult(lottoManager, lottoList);
        LottoPrize lottoPrize = LottoPrize.THIRD_PRIZE;

        HashMap<LottoPrize, Integer> result = new HashMap<>();
        result.put(lottoPrize, 1);
        assertEquals(lottoResult.getResultMap(), result);
    }

    @DisplayName("로또 당첨 번호,보너스 번호와 비교해서 당첨 결과를 계산한다.(4등일 경우)")
    @Test
    void calculateLottoResultTestFour() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumbers = 7;
        LottoManager lottoManager = new LottoManager(winningNumbers);
        lottoManager.addBonusNumber(bonusNumbers);

        List<Lotto> lottoList = List.of(
                new Lotto(List.of(1, 2, 3, 4, 8, 9))
        );
        LottoResult lottoResult = lottoService.calculateLottoResult(lottoManager, lottoList);

        HashMap<LottoPrize, Integer> result = new HashMap<>();
        result.put(LottoPrize.FOURTH_PRIZE, 1);
        assertEquals(lottoResult.getResultMap(), result);
    }

    @DisplayName("로또 당첨 번호,보너스 번호와 비교해서 당첨 결과를 계산한다.(5등일 경우)")
    @Test
    void calculateLottoResultTestFive() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumbers = 7;
        LottoManager lottoManager = new LottoManager(winningNumbers);
        lottoManager.addBonusNumber(bonusNumbers);

        List<Lotto> lottoList = List.of(
                new Lotto(List.of(1, 2, 3, 8, 9, 10))
        );
        LottoResult lottoResult = lottoService.calculateLottoResult(lottoManager, lottoList);
        HashMap<LottoPrize, Integer> result = new HashMap<>();
        result.put(LottoPrize.FIFTH_PRIZE, 1);

        assertEquals(lottoResult.getResultMap(), result);
    }

    @DisplayName("로또 당첨 번호,보너스 번호와 비교해서 당첨 결과를 계산한다.(일치하는게 없는 경우)")
    @Test
    void calculateLottoResultTestNothingMatch() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumbers = 7;
        LottoManager lottoManager = new LottoManager(winningNumbers);
        lottoManager.addBonusNumber(bonusNumbers);

        List<Lotto> lottoList = List.of(
                new Lotto(List.of(8, 9, 10, 11, 12, 13))
        );
        LottoResult lottoResult = lottoService.calculateLottoResult(lottoManager, lottoList);
        HashMap<LottoPrize, Integer> result = new HashMap<>();
        result.put(LottoPrize.NOTHING_MATCH, 1);

        assertEquals(lottoResult.getResultMap(), result);
    }

}
