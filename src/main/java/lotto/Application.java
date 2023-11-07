package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    public static void main(String[] args) {

    }
    public static LottoInit ReceiveInitial() {
        LottoInit lottoInit = null;
        try {
            System.out.println("구입금액을 입력해 주세요");
            int purchaseAmount = Integer.parseInt(Console.readLine());
            int numberOfLotto = purchaseAmount / 1000;

            lottoInit = new LottoInit(purchaseAmount, numberOfLotto);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return ReceiveInitial();
        }

        System.out.println("\n" + lottoInit.numberOfLotto + "개를 구매했습니다.");
        return lottoInit;
    }
    private static List<Integer> makeRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_SIZE);
    }

    private static List<Lotto> makeAllLottoPaper(int numberOfLotto) {
        List<Lotto> allOfLottoPapers = new ArrayList<>();
        for (int i = 0; i < numberOfLotto; i++) {
            Lotto lottoPaper = new Lotto(makeRandomNumbers());
            lottoPaper.printLottoPaper(lottoPaper);
            allOfLottoPapers.add(lottoPaper);
        }
        return allOfLottoPapers;
    }

    private static void validateInputDataType(String winningLotteryNumber) {
        if (!(winningLotteryNumber.matches("^[0-9, ]+$"))) {
            throw new IllegalArgumentException("[Error] 숫자와 콤마(,) 이외의 값을 입력하셨습니다.");
    }





}
