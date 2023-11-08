package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    LottoMachine lottoMachine = getLottoMachine(List.of(1, 3, 5, 6, 34, 21), 21);

    @Test
    void 문자열_분리_테스트() {

        //given
        String input = "1,2,3";

        //when
        String[] result = input.split(",");

        //then
        Assertions.assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    void 문자열배열을_Integer리스트로_변환() {

        //given
        String[] strings = {"1", "3", "15", "11", "33", "42"};

        //when
        List<Integer> result = lottoMachine.toIntList(strings);

        //then
        assertThat(result).isInstanceOf(List.class);
        assertThat(result).contains(1, 3, 15, 11, 33, 42);
    }

    @Test
    void 당첨결과_저장_Map_초기화() {

        //when
        Map<Rank, Integer> result = lottoMachine.initDrawResult();

        //then
        assertThat(result.size()).isEqualTo(Rank.values().length);
        assertThat(result.keySet()).contains(Rank.values());
        assertThat(Set.copyOf(result.values())).isEqualTo(Set.of(0));
    }

    @Test
    void 로또_번호_비교() {

        //given
        LottoMachine lottoMachine = getLottoMachine(List.of(1, 2, 3, 6, 23, 34), 7);
        Lotto lotto = new Lotto(List.of(1, 3, 5, 6, 34, 21));

        //when
        int matchCount = lottoMachine.calculateMatchCount(lotto);

        //then
        assertThat(matchCount).isEqualTo(4);
    }

    @Test
    void 로또번호가_5개_일치하고_보너스_번호도_일치하는_경우() {

        //given
        LottoMachine lottoMachine = getLottoMachine(List.of(1, 3, 5, 6, 34, 21), 21);
        Lotto lotto = new Lotto(List.of(1, 3, 5, 7, 34, 21));
        int matchCount = 5;

        //when
        boolean result = lottoMachine.hasBonus(lotto, matchCount);

        //then
        assertThat(result).isEqualTo(true);
    }

    @Test
    void 로또번호가_5개_일치하지만_보너스_번호가_일치_X() {

        //given
        LottoMachine lottoMachine = getLottoMachine(List.of(1, 3, 5, 6, 34, 21), 22);
        Lotto lotto = new Lotto(List.of(1, 3, 5, 6, 34, 21));
        int matchCount = 5;

        //when
        boolean result = lottoMachine.hasBonus(lotto, matchCount);

        //then
        assertThat(result).isEqualTo(false);
    }

    @ParameterizedTest
    @ValueSource(strings = {"3", "4", "6"})
    void 보너스_번호가_의미없는_경우(int matchCount) {

        //given
        Lotto lotto = new Lotto(List.of(1, 3, 5, 6, 34, 21));
        int bonusNum = 21;

        //when
        boolean result = lottoMachine.hasBonus(lotto, matchCount);

        //then
        assertThat(result).isEqualTo(false);
    }

    @Test
    void 로또_당첨_결과_확인() {

        //given
        LottoMachine lottoMachine = getLottoMachine(List.of(1, 2, 3, 4, 5, 6), 7);
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 7, 8, 9)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        lottos.add(new Lotto(List.of(10, 11, 12, 13, 14, 15)));

        //when
        Map<Rank, Integer> result = lottoMachine.draw(lottos);

        //then
        assertThat(result.get(Rank.FIRST)).isEqualTo(0);
        assertThat(result.get(Rank.SECOND)).isEqualTo(1);
        assertThat(result.get(Rank.FIFTH)).isEqualTo(1);
        assertThat(result.get(Rank.NO_RANK)).isEqualTo(1);
    }

    private LottoMachine getLottoMachine(List lottoNums, int bonusNum) {
        Lotto lotto = new Lotto(lottoNums);
        return new LottoMachine(lotto, bonusNum);
    }
}