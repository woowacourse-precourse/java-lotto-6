package lotto.view.output.component;

import lotto.controller.dto.LottoDto;
import lotto.controller.dto.LottoDtos;

import java.util.List;

public class PrintAllLottoComponent {

    private final String FORMAT_LOTTO_AMOUNT = "개를 구매했습니다.";
    private final String LOTTO_NUMBERS_JOIN_DELIMITER = ", ";
    private final String LEFT_BRACKET = "[";
    private final String RIGHT_BRACKET = "]";



    public void printLottos(final LottoDtos lottoDtos) {
        System.out.println();
        System.out.println(lottoDtos.size() + FORMAT_LOTTO_AMOUNT);
        printAllLotto(lottoDtos.lottoDtos());
    }

    private void printAllLotto(final List<LottoDto> lottoDtos) {
        lottoDtos.stream()
                .map(this::parseLottoNumber)
                .forEach(this::printNumbers);
    }

    private String parseLottoNumber(final LottoDto lottoDto) {
        List<String> numbers = lottoDto.numbers()
                .stream()
                .map(Object::toString)
                .toList();
        return String.join(LOTTO_NUMBERS_JOIN_DELIMITER, numbers);
    }

    private void printNumbers(final String numbers) {
        System.out.println(LEFT_BRACKET + numbers + RIGHT_BRACKET);
    }
}
