package lotto.model;

import static lotto.model.constant.LottoMessageConstant.END_BRACKET;
import static lotto.model.constant.LottoMessageConstant.NUMBER_DELIMITER;
import static lotto.model.constant.LottoMessageConstant.START_BRACKET;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.LottoValidator;

/**
 * - numbers 접근 제한자 변경불가 - 필드 추가 불가 - 패키지 변경 가능
 */
public class Lotto {

    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> lottoNumberInput) {
        isValidLottoNumbers(lottoNumberInput);
        numbers = new ArrayList<>();
        for (Integer integer : lottoNumberInput) {
            numbers.add(new LottoNumber(integer));
        }
        numbers.sort(Comparator.comparingInt(LottoNumber::number));
    }

    public void isValidLottoNumbers(List<Integer> lottoNumberInput) {
        LottoValidator validator = new LottoValidator();
        validator.validateLottoNumbers(lottoNumberInput);
    }

    public List<LottoNumber> getLottoNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(
                        NUMBER_DELIMITER.getConstant(), START_BRACKET.getConstant(), END_BRACKET.getConstant()));
    }
}
