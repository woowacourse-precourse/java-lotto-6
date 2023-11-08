package lotto.dto;

import java.util.List;

public class LottoDto {
    private List<Integer> lottoNumber;

    public LottoDto(List<Integer> numbers) {
        this.lottoNumber = numbers;
    }

    public static LottoDto toDto(List<Integer> numbers) {
        return new LottoDto(numbers);
    }

    public List<Integer> getLottoNumber() {
        return lottoNumber;
    }
}
