package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoManager {
    private final int pricePerLotto = 1000;
    private final int lottoNumberCount = 6;
    private final int minLottoNumber = 1;
    private final int maxLottoNumber = 45;

    public void launch() {

        int purchaseAmount = inputPurchaseAmount();
        List<Lotto> lottos = purchaseLottos(purchaseAmount);
        printLottos(lottos);
        // 로또 게임의 나머지 진행 로직을 추가
        // 에러 발생시 재시도 로직 추가

    }

    private int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    private boolean isValidPurchaseAmount(int purchaseAmount) {
        return purchaseAmount % pricePerLotto == 0;
    }

    private void verifyValidPurchaseAmount(int purchaseAmount) {
        if (!isValidPurchaseAmount(purchaseAmount)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
    }

    public List<Lotto> purchaseLottos(int purchaseAmount) {
        verifyValidPurchaseAmount(purchaseAmount);
        int numberOfLottos = purchaseAmount / pricePerLotto;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < numberOfLottos; i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    private Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(minLottoNumber, maxLottoNumber, lottoNumberCount);
        return new Lotto(numbers);
    }

    public void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            List<Integer> sortedNumbers = lotto.getNumbers().stream()
                    .sorted()
                    .collect(Collectors.toList());
            System.out.println(sortedNumbers);
        }
    }

}
