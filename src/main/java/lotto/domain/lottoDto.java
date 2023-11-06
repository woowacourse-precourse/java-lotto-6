package lotto.domain;

import java.util.List;

public class lottoDto {

    private List<Integer> lottoNumbers;

    public lottoDto(List<Integer> numbers) {
        this.lottoNumbers = numbers;
    }

    public List<Integer> getNumbers() {
        return lottoNumbers;
    }
}
