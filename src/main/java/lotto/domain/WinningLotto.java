package lotto.domain;

import java.util.*;

import static lotto.domain.Statistics.*;

public class WinningLotto {

    private final List<Integer> winningLotto = new ArrayList<>();
    private int bonusNumber;
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
            putWinningList(count);
        }
    }

    private void putWinningList(int count) {
        Statistics statistics = getStatistics(count, bonusNumber, winningLotto);
        if (!statistics.equals(NON)) {
            Integer plusCount = winningCount.get(statistics);
            plusCount++;
            winningCount.put(statistics, plusCount);
        }
    }

    private int compareLotto(List<Integer> lottoNumbers) {
        int count = 0;
        for (Integer winningNumber : winningLotto) {
            checkLotto(lottoNumbers, winningNumber, count);
        }
        return count;
    }

    private void checkLotto(List<Integer> lottoNumbers, Integer winningNumber, int count) {
        if (isExist(lottoNumbers, winningNumber)) {
            count++;
        }
    }

    private boolean isExist(List<Integer> lottoNumbers, Integer winningNumber) {
        return lottoNumbers.contains(winningNumber);
    }
}
