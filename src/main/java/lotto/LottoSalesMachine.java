package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoSalesMachine {
    private final String inputMoneyMessage = "구입금액을 입력해 주세요.";
    public static final int lottoPrice = 1000;

    public List<Lotto> buyLotto() {
        System.out.println(inputMoneyMessage);
        int money = inputMoney();
        validateMoney(money);
        int lottoCount = money / lottoPrice;
        return issueLotto(lottoCount);
    }

    private int inputMoney() {
        String userInput = Console.readLine();
        try {
            return Integer.parseInt(userInput);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
        }
    }

    private void validateMoney(int money) {
        if (money < lottoPrice) {
            throw new IllegalArgumentException("[ERROR] " + lottoPrice + "원 이상의 금액을 입력해주세요.");
        }
        if (money % lottoPrice != 0) {
            throw new IllegalArgumentException("[ERROR] " + lottoPrice + "원 단위로 입력해주세요.");
        }
    }

    private List<Lotto> issueLotto(int lottoCount) {
        List<Lotto> lottoes = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers
                    = Randoms.pickUniqueNumbersInRange(LottoValidator.LOTTO_MIN_NUMBER,
                    LottoValidator.LOTTO_MAX_NUMBER, LottoValidator.LOTTO_SIZE);
            Lotto lotto = new Lotto(numbers);
            lottoes.add(lotto);
        }
        return lottoes;
    }

}
