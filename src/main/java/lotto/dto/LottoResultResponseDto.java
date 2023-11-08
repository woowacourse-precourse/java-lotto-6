package lotto.dto;

import lombok.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class LottoResultResponseDto {
    private int threeMatchingPrizeCount;
    private int fourMatchingPrizeCount;
    private int fiveMatchingPrizeCount;
    private int fiveMatchingWithBonusBallPrizeCount;
    private int sixMatchingPrizeCount;
    private int oneOrTwoMatchingPrizeCount;

    public static LottoResultResponseDto of(int threeMatchingPrizeCount, int fourMatchingPrizeCount, int fiveMatchingPrizeCount, int fiveMatchingWithBonusBallPrizeCount, int sixMatchingPrizeCount, int oneOrTwoMatchingPrizeCount){
        return LottoResultResponseDto.builder()
                .threeMatchingPrizeCount(threeMatchingPrizeCount)
                .fourMatchingPrizeCount(fourMatchingPrizeCount)
                .fiveMatchingPrizeCount(fiveMatchingPrizeCount)
                .fiveMatchingWithBonusBallPrizeCount(fiveMatchingWithBonusBallPrizeCount)
                .sixMatchingPrizeCount(sixMatchingPrizeCount)
                .oneOrTwoMatchingPrizeCount(oneOrTwoMatchingPrizeCount)
                .build();
    }
}
