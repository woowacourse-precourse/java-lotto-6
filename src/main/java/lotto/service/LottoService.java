package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import lotto.domain.Lotto;

public class LottoService {

    private static final Integer LOTTO_PRICE = 1000;

    public static void run() {
        System.out.println("구입금액을 입력해 주세요.");
        int tryNum;
        while (true) {
            //TODO 메세지 출력 부분을 IllegalArgumentException 발생 후 처리로 변경
            try {
                tryNum = Integer.parseInt(Console.readLine());
                if (tryNum % LOTTO_PRICE == 0) {
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
        List<Integer> winningNum;
        while (true) {
            winningNum = new ArrayList<>();
            System.out.println("당첨 번호를 입력해 주세요.");

            //TODO 메세지 출력 부분을 IllegalArgumentException 발생 후 처리로 변경
            for (String s : Console.readLine().split(",")) {
                try {
                    //TODO 숫자 범위 1~45 체크
                    winningNum.add(Integer.parseInt(s));
                } catch (NumberFormatException e) {
                    System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                }
            }
            if (new HashSet<>(winningNum).size() != 6) {
                System.out.println("[ERROR] 로또 번호는 중복 되지 않는 숫자 6개여야 합니다.");
            }
            if (winningNum.size() == 6) {
                break;
            }
            System.out.println("[ERROR] 로또 번호는 숫자 6개여야 합니다.");
        }
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNum;
        while (true) {
            //TODO 메세지 출력 부분을 IllegalArgumentException 발생 후 처리로 변경
            try {
                bonusNum = Integer.parseInt(Console.readLine());
                if (!winningNum.contains(bonusNum)) {
                    break;
                }
                    System.out.println("[ERROR] 보너스 번호는 당첨 번호 6개 외의 숫자만 입력 가능합니다.");
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 보너스 번호는 1~45 사이의 숫자만 입력 가능합니다.");
            }
        }
    }
}
