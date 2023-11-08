package lotto.domain;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("LottoMachine 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LottoMachineTest {

    @Test
    void getInstance_정적_팩토리_메소드는_같은_인스턴스를_반환한다() {
        LottoMachine firstInstance = LottoMachine.getInstance();
        LottoMachine secondInstance = LottoMachine.getInstance();

        Assertions.assertEquals(firstInstance, secondInstance);
    }

    @Test
    void issue_메소드는_입력값_수량만큼_로또를_발행한다() {
        LottoMachine lottoMachine = LottoMachine.getInstance();
        List<Lotto> lottos = lottoMachine.issue(10, new LottoAutoIssuePolicy());

        Assertions.assertEquals(lottos.size(), 10);
    }

    @ParameterizedTest
    @MethodSource("provideLottoNumbers")
    void issue_메소드는_입력값으로_주어진_전략에_따라_로또를_발행한다(List<Integer> numbers) {
        LottoMachine lottoMachine = LottoMachine.getInstance();
        List<Lotto> lottos = lottoMachine.issue(1, new LottoManualIssuePolicy(numbers));

        Assertions.assertTrue(isEquals(lottos.get(0), numbers));
    }

    private boolean isEquals(Lotto lotto, List<Integer> numbers) {
        return numbers.stream()
                .allMatch(number -> lotto.isContain(new LottoNumber(number)));
    }

    private static Stream<Arguments> provideLottoNumbers() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6)),
                Arguments.of(List.of(12, 5, 28, 45, 34, 32))
        );
    }

    static class LottoManualIssuePolicy implements LottoIssuePolicy {
        private final List<Integer> numbers;

        public LottoManualIssuePolicy(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public List<Integer> issue() {
            return numbers;
        }
    }
}
