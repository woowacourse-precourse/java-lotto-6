package lotto.gameUtil;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.ConstantValue;
import lotto.domain.Lotto;
import lotto.domain.Enum.Rank;
import lotto.view.OutputView;

import java.util.*;

public class GameLogic {
    private OutputView outputView;
    private Map<Rank, Integer> ranks = new HashMap<>();

    public GameLogic() {
        outputView = new OutputView();
        initRank();
    }

    private void initRank() {
        ranks.put(Rank.FIRST, ConstantValue.zero);
        ranks.put(Rank.SECOND, ConstantValue.zero);
        ranks.put(Rank.THIRD, ConstantValue.zero);
        ranks.put(Rank.FORTH, ConstantValue.zero);
        ranks.put(Rank.FIFTH, ConstantValue.zero);
    }

    public List<Lotto> lottoNumber(int amount) {
        int count = amount / ConstantValue.thousand;
        outputView.countMessage(count);
        List<Lotto> lottoes = new ArrayList<>();

        for (int i = ConstantValue.zero; i < count; i++) {
            List<Integer> lottoNumbers = makingLottoNumbers();
            Lotto lotto = new Lotto(lottoNumbers);
            lottoes.add(lotto);
            outputView.lottoNumberMessage(lotto.toString());
        }
        return lottoes;
    }

    public List<Integer> makingLottoNumbers() {
        List<Integer> tmpLottoNumbers = Randoms.pickUniqueNumbersInRange(ConstantValue.one, ConstantValue.maxNumber, ConstantValue.six);
        List<Integer> lottoNumbers = new ArrayList<>(tmpLottoNumbers);
        return lottoNumbers;
    }

    public Lotto winningNumber(String[] winningNumber) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String str : winningNumber) {
            winningNumbers.add(Integer.parseInt(str));
        }
        Lotto lotto = new Lotto(winningNumbers);
        return lotto;
    }

    public String[] splitNumber(String number) {
        String[] splitNumber = number.split(",");
        return splitNumber;
    }

    public int matchCount(Lotto buyingLotto, Lotto winningLotto, int bonus) {
        int[] buyingLottoNumber = buyingLotto.toIntegerArr();
        Set<Integer> winningLottoNumber = winningLotto.toSet();

        int count = ConstantValue.zero;
        for (int i = ConstantValue.zero; i < ConstantValue.six; i++) {
            if (winningLottoNumber.contains(buyingLottoNumber[i]) || buyingLottoNumber[i] == bonus) {
                count++;
            }
        }
        return count;
    }

    public boolean matchBonus(Lotto buyingLotto, int bonus) {
        Set<Integer> buyingLottoNumber = buyingLotto.toSet();
        if (buyingLottoNumber.contains(bonus)) {
            return true;
        }
        return false;
    }

    public void matchLotto(int count, boolean isSecond) {
        if (count == ConstantValue.six && !isSecond) {
            firstRank();
        }
        if (count == ConstantValue.six && isSecond) {
            secondRank();
        }
        if (count == ConstantValue.five) {
            thirdRank();
        }
        if (count == ConstantValue.four) {
            forthRank();
        }
        if (count == ConstantValue.three) {
            fifthRank();
        }
    }

    public void firstRank() {
        ranks.put(Rank.FIRST, ranks.get(Rank.FIRST) + ConstantValue.one);
    }

    public void secondRank() {
        ranks.put(Rank.SECOND, ranks.get(Rank.SECOND) + ConstantValue.one);
    }

    public void thirdRank() {
        ranks.put(Rank.THIRD, ranks.get(Rank.THIRD) + ConstantValue.one);
    }

    public void forthRank() {
        ranks.put(Rank.FORTH, ranks.get(Rank.FORTH) + ConstantValue.one);
    }

    public void fifthRank() {
        ranks.put(Rank.FIFTH, ranks.get(Rank.FIFTH) + ConstantValue.one);
    }

    public Map<Rank, Integer> getRanks() {
        return ranks;
    }

    public void lottoResult(Map<Rank, Integer> ranks, int amount) {
        Double prize = 0D;
        prize += ranks.get(Rank.FIRST) * Rank.FIRST.getAmount();
        prize += ranks.get(Rank.SECOND) * Rank.SECOND.getAmount();
        prize += ranks.get(Rank.THIRD) * Rank.THIRD.getAmount();
        prize += ranks.get(Rank.FORTH) * Rank.FORTH.getAmount();
        prize += ranks.get(Rank.FIFTH) * Rank.FIFTH.getAmount();

        outputView.matchingMessage(ranks, (prize / amount * ConstantValue.hundred));
    }
}
