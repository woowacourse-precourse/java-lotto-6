package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import net.bytebuddy.TypeCache;

import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

enum Statistic {
    FAIL(0, 0, 0),
    THREE(3, 5000, 1),
    FOUR(4, 50_000,2),
    FIVE(5, 1_500_000, 3),
    BONUS(5, 3_000_000, 4),
    SIX(6, 2_000_000_000, 5);

    private final int matchingNumbers;
    final float prize;
    final int count;
    public String name;
    Statistic(int matchingNumbers, int prize, int count) {
        this.matchingNumbers = matchingNumbers;
        this.prize = prize;
        this.count = count;
    }
    public static Statistic getRank(int numberOfMatch, boolean bonusYes) {
        Statistic num =  Arrays.stream(values())
                .filter(statistic -> statistic.matchingNumbers == numberOfMatch)
                .findFirst()
                .orElseThrow();
        if (numberOfMatch == 5 && bonusYes) num = BONUS;
        return num;
    }
}
public class Application {
    public static void main(String[] args) {
        int price = inputPrice();
        List<List<Integer>> answers = new ArrayList<>(generateAnswers(price));
        List<Integer> numbers;
        while(true){
            try{
                Lotto lotto = new Lotto(inputUserNumbers());
                numbers = lotto.getLotto();
                break;
            }
            catch (IllegalArgumentException e){
            }
        }
        int bonus = inputBonus(numbers);
        calculateTotalprice(price, numbers, answers, bonus);
    }
    private static int inputPrice(){
        System.out.println("구입금액을 입력해 주세요.");
        int price = 0;
        while (true){
            try {
                price = Integer.parseInt(Console.readLine());
                validate(price);
                return price;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효하지 않은 값입니다. 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 유효하지 않는 값입니다. 가격은 1000원 단위로 입력할 수 있습니다.");
            }
        }
    }
    private static List<Integer> inputUserNumbers() {
        String input;
        System.out.println("당첨 번호를 입력해 주세요.");
        while(true){
            try {
                input = Console.readLine();
                List<String> strNum = new ArrayList<String>(Arrays.asList(input.split(",")));
                List<Integer> numbers = strNum.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
                return numbers;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효하지 않는 값입니다. 다시 입력해 주세요.");
            }
        }
    }
    private static int inputBonus(List<Integer> numbers){
        System.out.println("보너스 숫자를 입력해 주세요.");
        int bonus = 0;
        while(true){
            try {
                bonus = Integer.parseInt(Console.readLine());
                validateBonus(bonus, numbers);
                return bonus;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e){
                System.out.println("[ERROR] 보너스 숫자는 중복되지 않아야 합니다.");
            }
        }
    }

    public static List<List<Integer>> generateAnswers(int price){
        List<List<Integer>> answers = new ArrayList<>();
        List<Integer> answer ;
        System.out.println(price/1000+"개를 구매했습니다.");
        for(int i=0; i<price/1000; i++){
            answer = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            answers.add(answer);
            List<Integer> sortedNums = answer.stream().sorted().collect(Collectors.toList());
            System.out.println(sortedNums);
        }
        return answers;
    }
    public static Statistic getPrize(List<Integer> numbers, List<Integer> answer, int bonus){
        boolean bonusYes = answer.contains(bonus);
        List<Integer> answerBuf = new ArrayList<>();
        answerBuf.addAll(answer);
        answerBuf.retainAll(numbers);
        int match = answerBuf.size();
        if (match < 3)
            return Statistic.FAIL;
        return Statistic.getRank(match, bonusYes);
    }
    private static void printResult(float percent, int[] prizes){
        System.out.println("당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - "+prizes[1]+"개");
        System.out.println("4개 일치 (50,000원) - "+prizes[2]+"개");
        System.out.println("5개 일치 (1,500,000원) - "+prizes[3]+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+prizes[4]+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+prizes[5]+"개");
        System.out.println("총 수익률은 "+percent+"%입니다.");
    }
    private static void calculateTotalprice(int price, List<Integer> numbers, List<List<Integer>>answers, int bonus){
        float totalPrize = 0;
        int[] prizes={0,0,0,0,0,0};
        for(int i=0; i<price/1000; i++){
            Statistic prize = getPrize(numbers, answers.get(i), bonus);
            totalPrize += prize.prize;
            prizes[prize.count]++;
        }
        float percent = Math.round(totalPrize / price * 1000)/10;
        printResult(percent, prizes);
    }

    private static void validate(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
    private static void validateBonus(int bonus, List<Integer> numbers) {
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException();
        }
    }


}