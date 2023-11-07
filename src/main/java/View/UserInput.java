package View;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserInput {
    private static String GET_PURCHASE_AMOUNT_MSG="구입금액을 입력해 주세요";
    private static String GET_BONUS_NUM_MSG="보너스 번호를 입력해 주세요.";
    private static String GET_WINNING_NUM_MSG="당첨 번호를 입력해 주세요.";
    public Integer getPurchaseAmount() {
        System.out.println(GET_PURCHASE_AMOUNT_MSG);
        try{
            return validatePurchaseNum(validateConvertToInt(Console.readLine()));
        }catch (IllegalArgumentException e){
            return getPurchaseAmount();
        }
    }

    public Lotto getWinningNum() {
        System.out.println(GET_WINNING_NUM_MSG);
        try{
            List<Integer> winningNum=makeWinningNumToList(Console.readLine());
            return new Lotto(winningNum);
        }catch (IllegalArgumentException e) {
            return getWinningNum();
        }
    }
    private List<Integer> makeWinningNumToList(String input){
        List<Integer> winningNum = new ArrayList<>();
        String[] nums = input.split(",");
        for (String token : nums) {
            winningNum.add(validateConvertToInt(token));
        }
        return winningNum;
    }


    public Integer getBonusNum() {
        System.out.println(GET_BONUS_NUM_MSG);
        try{
            return validateBonusNum(validateConvertToInt(Console.readLine()));
        }catch (IllegalArgumentException e){
            return getBonusNum();
        }
    }

    private Integer validatePurchaseNum(Integer Num) {
        if (Num % 1000 != 0) {
            System.out.println("[ERROR] 1000원 단위어야 합니다");
            throw new IllegalArgumentException();
        }
        return Num;
    }

    private Integer validateConvertToInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자만 기입해주세요");
            throw new IllegalArgumentException();
        }
    }

    private Integer validateBonusNum(Integer Num) {
        if (Num > 45 || Num < 1) {
            System.out.println("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
        return Num;
    }
}
