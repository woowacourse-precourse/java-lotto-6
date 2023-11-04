package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class LottoService {

    private static final Integer LOTTO_PRICE = 1000;

    public static void run() {
        System.out.println("구입금액을 입력해 주세요.");
        int tryNum;
        while (true) {
            try {
                tryNum = Integer.parseInt(Console.readLine());
                if (tryNum%LOTTO_PRICE==0){
                    break;
                }
                System.out.println("[ERROR] 로또 구입 금액은 1000원의 양의 정수배만 입력 가능합니다.");
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 로또 구입 금액은 1000원의 양의 정수배만 입력 가능합니다.");
            }
        }
        int lottoCount = tryNum / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> randomNum = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(randomNum));
            System.out.println(randomNum);
        }
        if (lottos.size() != lottoCount) {
            throw new IllegalStateException();
        }
        while (true) {
            System.out.println("당첨 번호를 입력해 주세요.");
            List<Integer> winningNum = new ArrayList<>();

            for (String s : Console.readLine().split(",")) {
                try {
                    winningNum.add(Integer.parseInt(s));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException();
                }
            }
            if (winningNum.size() == 6) {
                break;
            }
        }
    }
}
