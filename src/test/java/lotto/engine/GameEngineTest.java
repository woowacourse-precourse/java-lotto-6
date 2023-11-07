package lotto.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.LottoScore;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class GameEngineTest {
    GameEngine gameEngine;

    private static String[] 숫자가_아닌경우() {
        return new String[]{null, "", " ", "1q", "qwe", "1o", "★", "!", "Q", "*", "+"};
    }

    private static Stream<List<Integer>> 여섯개의_사이즈_아닌_배열() {
        return Stream.of(
                List.of(1),
                List.of(1, 2),
                List.of(1, 2, 3),
                List.of(1, 2, 3, 4),
                List.of(1, 2, 3, 4, 5),
                List.of(1, 2, 3, 4, 5, 6, 7)
        );
    }

    private static Stream<List<Integer>> 로또숫자가6개인데_중복이있는경우() {
        return Stream.of(
                List.of(1, 2, 3, 4, 5, 1),
                List.of(1, 2, 3, 4, 2, 1),
                List.of(1, 2, 2, 2, 2, 1),
                List.of(1, 2, 3, 4, 4, 3)
        );
    }

    private static Stream<List<Integer>> 로또숫자가_1부터_45사이가_아닌_경우() {
        return Stream.of(
                List.of(1, 2, 3, 4, 5, 46),
                List.of(0, 2, 3, 4, 5, 45)
        );
    }

    private static Stream<List<Integer>> 로또숫자가_중복되지않고_6개_1부터_45사이인_경우() {
        return Stream.of(
                List.of(1, 2, 3, 4, 5, 45),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(40, 41, 42, 43, 44, 45)
        );
    }

    private static Stream<Arguments> 보너스로또번호_숫자가_아닌경우() {
        return Stream.of(
                Arguments.of("", ""),
                Arguments.of(" ", " "),
                Arguments.of("1q", "1q"),
                Arguments.of("qwe", "qwe"),
                Arguments.of("★", "★"),
                Arguments.of("1o", "1o"),
                Arguments.of("!", "!"),
                Arguments.of("Q", "Q"),
                Arguments.of("*", "*"),
                Arguments.of("+", "+"),
                Arguments.of("1,23,q,2,3,5", "1,23,q,2,3,5")
        );
    }

    private static Stream<Arguments> 로또번호_숫자가_아닌경우() {
        return Stream.of(
                Arguments.of("", ""),
                Arguments.of(" ", " "),
                Arguments.of("1q", "1q"),
                Arguments.of("qwe", "qwe"),
                Arguments.of("★", "★"),
                Arguments.of("1o", "1o"),
                Arguments.of("!", "!"),
                Arguments.of("Q", "Q"),
                Arguments.of("*", "*"),
                Arguments.of("+", "+"),
                Arguments.of("1,23,q,2,3,5", "q")
        );
    }

    private static Stream<Arguments> 로또결과() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), "1", LottoScore.FIRST_PLACE),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), "27", LottoScore.FIRST_PLACE),
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), "1", LottoScore.SECOND_PLACE),
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), "27", LottoScore.THIRD_PLACE),
                Arguments.of(List.of(1, 2, 3, 4, 8, 7), "27", LottoScore.FOURTH_PLACE),
                Arguments.of(List.of(1, 2, 3, 4, 8, 7), "1", LottoScore.FOURTH_PLACE),
                Arguments.of(List.of(1, 2, 3, 9, 8, 7), "27", LottoScore.FIFTH_PLACE),
                Arguments.of(List.of(1, 2, 3, 9, 8, 7), "1", LottoScore.FIFTH_PLACE),
                Arguments.of(List.of(1, 2, 10, 9, 8, 7), "27", LottoScore.NOTHING_PLACE),
                Arguments.of(List.of(1, 3, 10, 9, 8, 7), "27", LottoScore.NOTHING_PLACE),
                Arguments.of(List.of(1, 13, 10, 9, 8, 7), "27", LottoScore.NOTHING_PLACE),
                Arguments.of(List.of(11, 13, 10, 9, 8, 7), "27", LottoScore.NOTHING_PLACE)
        );
    }

    private static Stream<Arguments> 로또예상수익률() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), "1", 2.0E8),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), "27", 2.0E8),
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), "1", 3000000.0d),
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), "27", 150000.0),
                Arguments.of(List.of(1, 2, 3, 4, 8, 7), "27", 5000d),
                Arguments.of(List.of(1, 2, 3, 4, 8, 7), "1", 5000d),
                Arguments.of(List.of(1, 2, 3, 9, 8, 7), "27", 500d),
                Arguments.of(List.of(1, 2, 3, 9, 8, 7), "1", 500d),
                Arguments.of(List.of(1, 2, 10, 9, 8, 7), "27", 0d),
                Arguments.of(List.of(1, 3, 10, 9, 8, 7), "27", 0d),
                Arguments.of(List.of(1, 13, 10, 9, 8, 7), "27", 0d),
                Arguments.of(List.of(11, 13, 10, 9, 8, 7), "27", 0d)
        );
    }

    @ParameterizedTest
    @MethodSource("숫자가_아닌경우")
    void 가격은_숫자가_아니면_예외가나온다(String price) {
        gameEngine = new GameEngine(new GameEngineValidator(),
                ((startInclusive, endInclusive, size) -> new ArrayList<>()));
        Assertions.assertThatCode(() -> gameEngine.createLottos(price))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("%s는 숫자가 아닙니다.", price));
    }

    @ParameterizedTest
    @CsvSource({"-1", "0", "-21474836", "-2147484000", "-9223372036854775000"})
    void 가격은_양수가_아니면_예외가나온다(String price) {
        gameEngine = new GameEngine(new GameEngineValidator(),
                ((startInclusive, endInclusive, size) -> new ArrayList<>()));
        Assertions.assertThatCode(() -> gameEngine.createLottos(price))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("%s는 양수가 아닙니다.", price));
    }

    @ParameterizedTest
    @CsvSource({"2147483647", "2147483648", "9223372036854775807", "999", "10", "1", "9", "101", "999", "1001"})
    void 가격은_천의배수가_아니면_예외가나온다(String price) {
        gameEngine = new GameEngine(new GameEngineValidator(),
                ((startInclusive, endInclusive, size) -> new ArrayList<>()));
        Assertions.assertThatCode(() -> gameEngine.createLottos(price))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("%s는 천의 배수가 아닙니다.", price));
    }

    @ParameterizedTest
    @CsvSource({"2147483000", "2147484000", "1000", "10000", "9000", "7000"})
    void 가격은_천의배수인_양수이고_로또번호가_정상이면_예외가나오지_않는다(String price) {
        gameEngine = new GameEngine(new GameEngineValidator(),
                ((startInclusive, endInclusive, size) -> List.of(1, 2, 3, 4, 5, 6)));
        Assertions.assertThatCode(() -> gameEngine.createLottos(price))
                .doesNotThrowAnyException();
    }

    @Test
    void 로또넘버가_null이면_예외가나온다() {
        gameEngine = new GameEngine(new GameEngineValidator(),
                ((startInclusive, endInclusive, size) -> null));

        Assertions.assertThatCode(() -> gameEngine.createLottos("1000"))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 넘버는 null이 될수 없습니다.");
    }

    @ParameterizedTest
    @MethodSource({"로또숫자가6개인데_중복이있는경우"})
    void 로또숫자가_중복이_있는경우면_예외가나온다(List<Integer> lottoNumbers) {
        gameEngine = new GameEngine(new GameEngineValidator(),
                ((startInclusive, endInclusive, size) -> lottoNumbers));

        Assertions.assertThatCode(() -> gameEngine.createLottos("1000"))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또번호는 중복값을 가지고 있으면 안됩니다.");
    }

    @ParameterizedTest
    @MethodSource("로또숫자가_1부터_45사이가_아닌_경우")
    void 로또숫자가_1부터_45사이가_아니면_예외가나온다(List<Integer> lottoNumbers) {
        gameEngine = new GameEngine(new GameEngineValidator(),
                ((startInclusive, endInclusive, size) -> lottoNumbers));

        Assertions.assertThatCode(() -> gameEngine.createLottos("1000"))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @ParameterizedTest
    @MethodSource("로또숫자가_중복되지않고_6개_1부터_45사이인_경우")
    void 가격이_정상이고_로또숫자가_중복되지않고_6개_1부터_45사이면_예외가_나오지않는다(List<Integer> lottoNumbers) {
        gameEngine = new GameEngine(new GameEngineValidator(),
                ((startInclusive, endInclusive, size) -> lottoNumbers));

        Assertions.assertThatCode(() -> gameEngine.createLottos("1000"))
                .doesNotThrowAnyException();
    }

    @Test
    void 보너스로또숫자가_null이면_예외가_나온다() {
        gameEngine = new GameEngine(new GameEngineValidator(),
                ((startInclusive, endInclusive, size) -> List.of(1, 2, 3, 4, 5, 6)));
        Assertions.assertThatCode(() -> gameEngine.createAnswerBonusNumber(null))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 넘버는 null이 될수 없습니다.");
    }

    @ParameterizedTest
    @MethodSource("보너스로또번호_숫자가_아닌경우")
    void 보너스로또숫자가_숫자가아니면_예외가_나온다(String readLine, String exceptionValue) {
        gameEngine = new GameEngine(new GameEngineValidator(),
                ((startInclusive, endInclusive, size) -> List.of(1, 2, 3, 4, 5, 6)));
        Assertions.assertThatCode(() -> gameEngine.createAnswerBonusNumber(readLine))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("%s는 숫자가 아닙니다.", exceptionValue));
    }

    @ParameterizedTest
    @CsvSource({"0", "46", "21473694"})
    void 보너스로또숫자가__1부터_45사이가_아니면_예외가나온다(String readLine) {
        gameEngine = new GameEngine(new GameEngineValidator(),
                ((startInclusive, endInclusive, size) -> List.of(1, 2, 3, 4, 5, 6)));
        Assertions.assertThatCode(() -> gameEngine.createAnswerBonusNumber(readLine))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @ParameterizedTest
    @CsvSource({"1", "45", "44", "2"})
    void 보너스로또숫자가__1부터_45사이면_예외가_나오지않는다(String readLine) {
        gameEngine = new GameEngine(new GameEngineValidator(),
                ((startInclusive, endInclusive, size) -> List.of(1, 2, 3, 4, 5, 6)));
        Assertions.assertThatCode(() -> gameEngine.createAnswerBonusNumber(readLine))
                .doesNotThrowAnyException();
    }

    @Test
    void 입력한_로또넘버가_null이면_예외가나온다() {
        gameEngine = new GameEngine(new GameEngineValidator(),
                ((startInclusive, endInclusive, size) -> List.of(1, 2, 3, 4, 5, 6)));

        Assertions.assertThatCode(() -> gameEngine.createAnswerLotto(null))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 넘버는 null이 될수 없습니다.");
    }

    @ParameterizedTest
    @MethodSource("로또번호_숫자가_아닌경우")
    void 입력한_로또넘버가_숫자가_아니면_예외가나온다(String readLine, String exceptionValue) {
        gameEngine = new GameEngine(new GameEngineValidator(),
                ((startInclusive, endInclusive, size) -> List.of(1, 2, 3, 4, 5, 6)));

        Assertions.assertThatCode(() -> gameEngine.createAnswerLotto(readLine))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("%s는 숫자가 아닙니다.", exceptionValue));
    }

    @ParameterizedTest
    @MethodSource("여섯개의_사이즈_아닌_배열")
    void 입력한_로또넘버사이즈가_6가_아니면_예외가나온다(List<Integer> lottoNumbers) {
        String readLine = lottoNumbers.stream()
                .map(x -> Integer.toString(x))
                .collect(Collectors.joining(","));
        gameEngine = new GameEngine(new GameEngineValidator(),
                ((startInclusive, endInclusive, size) -> List.of(1, 2, 3, 4, 5, 6)));

        Assertions.assertThatCode(() -> gameEngine.createAnswerLotto(readLine))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("로또 넘버개수는 %s가 아니라 %s 여야합니다.", lottoNumbers.size(), 6));
    }

    @ParameterizedTest
    @MethodSource({"로또숫자가6개인데_중복이있는경우"})
    void 입력한_로또숫자가_중복이_있는경우면_예외가나온다(List<Integer> lottoNumbers) {
        String readLine = lottoNumbers.stream()
                .map(x -> Integer.toString(x))
                .collect(Collectors.joining(","));
        gameEngine = new GameEngine(new GameEngineValidator(),
                ((startInclusive, endInclusive, size) -> List.of(1, 2, 3, 4, 5, 6)));

        Assertions.assertThatCode(() -> gameEngine.createAnswerLotto(readLine))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또번호는 중복값을 가지고 있으면 안됩니다.");
    }

    @ParameterizedTest
    @MethodSource("로또숫자가_1부터_45사이가_아닌_경우")
    void 압력한_로또숫자가_1부터_45사이가_아니면_예외가나온다(List<Integer> lottoNumbers) {
        String readLine = lottoNumbers.stream()
                .map(x -> Integer.toString(x))
                .collect(Collectors.joining(","));
        gameEngine = new GameEngine(new GameEngineValidator(),
                ((startInclusive, endInclusive, size) -> List.of(1, 2, 3, 4, 5, 6)));

        Assertions.assertThatCode(() -> gameEngine.createAnswerLotto(readLine))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @ParameterizedTest
    @MethodSource("로또숫자가_중복되지않고_6개_1부터_45사이인_경우")
    void 입력한_로또숫자가_중복되지않고_6개_1부터_45사이면_예외가_나오지않는다(List<Integer> lottoNumbers) {
        String readLine = lottoNumbers.stream()
                .map(x -> Integer.toString(x))
                .collect(Collectors.joining(","));
        gameEngine = new GameEngine(new GameEngineValidator(),
                ((startInclusive, endInclusive, size) -> List.of(1, 2, 3, 4, 5, 6)));

        Assertions.assertThatCode(() -> gameEngine.createAnswerLotto(readLine))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @MethodSource("로또결과")
    void 예상되는_로또결과대로_나와야한다(List<Integer> lottoNumbers, String bonusLottoNumber, LottoScore expectLottoScore) {
        String answerLotto = lottoNumbers.stream()
                .map(x -> Integer.toString(x))
                .collect(Collectors.joining(","));
        gameEngine = new GameEngine(new GameEngineValidator(),
                ((startInclusive, endInclusive, size) -> List.of(1, 2, 3, 4, 5, 6)));
        gameEngine.createLottos("1000");
        gameEngine.createAnswerLotto(answerLotto);
        gameEngine.createAnswerBonusNumber(bonusLottoNumber);
        Assertions.assertThat(gameEngine.getCalculateScore().get(0)).isEqualTo(expectLottoScore);
    }

    @ParameterizedTest
    @MethodSource("로또예상수익률")
    void 예상되는_로또수익률이_나와야한다(List<Integer> lottoNumbers, String bonusLottoNumber, double expectEarning) {
        String answerLotto = lottoNumbers.stream()
                .map(x -> Integer.toString(x))
                .collect(Collectors.joining(","));
        gameEngine = new GameEngine(new GameEngineValidator(),
                ((startInclusive, endInclusive, size) -> List.of(1, 2, 3, 4, 5, 6)));
        gameEngine.createLottos("1000");
        gameEngine.createAnswerLotto(answerLotto);
        gameEngine.createAnswerBonusNumber(bonusLottoNumber);

        Assertions.assertThat(gameEngine.getEarningPercent()).isEqualTo(expectEarning);
    }
}