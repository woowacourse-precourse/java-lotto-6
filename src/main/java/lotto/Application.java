package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

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
    final int prize;
    final int count;
    public String name;
    Statistic(int matchingNumbers, int prize, int count) {
        this.matchingNumbers = matchingNumbers;
        this.prize = prize;
        this.count = count;
    }
    public String getName() {
        return name;
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
        // TODO: 프로그램 구현
        int price = inputPrice();
        Lotto lotto = new Lotto(inputUserNumbers());
        List<Integer> numbers = lotto.getLotto();
        int bonus = inputBonus();
        int totalprize =0;
        int[] prizes = {0, 0, 0, 0, 0, 0};
        for(int i=0; i<price/1000; i++){
            List<Integer> answers = generateAnswers();
//            int [] arr = {1,2,3,4,5,6};
//            List<Integer> answers = Arrays.stream(arr).boxed().collect(Collectors.toList());
            Statistic prize = getPrize(numbers, answers, bonus);
            totalprize += prize.prize;
            prizes[prize.count]++;
        }
        float percent = totalprize/price;
        printResult(percent, prizes);

    }
    private static int inputPrice(){
        System.out.println("구입금액을 입력해 주세요.");
        int price = 0;
        try {
            price = Integer.parseInt(Console.readLine());
            validate(price);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자를 입력해 주세요.");
            inputPrice();
        } catch (IllegalArgumentException e){
            System.out.println("[ERROR] 유효하지 않는 값입니다. 가격은 1000원 단위로 입력할 수 있습니다.");
            inputPrice();
        }
        return price;
    }
    private static List<Integer> inputUserNumbers() {
        String input;

        System.out.println("당첨 번호를 입력해 주세요.");
        input = Console.readLine();
        List<String> strNum = new ArrayList<String>(Arrays.asList(input.split(",")));
        List<Integer> numbers = strNum.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        return numbers;
    }
    private static int inputBonus(){
        System.out.println("보너스 숫자를 입력해 주세요.");
        int bonus = 0;
        try {
            bonus = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자를 입력해 주세요.");
            inputBonus();
        }
        return bonus;
    }

    public static List<Integer> generateAnswers(){
        List<Integer> answers;
        answers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return answers;
    }
    public static Statistic getPrize(List<Integer> numbers, List<Integer> answers, int bonus){
        boolean bonusYes = answers.contains(bonus);
        answers.retainAll(numbers);
        int match = answers.size();

        if (match < 3)
            return Statistic.FAIL;

        return Statistic.getRank(match, bonusYes);
    }
    private static void printResult(float percent, int[] prizes){
        System.out.println("3개 일치 (5,000원) - "+prizes[1]+"개");
        System.out.println("4개 일치 (50,000원) - "+prizes[2]+"개");
        System.out.println("5개 일치 (1,500,000원) - "+prizes[3]+"개");
        System.out.println("5개 일치 , 보너스 볼 일치 (30,000,000원) - "+prizes[4]+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+prizes[5]+"개");
        System.out.println("총 수익률은 "+percent+"%입니다.");

    }


    private static void validate(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }



}