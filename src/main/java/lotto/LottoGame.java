package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGame {
    List<Lotto> lottoGame;
    List<Integer> winningNum;
    int bonusNum;

    LottoGame(int lottoCount) {
        lottoGame = IntStream.range(0, lottoCount)
                .mapToObj(i -> new Lotto(createRandoms()))
                .collect(Collectors.toList());
    }

    public void setWinningNum(List<Integer> winningNum) {
        this.winningNum = winningNum;
    }

    public void setBonusNum(int bonusNum) {
        this.bonusNum = bonusNum;
    }

    public List<Integer> createRandoms() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Integer> resultLotto() {
        return lottoGame.stream()
                .map(lotto -> compareLotto(lottoNumMaker(lotto.toString())))
                .collect(Collectors.toList());
    }

    public int compareLotto(List<Integer> lotto) {
        return (int)lotto.stream()
                .filter(winningNum::contains)
                .count();
    }

    public List<Integer> lottoNumMaker(String lottoNum) {
        String[] strArray = lottoNum.substring(1, lottoNum.length() - 1).split(", ");
        List<Integer> list = new ArrayList<>();
        for (String s : strArray) {
            list.add(Integer.parseInt(s));
        }
        return list;
    }


    @Override
    public String toString() {
        return lottoGame.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }
}
