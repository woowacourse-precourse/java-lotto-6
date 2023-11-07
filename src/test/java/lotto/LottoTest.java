package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.Console;
import features.InputMoney;
import features.InputNumbers;
import features.RunGame;
import model.Data;
import validator.Provider;
import validator.Validator_Lotto;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static model.FixedValues.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LottoTest {
	
	private RunGame testrun=CREATOR.runningCreator();
	private Validator_Lotto testvalidate=CREATOR.convertor();
	
	private static final String VALID_INPUT="  1,  2 , 3 ,4,5    ,  6 ";
	private static final String MORE_THAN_SIZE="1,2,3,4,5,6,7,8,9,10";
	private static final String LESS_THAN_SIZE="1,2,3";
	private static final String DUPLICATED_VALUES="4,6,10,4,9,13";
	private static final String DOUBLE_INPUT="1,2,3.0,4.0,5.6";
	private static final String EMPTY_NUM="1,,2,3,4,5";
	private static final String NFE="1,a,3,b,5,c";
	private static final String OUT_OF_BOUNDARY="90,1,2,3,4,-3";
	
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("로또 번호의 입력 실수는 예상하여 수용 가능하다.")
    @Test
    void predictableMistake() {
    	assertDoesNotThrow(() -> testvalidate.insertLottoNums(VALID_INPUT.replace(" ", "")));
    	//assertEquals(List.of(1, 2, 3, 4, 5, 6), number.forMyTest(VALID_INPUT));
    }
    
    @DisplayName("중복된 번호가 있을 시 예외가 발생한다.")
    @Test
    void duplicationCheck() {
    	IllegalArgumentException exception=assertThrows(IllegalArgumentException.class, () -> testvalidate.insertLottoNums(DUPLICATED_VALUES));
    	assertEquals("[ERROR] 중복된 번호는 유효하지 않습니다", exception.getMessage());
    }

    @DisplayName("로또 번호의 개수가 6개보다 많을 시 예외가 발생한다.")
    @Test
    void moreThanSize() {
    	IllegalArgumentException exception=assertThrows(IllegalArgumentException.class, () -> testvalidate.insertLottoNums(MORE_THAN_SIZE));
    	assertEquals("[ERROR] 6개의 번호만 유효합니다", exception.getMessage());
    }
    
    @DisplayName("로또 번호의 개수가 6개보다 적을 시 예외가 발생한다.")
    @Test
    void lessThanSize() {
    	IllegalArgumentException exception=assertThrows(IllegalArgumentException.class, () -> testvalidate.insertLottoNums(LESS_THAN_SIZE));
    	assertEquals("[ERROR] 6개의 번호만 유효합니다", exception.getMessage());
    }
    
    @DisplayName("로또 번호가 double일 경우 예외가 발생한다.")
    @Test
    void onlyInteger() {
    	IllegalArgumentException exception=assertThrows(IllegalArgumentException.class, () -> testvalidate.insertLottoNums(DOUBLE_INPUT));
    	assertEquals("[ERROR] 번호는 정수인 숫자만 유효합니다(공백 불가)", exception.getMessage());
    }
    
    @DisplayName("로또 번호가 공백일 경우(쉼표 연속) 예외가 발생한다.")
    @Test
    void emptyNum() {
    	IllegalArgumentException exception=assertThrows(IllegalArgumentException.class, () -> testvalidate.insertLottoNums(EMPTY_NUM));
    	assertEquals("[ERROR] 번호는 정수인 숫자만 유효합니다(공백 불가)", exception.getMessage());
    }
    
    @DisplayName("숫자가 아닌 번호를 입력 시 예외가 발생한다.")
    @Test
    void naN() {
    	IllegalArgumentException exception=assertThrows(IllegalArgumentException.class, () -> testvalidate.insertLottoNums(NFE));
    	assertEquals("[ERROR] 번호는 정수인 숫자만 유효합니다(공백 불가)", exception.getMessage());
    }
    
    @DisplayName("1~45이외의 정수 입력 시 예외가 발생한다.")
    @Test
    void outOfBoundary() {
    	IllegalArgumentException exception=assertThrows(IllegalArgumentException.class, () -> testvalidate.insertLottoNums(OUT_OF_BOUNDARY));
    	assertEquals("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.", exception.getMessage());
    }
}