package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MatchingMachineTest {

    private final Lotto BASIC_LOTTO = new Lotto(Arrays.asList(1,2,3,4,5,6));
    private MatchingMachine matchingMachine;

    @BeforeEach
    void setUp(){
        matchingMachine = new MatchingMachine();
    }

    @DisplayName("일치하는 로또 번호 개수 찾아오기")
    @Test
    void matchLottoNumberCountTest(){
        Lotto winningLotto = new Lotto(Arrays.asList(5,4,8,7,2,9));
        int count = matchingMachine.countSingleLottoMatchingNumbers(BASIC_LOTTO,winningLotto);
        assertThat(count).isEqualTo(3);
    }

    @DisplayName("보너스 숫자가 존재하는지 확인")
    @Test
    void checkBonusNumberTest(){
        boolean hasBonus1 = matchingMachine.checkBonusNumber(BASIC_LOTTO, 5);
        boolean hasBonus2 = matchingMachine.checkBonusNumber(BASIC_LOTTO, 7);
        assertThat(hasBonus1).isEqualTo(true);
        assertThat(hasBonus2).isEqualTo(false);
    }

    @DisplayName("최종 결과를 열거형으로 가져온다.")
    @Test
    void countAllLottoNumberTest(){
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(BASIC_LOTTO);
        lottos.add(new Lotto(Arrays.asList(7,8,9,10,11,12)));
        Lotto winningLotto = new Lotto(Arrays.asList(1,2,3,7,8,9));
        List<MatchingCount> list = matchingMachine.countAllLottoMatchingNumbers(lottos, winningLotto, 10);
        assertThat(list.get(0)).isEqualTo(MatchingCount.THREE);
        assertThat(list.get(1)).isEqualTo(MatchingCount.THREE);
        Lotto winningLotto2 = new Lotto(Arrays.asList(1,2,3,4,5,10));
        List<MatchingCount> list2 =matchingMachine.countAllLottoMatchingNumbers(lottos, winningLotto2, 6);
        assertThat(list2.get(0)).isEqualTo(MatchingCount.FIVE_BONUS);
    }

    @DisplayName("최종 결과별 개수를 map 형태로 반환한다.")
    @Test
    void getLottoResultMap(){
        MatchingCount[] matchingCounts = MatchingCount.values();
        List<MatchingCount> enums = new ArrayList<>( Arrays.asList(matchingCounts));
        enums.add(MatchingCount.THREE);
        enums.add(MatchingCount.THREE);
        enums.add(MatchingCount.FIVE_BONUS);
        Map<MatchingCount, Integer> resultCount = matchingMachine.getLottoResultAsMap(enums);
        assertThat(resultCount.get(MatchingCount.THREE)).isEqualTo(3);
        assertThat(resultCount.get(MatchingCount.FIVE_BONUS)).isEqualTo(2);
    }
}