package lotto.computer;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Field;
import java.util.List;
import lotto.domain.computer.Result;
import lotto.domain.computer.ResultGenerator;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class ResultGeneratorTest {

    private ResultGenerator resultGenerator;

    public ResultGeneratorTest() {
        resultGenerator = new ResultGenerator();
    }

    @DisplayName("ResultGenerator 결과 생성 테스트")
    @ParameterizedTest
    @MethodSource("lotto.computer.ResultArgumentsProvider#provideCorrectInput")
    void createResult(
            Lotto winningLotto,
            int bonusNumber,
            List<Lotto> userLottos,
            List<Integer> resultList
    ) {
        resultGenerator.setWinningLotto(winningLotto);
        resultGenerator.setBonusNumber(bonusNumber);

        Result result = resultGenerator.createResult(new Lottos(userLottos));
        assertThat(changeResultToList(result)).isEqualTo(resultList);
    }

    private List<Integer> changeResultToList(Result result) {
        try {
            int first = getValueByFieldName(result, "first");
            int second = getValueByFieldName(result, "second");
            int third = getValueByFieldName(result, "third");
            int forth = getValueByFieldName(result, "forth");
            int fifth = getValueByFieldName(result, "fifth");

            return List.of(first, second, third, forth, fifth);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private int getValueByFieldName(Result result, String fieldName)
            throws NoSuchFieldException, IllegalAccessException {
        Field field = Result.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        return (int) field.get(result);
    }
}