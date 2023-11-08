package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchaseMoney, lottoCount, bonusNumber;
        List<List<Integer>> selectedNumbers;
        List<Integer> luckyNumbers;
        Integer[] lottoResults;

        purchaseMoney = UIView.getPurchaseMoney();
        lottoCount = purchaseMoney / Lotto.PRICE;

        selectedNumbers = new ArrayList<>();
        for(int i = 0; i < lottoCount; i++) {
            selectedNumbers.add(randomNumbers());
        }
        UIView.showSelectedNumbers(selectedNumbers);

        luckyNumbers = UIView.getLuckyNumbers();
        bonusNumber = UIView.getBonusNumber();

        lottoResults = new Integer[LottoResult.values().length];
        for(int i = 0; i < lottoResults.length; i++) {
            lottoResults[i] = 0;
        }

        for(List<Integer> numbers : selectedNumbers) {
            Lotto lotto = new Lotto(numbers);
            LottoResult result = lotto.getResult(luckyNumbers, bonusNumber);
            lottoResults[result.index()] += 1;
        }
        UIView.showLottoResults(List.of(lottoResults));

        int sum = 0;
        for(int i = 0; i < lottoResults.length; i++) {
            sum += lottoResults[i] * LottoResult.values()[i].prize();
        }
        UIView.showReturnRate((float) (sum / lottoCount));
    }

    private void init() {

    }

    private static List<Integer> randomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

}
