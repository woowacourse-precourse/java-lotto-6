package lotto.controller;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;
import lotto.constance.PrintConst;
import lotto.exception.LottoGameException;
import lotto.exception.exceptionhandler.ExceptionHandler;
import lotto.exception.exceptionhandler.RetryExceptionHandler;
import lotto.model.LottoStore;
import lotto.model.domain.lotto.lottogenerator.FixedValueLottoGenerator;
import lotto.model.domain.lotto.lottogenerator.SequenceListLottoGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoControllerTest {

    static ExceptionHandler handler = new RetryExceptionHandler();

    @Nested
    @DisplayName("고정된 값의 로또만 생성하는 Generator로 통합 테스트")
    class TestUsingFixedValue extends NsTest {

        static List<Integer> fixedLottoValue = List.of(1, 2, 3, 4, 5, 6);
        LottoStore store = new LottoStore(
                new FixedValueLottoGenerator(fixedLottoValue));

        LottoController controller = new LottoController(handler, store);

        @ParameterizedTest
        @MethodSource("resultArgs")
        @DisplayName("고정된 값 로또 생성 통합 테스트")
        public void 고정된_값_로또_생성_통합_테스트(String[] inputs, List<String> expectedOutputs, String[] extraOutput) {
            //given
            //when
            run(inputs);
            expectedOutputs.addAll(purchasedLottoPrint(List.of(fixedLottoValue)));
            expectedOutputs.addAll(Arrays.stream(extraOutput).toList());

            //then
            String output = output();
            expectedOutputs.forEach(expectedPrint ->
                    Assertions.assertThat(output).contains(expectedPrint));
        }

        static Stream<Arguments> resultArgs() {
            return Stream.of(
                    Arguments.of(
                            new String[]{"1000", "1, 2, 3, 4, 5, 6", "7"},
                            resultString(List.of(1, 0, 0, 0, 0)),
                            new String[]{N_purchaseMessage(1),
                                    "총 수익률은 200,000,000.0%입니다."}
                    ), Arguments.of(
                            new String[]{"1000", "11, 12, 13, 14, 15, 16", "7"},
                            resultString(List.of(0, 0, 0, 0, 0)),
                            new String[]{N_purchaseMessage(1),
                                    "총 수익률은 0.0%입니다."}
                    ),
                    Arguments.of(
                            new String[]{"1000", "1, 2, 3, 4, 5, 7", "6"},
                            resultString(List.of(0, 1, 0, 0, 0)),
                            new String[]{N_purchaseMessage(1),
                                    "총 수익률은 3,000,000.0%입니다."}
                    ),
                    Arguments.of(
                            new String[]{"1000", "1, 2, 3, 4, 5, 7", "8"},
                            resultString(List.of(0, 0, 1, 0, 0)),
                            new String[]{N_purchaseMessage(1),
                                    "총 수익률은 150,000.0%입니다."}
                    )
            );
        }

        @Override
        protected void runMain() {
            controller.run();
        }
    }

    @Nested
    @DisplayName("주어진 값 리스트를 사용해 로또를 생성하는 Generator")
    class TestUsingNumberSequence extends NsTest {

        LottoController controller;

        @ParameterizedTest
        @MethodSource("sequenceTestArgs")
        @DisplayName("리스트 값 로또 생성 통합 테스트")
        public void 리스트_값_로또_생성_통합_테스트(List<List<Integer>> lottoNumbers, String[] inputs, List<String> resultString,
                                       String... extraExpect) {
            //given
            controller = new LottoController(handler,
                    new LottoStore(new SequenceListLottoGenerator(lottoNumbers)));

            resultString.addAll(purchasedLottoPrint(lottoNumbers));
            resultString.add(N_purchaseMessage(lottoNumbers.size()));
            resultString.addAll(Arrays.stream(extraExpect).toList());

            //when
            run(inputs);

            //then
            String output = output();
            resultString.forEach(expected ->
                    Assertions.assertThat(output).contains(expected));
        }

        static Stream<Arguments> sequenceTestArgs() {
            return Stream.of(
                    Arguments.of(
                            List.of(
                                    List.of(1, 2, 3, 4, 5, 6),
                                    List.of(1, 2, 3, 4, 5, 7),
                                    List.of(1, 2, 3, 4, 5, 8),
                                    List.of(1, 2, 3, 4, 7, 8),
                                    List.of(1, 2, 3, 7, 8, 9)
                            ),
                            new String[]{"5000", "1, 2, 3, 4, 5, 6", "7"},
                            resultString(List.of(1, 1, 1, 1, 1)),
                            new String[]{"총 수익률은 40,631,100.0%입니다."}
                    ),
                    Arguments.of(
                            List.of(
                                    List.of(1, 2, 3, 4, 5, 6), //1
                                    List.of(4, 5, 6, 7, 8, 9), //5
                                    List.of(11, 12, 13, 14, 15, 16), //0
                                    List.of(11, 12, 13, 14, 15, 16),
                                    List.of(11, 12, 13, 14, 15, 16),
                                    List.of(11, 12, 13, 14, 15, 16),
                                    List.of(11, 12, 13, 14, 15, 16)
                            ),
                            new String[]{"7000", "1, 2, 3, 4, 5, 6", "7"},
                            resultString(List.of(1, 0, 0, 0, 1)),
                            new String[]{"총 수익률은 28,571,500.0%입니다."}
                    ),
                    Arguments.of(
                            List.of(
                                    List.of(1, 2, 3, 4, 5, 6), //1
                                    List.of(4, 5, 6, 7, 8, 9), //5
                                    List.of(11, 12, 13, 14, 15, 16)
                            ),
                            new String[]{"130000", "3000", "1, 2, 3, 4, 5, 6", "7"},
                            resultString(List.of(1, 0, 0, 0, 1)),
                            new String[]{
                                    "총 수익률은 66,666,833.3%입니다.",
                                    LottoGameException.OVER_PURCHASE_LIMIT.getExceptionMessage()
                            }
                    )
            );
        }

        @Override
        protected void runMain() {
            controller.run();
        }
    }

    private static String N_purchaseMessage(int size) {
        return String.format("%d개를 구매했습니다.", size);
    }

    private static List<String> purchasedLottoPrint(List<List<Integer>> lottoNumbers) {
        return lottoNumbers.stream()
                .map(numbers -> String.format(PrintConst.FORMAT_LOTTO_NUMBERS,
                        numbers.toArray()))
                .toList();
    }

    private static List<String> resultString(List<Integer> counts) {
        return new LinkedList<>(List.of(
                String.format("3개 일치 (5,000원) - %d개", counts.get(4)),
                String.format("4개 일치 (50,000원) - %d개", counts.get(3)),
                String.format("5개 일치 (1,500,000원) - %d개", counts.get(2)),
                String.format("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", counts.get(1)),
                String.format("6개 일치 (2,000,000,000원) - %d개", counts.get(0))));
    }
}