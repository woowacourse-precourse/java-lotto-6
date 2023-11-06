package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {
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
    @DisplayName("로또 번호가 최대 로또 번호보다 크면 예외가 발생한다.")
    @Test
    void createLottoByGreaterThanMaxNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 최소 로또 번호보다 작으면 예외가 발생한다.")
    @Test
    void createLottoByLessThanMinNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 45)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상 테스트")
    @Test
    void createLotto() {
        //given
        List<Integer> expect = new ArrayList<>(Arrays.asList(1, 4, 22, 7, 32, 45));
        //when
        Lotto lotto = new Lotto(expect);
        List<Integer> result = lotto.getNumbers();
        //then
        assertThat(result).isEqualTo(expect);
    }

    @DisplayName("1등 로또와 비교해서 얼마나 맞았는지 체크")
    @ParameterizedTest
    @MethodSource({"provideLottoAndFirstPrizeAndExpect_1", "provideLottoAndFirstPrizeAndExpect_2",
            "provideLottoAndFirstPrizeAndExpect_3"})
    void 테스트_compareLotto(Lotto myLotto, Lotto firstPrizeLotto, int expect) {
        //when
        int result = myLotto.compareLotto(firstPrizeLotto);
        //then
        assertThat(result).isEqualTo(expect);
    }

    private static Stream<Arguments> provideLottoAndFirstPrizeAndExpect_1() {
        Lotto firstPrizeLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(1, 8, 2, 6, 5, 7)));
        lottos.add(new Lotto(Arrays.asList(1, 8, 2, 9, 5, 7)));
        lottos.add(new Lotto(Arrays.asList(1, 8, 43, 9, 5, 7)));
        return Stream.of(
                Arguments.of(lottos.get(0), firstPrizeLotto, 4),
                Arguments.of(lottos.get(1), firstPrizeLotto, 3),
                Arguments.of(lottos.get(2), firstPrizeLotto, 2)
        );
    }

    private static Stream<Arguments> provideLottoAndFirstPrizeAndExpect_2() {
        Lotto firstPrizeLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(Arrays.asList(1, 4, 2, 6, 5, 3)));
        lottos.add(new Lotto(Arrays.asList(1, 4, 2, 6, 5, 7)));
        return Stream.of(
                Arguments.of(lottos.get(0), firstPrizeLotto, 6),
                Arguments.of(lottos.get(1), firstPrizeLotto, 6),
                Arguments.of(lottos.get(2), firstPrizeLotto, 5)
        );
    }

    private static Stream<Arguments> provideLottoAndFirstPrizeAndExpect_3() {
        Lotto firstPrizeLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(12, 8, 43, 9, 5, 7)));
        lottos.add(new Lotto(Arrays.asList(12, 8, 43, 9, 23, 7)));
        return Stream.of(
                Arguments.of(lottos.get(0), firstPrizeLotto, 1),
                Arguments.of(lottos.get(1), firstPrizeLotto, 0)
        );
    }
}