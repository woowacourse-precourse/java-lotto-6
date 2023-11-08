package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private final static int LOTTO_NUMBER_COUNT = 6;
    private final static int LOTTO_MIN_NUMBER = 1;
    private final static int LOTTO_MAX_NUMBER = 45;

    public List<Lotto> buyLottos() {
        int lottoCount = getLottoCount();
        return generateLottos(lottoCount);
    }

    private int getLottoCount() {
        int amount = getInputAmount();
        validateAmount(amount);
        return amount / 1000;
    }

    private int getInputAmount() {
        System.out.println("구입금액을 입력해 주세요: ");
        String input = Console.readLine();
        while (true) {
            try {
                validateInput(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 잘못된 입력입니다. 1000원 단위로 입력해주세요.");
                System.out.println("구입금액을 입력해 주세요: ");
                input = Console.readLine();
            }
        }
        return Integer.parseInt(input);
    }

    public void validateInput(String input) {
        if (isNotNumeric(input) || !isMultipleOf1000(input)) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }


    private void validateAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    private boolean isNotNumeric(String str) {
        try {
            Integer.parseInt(str);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private boolean isMultipleOf1000(String str) {
        int amount = Integer.parseInt(str);
        return amount % 1000 == 0;
    }

    private List<Lotto> generateLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = generateLottoNumbers();
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBER_COUNT);
    }
}
