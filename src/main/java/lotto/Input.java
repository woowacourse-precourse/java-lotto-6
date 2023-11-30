package lotto;
// 오류 메세지는 enum으로 처리해서 클래스 각각마다 갖다줘서 사용할 수 있게 해야한다. 오류메세지는 한번 정해놓으면 여러 클래스에서 사용가능하니까.
// 오류 메세지 출력하고 다시 그 부분부터 실행시켜야 하는데 메소드 부분에서 try-catch를 사용해 오류값들만 illegal로 해버리고 catch부분에서 오류 메세지 출력하는 방법으로 해야 모든 예외 상황하나씩 하지않고
// 메소드 기능 전부 확인해서 오류만 딱 보내고 그 메소드 다시 실행시킬 수 있게 된다.

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class Input {
    private static final String INPUT_USER_CASH = "구입 금액을 입력해 주세요.";
    private static final String INPUT_WIN_LOTTO_NUM = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_USER_BONUS_LOTTO_NUM = "보너스 번호를 입력해 주세요.";
    private static final String ERROR_UNIT = "[ERROR] 입력 금액 단위는 1000단위입니다.";
    private static final String ERROR_ONLY_NUM = "[ERROR] 숫자를 입력하십시오.";

    public int getUserCash() {
        System.out.println(INPUT_USER_CASH);
        String userCashString = (Console.readLine());
        int userCash = 0;
        try {
            userCash = makeStringToNum(userCashString);
            checkCashUnit(userCash);
        } catch (IllegalArgumentException e) {
            getUserCash();
        }
        return userCash;
    }

    public void checkCashUnit(int userCash) {
        if (userCash % 1000 != 0) {
            System.out.println(ERROR_UNIT);
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> printWinnerNum() {
        List<Integer> winnerNum = new ArrayList<>();
        try {
            System.out.println(INPUT_WIN_LOTTO_NUM);
            String[] winnerNumList = (Console.readLine()).split(",");
            winnerNum = makeList(winnerNumList);
        } catch
        (IllegalArgumentException e) {
            printWinnerNum();
        }
        return winnerNum;
    }

    public int printBonusNum() {
        System.out.println(INPUT_USER_BONUS_LOTTO_NUM);
        String bonus = Console.readLine();
        int bonusNum = makeNum(bonus);
        return bonusNum;
    }

    private List<Integer> makeList(String[] numList) {
        List<Integer> winnerNumList = new ArrayList<>(numList.length);
        try {
            for (int i = 0; i < numList.length; i++) {
                winnerNumList.add(Integer.parseInt(numList[i]));
            }
        } catch (NumberFormatException exception) {
            System.out.println(ERROR_ONLY_NUM);
            throw new IllegalArgumentException();
        }
        return winnerNumList;
    }

    private int makeNum(String bonusNum) {
        int Num;
        try {
            Num = Integer.parseInt(bonusNum);
        } catch (NumberFormatException exception) {
            System.out.println(ERROR_ONLY_NUM);
            throw new IllegalArgumentException();
        }
        return Num;
    }

    private int makeStringToNum(String userCash) {
        int Num;
        try {
            Num = Integer.parseInt(userCash);
        } catch (NumberFormatException exception) {
            System.out.println(ERROR_ONLY_NUM);
            throw new IllegalArgumentException();
        }
        return Num;
    }
}




