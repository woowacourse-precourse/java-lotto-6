package lotto.view.inputview;

import lotto.view.InputView;

import java.util.Map;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.view.ParameterConfig.BUY_LOTTO_DTO;

public final class LottoBuyInputView implements InputView {
    @Override
    public void read(Map<String, String> parameter) {
        parameter.put(BUY_LOTTO_DTO, readBuyPrice());
    }

    private String readBuyPrice() {
        String price = removeEmptySpace(readLine());
        InputValidator.validateIsNumber(price);
        return price;
    }

    private String removeEmptySpace(String input) {
        StringBuilder sb = new StringBuilder();
        input.chars()
                .filter(e -> e != ' ')
                .forEach(e -> sb.append((char) e));

        return sb.toString();
    }
}
