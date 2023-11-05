package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private final static String AMOUNT = "구입금액을 입력해 주세요.";
    private final static String COUNT = "개를 구매했습니다.";
    private final static String LUCKY_NUMBER = "당첨 번호를 입력해 주세요.";
    private final static String BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private final String ERROR = "[ERROR]";
    private final static int MIN = 1;
    private final static int MAX = 45;
    private final static int NUMBER = 6;
    private List<Lotto> lottos = new ArrayList<>();
    private int bonusNumber = 0;

    public void start() {
        int count = purchase();
        generateLottoNumbers(count);
        luckyNumber();
        bonusNumber();
    }

    public int purchase() {
        while (true) {
            System.out.println(AMOUNT);
            try {
                String priceStr = Console.readLine();
                int amount = Integer.parseInt(priceStr);
                if (isNotDivisibleBy1000(amount)) {
                    return count(amount);
                }
            } catch (IllegalArgumentException e) {
            }
        }
    }

    public boolean isNotDivisibleBy1000(int amount) {
        if (amount % 1000 != 0) {
            System.out.println(ERROR + " 1000으로 나누어 떨어지는 금액을 입력하세요.");
            return false;
        }
        return true;
    }

    public int count(int num) {
        num = num / 1000;
        System.out.println("\n" + num + COUNT);
        return num;
    }
    public List<Lotto> generateLottoNumbers(int count) {
        for (int i = 0; i < count; i++) {
            List<Integer> generateNumbers = Randoms.pickUniqueNumbersInRange(MIN, MAX, NUMBER);
            Lotto lotto = new Lotto(generateNumbers);
            lottos.add(lotto);
        }
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getRandomNumber());
        }
        System.out.println("\n");
        return lottos;
    }

    public List<Lotto> luckyNumber(){
        while(true){
            try {
                System.out.println(LUCKY_NUMBER);
                String inputLuckyNumbers = Console.readLine();
                String[] LuckyNumbers = inputLuckyNumbers.split(",");
                List<Integer> luckyNumbers= new ArrayList<>();
                for (String luckynumbers:LuckyNumbers){
                    int numbers = Integer.parseInt(luckynumbers);
                    luckyNumbers.add(numbers);
                }
                Lotto lotto = new Lotto(luckyNumbers);
                lottos.add(lotto);
                return lottos;
            } catch (IllegalArgumentException e) {
            }
        }
    }

    public int bonusNumber(){
        while (true) {
            System.out.println(BONUS_NUMBER);
            try {
                String bonusNumberStr = Console.readLine();
                bonusNumber = Integer.parseInt(bonusNumberStr);
                if (bonusNumber >= 1 && bonusNumber <= 45) {
                    return bonusNumber;
                }
            } catch (NumberFormatException e) {
                System.out.println(ERROR + " 올바른 숫자를 입력하세요.");
            }
        }
    }
}