package lotto.View;

public class Lottogameview {
  public void printPurchasedLottosCount(int numberOfLotto) {
        System.out.println(numberOfLotto + "개를 구매했습니다.");
    }

    public void printPurchasedLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            printLottoNumbers(lotto.getNumbers());
        }
    }

    private void printLottoNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }
}
