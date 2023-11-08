package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Validator {
    public static void buyCheck(String inputText) {
        try {
            int price = Integer.parseInt(inputText);
            if (price % 1000 != 0) {
                System.out.println("[ERROR] 1000원 단위로 입력해 주세요.");
                throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해 주세요.");
            }
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 정수만 입력해 주세요.");
            throw new IllegalArgumentException("[ERROR] 정수만 입력해 주세요.");
        }
    }

    public static void targetNumberCheck(String inputText) {
        String[] splitInputData = inputText.split(",");
        checkLength(splitInputData);
        HashSet<Integer> TargetNumbers = new HashSet<>();
        try {
            for (int i = 0; i < 6; i++) {
                int tmp = Integer.parseInt(splitInputData[i]);
                TargetNumbers.add(tmp);
                checkLange(tmp);
            }
            checkDuplicate(TargetNumbers);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 정수만 입력해 주세요.");
            throw new IllegalArgumentException("[ERROR] 정수만 입력해 주세요.");
        }

    }

    private static void checkLength(String[] splitInputData) {
        if (splitInputData.length != 6) {
            System.out.println("[ERROR] 번호를 6개 입력하세요");
            throw new IllegalArgumentException("[ERROR] 번호를 6개 입력하세요");
        }
    }

    private static void checkDuplicate(HashSet<Integer> TargetNumbers) {
        if (TargetNumbers.size() != 6) {
            System.out.println("[ERROR] 중복된 수를 입력하셨습니다.");
            throw new IllegalArgumentException("[ERROR] 중복된 수를 입력하셨습니다.");
        }
    }

    private static void checkLange(int number) {
        if (number < 1 || number > 45){
            System.out.println("[ERROR] 1~45 사이의 수를 입력하세요.");
            throw new IllegalArgumentException("[ERROR] 1~45 사이의 수를 입력하세요.");
        }
    }

    public static void checkBonusNumber(String inputText,List<Integer> targetNumbers){
        try{
            int bonusNumber = Integer.parseInt(inputText);
        }catch (NumberFormatException e)
    }


}
