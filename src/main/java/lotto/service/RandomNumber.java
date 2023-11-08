package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Domain.Lotto;
import lotto.view.Input;
import lotto.view.Output;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RandomNumber {

    int lottocount=0;
    public List<Integer> randomNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    public List<Lotto> lottoList() {
        Input input = new Input();
        Output output = new Output();
        List<Lotto> lottolist = new ArrayList<>();
        int money = Integer.parseInt(input.readMoney());
        for (int i = 0; i < money / 1000; i++,lottocount++) {
            List<Integer> number = new ArrayList<>(randomNumber());
            Collections.sort(number);
            Lotto lotto = new Lotto(number);
            lottolist.add(lotto);
        }
        System.out.printf("\n%d",lottocount);
        output.printHowManyLotto();
        output.printLottoList(lottolist);
        return lottolist;
    }
}
