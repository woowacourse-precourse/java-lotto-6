package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Lottery {
    private static final String EXCEPTION_PREFIX = "[ERROR]";
    private static final int PRICE_OF_LOTTO = 1000;
    private int receivedMoney;
    private int quantityOfLottoPublishable;
    private List<Lotto> lottos = new ArrayList<>();

    public void receiveMoney () {
        int receivedMoney = 0;
        try {
            String money = Console.readLine();
            if (money.matches("^-?\\d+$\n")) {
                throw new IllegalArgumentException(EXCEPTION_PREFIX+"정수만 입력 가능합니다.");
            }
            if (Integer.parseInt(money) % 1000 != 0) {
                throw new IllegalArgumentException(EXCEPTION_PREFIX+"입력은 1000 단위로 해주세요.");
            }
            receivedMoney = Integer.parseInt(money);
        }catch (IllegalArgumentException e){
            System.err.println(EXCEPTION_PREFIX + e.getMessage());
            receiveMoney();
        }finally {
            this.receivedMoney = receivedMoney;
        }
    }

    public void calculateQuantityOfLottoAndNotify () {
        quantityOfLottoPublishable = receivedMoney / PRICE_OF_LOTTO;
        System.out.println(quantityOfLottoPublishable + ValueToNotify.BUY_NOTIFY);
    }

    public void publishLotto () {
        for (int i = 0; i < quantityOfLottoPublishable; i++) {
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoNumber = lottoNumber.stream().sorted().toList();
            Lotto lotto = new Lotto(lottoNumber);
            lottos.add(lotto);

            System.out.println(lotto);
        }
    }

}
