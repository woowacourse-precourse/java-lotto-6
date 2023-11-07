package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import features.InputMoney;

import static model.FixedValues.*;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MoneyTest {
	
	private final InputMoney money=CREATOR.moneyCreator();
	
	private static final String VALID_INPUT="50, 00 0.0  ";
	private static final String EMPTY_INPUT="";
	private static final String NAN_INPUT="not a number";
	private static final String WITH_CHANGES="500120";

    @DisplayName("구입금액의 입력 실수는 예상하여 수용 가능하다.")
    @Test
    void predictableMistake() {
    	String test=VALID_INPUT.replace(" ", "").replace(".", "").replace(",", "");
    	assertDoesNotThrow(() -> money.forTest(test));
    	assertEquals(500000, money.forTest(test));
    }
    
    @DisplayName("구입금액 공백 입력 시 예외를 발생한다.")
    @Test
    void inputEmptyAmount() {
    	IllegalArgumentException exception=assertThrows(IllegalArgumentException.class, () -> money.forTest(EMPTY_INPUT));
    	assertEquals("[ERROR] 구입금액을 반드시 입력해주세요", exception.getMessage());
    }
    
    @DisplayName("구입금액 double입력 시 예외를 발생한다.")
    @Test
    void inputDoubleValue() {
    	IllegalArgumentException exception=assertThrows(IllegalArgumentException.class, () -> money.forTest(NAN_INPUT));
    	assertEquals("[ERROR] 구입금액은 반드시 숫자여야합니다", exception.getMessage());
    }
    
    @DisplayName("거스름돈 발생 시 예외를 발생한다.")
    @Test
    void occurChanges() {
    	IllegalArgumentException exception=assertThrows(IllegalArgumentException.class, () -> money.forTest(WITH_CHANGES));
    	assertEquals("[ERROR] 거스름돈은 받을 수 없습니다", exception.getMessage());
    }
}