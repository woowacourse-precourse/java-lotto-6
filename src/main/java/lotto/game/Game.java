package lotto.game;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.lotto.Lotto;
import lotto.lotto.WinningLotto;
import lotto.winningmanager.WinningManager;

public class Game {
    private List<Lotto> purchasedLottos;
    private WinningLotto winningLotto;

    public void purchaseLotto(int price) {
        purchasedLottos = IntStream.range(0, price / 1000)
                .mapToObj(i -> publishLotto())
                .collect(Collectors.toList());
    }

    public String getPurchasedLottosInfo() {
        String lottosSizeInfo = purchasedLottos.size() + "개를 구매했습니다.\n";
        return lottosSizeInfo + purchasedLottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }

    public void setWinningLotto(List<Integer> numbers, int bonusNumber) {
        winningLotto = new WinningLotto(numbers, bonusNumber);
    }

    public String getLottoWinningResult() {
        List<Integer> lottoRanks = getLottoRanks();
        String lottoRankResult = IntStream.range(1, 6)
                .mapToObj(
                        i -> WinningManager.WINNING_MANAGER.getRankMessage(6 - i) + " - " + lottoRanks.get(6 - i) + "개")
                .collect(Collectors.joining("\n"));
        String earningRate = "총 수익률은 " + gerEarningRate(lottoRanks) + "%입니다.";

        return lottoRankResult + "\n" + earningRate;
    }

    private String gerEarningRate(List<Integer> lottoRanks) {
        double principal = purchasedLottos.size() * 1000;
        double revenue = WinningManager.WINNING_MANAGER.getTotalPrice(lottoRanks);
        double earningRate = revenue / principal * 100;
        return String.format("%.1f", earningRate);
    }

    private List<Integer> getLottoRanks() {
        List<Integer> lottoRanks = IntStream.range(0, 6)
                .mapToObj(i -> 0)
                .collect(Collectors.toList());
    
        purchasedLottos.forEach(lotto -> {
            int idx = WinningManager.WINNING_MANAGER.getWinningRank(winningLotto, lotto);
            lottoRanks.set(idx, lottoRanks.get(idx) + 1);
        });
    
        return lottoRanks;
    }

    private Lotto publishLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
