package lotto.util.mapper;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.PurchaseAmount;
import lotto.view.dto.LottosResponseDto;
import lotto.view.dto.PurchaseAmountRequestDto;

public class DtoModelMapper {
    public static PurchaseAmount dtoToPurchaseAmount(PurchaseAmountRequestDto requestDto) {
        return PurchaseAmount.from(Integer.parseInt(requestDto.amount()));
    }

    public static LottosResponseDto LottosToDto(Lottos lottos) {
        return new LottosResponseDto(
                lottosToIntegers(lottos),
                lottos.getLottos()
                        .size()
        );
    }

    private static List<List<Integer>> lottosToIntegers(Lottos lottos) {
        return lottos.getLottos()
                .stream()
                .map(Lotto::getNumbers)
                .toList();
    }

}
