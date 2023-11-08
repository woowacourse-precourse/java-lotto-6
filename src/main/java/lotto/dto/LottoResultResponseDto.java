package lotto.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LottoResultResponseDto {
    private int threeMatchingPrizeCount;
    private int fourMatchingPrizeCount;
    private int fiveMatchingPrizeCount;
    private int fiveMatchingWithBonusBallPrizeCount;
    private int sixMatchingPrizeCount;


    public static LottoResultResponseDto of(int threeMatchingPrizeCount, int fourMatchingPrizeCount, int fiveMatchingPrizeCount, int fiveMatchingWithBonusBallPrizeCount, int sixMatchingPrizeCount){
        return LottoResultResponseDto.builder()
                .threeMatchingPrizeCount(threeMatchingPrizeCount)
                .fourMatchingPrizeCount(fourMatchingPrizeCount)
                .fiveMatchingPrizeCount(fiveMatchingPrizeCount)
                .fiveMatchingWithBonusBallPrizeCount(fiveMatchingWithBonusBallPrizeCount)
                .sixMatchingPrizeCount(sixMatchingPrizeCount)
                .build();
    }
    public static LottoResultResponseDto plus(int threeMatchingPrizeCount, int fourMatchingPrizeCount, int fiveMatchingPrizeCount, int fiveMatchingWithBonusBallPrizeCount, int sixMatchingPrizeCount,LottoResultResponseDto lottoResultResponseDto){
        return LottoResultResponseDto.builder()
                .threeMatchingPrizeCount(threeMatchingPrizeCount+lottoResultResponseDto.getThreeMatchingPrizeCount())
                .fourMatchingPrizeCount(fourMatchingPrizeCount+lottoResultResponseDto.getFourMatchingPrizeCount())
                .fiveMatchingPrizeCount(fiveMatchingPrizeCount+lottoResultResponseDto.getFiveMatchingPrizeCount())
                .fiveMatchingWithBonusBallPrizeCount(fiveMatchingWithBonusBallPrizeCount+lottoResultResponseDto.getFiveMatchingWithBonusBallPrizeCount())
                .sixMatchingPrizeCount(sixMatchingPrizeCount+lottoResultResponseDto.getSixMatchingPrizeCount())
                .build();
    }
}
