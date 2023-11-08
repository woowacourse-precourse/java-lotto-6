package lotto.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.exception.ErrorCode.BLANK_INPUT;
import static lotto.exception.ErrorCode.BONUS_NUMBER_DUPLICATE;
import static lotto.exception.ErrorCode.BONUS_NUMBER_RANGE;
import static lotto.exception.ErrorCode.LOTTO_NUMBER_DUPLICATE;
import static lotto.exception.ErrorCode.LOTTO_NUMBER_RANGE;
import static lotto.exception.ErrorCode.LOTTO_NUMBER_SIZE;
import static lotto.exception.ErrorCode.NOT_INTEGER_INPUT;
import static lotto.exception.ErrorCode.PURCHASE_AMOUNT_NOT_POSITIVE;
import static lotto.exception.ErrorCode.PURCHASE_AMOUNT_NOT_PRICE_UNIT;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class LottoGameControllerTest extends NsTest {

    @Test
    void 구매_가격이_숫자가_아니라면_예외를_던진다() {
        assertSimpleTest(() -> {
            runException("poby");
            assertThat(output()).contains(NOT_INTEGER_INPUT.getMessage());
        });
    }

    @Test
    void 구매_가격이_빈값이라면_예외를_던진다() {
        assertSimpleTest(() -> {
            runException("\n");
            assertThat(output()).contains(BLANK_INPUT.getMessage());
        });
    }

    @Test
    void 구매_가격이_로또_단위가_아니라면_예외를_던진다() {
        assertSimpleTest(() -> {
            runException("12345");
            assertThat(output()).contains(PURCHASE_AMOUNT_NOT_PRICE_UNIT.getMessage());
        });
    }

    @Test
    void 구매_가격이_양수가_아니라면_예외를_던진다() {
        assertSimpleTest(() -> {
            runException("-1000");
            assertThat(output()).contains(PURCHASE_AMOUNT_NOT_POSITIVE.getMessage());
        });
    }

    @Test
    void 당첨_번호가_6개의_숫자가_아니라면_예외를_발생한다() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6,7");
            assertThat(output()).contains(LOTTO_NUMBER_SIZE.getMessage());
        });
    }

    @Test
    void 당첨_번호가_1에서_45의_수가_아니라면_예외를_던진다() {
        assertSimpleTest(() -> {
            runException("1000", "0,2,3,4,5,6");
            assertThat(output()).contains(LOTTO_NUMBER_RANGE.getMessage());
        });
    }

    @Test
    void 당첨_번호에_중복된_수가_존재하면_예외를_발생한다() {
        assertSimpleTest(() -> {
            runException("1000", "2,2,3,4,5,6");
            assertThat(output()).contains(LOTTO_NUMBER_DUPLICATE.getMessage());
        });
    }

    @Test
    void 보너스_번호가_당첨_번호와_중복된다면_예외를_발생한다() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "6");
            assertThat(output()).contains(BONUS_NUMBER_DUPLICATE.getMessage());
        });
    }

    @Test
    void 보너스_번호가_1에서_45의_수가_아니라면_예외를_발생한다() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "0");
            assertThat(output()).contains(BONUS_NUMBER_RANGE.getMessage());
        });
    }

    @Override
    public void runMain() {
        LottoGameController gameController = new LottoGameController();
        gameController.run();
    }

}