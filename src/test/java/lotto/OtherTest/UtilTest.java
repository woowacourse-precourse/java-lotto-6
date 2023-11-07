package lotto.OtherTest;


import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.Util.PurchasePriceUtil;
import lotto.Util.WinningLottoNumberUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class UtilTest extends NsTest {
    private PurchasePriceUtil priceUtil = new PurchasePriceUtil();
    private WinningLottoNumberUtil lottoUtil = new WinningLottoNumberUtil();

    @Test
    @DisplayName("구매가격 검증")
    void 구매가격_검증() {
        //given
        String onlyNumeric = "1000";
        String greaterThanInteger = "2147483648";
        String greaterThanMaxRange = "2147483001";
        String smallerThanMinRange = "0";
        String MultipleOfThousand = "1230";

        Assertions.assertDoesNotThrow(() -> priceUtil.validPurchasePrice(onlyNumeric));
        Assertions.assertThrows(IllegalArgumentException.class, () -> priceUtil.validPurchasePrice(greaterThanInteger));
        Assertions.assertThrows(IllegalArgumentException.class, () -> priceUtil.validPurchasePrice(greaterThanMaxRange));
        Assertions.assertThrows(IllegalArgumentException.class, () -> priceUtil.validPurchasePrice(smallerThanMinRange));
        Assertions.assertThrows(IllegalArgumentException.class, () -> priceUtil.validPurchasePrice(MultipleOfThousand));
    }

    @Test
    @DisplayName("로또번호 검증")
    void 로또번호_검증() {
        //given
        String rightFormat = "1,2,3,4,5,6";
        String greaterThanInteger = "1,2,3,4,5,2147483648";
        String greaterThanMaxRange = "1,2,3,4,6,46";
        String smallerThanMinRange = "0,2,3,4,6,46";
        String duplicate = "1,2,3,4,6,6";

        Assertions.assertDoesNotThrow(() -> lottoUtil.validLotto(rightFormat));
        Assertions.assertThrows(IllegalArgumentException.class, () -> lottoUtil.validLotto(greaterThanInteger));
        Assertions.assertThrows(IllegalArgumentException.class, () -> lottoUtil.validLotto(greaterThanMaxRange));
        Assertions.assertThrows(IllegalArgumentException.class, () -> lottoUtil.validLotto(smallerThanMinRange));
        Assertions.assertThrows(IllegalArgumentException.class, () -> lottoUtil.validLotto(duplicate));
    }

    @Test
    @DisplayName("보너스번호 검증")
    void 보너스번호_검증() {
        //given
        String rightFormat = "45";
        String greaterThanInteger = ",2147483648";
        String greaterThanMaxRange = "46";
        String smallerThanMinRange = "0";
        String duplicate = "6";
        List<Integer> lotto = Arrays.asList(1,2,3,4,5,6);

        Assertions.assertDoesNotThrow(() -> lottoUtil.validBonusNumber(rightFormat, lotto));
        Assertions.assertThrows(IllegalArgumentException.class, () -> lottoUtil.validBonusNumber(greaterThanInteger, lotto));
        Assertions.assertThrows(IllegalArgumentException.class, () -> lottoUtil.validBonusNumber(greaterThanMaxRange, lotto));
        Assertions.assertThrows(IllegalArgumentException.class, () -> lottoUtil.validBonusNumber(smallerThanMinRange, lotto));
        Assertions.assertThrows(IllegalArgumentException.class, () -> lottoUtil.validBonusNumber(duplicate, lotto));
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
