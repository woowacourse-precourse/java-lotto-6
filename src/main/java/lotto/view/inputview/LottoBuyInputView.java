package lotto.view.inputview;

import lotto.dto.BuyLottoDto;
import lotto.dto.InputDto;
import lotto.view.InputView;

import java.util.Map;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.view.ParameterConfig.BUY_PRICE;

public final class LottoBuyInputView implements InputView {
    @Override
    public void read(Map<String, InputDto> inputs) {
        BuyLottoDto.Input dto = (BuyLottoDto.Input) inputs.get(BUY_PRICE);
        inputBuyPrice(dto);
    }

    private void inputBuyPrice(BuyLottoDto.Input dto) {
        String price = removeEmptySpace(readLine());
        InputValidator.validateIsNumber(price);
        dto.setBuyPrice(Long.parseLong(price));
    }

    private String removeEmptySpace(String input) {
        StringBuilder sb = new StringBuilder();
        input.chars()
                .filter(e -> e != ' ')
                .forEach(e -> sb.append((char) e));

        return sb.toString();
    }
}
