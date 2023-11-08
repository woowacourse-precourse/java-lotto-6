package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.ArrayList;

public class LottoStore {

    private final int lottoPrice = 1000;

    private List<Lotto> myLottos;
    private Lotto winningNumber;
    private int bonusNumber;

    public LottoStore() {
        myLottos = new ArrayList<Lotto>();
    }
    public void receiveMoney() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine();
                validateMoney(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateMoney(String number) {
        for (int i = 0; i < number.length(); ++i) {
            if (number.charAt(i) < '0' || number.charAt(i) > '9') {
                throw new IllegalArgumentException("[ERROR] 숫자로 된 금액을 입력해야 합니다.");
            }
        }
        if (Integer.parseInt(number) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 금액을 입력해야 합니다.");
        }
    }
}
