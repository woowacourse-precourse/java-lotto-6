package lotto;

import java.util.*;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_PRICE = 1000;
    private static int amount;
    private static int bonusNum;
    private static Lotto answer;
    private static List<Lotto> lottos = new ArrayList<>();

    public static void main(String[] args) {
        getAmount();

        buyLotto();

        getAnswer();

        getBonusNum();

        calculateRes();

        printResult();

        calculateRateOfReturn();
    }

    private static void printResult(){
        System.out.println("당첨 통계");
        System.out.println("---");
        for (WinningResult result : WinningResult.values()) {
            System.out.println(result.getPhrase() + " - " + result.getCount() + "개");
        }
    }

    private static void getAmount(){
        while (true) {
            try{
                System.out.println("구입금액을 입력해 주세요.");
                String amountInput = Console.readLine();
                validateAmount(amountInput);
                break;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private static void validateAmount(String amountInput) {
        if (!amountInput.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
        amount = Integer.parseInt(amountInput);
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    private static void getBonusNum(){
        System.out.println();
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String bonusNumInput = Console.readLine();
                validateBonusNum(bonusNumInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void validateBonusNum(String bonusNumInput) {
        if (!bonusNumInput.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
        bonusNum = Integer.parseInt(bonusNumInput);
        if (bonusNum < LOTTO_START_NUMBER || bonusNum > LOTTO_END_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 정수로 입력해야 합니다.");
        }
    }

    private static void getAnswer(){
        System.out.println();
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String answerInput = Console.readLine();
                List<Integer> answerNums = Arrays.stream(answerInput.split(","))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                answer = new Lotto(answerNums);
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void buyLotto(){
        System.out.println();
        int lottoNum = amount / LOTTO_PRICE;
        System.out.println(lottoNum+"개를 구매했습니다.");
        for (int i=0; i<lottoNum; i++){
            List<Integer> randomNums = generateRandomNumbers();
            Lotto lotto = new Lotto(randomNums);
            lottos.add(lotto);
        }
    }

    private static List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_NUMBER_COUNT));
        Collections.sort(numbers);
        System.out.println(numbers);
        return numbers;
    }

    public static void calculateRes(){
        for(Lotto lotto: lottos){
            long count = lotto.getNumbers().stream()
                    .filter(answer.getNumbers()::contains)
                    .count();
            boolean isContainBonus = lotto.getNumbers().contains(bonusNum);
            winngResIncrese(count, isContainBonus);
        }
    }

    private static void winngResIncrese(long count, boolean isContainBonus){
        if (count == 3){
            WinningResult.THREE_MATCH.incrementCount();
            return;
        }
        if (count == 4){
            WinningResult.THREE_MATCH.incrementCount();
            return;
        }
        if (count == 6){
            WinningResult.THREE_MATCH.incrementCount();
            return;
        }
        if (count == 5 && !isContainBonus){
            WinningResult.FIVE_MATCH.incrementCount();
            return;
        }
        if (count == 5 && isContainBonus){
            WinningResult.BONUS_MATCH.incrementCount();
        }
    }

    private static void calculateRateOfReturn(){
        long total = WinningResult.calculateTotalAmount();
        double rateOfReturn = (double) total / amount * 100;  // 실수 나눗셈을 사용
        rateOfReturn = Math.round(rateOfReturn * 10) / 10.0;
        System.out.println("총 수익률은 "+rateOfReturn+"%입니다.");
    }
}
