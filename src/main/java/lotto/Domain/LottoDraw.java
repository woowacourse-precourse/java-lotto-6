package lotto.Domain;


import java.util.List;

public class LottoDraw {
    private final WinningLotto winningLotto;

    public LottoDraw(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }


    public int checkNumbers(Human human) {
        List<Lotto> lottos = human.getLottos();
        List<Integer> normalNumbers = winningLotto.getNormalNumbers();
        int bonusNumber = winningLotto.getBonusNumber();

        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();

            int normalNumberMatch = (int) normalNumbers.stream()
                    .filter(numbers::contains)
                    .count();
            boolean bonusNumberMatch = numbers.contains(bonusNumber);

            checkWinner(normalNumberMatch, bonusNumberMatch);
            System.out.println(normalNumberMatch + " " + bonusNumberMatch);
        }
        return 1;
    }

    private void checkWinner(int normalNumberMatch, boolean bonusNumberMatch) {

    }
}
