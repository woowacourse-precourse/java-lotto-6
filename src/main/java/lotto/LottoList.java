package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoList {
    private final List<Lotto> lottoList;

    public LottoList(List<Lotto> lotto_list) {
        this.lottoList = lotto_list;
    }

    public void printLottoList() {
        for (int i = 0; i < lottoList.size(); i++) {
            List<Integer> lotto = lottoList.get(i).getNumbers();
            List<String> lottoNumbers = lotto.stream().map(x -> String.valueOf(x))
                            .collect(Collectors.toList());
            System.out.println("[" + String.join(", ", lottoNumbers) + "]");
        }
    }
}
