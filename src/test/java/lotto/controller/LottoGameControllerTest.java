package lotto.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.constant.BonusNumberTestConstant.BONUS_NUMBER;
import static lotto.constant.BonusNumberTestConstant.DUPLICATION_BONUS_NUMBER;
import static lotto.constant.BonusNumberTestConstant.INVALID_RANGE_BONUS_NUMBER;
import static lotto.constant.BonusNumberTestConstant.INVALID_TYPE_BONUS_NUMBER;
import static lotto.constant.ErrorMessage.DIGIT_EXCEPTION;
import static lotto.constant.ErrorMessage.DUPLICATION_EXCEPTION;
import static lotto.constant.ErrorMessage.MULTIPLE_EXCEPTION;
import static lotto.constant.ErrorMessage.NUMBER_IN_RANGE_EXCEPTION;
import static lotto.constant.ErrorMessage.SIZE_EXCEPTION;
import static lotto.constant.LottoTestConstant.LOTTO_NUMBERS_1;
import static lotto.constant.LottoTestConstant.LOTTO_NUMBERS_2;
import static lotto.constant.LottoTestConstant.LOTTO_NUMBERS_3;
import static lotto.constant.LottoTestConstant.LOTTO_NUMBERS_4;
import static lotto.constant.LottoTestConstant.LOTTO_NUMBERS_5;
import static lotto.constant.LottoTestConstant.LOTTO_NUMBERS_6;
import static lotto.constant.LottoTestConstant.LOTTO_NUMBERS_7;
import static lotto.constant.LottoTestConstant.LOTTO_NUMBERS_8;
import static lotto.constant.LottosTestConstant.THE_NUMBER_OF_LOTTO;
import static lotto.constant.PaymentAmountTestConstant.INVALID_MULTIPLE_PAYMENT_AMOUNT;
import static lotto.constant.PaymentAmountTestConstant.INVALID_TYPE_PAYMENT_AMOUNT;
import static lotto.constant.PaymentAmountTestConstant.PAYMENT_AMOUNT;
import static lotto.constant.WinningDetailTestConstant.FIFTH_RANKING_LOTTO_COUNT;
import static lotto.constant.WinningDetailTestConstant.FIRST_RANKING_LOTTO_COUNT;
import static lotto.constant.WinningDetailTestConstant.FOURTH_RANKING_LOTTO_COUNT;
import static lotto.constant.WinningDetailTestConstant.PROFIT_RATE;
import static lotto.constant.WinningDetailTestConstant.SECOND_RANKING_LOTTO_COUNT;
import static lotto.constant.WinningDetailTestConstant.THIRD_RANKING_LOTTO_COUNT;
import static lotto.constant.WinningNumberTestConstant.DUPLICATION_WINNING_NUMBER;
import static lotto.constant.WinningNumberTestConstant.EXCEED_SIZE_WINNING_NUMBER;
import static lotto.constant.WinningNumberTestConstant.INVALID_RANGE_WINNING_NUMBER;
import static lotto.constant.WinningNumberTestConstant.INVALID_TYPE_WINNING_NUMBER;
import static lotto.constant.WinningNumberTestConstant.LESS_SIZE_WINNING_NUMBER;
import static lotto.constant.WinningNumberTestConstant.WINNING_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoGameControllerTest extends NsTest {
    @Test
    @DisplayName("정상 입력")
    void success() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run(PAYMENT_AMOUNT.getValue(), WINNING_NUMBER, BONUS_NUMBER);
                    assertThat(output()).contains(
                            THE_NUMBER_OF_LOTTO,
                            LOTTO_NUMBERS_1.toString(),
                            LOTTO_NUMBERS_2.toString(),
                            LOTTO_NUMBERS_3.toString(),
                            LOTTO_NUMBERS_4.toString(),
                            LOTTO_NUMBERS_5.toString(),
                            LOTTO_NUMBERS_6.toString(),
                            LOTTO_NUMBERS_7.toString(),
                            LOTTO_NUMBERS_8.toString(),
                            FIFTH_RANKING_LOTTO_COUNT,
                            FOURTH_RANKING_LOTTO_COUNT,
                            THIRD_RANKING_LOTTO_COUNT,
                            SECOND_RANKING_LOTTO_COUNT,
                            FIRST_RANKING_LOTTO_COUNT,
                            PROFIT_RATE
                    );
                },
                LOTTO_NUMBERS_1,
                LOTTO_NUMBERS_2,
                LOTTO_NUMBERS_3,
                LOTTO_NUMBERS_4,
                LOTTO_NUMBERS_5,
                LOTTO_NUMBERS_6,
                LOTTO_NUMBERS_7,
                LOTTO_NUMBERS_8
        );
    }

    @Nested
    @DisplayName("로또 구입 금액 입력 테스트")
    class PurchaseCostTest {
        @Nested
        @DisplayName("예외 테스트")
        class ExceptionTest {
            @Test
            @DisplayName("숫자가 아닌 입력 테스트")
            void invalidTypeTest() {
                assertSimpleTest(
                        () -> {
                            runException(INVALID_TYPE_PAYMENT_AMOUNT.getValue(), PAYMENT_AMOUNT.getValue());
                            assertThat(output()).contains(DIGIT_EXCEPTION.getMessage());
                        }
                );
            }

            @Test
            @DisplayName("1000원 단위가 아닌 입력 테스트")
            void invalidMultipleTest() {
                assertSimpleTest(
                        () -> {
                            runException(INVALID_MULTIPLE_PAYMENT_AMOUNT.getValue(), PAYMENT_AMOUNT.getValue());
                            assertThat(output()).contains(MULTIPLE_EXCEPTION.getMessage());
                        }
                );
            }
        }
    }

    @Nested
    @DisplayName("당첨 번호 입력 테스트")
    class WinningNumberTest {
        @Nested
        @DisplayName("예외 테스트")
        class ExceptionTest {
            @Test
            @DisplayName("6개보다 적은 입력 테스트")
            void lessSizeTest() {
                assertSimpleTest(
                        () -> {
                            runException(PAYMENT_AMOUNT.getValue(), LESS_SIZE_WINNING_NUMBER, WINNING_NUMBER);
                            assertThat(output()).contains(SIZE_EXCEPTION.getMessage());
                        }
                );
            }

            @Test
            @DisplayName("6개보다 많은 입력 테스트")
            void exceedSizeTest() {
                assertSimpleTest(
                        () -> {
                            runException(PAYMENT_AMOUNT.getValue(), EXCEED_SIZE_WINNING_NUMBER, WINNING_NUMBER);
                            assertThat(output()).contains(SIZE_EXCEPTION.getMessage());
                        }
                );
            }

            @Test
            @DisplayName("숫자가 아닌 입력 테스트")
            void invalidTypeTest() {
                assertSimpleTest(
                        () -> {
                            runException(PAYMENT_AMOUNT.getValue(), INVALID_TYPE_WINNING_NUMBER, WINNING_NUMBER);
                            assertThat(output()).contains(DIGIT_EXCEPTION.getMessage());
                        }
                );
            }

            @Test
            @DisplayName("1부터 45 사이가 아닌 번호 입력 테스트")
            void invalidRangeTest() {
                assertSimpleTest(
                        () -> {
                            runException(PAYMENT_AMOUNT.getValue(), INVALID_RANGE_WINNING_NUMBER, WINNING_NUMBER);
                            assertThat(output()).contains(NUMBER_IN_RANGE_EXCEPTION.getMessage());
                        }
                );
            }

            @Test
            @DisplayName("중복되는 번호 입력 테스트")
            void duplicationTest() {
                assertSimpleTest(
                        () -> {
                            runException(PAYMENT_AMOUNT.getValue(), DUPLICATION_WINNING_NUMBER, WINNING_NUMBER);
                            assertThat(output()).contains(DUPLICATION_EXCEPTION.getMessage());
                        }
                );
            }
        }
    }

    @Nested
    @DisplayName("보너스 번호 입력 테스트")
    class BonusNumberTest {
        @Nested
        @DisplayName("예외 테스트")
        class ExceptionTest {
            @Test
            @DisplayName("숫자가 아닌 입력 테스트")
            void invalidTypeTest() {
                assertSimpleTest(
                        () -> {
                            runException(PAYMENT_AMOUNT.getValue(), WINNING_NUMBER, INVALID_TYPE_BONUS_NUMBER,
                                    BONUS_NUMBER);
                            assertThat(output()).contains(DIGIT_EXCEPTION.getMessage());
                        }
                );
            }

            @Test
            @DisplayName("1부터 45 사이가 아닌 번호 입력 테스트")
            void invalidRangeTest() {
                assertSimpleTest(
                        () -> {
                            runException(PAYMENT_AMOUNT.getValue(), WINNING_NUMBER, INVALID_RANGE_BONUS_NUMBER,
                                    BONUS_NUMBER);
                            assertThat(output()).contains(NUMBER_IN_RANGE_EXCEPTION.getMessage());
                        }
                );
            }

            @Test
            @DisplayName("중복되는 번호 입력 테스트")
            void duplicationTest() {
                assertSimpleTest(
                        () -> {
                            runException(PAYMENT_AMOUNT.getValue(), WINNING_NUMBER, DUPLICATION_BONUS_NUMBER,
                                    BONUS_NUMBER);
                            assertThat(output()).contains(DUPLICATION_EXCEPTION.getMessage());
                        }
                );
            }
        }
    }

    @Override
    protected void runMain() {
        LottoGameController lottoGameController = new LottoGameController();
        lottoGameController.startGame();
    }
}