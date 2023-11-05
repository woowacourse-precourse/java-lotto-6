package lotto.model;

import lotto.exception.Validation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto(String lottoNumbers) {
        this.lottoNumbers = parseLottoNumbers(lottoNumbers);
    }

    public Lotto(List<LottoNumber> lottoNumbers) {
        Validation.validateLottoSize(lottoNumbers);
        Validation.validateLottoDuplication(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static int getLottoSize() {
        return LOTTO_SIZE;
    }

    public List<LottoNumber> getNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public static List<LottoNumber> parseLottoNumbers(String lottoNumbers) {

        return Arrays.stream(lottoNumbers.split(","))
                .map(String::trim)
                .map(number -> new LottoNumber(Integer.parseInt(number)))
                .collect(Collectors.toList());
    }
}
