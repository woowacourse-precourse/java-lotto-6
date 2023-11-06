package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import lotto.domain.lotto.BonusNumber;
import lotto.domain.lotto.PurchasePrice;
import lotto.domain.lotto.WinningNumbers;
import lotto.view.inputview.InputView;
import lotto.view.inputview.InputValueType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @AfterEach
    void closeConsole() {
        Console.close();
    } //기존의 Scanner를 계속 사용하게 되어 nextLine() 값이 없는 현상을 방지. 새로운 Scanner를 생성할 수 있도록 닫아준다.

    @Test
    @DisplayName("inputValue() 메서드에 purchasePrice 키 값을 넣으면 PurchasePrice 객체를 생성한다.")
    void testPriceInputValue() {
        //given
        System.setIn(createUserInput("7000"));

        //when
        Object purchasePrice = InputView.inputValue(InputValueType.PURCHASE_PRICE);

        //then
        Assertions.assertThat(purchasePrice).isInstanceOf(PurchasePrice.class);
        Assertions.assertThat(purchasePrice).isNotInstanceOf(BonusNumber.class);
    }

    @Test
    @DisplayName("inputValue() 메서드에 bonusNumber 키 값을 넣으면 BonusNumber 객체를 생성한다.")
    void testBonusNumInputValue() {
        //given
        System.setIn(createUserInput("1,2,3,4,5,6"));
        WinningNumbers winningNumbers = (WinningNumbers) InputView.inputValue(InputValueType.WINNING_NUMBERS);
        Console.close();

        System.setIn(createUserInput("7"));
        Object bonusNumber = InputView.inputValue(InputValueType.BONUS_NUMBER, winningNumbers);

        Assertions.assertThat(winningNumbers).isInstanceOf(WinningNumbers.class);
        Assertions.assertThat(bonusNumber).isInstanceOf(BonusNumber.class);
    }

    InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}