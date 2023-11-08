package lotto.Domain;


import java.util.List;
import lotto.Enum.WinningType;

public class LottoDraw {

    private final WinningLotto winningLotto;

    public LottoDraw(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public WinningLotto getWinningLotto() {
        return winningLotto;
    }

    public void checkNumbers(Human human) {
        List<Lotto> lottos = human.getLottos();
        List<Integer> normalNumbers = winningLotto.getNormalNumbers();
        int bonusNumber = winningLotto.getBonusNumber();

        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();

            int normalNumberMatch = (int) normalNumbers.stream().filter(numbers::contains).count();
            boolean bonusNumberMatch = numbers.contains(bonusNumber);

            if (bonusNumberMatch) {
                human.addWinningResult(checkWinnerBonusTrue(normalNumberMatch));
                continue;
            }
            human.addWinningResult(checkWinnerBonusFalse(normalNumberMatch));
        }
    }

    private WinningType checkWinnerBonusTrue(int normalNumberMatch) {
        if (normalNumberMatch == 5) {
            return WinningType.FIRST_PLACE;
        }
        if (normalNumberMatch == 4) {
            return WinningType.THIRD_PLACE;
        }
        if (normalNumberMatch == 3) {
            return WinningType.FORTH_PLACE;
        }
        if (normalNumberMatch == 2) {
            return WinningType.FIFTH_PLACE;
        }
        return WinningType.NONE;
    }

    private WinningType checkWinnerBonusFalse(int normalNumberMatch) {
        if (normalNumberMatch == 5) {
            return WinningType.SECOND_PLACE;
        }
        if (normalNumberMatch == 4) {
            return WinningType.FORTH_PLACE;
        }
        if (normalNumberMatch == 3) {
            return WinningType.FIFTH_PLACE;
        }
        return WinningType.NONE;
    }
}
