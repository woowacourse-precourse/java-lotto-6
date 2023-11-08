package lotto.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ValidateAmountResponseDto {
    private int lottoCount;
    private boolean validate;
    public static ValidateAmountResponseDto of(int lottoCount,boolean validate){
        return ValidateAmountResponseDto.builder()
                .lottoCount(lottoCount)
                .validate(validate)
                .build();
    }
}
