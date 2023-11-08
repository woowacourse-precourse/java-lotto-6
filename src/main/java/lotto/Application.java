package lotto;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import camp.nextstep.edu.missionutils.Console;



public class Application {
    public static void main(String[] args) {

        int lottoCount = inputMoney();

        Lotto lotto = new Lotto(InputUserNumber());

        System.out.println("보너스 번호를 입력하세요 ");
        String InputBonusNumber = Console.readLine();

//        lotto.createLotto(lottoCount);





    }

    public static List<Integer> parseCommaSeparatedNumbers(String input) { //string 을 리스트로
        String[] tokens = input.split(",");
        List<Integer> numbers = new ArrayList<>();

        for (String token : tokens) {
            int number = Integer.parseInt(token.trim());
            numbers.add(number);
        }
        return numbers;
    }

    public static int inputMoney() { // 금액 투입 및 예외처리
        int count=0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("구매금액을 입력하세요 (1000원 단위):");
                int money = Integer.parseInt(Console.readLine());
                if(money % 1000==0)
                {
                    validInput = true; // 유효한 입력일 경우 반복문 종료
                }
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효한 숫자가 아닙니다. 다시 입력하세요.");
            }
        }
        return count;
    }
    public static List<Integer> InputUserNumber() { //당첨번호,보너스번호 입력
        System.out.println("당첨 번호를 입력하세요 ");
        String InputNumber = Console.readLine();
        return parseCommaSeparatedNumbers(InputNumber);
    }
}
