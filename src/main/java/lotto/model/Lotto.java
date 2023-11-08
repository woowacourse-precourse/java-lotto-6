package lotto.model;

import java.util.List;
import lotto.util.LottoValidator;

/**
 * - numbers 접근 제한자 변경불가 - 필드 추가 불가 - 패키지 변경 가능
 */
public class Lotto {

    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> lottoNumberInput) {
        isValidLottoNumbers(lottoNumberInput);
        this.numbers = lottoNumberInput.stream().map(LottoNumber::new).toList();
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
        String str = "";
        for (LottoNumber number : numbers) {
            str += number + " ";
        }
        return str;
    }
}
