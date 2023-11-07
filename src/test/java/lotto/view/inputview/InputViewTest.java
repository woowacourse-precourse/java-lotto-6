package lotto.view.inputview;

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
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

class InputViewTest {

    @AfterEach
    void closeConsole() {
        Console.close();
    } //기존의 Scanner를 계속 사용하게 되어 nextLine() 값이 없는 현상을 방지. 새로운 Scanner를 생성할 수 있도록 닫아준다.

    @Test
    @DisplayName("inputValue() 메서드에 purchasePrice 타입을 넣으면 PurchasePrice 객체를 생성한다.")
    void testPriceInputValue() {
        //given
        System.setIn(createUserInput("7000"));

        //when
        Object purchasePrice = InputView.inputValue(InputValueType.PURCHASE_PRICE);

        //then
        Assertions.assertThat(purchasePrice).isInstanceOf(PurchasePrice.class);
    }

    @Test
    @DisplayName("inputValue() 메서드에 WinningNumbers 타입을 넣으면 WinningNumbers 객체를 생성한다.")
    void testWinningNumbers() {
        //given
        System.setIn(createUserInput("1,2,3,4,5,6"));

        //when
        Object purchasePrice = InputView.inputValue(InputValueType.WINNING_NUMBERS);

        //then
        Assertions.assertThat(purchasePrice).isInstanceOf(WinningNumbers.class);
    }

    @Test
    @DisplayName("inputValue() 메서드에 BonusNumber 타입을 넣으면 BonusNumber 객체를 생성한다.")
    void testBonusNumInputValue() {
        //given
        WinningNumbers winningNumbers = BDDMockito.mock(WinningNumbers.class);
        System.setIn(createUserInput("7"));

        //when
        Object bonusNumber = InputView.inputValue(InputValueType.BONUS_NUMBER, winningNumbers);

        //then
        Assertions.assertThat(bonusNumber).isInstanceOf(BonusNumber.class);
    }

    InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}