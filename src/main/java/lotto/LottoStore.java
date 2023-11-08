package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.ArrayList;

public class LottoStore {

    private List<Lotto> myLottos;
    private Lotto winningNumber;
    private int bonusNumber;

    public LottoStore() {
        myLottos = new ArrayList<Lotto>();
    }

    public void purchaseLotto() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine();
                validateMoney(input);
                issueLotto(Integer.parseInt(input));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void printLottos() {
        System.out.println(myLottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : myLottos) {
            lotto.printLotto();
        }
    }

    private void issueLotto(int input) {
        int number = input / Value.LOTTO_PRICE.get();
        for (int i = Value.ZERO.get(); i < number; ++i) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            myLottos.add(new Lotto(lottoNumbers));
        }
    }

    private void validateMoney(String number) {
        for (int i = Value.ZERO.get(); i < number.length(); ++i) {
            if (number.charAt(i) < '0' || number.charAt(i) > '9') {
                throw new IllegalArgumentException("[ERROR] 숫자로 된 금액을 입력해야 합니다.");
            }
        }
        if (Integer.parseInt(number) <= Value.ZERO.get()) {
            throw new IllegalArgumentException("[ERROR] 금액은 양수를 입력해야 합니다")
        }
        if (Integer.parseInt(number) % Value.LOTTO_PRICE.get() != Value.ZERO.get()) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 금액을 입력해야 합니다.");
        }
    }
}
