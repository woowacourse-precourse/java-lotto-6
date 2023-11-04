package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoStore {

    private static LottoStore lottoStore = new LottoStore();

    public static LottoStore getInstance() {
        return lottoStore;
    }

    private List<Lotto> lottos = new ArrayList<>();
    private List<Integer> winningLotto = new ArrayList<>();
    private Integer bonusNumber;

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Integer> setWinningLotto(String number) {
        List<String> tempLotto = Arrays.asList(number.split(","));
        tempLotto.stream().forEach(tempNumber -> winningLotto.add(Integer.parseInt(tempNumber)));

        return winningLotto;
    }

    public void setBonusNumber(int bonus) {
        this.bonusNumber = bonus;
    }

    public List<Lotto> getLotto() {
        return lottos;
    }

    public String getLottoHistory() {
        List<Lotto> lottos = lottoStore.getLotto();
        StringBuilder sb = new StringBuilder();

        for (Lotto lotto : lottos) {
            sb.append(lotto.getNumbers().toString()+"\n");
        }

        return String.valueOf(sb);
    }
}
