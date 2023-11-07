package lotto.exception;

import lotto.Constant.ErrorMessageConstant;
import lotto.domain.Vendor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class VendorTestException {
    @Test
    @DisplayName("로또 구매 시 수가 아닌 값 입력 시 예외 발생")
    void insertNotNumber(){
        Vendor vendor = new Vendor();
        String input = "wootech";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assertions.assertThrows(IllegalArgumentException.class, () ->
            vendor.insertMoney(), ErrorMessageConstant.NOT_INTEGER
        );
    }

    @Test
    @DisplayName("로또 구매 시 0 또는 음수 입력 시 예외 발생")
    void insertZeroOrMinusNumber(){
        Vendor vendor = new Vendor();
        int userInput = -1;

        Assertions.assertThrows(IllegalArgumentException.class, () ->
                vendor.calculateLottoNum(userInput), ErrorMessageConstant.CANNOT_INSERT_MINOUS
        );
    }

    @Test
    @DisplayName("로또 구매 시 1000원 단위가 아닌 경우 예외 발생")
    void insertNotDiviedBy1000(){
        Vendor vendor = new Vendor();
        int userInput = 8100;

        Assertions.assertThrows(IllegalArgumentException.class, () ->
                vendor.calculateLottoNum(userInput), ErrorMessageConstant.ONLY_DIVIDE_BY_1000
        );
    }
}
