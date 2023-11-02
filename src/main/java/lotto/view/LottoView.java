package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;

public class LottoView {
    private static final String REQUEST_MONEY = "구입금액을 입력해 주세요.";
    private static final String REQUEST_LOTTO = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String ERROR_MESSAGE_MONEY = "[ERROR] 잘못된 숫자 입력, 1000원 단위의 숫자를 입력해주세요";

    public int requestMoney() {
        printRequestMoney();
        String input = Console.readLine();
        int tryNumber = validMoney(input);
        System.out.println();
        return tryNumber;
    }

    public void printLottos(List<Lotto> Lottos, int tryNumber) {
        printLOTTO(tryNumber);
        for (Lotto lotto : Lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public List<Integer> requestWinningLOTTO() {
        printRequestLOTTO();
        List<Integer> numbers = new ArrayList<>();
        String input = Console.readLine();
        for (String Splitinput : input.split(",")) {
            int number = validLottoNumber(Splitinput);
            numbers.add(number);
        }
        return numbers;
    }

    public int requestBonusNumber() {
        printBonusNumber();
        String input = Console.readLine();
        int number = validLottoNumber(input);
        return number;
    }

    private int validMoney(String input) {
        try {
            int money = Integer.parseInt(input);
            if (money % 1000 != 0) {
                throw new IllegalArgumentException(ERROR_MESSAGE_MONEY);
            }
            return money / 1000;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_MONEY);
        }
    }

    private int validLottoNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 숫자 입력");
        }
    }

    private void printBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER);
    }

    private void printRequestMoney() {
        System.out.println(REQUEST_MONEY);
    }

    private void printLOTTO(int tryNumber) {
        System.out.println(tryNumber + "개를 구매했습니다.");
    }

    private void printRequestLOTTO() {
        System.out.println(REQUEST_LOTTO);
    }
}
