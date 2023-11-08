package lotto.service;

import java.util.List;

public class OutputService {
    public void requestMoney () {
        System.out.println("구입금액을 입력해주세요 : ");
    }

    public void printLotto(List<Integer> numbers) {
        System.out.println(numbers);
    }
}
