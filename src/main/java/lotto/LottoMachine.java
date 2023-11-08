package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private final static int LOTTO_NUMBERS_LENGTH = 6;
    private final static int MIN_LOTTO_NUMBER = 1;
    private final static int MAX_LOTTO_NUMBER = 45;
    private final static int LOTTO_PRICE = 1000;

    public int lottoCount;
    public List<Lotto> lottoBundle = new ArrayList<>();


    public void lottoMachineInput() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            insertMoney(Console.readLine());
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            lottoMachineInput();
        }
    }

    public void insertMoney(String input) {
        Exception.validateMoney(input);
        lottoCount = Integer.parseInt(input) / LOTTO_PRICE;
    }

    public List<Lotto> lottoMachineOutput() {
        generateLottoBundle();

        System.out.println(lottoCount + "개를 구매했습니다.");
        for (Lotto lotto : lottoBundle) {
            System.out.println(lotto.lottoPrintFormat());
        }
        System.out.println();

        return lottoBundle;
    }

    public void generateLottoBundle() {
        for (int i = 0; i < lottoCount; i++) {
            Lotto processingLotto = new Lotto(generateLottoNumbers());
            lottoBundle.add(processingLotto);
        }
    }

    public List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBERS_LENGTH);
    }

}
