package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoRankTest {

    @ParameterizedTest
    @CsvSource(value = {"6:true:FIRST_PRIZE", "6:false:FIRST_PRIZE",
            "5:true:SECOND_PRIZE",
            "5:false:THIRD_PRIZE",
            "4:false:FOURTH_PRIZE",
            "3:true:FIFTH_PRIZE", "3:false:FIFTH_PRIZE",
            "2:true:NONE_PRIZE", "2:false:NONE_PRIZE",
            "1:true:NONE_PRIZE", "1:false:NONE_PRIZE",
            "0:true:NONE_PRIZE", "0:false:NONE_PRIZE",}, delimiter = ':')
    @DisplayName("맞힌 번호 갯수와 보너스 번호를 맞힌 경우에 따라서 로또 등수를 반환한다.")
    void getLottoRank(int matchLottoNumber, boolean containBonusNumber, LottoRank lottoRank) {
        // given // when
        LottoRank result = LottoRank.getLottoRank(matchLottoNumber, containBonusNumber);

        // then
        assertThat(result).isEqualTo(lottoRank);
    }
}