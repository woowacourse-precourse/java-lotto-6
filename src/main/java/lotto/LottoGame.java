package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoGame {
    private final int lottoStartNumber = 1;
    private final int lottoEndNumber = 45;
    private final int lottoLength = 6;
    private Lotto winningLotto;
    private int bonusNumber;
    private Map<Integer, LottoPrize> numberToPrize;

    public LottoGame() {
        numberToPrize = new HashMap<>();
        numberToPrize.put(7, LottoPrize.SECOND);
        numberToPrize.put(6, LottoPrize.FIRST);
        numberToPrize.put(5, LottoPrize.THIRD);
        numberToPrize.put(4, LottoPrize.FOURTH);
        numberToPrize.put(3, LottoPrize.FIFTH);
    }

    public Lotto getLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(lottoStartNumber, lottoEndNumber, lottoLength);
        Lotto lotto = new Lotto(numbers);
        return lotto;
    }

    public void checkLotto(Lotto lotto) {
        int equalcount = countEqual(lotto);
        boolean bonusCheck = checkBounsNumber(lotto);
        if (equalcount == 5) {
            if (bonusCheck) {
                equalcount += 2;
            }
        }
        if (equalcount >= 3) {
            numberToPrize.get(equalcount).increaseCount();
        }
    }

    private int countEqual(Lotto baseLotto) {
        int duplicateCount = 0;
        List<Integer> winningList = this.winningLotto.getNumbers();
        List<Integer> baseList = baseLotto.getNumbers();
        Set<Integer> checkSet = new HashSet<>();
        for (Integer winningNumber : winningList) {
            checkSet.add(winningNumber);
        }
        for (Integer baseNumber : baseList) {
            if (checkSet.contains(baseNumber)) {
                duplicateCount++;
            }
        }
        return duplicateCount;
    }

    private boolean checkBounsNumber(Lotto baseLotto) {
        if (baseLotto.getNumbers().contains(this.bonusNumber)) {
            return true;
        }
        return false;
    }

    public void setWinningLotto(List<Integer> numbers) {
        this.winningLotto = new Lotto(numbers);
    }

    public void setBonusNumber(int number) {
        this.bonusNumber = number;
    }

    public Lotto getWinningLotto() {
        return this.winningLotto;
    }
}
