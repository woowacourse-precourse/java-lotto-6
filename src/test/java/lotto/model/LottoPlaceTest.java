package lotto.model;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoPlaceTest {

    @DisplayName("맞춘 갯수와 보너스 여부로 등수를 판별할 수 있다.")
    @ParameterizedTest(name = "맞춘 공의 갯수 : {0} , 보너스 일치여부 :{1} ===> 예측 순위 : {2}")
    @CsvSource(value = {"3,false,FIFTH","4,false,FOURTH","5,false,THIRD","5,true,SECOND","6,false,FIRST"})
    void judgeLottoPlace(int countCorrectNumber, boolean isBonusNumberCorrect, String expected ) {
        LottoPlace expectedLottoPlace = LottoPlace.valueOf(expected);
        Optional<LottoPlace> resultPlace = expectedLottoPlace.judgeLottoPlace(countCorrectNumber, isBonusNumberCorrect);

        assertThat(resultPlace).contains(expectedLottoPlace);
    }
}
