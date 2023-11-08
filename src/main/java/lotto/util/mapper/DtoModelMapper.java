package lotto.util.mapper;

import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.Lottos;
import lotto.model.MainNumbers;
import lotto.model.PurchaseAmount;
import lotto.util.converter.ListConverter;
import lotto.view.dto.BonusNumberRequestDto;
import lotto.view.dto.LottoResultResponseDto;
import lotto.view.dto.LottosResponseDto;
import lotto.view.dto.MainNumbersRequestDto;
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

    public static MainNumbers dtoToMainNumbers(MainNumbersRequestDto requestDto) {
        return MainNumbers.from(ListConverter.splitStringByComma(requestDto.mainNumbers()));
    }

    public static BonusNumber dtoToBonusNumbers(BonusNumberRequestDto requestDto) {
        return BonusNumber.from(requestDto.bonusNumber());
    }

    public static LottoResultResponseDto LottoResultToDto(LottoResult lottoResult) {
        return new LottoResultResponseDto(lottoResult.getMatchResult(), lottoResult.getRateOfReturn());
    }
}
