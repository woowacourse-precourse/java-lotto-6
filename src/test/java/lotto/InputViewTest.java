/*
package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import view.InputView;
import org.junit.jupiter.api.Test;

public class InputViewTest {
InputView inputView = new InputView();
@Test
void 구입_금액_천원_단위_예외_테스트() {
    String purchaseAmount = "1500";
    assertThatThrownBy(() -> inputView.inputPurchaseAmount(purchaseAmount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 구입 금액은 1,000원 단위로 입력 받습니다.");
}

@Test
void 구입_금액_천원_이하_예외_테스트() {
    String purchaseAmount = "999";
    assertThatThrownBy(() -> inputView.inputPurchaseAmount(purchaseAmount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 구입 금액은 1,000원 이상이어야 합니다.");
}

@Test
void 구입_금액_숫자_구성_예외_테스트() {
    String purchaseAmount = "1000a";
    assertThatThrownBy(() -> inputView.inputPurchaseAmount(purchaseAmount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 구입 금액은 숫자로만 구성됩니다.");
}

@Test
void 당첨_번호_입력_테스트() {
    inputView.inputPrizeNumber("1,2,3,4,5,6");
    List<Integer> prizeNumber = inputView.getPrizeNumber();
    assertThat(prizeNumber).hasSize(6);
}

@Test
void 당첨번호_중복_예외_테스트() {
    String prizeNumber = "1,1,2,3,4,5";
    assertThatThrownBy(() -> inputView.inputPrizeNumber(prizeNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 당첨 번호는 중복되면 안됩니다.");
}

@Test
void 당첨번호_구분자_예외_테스트() {
    String prizeNumber = "1,2,3,4,5#6";
    assertThatThrownBy(() -> inputView.inputPrizeNumber(prizeNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 당첨 번호는 숫자로 구성되고 쉼표(,)로 구분됩니다.");
}

@Test
void 당첨번호_길이_예외_테스트() {
    String prizeNumber = "1,2,3,4";
    assertThatThrownBy(() -> inputView.inputPrizeNumber(prizeNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 당첨 번호는 6개의 숫자로 구성됩니다.");
}

@Test
void 당첨번호_숫자_범위_예외_테스트() {
    String prizeNumber = "1,2,3,4,5,46";
    assertThatThrownBy(() -> inputView.inputPrizeNumber(prizeNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 당첨 번호는 45 이하의 숫자로 구성됩니다.");
}

@Test
void 당첨번호_숫자_구성_예외_테스트() {
    String prizeNumber = "1,2,3,4,5,c";
    assertThatThrownBy(() -> inputView.inputPrizeNumber(prizeNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 당첨 번호는 숫자로 구성되고 쉼표(,)로 구분됩니다.");
}

@Test
void 보너스_번호_숫자_예외_테스트() {
    String bonusNumber = "c";
    assertThatThrownBy(() -> inputView.inputBonusNumber(bonusNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 보너스 번호는 숫자로만 구성됩니다.");
}

@Test
void 보너스_번호_숫자_범위_예외_테스트() {
    String bonusNumber = "46";
    assertThatThrownBy(() -> inputView.inputBonusNumber(bonusNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 보너스 번호는 45 미만의 숫자로 구성됩니다.");
}

@Test
void 보너스_번호_당첨번호_포함_예외_테스트() {
    String bonusNumber = "6";
    String inputPrizeNumber = "1,2,3,4,5,6";
    inputView.inputPrizeNumber(inputPrizeNumber);
            assertThatThrownBy(() -> inputView.inputBonusNumber(bonusNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 보너스 번호는 당첨 번호와 중복되면 안됩니다.");
}
}


 */