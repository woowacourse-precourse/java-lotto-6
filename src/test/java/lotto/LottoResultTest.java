package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constants.Rank;
import lotto.constants.Value;
import lotto.domain.WinningLotto;
import lotto.manager.LottoManager;
import lotto.utils.OutputUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static lotto.constants.Value.*;

public class LottoResultTest {

    LottoManager lottoManager;
    List<Integer> buyLottoNumbers;
    List<Integer> winningLottoNumbers;
    @BeforeEach
    void init() {
        lottoManager = new LottoManager();
        lottoManager.setBuyLottos(LOTTO_TICKET_PRICE);
        buyLottoNumbers = lottoManager.getBuyLottos().get(0).getNumbers();
        winningLottoNumbers = new ArrayList<>();
    }

    void setWinningLottoNumbers() {
        while (winningLottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER);
            if (!buyLottoNumbers.contains(randomNumber) && !winningLottoNumbers.contains(randomNumber)) {
                winningLottoNumbers.add(randomNumber);
            }
        }
        lottoManager.setWinningLotto(new WinningLotto(winningLottoNumbers));
    }


    @DisplayName("0개 일치 시 랭크에 포함되지 않는 것 확인")
    @Test
    void rankOfNONE_ZERO() {
        setWinningLottoNumbers();
        lottoManager.calculateRank();

        Map<Rank, Integer> expectResult = new LinkedHashMap<>();
        expectResult.put(Rank.FIFTH, 0);
        expectResult.put(Rank.FOURTH, 0);
        expectResult.put(Rank.THIRD, 0);
        expectResult.put(Rank.SECOND, 0);
        expectResult.put(Rank.FIRST, 0);

        Assertions.assertEquals(expectResult, lottoManager.getLottoResults());
    }

    @DisplayName("0개 일치 시 수익률 0% 확인")
    @Test
    void checkProfitRateAtSameCountZero() {
        setWinningLottoNumbers();
        lottoManager.calculateRank();

        String profitRate = lottoManager.calculateProfitRate(LOTTO_TICKET_PRICE);

        Assertions.assertEquals("0", profitRate);
    }

    @DisplayName("1개 일치 시 랭크에 포함되지 않는 것 확인")
    @Test
    void rankOfNONE_ONE() {
        for (int i = 0; i < 1; i++) {
            winningLottoNumbers.add(buyLottoNumbers.get(i));
        }

        setWinningLottoNumbers();
        lottoManager.calculateRank();

        Map<Rank, Integer> expectResult = new LinkedHashMap<>();
        expectResult.put(Rank.FIFTH, 0);
        expectResult.put(Rank.FOURTH, 0);
        expectResult.put(Rank.THIRD, 0);
        expectResult.put(Rank.SECOND, 0);
        expectResult.put(Rank.FIRST, 0);

        Assertions.assertEquals(expectResult, lottoManager.getLottoResults());
    }

    @DisplayName("1개 일치 시 수익률 0% 확인")
    @Test
    void checkProfitRateAtSameCountOne() {
        for (int i = 0; i < 1; i++) {
            winningLottoNumbers.add(buyLottoNumbers.get(i));
        }

        setWinningLottoNumbers();
        lottoManager.calculateRank();

        String profitRate = lottoManager.calculateProfitRate(LOTTO_TICKET_PRICE);

        Assertions.assertEquals("0", profitRate);
    }

    @DisplayName("2개 일치 시 랭크에 포함되지 않는 것 확인")
    @Test
    void rankOfNONE_TWO() {
        for (int i = 0; i < 2; i++) {
            winningLottoNumbers.add(buyLottoNumbers.get(i));
        }

        setWinningLottoNumbers();
        lottoManager.calculateRank();

        Map<Rank, Integer> expectResult = new LinkedHashMap<>();
        expectResult.put(Rank.FIFTH, 0);
        expectResult.put(Rank.FOURTH, 0);
        expectResult.put(Rank.THIRD, 0);
        expectResult.put(Rank.SECOND, 0);
        expectResult.put(Rank.FIRST, 0);

        Assertions.assertEquals(expectResult, lottoManager.getLottoResults());
    }


    @DisplayName("2개 일치 시 수익률 0% 확인")
    @Test
    void checkProfitRateAtSameCountTwo() {
        for (int i = 0; i < 2; i++) {
            winningLottoNumbers.add(buyLottoNumbers.get(i));
        }

        setWinningLottoNumbers();
        lottoManager.calculateRank();

        String profitRate = lottoManager.calculateProfitRate(LOTTO_TICKET_PRICE);

        Assertions.assertEquals("0", profitRate);
    }

    @DisplayName("3개 일치 시 5000원 1개 당첨으로 출력되는지 확인")
    @Test
    void rankOfFIFTH() {
        for (int i = 0; i < 3; i++) {
            winningLottoNumbers.add(buyLottoNumbers.get(i));
        }

        setWinningLottoNumbers();
        lottoManager.calculateRank();

        Map<Rank, Integer> expectResult = new LinkedHashMap<>();
        expectResult.put(Rank.FIFTH, 1);
        expectResult.put(Rank.FOURTH, 0);
        expectResult.put(Rank.THIRD, 0);
        expectResult.put(Rank.SECOND, 0);
        expectResult.put(Rank.FIRST, 0);

        Assertions.assertEquals(expectResult, lottoManager.getLottoResults());
    }

    @DisplayName("3개 일치 시 수익률 500% 확인")
    @Test
    void checkProfitRateAtSameCountThree() {
        for (int i = 0; i < 3; i++) {
            winningLottoNumbers.add(buyLottoNumbers.get(i));
        }

        setWinningLottoNumbers();
        lottoManager.calculateRank();

        String profitRate = lottoManager.calculateProfitRate(LOTTO_TICKET_PRICE);

        Assertions.assertEquals("500", profitRate);
    }


    @DisplayName("4개 일치 시 50000원 1개 당첨으로 출력되는지 확인")
    @Test
    void rankOfFOURTH() {
        for (int i = 0; i < 4; i++) {
            winningLottoNumbers.add(buyLottoNumbers.get(i));
        }

        setWinningLottoNumbers();
        lottoManager.calculateRank();

        Map<Rank, Integer> expectResult = new LinkedHashMap<>();
        expectResult.put(Rank.FIFTH, 0);
        expectResult.put(Rank.FOURTH, 1);
        expectResult.put(Rank.THIRD, 0);
        expectResult.put(Rank.SECOND, 0);
        expectResult.put(Rank.FIRST, 0);

        Assertions.assertEquals(expectResult, lottoManager.getLottoResults());
    }

    @DisplayName("4개 일치 시 수익률 5000% 확인")
    @Test
    void checkProfitRateAtSameCountFour() {
        for (int i = 0; i < 4; i++) {
            winningLottoNumbers.add(buyLottoNumbers.get(i));
        }

        setWinningLottoNumbers();
        lottoManager.calculateRank();

        String profitRate = lottoManager.calculateProfitRate(LOTTO_TICKET_PRICE);

        Assertions.assertEquals("5000", profitRate);
    }

    @DisplayName("5개 일치 시 1500000원 1개 당첨으로 출력되는지 확인")
    @Test
    void rankOfTHIRD() {
        for (int i = 0; i < 5; i++) {
            winningLottoNumbers.add(buyLottoNumbers.get(i));
        }

        setWinningLottoNumbers();
        lottoManager.calculateRank();

        Map<Rank, Integer> expectResult = new LinkedHashMap<>();
        expectResult.put(Rank.FIFTH, 0);
        expectResult.put(Rank.FOURTH, 0);
        expectResult.put(Rank.THIRD, 1);
        expectResult.put(Rank.SECOND, 0);
        expectResult.put(Rank.FIRST, 0);

        Assertions.assertEquals(expectResult, lottoManager.getLottoResults());
    }

    @DisplayName("5개 일치 시 수익률 150000% 확인")
    @Test
    void checkProfitRateAtSameCountFive() {
        for (int i = 0; i < 5; i++) {
            winningLottoNumbers.add(buyLottoNumbers.get(i));
        }

        setWinningLottoNumbers();
        lottoManager.calculateRank();

        String profitRate = lottoManager.calculateProfitRate(LOTTO_TICKET_PRICE);

        Assertions.assertEquals("150000", profitRate);
    }

    @DisplayName("6개 일치 시 2000000000원 1개 당첨으로 출력되는지 확인")
    @Test
    void rankOfFIRST() {
        for (int i = 0; i < 6; i++) {
            winningLottoNumbers.add(buyLottoNumbers.get(i));
        }

        setWinningLottoNumbers();
        lottoManager.calculateRank();

        Map<Rank, Integer> expectResult = new LinkedHashMap<>();
        expectResult.put(Rank.FIFTH, 0);
        expectResult.put(Rank.FOURTH, 0);
        expectResult.put(Rank.THIRD, 0);
        expectResult.put(Rank.SECOND, 0);
        expectResult.put(Rank.FIRST, 1);

        Assertions.assertEquals(expectResult, lottoManager.getLottoResults());
    }

    @DisplayName("6개 일치 시 수익률 150000% 확인")
    @Test
    void checkProfitRateAtSameCountSix() {
        for (int i = 0; i < 6; i++) {
            winningLottoNumbers.add(buyLottoNumbers.get(i));
        }

        setWinningLottoNumbers();
        lottoManager.calculateRank();

        String profitRate = lottoManager.calculateProfitRate(LOTTO_TICKET_PRICE);

        Assertions.assertEquals("200000000", profitRate);
    }


    @DisplayName("5개 번호와 보너스 번호 일치 시 30000000원 1개 당첨으로 출력되는지 확인")
    @Test
    void rankOfSECOND() {
        for (int i = 0; i < 5; i++) {
            winningLottoNumbers.add(buyLottoNumbers.get(i));
        }

        while (winningLottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER);
            if (!buyLottoNumbers.contains(randomNumber) && !winningLottoNumbers.contains(randomNumber)) {
                winningLottoNumbers.add(randomNumber);
            }
        }

        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers);

        while (true) {
            int randomNumber = Randoms.pickNumberInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER);
            if (buyLottoNumbers.contains(randomNumber) && !winningLottoNumbers.contains(randomNumber)) {
                winningLotto.setBonusNumber(randomNumber);
                break;
            }
        }

        lottoManager.setWinningLotto(winningLotto);


        lottoManager.calculateRank();

        Map<Rank, Integer> expectResult = new LinkedHashMap<>();
        expectResult.put(Rank.FIFTH, 0);
        expectResult.put(Rank.FOURTH, 0);
        expectResult.put(Rank.THIRD, 0);
        expectResult.put(Rank.SECOND, 1);
        expectResult.put(Rank.FIRST, 0);

        Assertions.assertEquals(expectResult, lottoManager.getLottoResults());
    }


    @DisplayName("5개, 보너스 일치 시 수익률 150000% 확인")
    @Test
    void checkProfitRateAtSameCountSixWithBonus() {
        for (int i = 0; i < 5; i++) {
            winningLottoNumbers.add(buyLottoNumbers.get(i));
        }

        while (winningLottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER);
            if (!buyLottoNumbers.contains(randomNumber) && !winningLottoNumbers.contains(randomNumber)) {
                winningLottoNumbers.add(randomNumber);
            }
        }

        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers);

        while (true) {
            int randomNumber = Randoms.pickNumberInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER);
            if (buyLottoNumbers.contains(randomNumber) && !winningLottoNumbers.contains(randomNumber)) {
                winningLotto.setBonusNumber(randomNumber);
                break;
            }
        }

        lottoManager.setWinningLotto(winningLotto);
        lottoManager.calculateRank();

        String profitRate = lottoManager.calculateProfitRate(LOTTO_TICKET_PRICE);

        Assertions.assertEquals("3000000", profitRate);
    }

}
