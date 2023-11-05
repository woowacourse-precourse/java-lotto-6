package lotto.view.inputview;

import lotto.view.InputView;

import java.util.Map;

import static camp.nextstep.edu.missionutils.Console.readLine;

public final class LottoBuyInputView implements InputView {
    @Override
    public void read(Map<String, String> parameter) {
        parameter.put("buyPrice", readBuyPrice());
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
