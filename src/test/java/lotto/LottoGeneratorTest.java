package lotto;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static lotto.LottoException.*;
import static org.assertj.core.api.AssertionsForClassTypes.*;

public class LottoGeneratorTest {

    public static LottoGenerator lottoGenerator;

    static Stream<Arguments> generateLottoWithErrorNum(){
        return Stream.of(
                Arguments.of(LOTTO_NUMBER_INVALID_SIZE.getMessage(), List.of(1,2,3,4,5)),
                Arguments.of(LOTTO_HAS_DUPLICATE_NUM.getMessage(), List.of(1,2,3,4,5,5)),
                Arguments.of(LOTTO_NUMBER_NOT_ORDERED.getMessage(), List.of(9,2,3,4,5,10)),
                Arguments.of(LOTTO_NUMBER_INVALID_RANGE.getMessage(), List.of(1,2,3,9,10,46))
        );
    }

    static Stream<Arguments> generateMoneyWithPurchasableCount(){
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(5000, 5)
        );
    }

    @BeforeAll
    static void init(){
        lottoGenerator = LottoGenerator.getInstance();
    }

    @DisplayName("로또 생성 클래스의 인스턴스 가져오기")
    @Test
    void getLottoGeneratorInstance(){
        assertThat(LottoGenerator.getInstance())
                .isInstanceOf(LottoGenerator.class);
    }

    @DisplayName("최대 구매가능한 로또의 수 테스트")
    @ParameterizedTest
    @MethodSource("generateMoneyWithPurchasableCount")
    void getMaxPurchasableCountTest(int money, int expect){
        assertThat(lottoGenerator.getMaxPurchasableCount(money))
                .isEqualTo(expect);
    }

    @DisplayName("로또 생성에 실패하는 경우")
    @ParameterizedTest
    @MethodSource("generateLottoWithErrorNum")
    void issueLottoErrorTest(String message, List<Integer> numbers){
        try {
            final Method issueLottoMethod = LottoGenerator.class.getDeclaredMethod("issueLotto", List.class);
            issueLottoMethod.setAccessible(true);
            assertThatThrownBy(()-> issueLottoMethod.invoke(lottoGenerator, numbers))
                    .isInstanceOf(InvocationTargetException.class)
                    .getCause()
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(message);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    @DisplayName("단일 로또 생성에 성공")
    @Test
    void issueLotto(){
        try {
            List<Integer> numbers = List.of(1,2,3,4,5,6);
            final Method issueLottoMethod = LottoGenerator.class.getDeclaredMethod("issueLotto", List.class);
            issueLottoMethod.setAccessible(true);
            assertThatCode(()-> issueLottoMethod.invoke(lottoGenerator, numbers));
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    @DisplayName("로또 여러장 생성")
    @ParameterizedTest
    @ValueSource(ints = {0, 5})
    void issueLottos(int time){
        assertThat(lottoGenerator.issueLottos(time).size())
                .isEqualTo(time);
    }

    @DisplayName("숫자 정렬 가능 확인")
    @Test
    void checkOrdering(){
        List<Integer> numbers = List.of(4,1,2,3,5,6);
        assertThat(lottoGenerator.orderList(numbers))
                .isNotEqualTo(numbers)
                .isEqualTo(Arrays.asList(1,2,3,4,5,6));
    }
}
