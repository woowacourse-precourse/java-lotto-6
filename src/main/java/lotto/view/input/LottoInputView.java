package lotto.view.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import lotto.view.input.dto.LottoBonusNumberDto;
import lotto.view.input.dto.LottoNumbersDto;
import lotto.view.input.dto.PurchasePriceDto;
import lotto.utils.Converter;

public class LottoInputView {

    public static final String NUMBERS_REGEX = ",";

    public PurchasePriceDto readPurchasePrice() {
        String input = readLine();
        long convertedInput = Converter.toLong(input);

        return new PurchasePriceDto(convertedInput);
    }

    public LottoNumbersDto readLottoNumber() {
        String input = readLine();

        return new LottoNumbersDto(
                parseLottoNumber(input)
        );
    }

    private static List<Integer> parseLottoNumber(String input) {
        return Arrays.stream(
                        input.split(NUMBERS_REGEX)
                )
                .map(Converter::toInt)
                .toList();
    }

    public LottoBonusNumberDto readLottoBonusNumber() {
        String input = readLine();
        return new LottoBonusNumberDto(Converter.toInt(input));
    }
}
