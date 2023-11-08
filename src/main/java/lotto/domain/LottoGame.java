package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGame {
    public List<Lotto> lottoGames;
    public List<Integer> winningNum;
    public int bonusNum;

    public LottoGame(int lottoCount) {
        lottoGames = IntStream.range(0, lottoCount)
                .mapToObj(i -> {
                    LottoNumbers lottoNumbers = new LottoNumbers();
                    return new Lotto(lottoNumbers.createRandomNumbers());
                })
                .collect(Collectors.toList());
    }

    public void setWinningNum(List<Integer> winningNum) {
        this.winningNum = winningNum;
    }

    public void setBonusNum(int bonusNum) {
        this.bonusNum = bonusNum;
    }


    @Override
    public String toString() {
        return lottoGames.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }
}
