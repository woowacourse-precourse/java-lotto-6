package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Casher;

public class InputView {
    private final String INPUT_PRICE = "구입금액을 입력해 주세요.";
    private final String NOT_NUMBER = "유효한 숫자 형식이 아닙니다. 다시 입력해 주세요.";
    private final String ERROR_CODE = "[ERROR]";

    public void inputLottoPrice() {
        System.out.println(INPUT_PRICE);
        String inputPrice = null;
        int lottoCount = 0;
        Casher casher = new Casher();
        // 각종 검증 후 예외 메시지 발생
        while (true) {
            inputPrice = inputValue();
            try {
                validateNumber(inputPrice);
                lottoCount = casher.getLottoCount(Integer.parseInt(inputPrice));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_CODE + " " + e.getMessage());
            }
        }
        // 로또 생성기에게 lottoCount를 전달해서 로또 생성 요청
    }

    private String inputValue() {
        return Console.readLine();
    }

    private void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER);
        }
    }
}
