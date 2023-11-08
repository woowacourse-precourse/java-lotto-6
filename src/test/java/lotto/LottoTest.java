package lotto;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    public static List<Integer> winnerNumbers;
    public static int bonusNumber;
    @BeforeAll
    static void init(){
        winnerNumbers = List.of(1,2,3,4,5,6);
        bonusNumber = 8;
    }
    static Stream<Arguments> generateLottoWithDivisionData(){
        return Stream.of(
                Arguments.of(1, List.of(1,2,3,4,5,6)),
                Arguments.of(2, List.of(1,2,3,4,5,8)),
                Arguments.of(3, List.of(1,2,3,4,5,9)),
                Arguments.of(4, List.of(1,2,3,4,9,10)),
                Arguments.of(5, List.of(1,2,3,9,10,11)),
                Arguments.of(6, List.of(1,2,9,10,11,12)),
                Arguments.of(6, List.of(1,21,9,10,11,12)),
                Arguments.of(6, List.of(13,21,9,10,11,12))
                );
    }

    static Stream<Arguments> generateLottoWithSameCount(){
        return Stream.of(
                Arguments.of(6, List.of(1,2,3,4,5,6)),
                Arguments.of(5, List.of(1,2,3,4,5,8)),
                Arguments.of(5, List.of(1,2,3,4,5,9)),
                Arguments.of(4, List.of(1,2,3,4,9,10)),
                Arguments.of(3, List.of(1,2,3,9,10,11)),
                Arguments.of(2, List.of(1,2,9,10,11,12)),
                Arguments.of(1, List.of(1,21,9,10,11,12)),
                Arguments.of(0, List.of(13,21,9,10,11,12))
        );
    }

    static Stream<Arguments> generateLottoWithHasBounsBall(){
        return Stream.of(
                Arguments.of(false, List.of(1,2,3,4,5,6)),
                Arguments.of(true, List.of(1,2,3,4,5,8)),
                Arguments.of(false, List.of(1,2,3,4,5,9)),
                Arguments.of(false, List.of(1,2,3,4,9,10)),
                Arguments.of(false, List.of(1,2,3,9,10,11)),
                Arguments.of(false, List.of(1,2,9,10,11,12)),
                Arguments.of(false, List.of(1,21,9,10,11,12)),
                Arguments.of(false, List.of(13,21,9,10,11,12))
        );
    }
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

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 등수를 추론한다.")
    @ParameterizedTest
    @MethodSource("generateLottoWithDivisionData")
    void checkLottoDivision(int division, List<Integer> numbers){
        LottoGenerator generator = LottoGenerator.getInstance();
        Lotto lotto = new Lotto(generator.orderList(numbers));
        assertThat(
                lotto.getDrawResult(
                        Set.copyOf(winnerNumbers), bonusNumber)
        ).isEqualTo(division);
    }

    @DisplayName("내가 구매한 로또가 실제 당첨 번호와 얼마나 같은지 확인한다.")
    @ParameterizedTest
    @MethodSource("generateLottoWithSameCount")
    void checkSameCount(int sameCount, List<Integer> numbers){
        LottoGenerator generator = LottoGenerator.getInstance();
        Lotto lotto = new Lotto(generator.orderList(numbers));
        assertThat(
                lotto.getSameCount(Set.copyOf(winnerNumbers))
        ).isEqualTo(sameCount);
    }

    @DisplayName("내가 구매한 로또가 실제 당첨 번호와 얼마나 같은지 확인한다.")
    @ParameterizedTest
    @MethodSource("generateLottoWithHasBounsBall")
    void checkHasBonusBall(boolean hasBonus, List<Integer> numbers){
        LottoGenerator generator = LottoGenerator.getInstance();
        Lotto lotto = new Lotto(generator.orderList(numbers));
        assertThat(
                lotto.hasBonusBall(bonusNumber)
        ).isEqualTo(hasBonus);
    }
}