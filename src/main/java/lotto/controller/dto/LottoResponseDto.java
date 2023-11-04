package lotto.controller.dto;

import java.util.List;

public class LottoResponseDto {

    private final List<Integer> lottoNumber;

    public LottoResponseDto(List<Integer> numbers) {
        this.lottoNumber = numbers;
    }

    public List<Integer> getLottoNumber(){
        return lottoNumber;
    }
}
