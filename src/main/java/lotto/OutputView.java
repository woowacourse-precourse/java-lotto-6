package lotto;

import java.util.List;

public class OutputView {

    public void printPurchasedLottos(List<Lotto> purchasedLottos) {
        System.out.printf("%d개를 구매했습니다.\n", purchasedLottos.size());
        for (Lotto purchasedLotto : purchasedLottos) {
            printPurchasedLotto(purchasedLotto);
        }
    }

    private void printPurchasedLotto(Lotto purchasedLotto) {
        List<LottoNumber> numbers = purchasedLotto.getNumbers();
        List<LottoNumber> list = numbers.stream()
                .sorted()
                .toList();

        System.out.println(list);
    }

    // TODO: 출력 테스트 용, 나중에 삭제하자
    public static void main(String[] args) {
        Lotto lotto1 = new Lotto(List.of(11, 22, 33, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(43, 32, 21, 13, 5, 6));

        OutputView outputView = new OutputView();
        outputView.printPurchasedLottos(List.of(lotto1, lotto2));
    }
}
