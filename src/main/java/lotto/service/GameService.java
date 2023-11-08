package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.WinningResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GameService {
    private int purchaseAmount;
    private final List<Lotto> lottos = new ArrayList<>();
    private Lotto winningLotto;
    private int bonusNumber;
    private WinningResult winningResult;

    public void setPurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public List<Lotto> publishLottoNumbers() {
        int publishCount = this.purchaseAmount / 1000;
        for (int i = 0; i < publishCount; i++) {
            lottos.add(createLotto());
        }

        return lottos;
    }

    private Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> sortNumbers = new ArrayList<>(numbers);
        Collections.sort(sortNumbers);

        return new Lotto(sortNumbers);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Lotto createWinningLotto(List<Integer> winningNumber) {
        this.winningLotto = new Lotto(winningNumber);

        return winningLotto;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public WinningResult createWinningResult() {
        this.winningResult = new WinningResult();
        calculateMatchedWinningResult();

        return winningResult;
    }

    private void calculateMatchedWinningResult() {
        for (Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            List<Integer> winningNumbers = winningLotto.getNumbers();

            List<Integer> matchesCounts = getMatchesCounts(lottoNumbers, winningNumbers);
            matchWinningResult(matchesCounts);
        }
        winningResult.calculateTotalReturn(purchaseAmount);
    }

    private List<Integer> getMatchesCounts(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int matchesCount = 0;
        int matchesBonusCount = 0;
        for (Integer lottoNumber : lottoNumbers) {
            matchesCount += winningNumbers.stream()
                    .filter(winningNumber -> winningNumber.equals(lottoNumber))
                    .count();

            if (lottoNumber == bonusNumber) {
                matchesBonusCount++;
            }
        }

        return Arrays.asList(matchesCount, matchesBonusCount);
    }

    private void matchWinningResult(List<Integer> matchesCounts) {
        switch (matchesCounts.get(0)) {
            case 3 -> winningResult.addThreeMatches();
            case 4 -> winningResult.addFourMatches();
            case 5 -> {
                if (matchesCounts.get(1) == 0) {
                    winningResult.addFiveMatches();
                    break;
                }
                winningResult.addFiveAndBonusMatches();
            }
            case 6 -> winningResult.addSixMatches();
        }
    }
}
