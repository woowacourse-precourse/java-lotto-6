package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class LottoController {
    Validator validator = new Validator();
    LottoService lottoService = new LottoService();

    static final String INPUT_CASH_MESSAGE = "구입금액을 입력해 주세요.";
    static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    int getInput() {
        int parsedInput;
        System.out.println(INPUT_CASH_MESSAGE);
        String input = Console.readLine();

        while (true) {
            try {
                parsedInput = Integer.parseInt(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 숫자를 입력해주세요.");
            }
        }

        return parsedInput;
    }

    // 구입금액 입력받아서 정수형으로 변환 후 반환
    int getCash() {
        int input = getInput();
        int cash;

        if (input % 1000 != 0) {
            throw new IllegalArgumentException();
        }

        cash = input / 1000;

//        while (true) {
//            try {
//                cash = validator.validateCash(parsedInput);
//                break;
//            } catch (IllegalArgumentException e) {
//                System.out.println("[ERROR] 구입금액은 1000원 단위이여야 합니다.");
//            }
//        }

        return cash;
    }

    void purchaseLotto() {
        int purchaseAmount = getCash();

        System.out.printf("%d개를 구매했습니다.\n", purchaseAmount);
        List<Lotto> lottos = lottoService.getLottoBundle(purchaseAmount);

        for (int i = 0; i < lottos.size(); i++) {
            List<Integer> lotto = lottos.get(i).getNumbers();
            System.out.println(lotto.toString());
        }
    }


}
