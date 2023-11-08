package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoResultCalculatorTest {

    LottoResultCalculator calculator;
    ArrayList<Lotto> lottos;
    ArrayList<Integer> prizeNum;
    int bonusNum;
    @BeforeEach
    void setUp() {
        calculator = new LottoResultCalculator();
        lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        prizeNum = new ArrayList<>(Arrays.asList(1,2,3,10,11,12));
        bonusNum = 13;
    }

    @DisplayName("로또 번호와 당첨 번호로 수익률을 계산한다.")
    @Test
    void getEarningsRate() {
        calculator.getWinningLottoSameSize(lottos,prizeNum,bonusNum);
        double result = calculator.getEarningsRate(3000);
        assertThat(result).isEqualTo(500.0);
    }
}