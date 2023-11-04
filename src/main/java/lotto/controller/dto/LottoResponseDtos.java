package lotto.controller.dto;

import java.util.List;

public class LottoResponseDtos {

    private List<LottoResponseDto> lottoResponseDtos;

    public LottoResponseDtos(List<LottoResponseDto> lottoResponseDtos) {
        this.lottoResponseDtos = lottoResponseDtos;
    }

    public List<LottoResponseDto> toLottoResponseDto(){
        return lottoResponseDtos;
    }
}
