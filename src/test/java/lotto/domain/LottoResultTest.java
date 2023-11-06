package lotto.domain;

import static lotto.domain.LottoResult.FIFTH;
import static lotto.domain.LottoResult.FIRST;
import static lotto.domain.LottoResult.FOURTH;
import static lotto.domain.LottoResult.SECOND;
import static lotto.domain.LottoResult.THIRD;
import static lotto.domain.LottoResult.findRank;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @DisplayName("번호 일치 개수가 3개일 때 5등인지 확인")
    @Test
    void threeNumberCorrectIsRank_5(){
        int matchNumber = 3;
        boolean hasBonus = false;
        assertThat(findRank(matchNumber,hasBonus))
                .isEqualTo(FIFTH);
    }

    @DisplayName("번호 일치 개수가 4개일 때 4등인지 확인")
    @Test
    void fourNumberCorrectIsRank_4(){
        int matchNumber = 4;
        boolean hasBonus = false;
        assertThat(findRank(matchNumber,hasBonus))
                .isEqualTo(FOURTH);
    }

    @DisplayName("번호 일치 개수가 5개, 보너스 숫자가 불일치일 때 3등인지 확인")
    @Test
    void fourNumberCorrectIsRank_3(){
        int matchNumber = 5;
        boolean hasBonus = false;
        assertThat(findRank(matchNumber,hasBonus))
                .isEqualTo(THIRD);
    }

    @DisplayName("번호 일치 개수가 5개, 보너스 숫자가 일치일 때 2등인지 확인")
    @Test
    void fourNumberCorrectIsRank_2(){
        int matchNumber = 5;
        boolean hasBonus = true;
        assertThat(findRank(matchNumber,hasBonus))
                .isEqualTo(SECOND);
    }

    @DisplayName("번호 일치 개수가 6개 1등인지 확인")
    @Test
    void fourNumberCorrectIsRank_1(){
        int matchNumber = 6;
        boolean hasBonus = false;
        assertThat(findRank(matchNumber,hasBonus))
                .isEqualTo(FIRST);
    }
}