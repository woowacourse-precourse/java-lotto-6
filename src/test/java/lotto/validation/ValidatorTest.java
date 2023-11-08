package lotto.validation;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    void 문자열이_정수라면_예외가_터지지_않는다(){
        assertDoesNotThrow(() -> Validator.validateInt("45"));
    }

    @Test
    void 문자열이_정수가_아니라면_예외가_터진다(){
        assertThatThrownBy(() -> Validator.validateInt("1.1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자로만_이루어진_문자라면_예외가_터지지_않는다(){
        assertDoesNotThrow(() -> Validator.validateOnlyNumber("45"));
    }

    @Test
    void 숫자로만_이루어진_문자가_아니라면_예외가_터진다(){
        assertThatThrownBy(() -> Validator.validateOnlyNumber(""))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validator.validateOnlyNumber("1a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 천단위로_이루어진_숫자라면_예외가_터지지_않는다(){
        assertDoesNotThrow(() -> Validator.validateThousandMultiple(1000));
        assertDoesNotThrow(() -> Validator.validateThousandMultiple(2000));
    }

    @Test
    void 천단위로_이루어진_숫자가_아니라면_예외가_터진다(){
        assertThatThrownBy(() -> Validator.validateThousandMultiple(100))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validator.validateThousandMultiple(1001))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 천이상의_정수값이라면_예외가_터지지_않는다(){
        assertDoesNotThrow(() -> Validator.validateMoreThan1000(1000));
        assertDoesNotThrow(() -> Validator.validateMoreThan1000(1050));
    }

    @Test
    void 천_미만의_값이라면_예외가_터진다(){
        assertThatThrownBy(() -> Validator.validateMoreThan1000(999))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복된_값이_존재하지_않으면_예외가_터지지_않는다(){
        assertDoesNotThrow(() -> Validator.validateDuplicateNumbers(new String[]{"1","2","3","4","5","6"}));
    }

    @Test
    void 중복된_값이_존재하면_예외가_터진다(){
        assertThatThrownBy(() -> Validator.validateDuplicateNumbers(new String[]{"1","2","3","4","5","5"}))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 컴마가_들어있으면_예외가_터지지_않는다(){
        assertDoesNotThrow(() -> Validator.validateContainComma("1,2,3,4,5,6"));
    }

    @Test
    void 컴마가_들어있지_않으면_예외가_터진다(){
        assertThatThrownBy(() -> Validator.validateContainComma("1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 일에서_사십오_사이의_숫자라면_예외가_터지지_않는다(){
        assertDoesNotThrow(() -> Validator.validate1To45Numbers(new String[]{"1","2","3","4","5","45"}));
        assertDoesNotThrow(() -> Validator.validate1To45Number(45));
    }
    
    @Test
    void 일에서_사십오_사이의_숫자가_아니면_예외가_터진다(){
        assertThatThrownBy(() -> Validator.validate1To45Numbers(new String[]{"1","2","3","4","5","46"}))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validator.validate1To45Number(46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호중_보너스번호랑_중복되는번호가_존재하지_않으면_예외가_터지지_않는다(){
        assertDoesNotThrow(
                () -> Validator.validateDuplicateBonusNumber(Arrays.asList(1, 2, 3, 4, 5, 6), 7));
    }

    @Test
    void 당첨번호중_보너스번호랑_중복되는번호가_존재하면_예외가_터진다(){
        assertThatThrownBy(
                () -> Validator.validateDuplicateBonusNumber(Arrays.asList(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }
}