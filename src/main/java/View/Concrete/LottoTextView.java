package View.Concrete;

import View.LottoView;
import Domain.lotto.Lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoTextView implements LottoView {
    public void printLotto(Lotto lotto){
        List<Integer> numbers = new ArrayList<>(lotto.getNumbers());
        numbers.sort(Comparator.naturalOrder());
        System.out.println(numbers.toString());
    }

    public void printLotteries(List<Lotto> lotteries){
        System.out.println(lotteries.size() + "개를 구매했습니다.");
        for(Lotto lotto: lotteries)
            printLotto(lotto);
    }
}
