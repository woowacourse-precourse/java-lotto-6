package View.Concrete;

import lotto.Lotto;

import java.util.Comparator;
import java.util.List;

public class LottoTextView {
    public void printLotto(Lotto lotto){
        List<Integer> numbers = lotto.getNumbers();
        numbers.sort(Comparator.naturalOrder());
        System.out.println(numbers.toString());
    }

    public void printLotteries(List<Lotto> lotteries){
        for(Lotto lotto: lotteries)
            printLotto(lotto);
    }
}
