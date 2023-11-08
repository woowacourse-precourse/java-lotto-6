package lotto.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lotto.domain.Rank;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class LottoResultResponseDto {
    private  int[] results;
    private Rank rank;

    public static LottoResultResponseDto of(int[] results, Rank rank){
        return LottoResultResponseDto.builder()
                .results(results)
                .rank(rank)
                .build();
    }
}
