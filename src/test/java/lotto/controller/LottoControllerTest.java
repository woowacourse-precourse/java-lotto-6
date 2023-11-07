package lotto.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoControllerTest {
    private final String[] WINNING_NUM = new String[]{"1", "2", "3", "4", "5", "21"};
    private LottoController controller;

    @BeforeEach
    public void setUp() {

    }


    @DisplayName("당첨 번호와 로또 번호 비교해서 일치하는 개수 세기")
    @ParameterizedTest
    @CsvSource(value = {"20,21,28,3,4,24:3", "42,36,1,24,27,39:1", "11,37,22,21,43,41:1"}, delimiter = ':')
    void countSameNumbers(String lottoEX, int expectedCount) {
        Lotto winningLotto = new Lotto(WINNING_NUM);
        controller = new LottoController();

        List<Integer> lottos = parseStringToList(lottoEX);

        int result = controller.countSameNumbers(lottos, winningLotto.getNumbers());

        assertThat(result).isEqualTo(expectedCount);
    }

    private List<Integer> parseStringToList(String lotto) {
        String[] numbers = lotto.split(",");
        List<Integer> inputList = Arrays.stream(numbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return inputList;
    }


}


