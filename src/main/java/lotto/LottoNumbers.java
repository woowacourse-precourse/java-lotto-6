package lotto;

import java.util.List;

public class LottoNumbers {
    private final List<List<Integer>> lottoNumbers;
    public LottoNumbers(List<List<Integer>> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        lottoNumbers.forEach(lottoNumber -> stringBuilder.append(lottoNumber.toString()).append("\n"));
        return stringBuilder.toString();
    }
}
