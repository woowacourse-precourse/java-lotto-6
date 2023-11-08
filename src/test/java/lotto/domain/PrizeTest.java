package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PrizeTest {
    @DisplayName("당첨 번호와 같은 번호가 3개 이상 포함된 로또면 일단 당첨인 것을 알려준다.")
    @ParameterizedTest
    @CsvSource({
            "0,false",
            "1,false",
            "2,false",
            "3,true",
            "4,true",
            "5,true",
            "6,true"
    })
    void canGetPrizeWhenSameCountEnough(int sameCount, boolean canGetPrize) {
        assertThat(Prize.canGetPrize(sameCount)).isEqualTo(canGetPrize);
    }


    @DisplayName("당첨 번호와 같은 번호의 개수와 보너스 번호 포함 여부를 알려주면 등수를 알려준다.")
    @ParameterizedTest
    @CsvSource({
            "0,false,NO_PRIZE",
            "0,true,NO_PRIZE",
            "1,false,NO_PRIZE",
            "1,true,NO_PRIZE",
            "2,false,NO_PRIZE",
            "2,true,NO_PRIZE",
            "3,false,FIFTH",
            "3,true,FIFTH",
            "4,false,FOURTH",
            "4,true,FOURTH",
            "5,false,THIRD",
            "5,true,SECOND",
            "6,false,FIRST", // 당첨 번호와 보너스 번호는 중복되지 않기에, 당첨 번호를 모두 맞췄다면 보너스 번호를 가질 수 없다.
    })
    void getPrize(int sameCount, boolean hasBonusNumber, Prize expectedResult) {
        assertThat(Prize.getPrize(sameCount, hasBonusNumber))
                .isEqualTo(expectedResult);
    }
}