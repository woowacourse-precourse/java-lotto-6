package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Casher;

public class InputView {
    private final String INPUT_PRICE = "구입금액을 입력해 주세요.";

    public void inputLottoPrice() {
        System.out.println(INPUT_PRICE);
        String inputPrice = null;
        // 숫자 값인지 검증 후 예외 메시지 발생
        while (true) {
            inputPrice = inputValue();
            try {
                validateNumber(inputPrice);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 유효한 숫자 형식이 아닙니다. 다시 입력해 주세요.");
            }
        }
        // Casher에게 값을 전달해서 나누어 떨어지는지 확인
        Casher casher = new Casher();
        int lottoCount = 0;
        while (true) {
            try {
                lottoCount = casher.getLottoCount(Integer.parseInt(inputPrice));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
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
            throw new IllegalArgumentException();
        }
    }
}
