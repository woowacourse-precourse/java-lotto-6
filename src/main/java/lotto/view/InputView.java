package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    private final InputParser inputParser;
    private static final String INPUT_LOTTO_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_LOTTO_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_WINNING_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public InputView() {
        this.inputParser = new InputParser();
    }

    public Integer getLottoPurchasePrice() {
        System.out.println(INPUT_LOTTO_PURCHASE_PRICE);
        try {
            return inputParser.parseInt(Console.readLine());
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public List<Integer> getWinningLottoNumbers() {
        System.out.println(INPUT_WINNING_LOTTO_NUMBERS);
        try {
            return inputParser.parsingNumbers(Console.readLine());
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public Integer getWinningBonusNumber() {
        System.out.println(INPUT_WINNING_BONUS_NUMBER);
        try {
            return inputParser.parseInt(Console.readLine());
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
}
