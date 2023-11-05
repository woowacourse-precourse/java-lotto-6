package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.RandomLottoNumbers;

public class GameMachine {

    private final LottoNumbers lottoNumbers;

    public GameMachine() {
        this.lottoNumbers = new RandomLottoNumbers();
    }

    public void start() {
        // 구입 금액 입력 , 1000으로 나눈다.
        System.out.println("구입금액을 입력해 주세요.");
        int inputPrice = Integer.parseInt(Console.readLine());
        int count = inputPrice / 1000;

        System.out.println();
        System.out.println(count + "개를 구매했습니다.");
        // 구입 금액 / 1000 만큼 발행 한다.
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(lottoNumbers.generateNumbers());

            System.out.println(lotto.getNumbers());
        }

    }

}