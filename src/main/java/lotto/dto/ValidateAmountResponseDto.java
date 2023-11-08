package lotto.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ValidateAmountResponseDto {
    private int lottoCount;
    private boolean validate;
    public ValidateAmountResponseDto(int lottoCount, boolean validate) {
        this.lottoCount = lottoCount;
        this.validate = validate;
    }
    public static ValidateAmountResponseDto of(int lottoCount,boolean validate){
        return ValidateAmountResponseDto.builder()
                .lottoCount(lottoCount)
                .validate(validate)
                .build();
    }
}
