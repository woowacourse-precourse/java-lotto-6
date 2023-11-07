package lotto.domain.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CountToRankMappingTableTest {

    @Test
    @DisplayName("매칭된 로또 번호의 갯수와 보너스 번호 일치 여부로 등수를 매핑해준다(일치 갯수 6~3까지만 등수를 매핑함)"
            + "나머지는 Null 값 반환한다.")
    void ImmutableTest() throws Exception{
        //given
        CountToRankMappingTable table = new CountToRankMappingTable();
        //when

        Integer ranking1 = table.getRanking(1, true);
        Integer ranking2 = table.getRanking(2, false);
        Integer ranking3 = table.getRanking(3, true);
        Integer ranking4 = table.getRanking(4, false);
        Integer ranking5 = table.getRanking(5, true);
        Integer ranking6 = table.getRanking(5, false);
        Integer ranking7 = table.getRanking(6, true);
        Integer ranking8 = table.getRanking(7, true);
        Integer ranking9 = table.getRanking(7, false);
        //then
        assertThat(ranking1).isEqualTo(null);
        assertThat(ranking2).isEqualTo(null);
        assertThat(ranking3).isEqualTo(5);
        assertThat(ranking4).isEqualTo(4);
        assertThat(ranking5).isEqualTo(2);
        assertThat(ranking6).isEqualTo(3);
        assertThat(ranking7).isEqualTo(1);
        assertThat(ranking8).isEqualTo(null);
        assertThat(ranking9).isEqualTo(null);
     }

}