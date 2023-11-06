package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class UserInput {
    private final static String AMOUNT = "구입금액을 입력해 주세요.";
    private final static String COUNT = "개를 구매했습니다.";
    private final static String LUCKY_NUMBER = "당첨 번호를 입력해 주세요.";
    private final static String BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    private List<Lotto> lottos = new ArrayList<>();
    private int bonusNumber = 0;
    private String inputLuckyNumbers = "";
    private LottoGame lottogame = new LottoGame();
    private final String ERROR = "[ERROR]";



    public int purchase() {
        while (true) {
            System.out.println(AMOUNT);
            try {
                String priceStr = Console.readLine();
                int amount = Integer.parseInt(priceStr);
                if (lottogame.isNotDivisibleBy1000(amount)) {
                    return count(amount);
                }
            } catch (IllegalArgumentException e) {
            }
        }
    }

    public int count(int num) {
        num = num / 1000;
        System.out.println("\n" + num + COUNT);
        return num;
    }

    public List<Lotto> luckyNumber() {
        while (true) {
            System.out.println(LUCKY_NUMBER);
            inputLuckyNumbers = Console.readLine();
            if (isLuckyNumbersValid(inputLuckyNumbers)) {
                return lottos;
            }
        }
    }

    public boolean isLuckyNumbersValid(String inputLuckyNumbers) {
        try {
            String[] LuckyNumbers = inputLuckyNumbers.split(",");
            List<Integer> luckyNumbers = new ArrayList<>();
            for (String luckyNumber : LuckyNumbers) {
                int number = Integer.parseInt(luckyNumber);
                luckyNumbers.add(number);
            }
            Lotto lotto = new Lotto(luckyNumbers);
            lottos.add(lotto);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public int bonusNumber(){
        while (true) {
            System.out.println(BONUS_NUMBER);
            bonusNumber = isBunusNumberInRange();
            if (bonusNumber != 0) {
                break;
            }
        }
        return bonusNumber;
    }

    public int isBunusNumberInRange(){
        try {
            String bonusNumberStr = Console.readLine();
            bonusNumber = Integer.parseInt(bonusNumberStr);
            if (bonusNumber >= 1 && bonusNumber <= 45) {
                return bonusNumber;
            }
        } catch (NumberFormatException e) {
            System.out.println(ERROR + " 올바른 숫자를 입력하세요.");
        }
        return 0;
    }
}

