package lotto.dto;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ValidateAmountDto {
    private boolean validate;
    private String amountStr;

    public static ValidateAmountDto of(boolean validate, String amountStr){
        return ValidateAmountDto.builder()
                .validate(validate)
                .amountStr(amountStr)
                .build();
    }
}
