package lotto.domain;

import java.util.*;

import static lotto.domain.Statistics.*;

public class WinningLotto {

    private final List<Integer> winningLotto = new ArrayList<>();
    private int bonusNumber;
    private int count = 0;
    private final Map<Statistics, Integer> winningCount = new HashMap<>(){{
           put(THREE, 0);
           put(FOUR, 0);
           put(FIVE, 0);
           put(FIVE_BONUS, 0);
           put(SIX, 0);
        }};

    public Map<Statistics, Integer> getWinningCount() {
        return winningCount;
    }

    public void setBonusNumber(int bonus) {
        this.bonusNumber = bonus;
    }

    public List<Integer> setWinningLotto(String number) {
        List<String> tempLotto = Arrays.asList(number.split(","));
        tempLotto.stream().forEach(tempNumber -> winningLotto.add(Integer.parseInt(tempNumber)));

        return winningLotto;
    }

    public void getCollectLottoNumber() {
        List<Lotto> lottos = LottoStore.getInstance().getLotto();
        for (Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            int count = compareLotto(lottoNumbers);
            putWinningList(count, lottoNumbers);
        }
    }

    private void putWinningList(int count, List<Integer> lottoNumbers) {
        Statistics statistics = getStatistics(count, bonusNumber, lottoNumbers);
        if (!statistics.equals(NON)) {
            Integer plusCount = winningCount.get(statistics);
            plusCount++;
            winningCount.put(statistics, plusCount);
        }
    }

    private int compareLotto(List<Integer> lottoNumbers) {
        count = 0;
        winningLotto.stream().forEach(
                winningNumber -> checkLotto(lottoNumbers, winningNumber));
        return count;
    }

    private void checkLotto(List<Integer> lottoNumbers, Integer winningNumber) {
        if (isExist(lottoNumbers, winningNumber)) {
            count++;
        }
    }

    private boolean isExist(List<Integer> lottoNumbers, Integer winningNumber) {
        return lottoNumbers.contains(winningNumber);
    }
}
