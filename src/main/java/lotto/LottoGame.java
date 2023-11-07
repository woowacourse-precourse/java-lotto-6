package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class LottoGame {
    public void execute() {
        int purchaseMoney = purchase();

        int purchaseLottoCount = getPurchaseLottoCount(purchaseMoney);

        List<Lotto> purchaseLottos = getPurchaseLotto(purchaseLottoCount);

        Lotto winningLotto = getWinningLotto();
    }

    private int purchase() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            int purchaseMoney;
            try {
                purchaseMoney = Integer.parseInt(Console.readLine());
                validatePurchaseMoney(purchaseMoney);
                return purchaseMoney;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 구입금액은 1,000단위 숫자여야 합니다.");
            }
        }
    }

    private int getPurchaseLottoCount(int purchaseMoney) {
        int purchaseLottoCount = (purchaseMoney / 1000);
        System.out.println(purchaseLottoCount + "개를 구매했습니다.");
        return purchaseLottoCount;
    }

    private List<Lotto> getPurchaseLotto(int lottoCount) {
        List<Lotto> purchaseLottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(lottoNumbers);
            purchaseLottos.add(new Lotto(lottoNumbers));
        }

        for (Lotto lotto : purchaseLottos) {
            lotto.printNumber();
        }

        return purchaseLottos;
    }

    private Lotto getWinningLotto() {
        while (true) {
            System.out.println("당첨 번호를 입력해 주세요.");
            try {
                String[] inputArr = Console.readLine().split(",");
                List<Integer> winningNumbers = Arrays.stream(inputArr).mapToInt(value -> Integer.parseInt(value))
                        .sorted().boxed().collect(Collectors.toList());
                return new Lotto(winningNumbers);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 당첨 번호는 숫자여야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validatePurchaseMoney(int purchaseMoney) {
        if (purchaseMoney % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}