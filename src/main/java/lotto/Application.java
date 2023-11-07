package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {

    public static final int LOTTO_PRICE_UNIT = 1000;
    public static final int LOTTO_NUMBER_COUNT = 6;

    public static void main(String[] args) {
        PurchasePrice purchasePrice = InputView.inputPurchasePrice();
        int purchaseCount = purchasePrice.getPurchaseCount();
        OutputView.printPurchaseCount(purchaseCount);

        List<Lotto> lottos = getLottos(purchaseCount);
        OutputView.printLottos(lottos);

        WinningNumber winningNumber = InputView.inputWinningNumber();
        Map<Rank, Integer> scoreTable = new HashMap<>();
        int earnMoney = calculateScore(lottos, winningNumber, scoreTable);
        OutputView.printLottoResult(purchasePrice, earnMoney, scoreTable);
    }

    private static int calculateScore(List<Lotto> lottos, WinningNumber winningNumber, Map<Rank, Integer> scoreTable) {
        int earnMoney = 0;
        for (Lotto lotto : lottos) {
            Rank rank = calculate(lotto, winningNumber);
            int currentCount = scoreTable.getOrDefault(rank, 0);
            scoreTable.put(rank, currentCount + 1);
            earnMoney += rank.getPrice();
        }
        return earnMoney;
    }

    private static Rank calculate(Lotto lotto, WinningNumber winningNumber) {
        List<Integer> lottos = lotto.getNumbersValue();
        List<Integer> winningNumbers = winningNumber.getNumbersValue();
        int bonusNumber = winningNumber.getBonusNumberValue();

        int sameCount = 0;
        for (Integer number : lottos) {
            if (winningNumbers.contains(number)) {
                sameCount++;
            }
        }
        boolean hasBonus = lottos.contains(bonusNumber);
        return Rank.find(sameCount, hasBonus);
    }

    private static List<Lotto> getLottos(int purchaseCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            Lotto lotto = getRandomLotto();
            lottos.add(lotto);
        }
        return lottos;
    }

    private static Lotto getRandomLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int randomNumber : randomNumbers) {
            LottoNumber lottoNumber = new LottoNumber(randomNumber);
            lottoNumbers.add(lottoNumber);
        }
        return new Lotto(lottoNumbers);
    }
}