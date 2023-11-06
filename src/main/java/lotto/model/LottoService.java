package lotto.model;

import static lotto.util.Utils.splitByComma;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoService {
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final String LOTTO_SIZE_ERROR_MESSAGE = "[ERROR] 로또 번호는 6개만 가능합니다.";
    private static final String LOTTO_DUPLICATE_MESSAGE = "[ERROR] 로또 번호는 중복될 수 없습니다.";

    public List<Integer> validateLottoNumber(String input) { // 1,2,3,4,5,6
        List<Integer> lottoNumbers = makeStringToList(input);
        validateLottoSize(lottoNumbers);
        validateLottoDuplicate(lottoNumbers);
        return lottoNumbers;
    }

    private List<Integer> makeStringToList(String input) {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (String str : splitByComma(input)) {
            lottoNumbers.add(Integer.parseInt(str));
        }
        return lottoNumbers;
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size()!= LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR_MESSAGE);
        }
    }

    private void validateLottoDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<Integer>(numbers);
        if(set.size()!=LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(LOTTO_DUPLICATE_MESSAGE);
        }
    }
}
