package lotto.service;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.domain.AnswerLotto;

public class CreateLottoServiceTest {

	private final CreateLottoService service = new CreateLottoService();

	@DisplayName("당첨로또를 생성한다.")
	@MethodSource("createCreateAnswerLottoMethodParameter")
	@ParameterizedTest
	void checkCreateAnswerLottoMethod(String inputValue, int bonusNumber) {
		AnswerLotto answerLotto = service.createAnswerLotto(inputValue, bonusNumber);
	}

	static Stream<Arguments> createCreateAnswerLottoMethodParameter() {
		return Stream.of(Arguments.of("1,2,3,4,5,6", 7));
	}
}
