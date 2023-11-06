package lotto.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputViewTest {
    OutputView outputView = new OutputView();

    @Test
    @DisplayName("구매 안내 출력 테스트")
    void 로또_구매_금액() {
        // given

        // when
//        String inputMoney = outputView.MoneyInputMessage();

        // then
//        Assertions.assertThat("구매금액을 입력해주세요.").isEqualTo(inputMoney);
    }

    @Test
    @DisplayName("로또 구매 개수 출력 테스트")
    void 몇개_구매_했는지_출력() {
        // given

        // when
//        String totalLottoMessage = outputView.totalLottoMessage();

        // then
//        Assertions.assertThat("8개를 구매했습니다.").isEqualTo(totalLottoMessage);
    }
}