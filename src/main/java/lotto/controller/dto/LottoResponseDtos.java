package lotto.controller.dto;

import java.util.List;

public class LottoResponseDtos {

    private List<LottoResponseDto> dtos;

    public LottoResponseDtos(List<LottoResponseDto> lottoResponseDtos) {
        this.dtos = lottoResponseDtos;
    }

    public List<LottoResponseDto> toLottoResponseDto() {
        return dtos;
    }
}
