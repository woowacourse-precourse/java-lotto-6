package lotto;


import lotto.domain.LottoEnum;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoEnumTest {
    @DisplayName("출력 되는 내용 확인")
    @Test
    void printDescriptionAndPrize() {
        Assertions.assertThat(LottoEnum.RANK1ST.getDescriptionAndPrize())
            .isEqualTo("6개 일치 (2,000,000,000원)");
        Assertions.assertThat(LottoEnum.RANK2ND.getDescriptionAndPrize())
            .isEqualTo("5개 일치, 보너스 볼 일치 (30,000,000원)");
        Assertions.assertThat(LottoEnum.RANK3RD.getDescriptionAndPrize())
            .isEqualTo("5개 일치 (1,500,000원)");
        Assertions.assertThat(LottoEnum.RANK4TH.getDescriptionAndPrize())
            .isEqualTo("4개 일치 (50,000원)");
        Assertions.assertThat(LottoEnum.RANK5TH.getDescriptionAndPrize())
            .isEqualTo("3개 일치 (5,000원)");
    }
}
