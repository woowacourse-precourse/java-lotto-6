package lotto;

import lotto.domain.Lotto;
import lotto.domain.Seller;
import lotto.io.IOOperation;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Integer price = IOOperation.getPrice();

        Integer numberOfLotto = Seller.numberOfLotto(price);
        List<Lotto> lottos = Seller.makeLottos(numberOfLotto);
        IOOperation.printLottos(lottos);

        List<Integer> winningNumbers = IOOperation.getWinningNumbers();

        Integer bonusNumber = IOOperation.getBonusNumber(winningNumbers);

        IOOperation.printResult(lottos, winningNumbers, bonusNumber, price);
    }
}
