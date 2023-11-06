package lotto.util.mapper;

import lotto.model.PurchaseAmount;
import lotto.view.dto.PurchaseAmountRequestDto;

public class DtoModelMapper {
    public static PurchaseAmount dtoToPurchaseAmount(PurchaseAmountRequestDto requestDto) {
        return PurchaseAmount.from(Integer.parseInt(requestDto.amount()));
    }
}
