package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.print("구입금액을 입력해 주세요.\n");
        String input = Console.readLine();
        int money = input_money(input);
        System.out.print(money);
    }
    private static int input_money(String str){      // Input을 String으로 받아서 Int로 반환
        try{
            return Integer.parseInt(str);
        }catch (NumberFormatException e){  // 변환 포멧 안맞으면 IllegalArgumentException 발생
            throw new IllegalArgumentException();
        }
    }


}
