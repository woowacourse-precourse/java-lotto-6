package lotto;

import java.util.Arrays;
import lotto.model.LottoMaker;
import lotto.model.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class LottoRankTest {
    @DisplayName("등수가 잘 나오는지 확인한다")
    @Test
    void getRankTest(){
        assertThat(LottoRank.values())
                .contains(LottoRank.NOLUCK
                    ,LottoRank.FIFTH
                    ,LottoRank.FOURTH
                    ,LottoRank.THIRD
                    ,LottoRank.SECOND
                    ,LottoRank.FIRST);
    }

    @DisplayName("상금이 잘 나오는지 확인한다")
    @Test
    void getWinnigMoneyTest(){
        assertThat(Arrays.stream(LottoRank.values())
                .map(LottoRank::getWinnigMoney))
                .contains("0원"
                        ,"5,000원"
                        ,"50,000원"
                        ,"1,500,000원"
                        ,"30,000,000원"
                        ,"2,000,000,000원");
    }

    @DisplayName("int형 상금이 잘 나오는지 확인한다")
    @Test
    void getWinnigTest(){
        assertThat(Arrays.stream(LottoRank.values())
                .map(LottoRank::getWinning))
                .contains(0
                        ,5000
                        ,50000
                        ,1500000
                        ,30000000
                        ,2000000000);
    }

    @DisplayName("산 로또와 당첨로또 일치 개수 확인")
    @Test
    void getMatchNumberTest(){
        assertThat(Arrays.stream(LottoRank.values())
                .map(LottoRank::getMatchLottoNumber))
                .contains(0
                        ,3
                        ,4
                        ,5
                        ,5
                        ,6);
    }

    @DisplayName("람다식을 이용해 rank 구하기")
    @Test
    void getLambdaTest(){
        assertThat(LottoRank.getRank(3,true))
                .isEqualTo(LottoRank.FIFTH);
    }

    @DisplayName("람다식을 이용해 rank 2등 구하기")
    @Test
    void getLambdaSecondTest(){
        assertThat(LottoRank.getRank(5,true))
                .isEqualTo(LottoRank.SECOND);
    }

}
