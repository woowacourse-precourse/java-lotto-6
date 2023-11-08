package lotto.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LottoResultAndProfitResponseDto {
    private LottoResultResponseDto lottoResultResponseDto;
    private double totalProfitRate;

    public static LottoResultAndProfitResponseDto of(LottoResultResponseDto lottoResultResponseDto, double totalProfitRate){
        return LottoResultAndProfitResponseDto.builder()
                .lottoResultResponseDto(lottoResultResponseDto)
                .totalProfitRate(totalProfitRate)
                .build();
    }
}
