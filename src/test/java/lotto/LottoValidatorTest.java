package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoValidatorTest {
    @TestFactory
    @DisplayName("로또 구입금액이 1000원 단위로 떨어지지 않을 경우")
    Collection<DynamicTest> 로또_구입금액이_1000원_단위로_떨어지지_않을_경우() {
        return List.of(
                DynamicTest.dynamicTest("로또 구입 금액이 999원인 경우", () -> {
                    assertThrows(IllegalArgumentException.class, () -> {
                        LottoValidator.validatePurchaseAmount("999");
                    });
                }),
                DynamicTest.dynamicTest("로또 구입 금액이 1001원인 경우", () -> {
                    assertThrows(IllegalArgumentException.class, () -> {
                        LottoValidator.validatePurchaseAmount("1001");
                    });
                })
        );
    }

    @Test
    @DisplayName("로또 번호가 6개가 아닌 경우")
    void 로또_번호가_6개가_아닌_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            LottoValidator.validateLottoNumberCount(5);
        });
    }

    @Test
    @DisplayName("로또 번호가 1 ~ 45 사이가 아닌 경우")
    void 로또_번호가_1_45_사이가_아닌_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            LottoValidator.validateLottoRange(0);
        });
    }

    @Test
    @DisplayName("입력값이 숫자가 아닌 경우")
    void 입력값이_숫자가_아닌_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            LottoValidator.validateInteger("a");
        });
    }

    @Test
    @DisplayName("로또 번호가 중복되는 경우")
    void 로또_번호가_중복되는_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            LottoValidator.validateDuplicateNumber(List.of("1", "2", "3", "4", "5", "6"), "6");
        });
    }

    @Test
    @DisplayName("보너스 번호가 1 ~ 45 사이가 아닌 경우")
    void 보너스_번호가_1_45_사이가_아닌_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            LottoValidator.validateLottoRange(0);
        });
    }


}
