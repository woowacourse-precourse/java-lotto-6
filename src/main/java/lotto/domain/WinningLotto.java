package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class WinningLotto {

    private List<Integer> winningLotto = new ArrayList<>();
    private Integer bonusNumber;

    public void setBonusNumber(int bonus) {
        this.bonusNumber = bonus;
    }

    public List<Integer> setWinningLotto(String number) {
        List<String> tempLotto = Arrays.asList(number.split(","));
        tempLotto.stream().forEach(tempNumber -> winningLotto.add(Integer.parseInt(tempNumber)));

        return winningLotto;
    }

    public void getCollectLottoNumber(Map<Statistics, Integer> countForRate) {
        List<Lotto> lottos = LottoStore.getInstance().getLotto();
        for (Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            int count = compareLotto(lottoNumbers);
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
