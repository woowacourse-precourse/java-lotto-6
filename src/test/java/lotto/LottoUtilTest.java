package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoUtilTest {

    @DisplayName("로또 구입 금액이 1000원 단위로 떨어지는지 검증")
    @Test
    void validateAmount() {
        assertThatThrownBy(() -> LottoUtil.validateAmount(1001))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 입력한 당첨 번호를 List<Integer>로 파싱 테스트")
    @Test
    void parseNumberToListInteger() {
        assertThat(LottoUtil.parseNumberToListInteger("1,2,3,4,5,6"))
                .isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("입력한 금액만큼 로또 구매")
    @Test
    void purchaseLottoList() {
        List<Lotto> lottoList = LottoUtil.createLottoList(8);
        assertThat(lottoList.size()).isEqualTo(8);
    }
}