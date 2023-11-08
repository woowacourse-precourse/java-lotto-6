package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

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

    @Test
    public void testCheckDuplicatedValue() {

        List<Integer> trueValue = new ArrayList<>();
        trueValue.add(1);
        trueValue.add(2);
        trueValue.add(3);
        trueValue.add(4);
        trueValue.add(5);
        trueValue.add(6);

        List<Integer> falseValue = new ArrayList<>();
        falseValue.add(1);
        falseValue.add(1);
        falseValue.add(2);
        falseValue.add(3);
        falseValue.add(4);
        falseValue.add(5);

        assertThatCode(() -> new Lotto(trueValue))
                .doesNotThrowAnyException();

        assertThatThrownBy(() -> new Lotto(falseValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void TestMakeLotto(){

        System.out.println("-----------------");
        System.out.println("test result");
        for(int i=0;i<10;i++) {
            List<Integer> testValue = Lotto.makeLotto();
            for (int number : testValue) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------");
    }

    @Test
    public void TestToString(){

        List<Integer> testValue = Lotto.makeLotto();
        Lotto lotto = new Lotto(testValue);
        System.out.println("-----------------");
        System.out.println("test result : " + lotto.toString());
        System.out.println("-----------------");
    }


    @Test
    public void TestCheckResult(){

        Integer [] winningValue = {1, 2, 3, 4, 5, 6};
        List<Integer> testWinningValues = Arrays.asList(winningValue);
        int testBonusValue = 7;

        Integer [] firstValue = {1, 2, 3, 4, 5, 6};
        Integer [] secondValue = {1, 2, 3, 4, 5, 30};
        Integer [] thirdValue = {1, 2, 3, 4, 7, 30};
        Integer [] fourthValue = {1, 2, 3, 4, 30, 31};
        Integer [] fifthValue = {1, 2, 3, 30, 31, 32};
        Integer [] failValue = {1, 2, 29, 30, 31, 32};

        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(firstValue)));
        lottos.add(new Lotto(Arrays.asList(secondValue)));
        lottos.add(new Lotto(Arrays.asList(thirdValue)));
        lottos.add(new Lotto(Arrays.asList(fourthValue)));
        lottos.add(new Lotto(Arrays.asList(fifthValue)));
        lottos.add(new Lotto(Arrays.asList(failValue)));

        assertThat(lottos.get(0).checkResult(testWinningValues, testBonusValue))
                .isEqualTo(6);

        assertThat(lottos.get(1).checkResult(testWinningValues, testBonusValue))
                .isEqualTo(7);

        assertThat(lottos.get(2).checkResult(testWinningValues, testBonusValue))
                .isEqualTo(5);

        assertThat(lottos.get(3).checkResult(testWinningValues, testBonusValue))
                .isEqualTo(4);

        assertThat(lottos.get(4).checkResult(testWinningValues, testBonusValue))
                .isEqualTo(3);

        assertThat(lottos.get(5).checkResult(testWinningValues, testBonusValue))
                .isEqualTo(2);
    }
}