package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MatchCheckTest {

    private final Map<Integer, Integer> resultMap = new LinkedHashMap<>();
    private final static Integer MATCHES_3 = 5000;
    private final static Integer MATCHES_4 = 50_000;
    private final static Integer MATCHES_5 = 1_500_000;
    private final static Integer MATCHES_5_PLUS_BONUS = 30_000_000;
    private final static Integer MATCHES_6 = 2_000_000_000;
    private final static int INIT_COUNT = 0;

    @BeforeEach
    public void init() {
        resultMap.put(MATCHES_3, INIT_COUNT);
        resultMap.put(MATCHES_4, INIT_COUNT);
        resultMap.put(MATCHES_5, INIT_COUNT);
        resultMap.put(MATCHES_5_PLUS_BONUS, INIT_COUNT);
        resultMap.put(MATCHES_6, INIT_COUNT);
    }

    @Test
    @DisplayName("복권 당첨이 하나도 안될 수 있다.")
    void matchCountZero() {
        //given
        Map<Integer, List<Integer>> customerLottoNumbers = Map.of(0, List.of(1,2,3,4,5,6),1, List.of(7,8,9,10,11,12));
        List<Integer> numbers = List.of(30,31,32,33,34,35);
        int bonusNumber = 45;

        //when
        Map<Integer, Integer> result = WinStatistics.result(customerLottoNumbers, numbers, bonusNumber);

        //then
        assertThat(result.get(MATCHES_3)).isEqualTo(0);
        assertThat(result.get(MATCHES_4)).isEqualTo(0);
        assertThat(result.get(MATCHES_5)).isEqualTo(0);
        assertThat(result.get(MATCHES_5_PLUS_BONUS)).isEqualTo(0);
        assertThat(result.get(MATCHES_6)).isEqualTo(0);
    }

    @Test
    @DisplayName("자동 복권의 번호와 당첨번호의 번호가 3개 일치하면 5000의 카운트가 1이 올라간다.")
    void matchCountThree() {
        //given
        Map<Integer, List<Integer>> customerLottoNumbers = Map.of(0, List.of(4,5,6,30,31,32),1, List.of(7,8,9,10,11,12));
        List<Integer> numbers = List.of(30,31,32,33,34,35);
        int bonusNumber = 45;

        //when
        Map<Integer, Integer> result = WinStatistics.result(customerLottoNumbers, numbers, bonusNumber);

        //then
        assertThat(result.get(MATCHES_3)).isEqualTo(1);
        assertThat(result.get(MATCHES_4)).isEqualTo(0);
        assertThat(result.get(MATCHES_5)).isEqualTo(0);
        assertThat(result.get(MATCHES_5_PLUS_BONUS)).isEqualTo(0);
        assertThat(result.get(MATCHES_6)).isEqualTo(0);
    }
    @Test
    @DisplayName("자동 복권의 번호와 당첨번호의 번호가 4개 일치하면 50000의 카운트가 1이 올라간다.")
    void matchCountFour() {
        //given
        Map<Integer, List<Integer>> customerLottoNumbers = Map.of(0, List.of(4,5,30,31,32,33),1, List.of(7,8,9,10,11,12));
        List<Integer> numbers = List.of(30,31,32,33,34,35);
        int bonusNumber = 45;

        //when
        Map<Integer, Integer> result = WinStatistics.result(customerLottoNumbers, numbers, bonusNumber);

        //then
        assertThat(result.get(MATCHES_3)).isEqualTo(0);
        assertThat(result.get(MATCHES_4)).isEqualTo(1);
        assertThat(result.get(MATCHES_5)).isEqualTo(0);
        assertThat(result.get(MATCHES_5_PLUS_BONUS)).isEqualTo(0);
        assertThat(result.get(MATCHES_6)).isEqualTo(0);
    }
    @Test
    @DisplayName("자동 복권의 번호와 당첨번호의 번호가 5개 일치하면 50000의 카운트가 1이 올라간다.")
    void matchCountFive() {
        //given
        Map<Integer, List<Integer>> customerLottoNumbers = Map.of(0, List.of(4,30,31,32,33,34),1, List.of(7,8,9,10,11,12));
        List<Integer> numbers = List.of(30,31,32,33,34,35);
        int bonusNumber = 45;

        //when
        Map<Integer, Integer> result = WinStatistics.result(customerLottoNumbers, numbers, bonusNumber);

        //then
        assertThat(result.get(MATCHES_3)).isEqualTo(0);
        assertThat(result.get(MATCHES_4)).isEqualTo(0);
        assertThat(result.get(MATCHES_5)).isEqualTo(1);
        assertThat(result.get(MATCHES_5_PLUS_BONUS)).isEqualTo(0);
        assertThat(result.get(MATCHES_6)).isEqualTo(0);
    }
    @Test
    @DisplayName("자동 복권의 번호와 당첨번호의 번호가 5개 일치하고 보너스 번호가 일치하면 30000000의 카운트가 1이 올라간다.")
    void matchCountFiveAndBonusNumber() {
        //given
        Map<Integer, List<Integer>> customerLottoNumbers = Map.of(0, List.of(30,31,32,33,34,45),1, List.of(7,8,9,10,11,12));
        List<Integer> numbers = List.of(30,31,32,33,34,35);
        int bonusNumber = 45;

        //when
        Map<Integer, Integer> result = WinStatistics.result(customerLottoNumbers, numbers, bonusNumber);

        //then
        assertThat(result.get(MATCHES_3)).isEqualTo(0);
        assertThat(result.get(MATCHES_4)).isEqualTo(0);
        assertThat(result.get(MATCHES_5)).isEqualTo(0);
        assertThat(result.get(MATCHES_5_PLUS_BONUS)).isEqualTo(1);
        assertThat(result.get(MATCHES_6)).isEqualTo(0);
    }
    @Test
    @DisplayName("자동 복권의 번호와 당첨번호의 번호가 6개 일치하면 2000000000의 카운트가 1이 올라간다.")
    void matchCountSix() {
        //given
        Map<Integer, List<Integer>> customerLottoNumbers = Map.of(0, List.of(30,31,32,33,34,35),1, List.of(7,8,9,10,11,12));
        List<Integer> numbers = List.of(30,31,32,33,34,35);
        int bonusNumber = 45;

        //when
        Map<Integer, Integer> result = WinStatistics.result(customerLottoNumbers, numbers, bonusNumber);

        //then
        assertThat(result.get(MATCHES_3)).isEqualTo(0);
        assertThat(result.get(MATCHES_4)).isEqualTo(0);
        assertThat(result.get(MATCHES_5)).isEqualTo(0);
        assertThat(result.get(MATCHES_5_PLUS_BONUS)).isEqualTo(0);
        assertThat(result.get(MATCHES_6)).isEqualTo(1);
    }




}