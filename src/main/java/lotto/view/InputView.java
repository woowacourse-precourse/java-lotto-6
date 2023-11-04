package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Casher;
import lotto.utils.Code;
import lotto.utils.Message;

public class InputView {
    private final String INPUT_PRICE = "구입금액을 입력해 주세요.";

    public int getLottoCount() {
        System.out.println(INPUT_PRICE);
        String inputPrice = null;
        int lottoCount = 0;
        Casher casher = new Casher();
        while (true) {
            inputPrice = inputValue();
            try {
                validateNumber(inputPrice);
                lottoCount = casher.getLottoCount(Integer.parseInt(inputPrice));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(Code.Error.getCode() + " " + e.getMessage());
            }
        }
        return lottoCount;
    }

    private String inputValue() {
        return Console.readLine();
    }

    private void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.NOT_NUMBER.getMessage());
        }
    }
}
