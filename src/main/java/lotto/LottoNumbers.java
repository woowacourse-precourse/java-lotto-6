package lotto;

import java.util.List;

public class LottoNumbers {
    private final List<LottoNumber> lottoNumbers;
    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        lottoNumbers.forEach(lottoNumber -> stringBuilder.append(lottoNumber.toString()).append("\n"));
        return stringBuilder.toString();
    }
}
