package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constants.Prize;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Lottos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.constants.LottoConstants.*;

public class LottoService {

    public Lottos createUserLottos(int amount) {
        Lottos lottos = new Lottos();
        for (int i = 0; i < amount; i++) {
            List<Integer> randomNumbers = generateRandomNumbers();
            sortNumbersByAsc(randomNumbers);
            Lotto lotto = new Lotto(randomNumbers);
            lottos.addLotto(lotto);
        }
        return lottos;
    }

    public Lotto createAnswerLotto(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public List<Integer> calculateWinningResult(Lottos lottos, Lotto answerLotto, BonusNumber bonusNumber) {
        int[] winningResult = new int[NUMBER_OF_LOTTO_NUMBERS + 2];
        for (Lotto lotto : lottos.getLottos()) {
            int sameNumber = lotto.calculateSameNumbers(answerLotto);
            winningResult[sameNumber]++;
            if (sameNumber == SECOND_PRIZE_SAME_NUMBERS && lotto.hasNumber(bonusNumber.getBonusNumber())) {
                winningResult[sameNumber]--;
                winningResult[NUMBER_OF_LOTTO_NUMBERS + 1]++;
            }
        }
        return Arrays.stream(winningResult)
                .boxed().collect(Collectors.toList());
    }

    public List<String> calculateEachWinningTimes(List<Integer> winningResult) {
        List<String> totalWinningTimes = new ArrayList<>();
        for (int i = MINIMUM_WINNING_SAME_NUMBERS; i < winningResult.size(); i++) {
            totalWinningTimes.add(String.valueOf(winningResult.get(i)));
        }
        return totalWinningTimes;
    }

    public int calculateTotalWinningAmount(List<Integer> winningResult) {
        int totalWinningAmount = 0;
        for (Prize value : Prize.values()) {
            int prizeCount = winningResult.get(value.getNumber());
            totalWinningAmount += (value.getWinningAmount() * prizeCount);
        }
        return totalWinningAmount;
    }

    public String calculateTotalProfitRate(int lottoAmount, int totalWinningAMount) {
        return String.format("%.1f",((double) totalWinningAMount / (double) lottoAmount) * 100);
    }

    public List<Integer> sortNumbersByAsc(List<Integer> integerList) {
        List<Integer> temp = new ArrayList<>(integerList);
        Collections.sort(temp);
        return List.copyOf(temp);
    }

    private List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER, NUMBER_OF_LOTTO_NUMBERS);
    }
}
