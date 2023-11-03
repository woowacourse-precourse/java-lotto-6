package lotto.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int inputMoneyForLottos() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputLottoPrice = Console.readLine();
        validate(inputLottoPrice);
        return Integer.parseInt(inputLottoPrice);
    }

    private static void validate(String inputLottoPrice) {
        try {
            int lottoPrice = toInt(inputLottoPrice);
            if (isNotDivideWithOneThousands(lottoPrice) || isNotCorrectMoneyRange(lottoPrice)) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 구입 금액은 1000원 단위로 1000원~20억원 사이로 입력해주세요.");
            inputMoneyForLottos();
        }
    }

    private static int toInt(String lottoPrice) {
        return Integer.parseInt(lottoPrice);
    }

    private static boolean isNotDivideWithOneThousands(int lottoPrice) {
        return lottoPrice % 1000 != 0;
    }

    private static boolean isNotCorrectMoneyRange(int lottoPrice) {
        return lottoPrice <= 0 || lottoPrice > 2000000000;
    }
}
