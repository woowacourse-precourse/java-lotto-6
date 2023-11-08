package lotto;

import domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.ValidationUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.List;

import static constant.ErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationTest {
    @DisplayName("구매 금액에 숫자가 입력되지 않으면 예외가 발생한다.")
    @Test
    void inputAmountByNonInteger() throws Exception {
        ValidationUtil validationUtil = new ValidationUtil();
        Method method = validationUtil.getClass().getDeclaredMethod("validPurchaseIntegerLottoAmount", String.class);
        method.setAccessible(true); // private 메서드 접근 활성화

        String purchaseAmount = "leejuyeon";

        try {
            method.invoke(validationUtil, purchaseAmount);
        } catch (InvocationTargetException e) {
            assertThat(e.getTargetException())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(PURCHASE_TYPE);
        }
    }
    @DisplayName("구매 금액이 1000의 배수가 아니면 예외가 발생한다.")
    @Test
    void inputAmountByNondivisible() throws Exception {
        ValidationUtil validationUtil = new ValidationUtil();
        Method method = validationUtil.getClass().getDeclaredMethod("validPurchaseRemainLottoAmount", String.class);
        method.setAccessible(true); // private 메서드 접근 활성화

        String purchaseAmount = "19980115";

        try {
            method.invoke(validationUtil, purchaseAmount);
        } catch (InvocationTargetException e) {
            assertThat(e.getTargetException())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(PURCHASE_REMAINDER);
        }
    }
    @DisplayName("입력받은 당첨 번호가 6개가 아니면 예외가 발생한다.")
    @Test
    void inputWrongTypeLottoNumber() throws Exception {
        ValidationUtil validationUtil = new ValidationUtil();
        Method method = validationUtil.getClass().getDeclaredMethod("validCountWinningNumber", String[].class);
        method.setAccessible(true); // private 메서드 접근 활성화

        String[] wrongLotto = {"1", "2", "3", "4", "5", "6", "7"};

        try {
            method.invoke(validationUtil, new Object[]{wrongLotto});
        } catch (InvocationTargetException e) {
            assertThat(e.getTargetException())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(LOTTO_NUMBER_COUNT_SIX);
        }
    }
    @DisplayName("입력받은 당첨 번호에 중복이 있으면 예외가 발생한다.")
    @Test
    void inputDuplicatedLottoNumber() throws Exception {
        ValidationUtil validationUtil = new ValidationUtil();
        Method method = validationUtil.getClass().getDeclaredMethod("validDuplicateWinningNumber", String[].class);
        method.setAccessible(true); // private 메서드 접근 활성화

        String[] wrongLotto = {"1", "2", "3", "4", "5", "5"};

        try {
            method.invoke(validationUtil, new Object[]{wrongLotto});
        } catch (InvocationTargetException e) {
            assertThat(e.getTargetException())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(LOTTO_NUMBER_DUPLICATE);
        }
    }
    @DisplayName("입력받은 당첨 번호가 범위를 벗어나면 예외가 발생한다.")
    @Test
    void inputWrongRangeLottoNumber() throws Exception {
        ValidationUtil validationUtil = new ValidationUtil();
        Method method = validationUtil.getClass().getDeclaredMethod("validRangeWinningNumber", String[].class);
        method.setAccessible(true); // private 메서드 접근 활성화

        String[] wrongLotto = {"1", "2", "3", "4", "5", "115"};

        try {
            method.invoke(validationUtil, new Object[]{wrongLotto});
        } catch (InvocationTargetException e) {
            assertThat(e.getTargetException())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(LOTTO_NUMBER_RANGE);
        }
    }
    @DisplayName("입력받은 보너스 번호가 숫자가 아니면 예외가 발생한다.")
    @Test
    void inputWrongTypeBonusNumber() throws Exception {
        ValidationUtil validationUtil = new ValidationUtil();
        Method method = validationUtil.getClass().getDeclaredMethod("validIntegerBonusNumber", String.class);
        method.setAccessible(true); // private 메서드 접근 활성화

        String wrongBonus = "leeseungyeon";

        try {
            method.invoke(validationUtil, new Object[]{wrongBonus});
        } catch (InvocationTargetException e) {
            assertThat(e.getTargetException())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(BONUS_TYPE);
        }
    }
    @DisplayName("입력받은 보너스 번호가 범위를 벗어나면 예외가 발생한다.")
    @Test
    void inputWrongRangeBonusNumber() throws Exception {
        ValidationUtil validationUtil = new ValidationUtil();
        Method method = validationUtil.getClass().getDeclaredMethod("validRangeBonusNumber", int.class);
        method.setAccessible(true); // private 메서드 접근 활성화

        int wrongBonus = 725;

        try {
            method.invoke(validationUtil, new Object[]{wrongBonus});
        } catch (InvocationTargetException e) {
            assertThat(e.getTargetException())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(LOTTO_NUMBER_RANGE);
        }
    }
}