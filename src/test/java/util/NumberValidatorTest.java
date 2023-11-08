package util;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.LottoException.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static util.NumberValidator.*;
import static view.ViewException.INPUT_SHOULD_BE_LOWER_THAN_INT_MAX;
import static view.ViewException.INPUT_SHOULD_BE_OVER_THOUSAND;

public class NumberValidatorTest {

    public static Class<IllegalArgumentException> illegalArgumentException;

    @BeforeAll
    static void init(){
        illegalArgumentException = IllegalArgumentException.class;
    }

    @DisplayName("정렬된 번호들인지 확인")
    @Test
    void checkIsOrder(){
        List<Integer> orderedNumber = List.of(1,2,3,4,5,6);
        assertThat(isOrdered(orderedNumber)).isTrue();

        List<Integer> notOrderedNumber = List.of(1,6,3,4,2,9);
        assertThatThrownBy(() -> isOrdered(notOrderedNumber))
                .isInstanceOf(illegalArgumentException)
                .hasMessage(LOTTO_NUMBER_NOT_ORDERED.getMessage());
    }

    @DisplayName("로또 번호의 길이 제약을 지키는지 확인")
    @Test
    void checkIsSuitableLength(){
        List<Integer> suitableNumbers = List.of(1,2,3,4,5,6);
        assertThat(isSuitableLength(suitableNumbers)).isTrue();

        List<List<Integer>> notSuitableNumbers
                = List.of(List.of(1,2,3,4,5,6,7), List.of(1,2,3));

        for(List<Integer> notSuitable : notSuitableNumbers){
            assertThatThrownBy(()->isSuitableLength(notSuitable))
                    .isInstanceOf(illegalArgumentException)
                    .hasMessage(LOTTO_NUMBER_INVALID_SIZE.getMessage());
        }
    }

    @DisplayName("겹치는 로또 번호가 있는지 확인")
    @Test
    void checkIsDistinct(){
        List<Integer> suitableNumbers = List.of(1,2,3,4,5,6);
        assertThat(isDistinct(suitableNumbers)).isTrue();

        List<Integer> duplicateNumbers = List.of(1,2,3,4,6,6);
        assertThatThrownBy(() -> isDistinct(duplicateNumbers))
                .isInstanceOf(illegalArgumentException)
                .hasMessage(LOTTO_HAS_DUPLICATE_NUM.getMessage());
    }

    @DisplayName("로또 번호의 범위(1~45)안에 들어오는지 확인")
    @Test
    void checkIsInRange(){
        List<Integer> suitableNumbers = List.of(1,2,3,4,5,6);
        assertThat(isInRange(suitableNumbers)).isTrue();

        List<Integer> notInRangeNumbers = List.of(1,2,3,4,6,100);
        assertThatThrownBy(() -> isInRange(notInRangeNumbers))
                .isInstanceOf(illegalArgumentException)
                .hasMessage(LOTTO_NUMBER_INVALID_RANGE.getMessage());
    }

    @DisplayName("로또 번호의 모든 제약조건에 해당하는 번호인지 확인")
    @Test
    void checkIsValidNumber(){
        List<Integer> suitableNumbers = List.of(1,2,3,4,5,6);
        assertThat(isValidNumber(suitableNumbers)).isTrue();

        List<List<Integer>> notValidNumbers = List.of(
                List.of(1,6,3,4,2,9),
                List.of(1,2,3,4,6,100),
                List.of(1,2,3,4,6,6),
                List.of(1,2,3,4,5,6,7),
                List.of(1,2,-3)
        );

        for(List<Integer> notValidNumber : notValidNumbers){
            assertThatThrownBy(() -> isValidNumber(notValidNumber))
                    .isInstanceOf(illegalArgumentException);
        }
    }

    @DisplayName("보너스 번호는 당첨 번호와 중복될 수 없다.")
    @Test
    void checkBonusNumberIsNotDuplicated(){
        List<Integer> winnerNumbers = List.of(1,2,3,4,5,6);
        int bonusNumber = 8;
        assertThat(isNotDuplicateWinnerNumbers(winnerNumbers, bonusNumber)).isTrue();
        int dupNumber = Randoms.pickNumberInRange(1, 6);
        assertThatThrownBy(() -> isNotDuplicateWinnerNumbers(winnerNumbers, dupNumber))
                .isInstanceOf(illegalArgumentException)
                .hasMessage(LOTTO_BOUNS_NUM_IS_DUPLECATE.getMessage());

    }

    @DisplayName("보너스 번호를 생성 할 수 있는지 확인")
    @Test
    void checkBonusNumberGenerate(){
        List<Integer> winnerNumbers = List.of(1,2,3,4,5,6);
        int bonusNumber = 8;
        assertThat(canGenerateBonusNumber(winnerNumbers, bonusNumber)).isTrue();

        List<List<Integer>> notSuitableNumbers
                = List.of(List.of(1,2,3,4,5,46), List.of(1,2,3,4,5,8));

        for(List<Integer> notSuitableNumber : notSuitableNumbers){
            assertThatThrownBy(()-> canGenerateBonusNumber(notSuitableNumber, -bonusNumber))
                    .isInstanceOf(illegalArgumentException);
        }
    }

    @DisplayName("로또 번호(양의 음수)로 바꿀 수 있는지 확인")
    @Test
    void checkIsNumeric(){
        String numericNumber = "12";
        assertThat(isNumeric(numericNumber)).isTrue();
        List<String> notSuitableNumbers
                = List.of("-5", "34.9");
        notSuitableNumbers.stream()
                .peek(notSuitableNumber -> {
                    assertThatThrownBy(()-> isNumeric(notSuitableNumber))
                            .isInstanceOf(NumberFormatException.class);
                });
    }

    @DisplayName("로또 구매 금액이 천원을 넘는지 확인")
    @Test
    void checkMoneyOverThousand(){
        long validMoney = 1500L;
        assertThat(overThousand(validMoney)).isTrue();

        List<Long> notSuitableNumbers = List.of(-1L, 999L);
        for(long notSuitableNumber : notSuitableNumbers){
            assertThatThrownBy(()->overThousand(notSuitableNumber))
                    .isInstanceOf(illegalArgumentException)
                    .hasMessage(INPUT_SHOULD_BE_OVER_THOUSAND.getMessage());
        }
    }

    @DisplayName("로또 구매 금액이 Integer.MAX_VALUE 를 넘지 않는지 확인")
    @Test
    void checkLowerThanMaxNumber(){
        long validMoney = 10_000_000L;
        assertThat(lowerThanMaxNumber(validMoney)).isTrue();

        long notValidMoney = Integer.MAX_VALUE + 1L;
        assertThatThrownBy(() -> lowerThanMaxNumber(notValidMoney))
                .isInstanceOf(illegalArgumentException)
                .hasMessage(INPUT_SHOULD_BE_LOWER_THAN_INT_MAX.getMessage());
    }

    @DisplayName("로또 구매 금액이 모든 제약조건을 만족하는지 확인")
    @Test
    void checkCanParseToMoney(){
        long validMoney = 10_000_000L;
        assertThat(canParseToMoney(validMoney)).isTrue();

        List<Long> notSuitableNumbers = List.of(-5L, 500L, Integer.MAX_VALUE+1L);
        for(long notSuitableNumber : notSuitableNumbers){
            assertThatThrownBy(() -> canParseToMoney(notSuitableNumber))
                    .isInstanceOf(illegalArgumentException);
        }
    }

}
