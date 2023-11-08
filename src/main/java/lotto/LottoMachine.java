package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import utils.InputValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {
    private final List<Lotto> lottos = new ArrayList<>();

    public void start() {
        int purchaseAmount = 0;
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                purchaseAmount = InputValidator.validateAndParsePurchaseAmount();
                if (purchaseAmount > 0) {
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        int lottoCount = purchaseAmount / 1000;
        System.out.println(lottoCount + "개를 구매했습니다.");
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
                    .stream()
                    .sorted()
                    .collect(Collectors.toList());
            lottos.add(new Lotto(lottoNumbers));
            System.out.println(lottos.get(i).getNumbers());
        }

        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = InputValidator.validateAndParseWinningNumbers();

        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = InputValidator.validateAndParseBonusNumber(winningNumbers);

        LottoResult lottoResult = new LottoResult(winningNumbers, bonusNumber);
        lottos.forEach(lottoResult::addLottoResult);

        lottoResult.printStatistics(lottoCount);
    }
}
