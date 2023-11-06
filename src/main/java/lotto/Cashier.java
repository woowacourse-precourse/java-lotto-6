package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Cashier {
    public LottoEnvelope sellLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        Integer money = Integer.valueOf(Console.readLine());

        LottoMachine lottoMachine = new LottoMachine();
        LottoEnvelope lottoEnvelope = lottoMachine.createLottoEnvelope(calculateLottoPrice(money));
        System.out.println(calculateLottoPrice(money) + "개를 구매했습니다.");

        return lottoEnvelope;
    }

    public Integer calculateLottoPrice(Integer money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
        return money / 1000;
    }

    public List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> result = Arrays.stream(Console.readLine().split(","))
                .map(Integer::valueOf)
                .toList();
        if (result.size() != 6) {
            throw new IllegalArgumentException();
        }
        return result;
    }

    public Integer getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.valueOf(Console.readLine());
    }
}
