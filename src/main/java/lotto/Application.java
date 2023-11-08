package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoPick lottoPick;
        Lotto lotto;
        while (true) {
            try {
                lottoPick = new LottoPick(getMoney());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        lottoPick.makeLottoPick();
        lottoPick.outputLottoPick();
        while (true) {
            try {
                lotto = new Lotto(winningNumber());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                lotto.bonusNumber(bonusNumber());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        LottoCheck lottoCheck = new LottoCheck(lottoPick.lottoPickNumber(),lotto.lottoNumber());
        lottoCheck.lottoCompare();
        lottoCheck.lottoOutput();
    }


    // 금액 받기.
    public static int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String line = Console.readLine();
        isInteger(line);
        return Integer.parseInt(line);
    }

    // 당첨 번호 받기.
    public static List<Integer> winningNumber() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        List<String> inputdate = Arrays.asList(input.split(","));
        return stringToInteger(inputdate);
    }

    //리스트 string을 리스트 integer로 바꿈.
    private static List<Integer> stringToInteger(List<String> string){
        List<Integer> integers = new ArrayList<>();
        for (String s : string) {
            integers.add(Integer.parseInt(s));
        }
        return integers;
    }

    //보너스 번호 받기.
    public static int bonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String line = Console.readLine();
        isInteger(line);
        return Integer.parseInt(line);
    }

    // 숫자 인지 확인
    public static void isInteger(String strValue) {
        try {
            Integer.parseInt(strValue);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력 하세요.");
        }
    }
}
