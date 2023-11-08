package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckNumber {
    public static void checkPurchaseMoney(int perchaseInput){ // 구매 금액이 올바른지 확인한다
        if(perchaseInput < 1000){ // 1000원보다 낮으면 예외 발생
            throw new IllegalArgumentException("로또를 구매할 수 없는 금액입니다");
        }
        if(perchaseInput % 1000 != 0){ // 1000으로 나눌 수 없으면 예외 발생
            throw new IllegalArgumentException("1000으로 나누어 떨어지지 않는 수입니다");
        }
    }
    public static void checkTextInput(String stringInput){ // 숫자로만 구성되어 있는지 확인한다
        Pattern pattern = Pattern.compile("^[0-9]+$"); // 정규 표현식: 숫자로만 구성된 문자열
        Matcher matcher = pattern.matcher(stringInput); // 숫자로 구성되어 있는지 확인
        if (!matcher.matches()) { // 숫자로 구성되지 않은 값이 있으면 예외 발생
            throw new IllegalArgumentException("숫자만 입력하세요");
        }
    }
    public static void checkPrizeNumber1(String prizeNumber){ // 당첨 번호가 올바른지 확인한다
        String[] splitNumber = prizeNumber.split(",");
        if(splitNumber.length != 6){ // 숫자가 6개가 아니면 예외 발생
            throw new IllegalArgumentException("당첨 번호는 6개를 입력해야 합니다");
        }
        for(String stringCheck : splitNumber){
            checkTextInput(stringCheck); // 숫자로만 구성되어 있는지 확인
            if(stringCheck.isEmpty()){ // 값이 없으면 예외 발생
                throw new IllegalArgumentException("쉼표 사이에 숫자가 없습니다");
            }
            int stringCheckNumber = Integer.parseInt(stringCheck);
            if(stringCheckNumber > 45 || stringCheckNumber < 1){ // 0이하거나 45보다 큰 수가 있다면 예외 발생
                throw new IllegalArgumentException("당첨 번호는 45이하 자연수입니다");
            }
        }
    }
    public static void checkPrizeNumber2(String prizeNumber){ // 당첨 번호가 올바른지 확인한다
        String[] splitNumber = prizeNumber.split(",");
        HashSet<String> stringCheckHashSet = new HashSet<>(); // 중복 값을 확인하기 위해 set 선언
        for(String stringCheck : splitNumber){ // set에 당첨 번호를 삽입
            stringCheckHashSet.add(stringCheck);
        }
        if(stringCheckHashSet.size() != 6){ // set의 size가 6이 아니면 동일한 숫자가 존재한 것이므로 예외 발생
            throw new IllegalArgumentException("동일한 숫자는 입력할 수 없습니다");
        }
    }
    public static void checkBonusNumber(String bonusNumber, ArrayList<Integer> prizeNumberArray){ // 보너스 번호가 올바른지 확인한다
        if(bonusNumber.isEmpty()){ // 값이 없으면 예외 발생
            throw new IllegalArgumentException("보너스 번호를 입력해주세요");
        }
        try {
            int bonusIntNumber = Integer.parseInt(bonusNumber); // 정수로 변환
            if (bonusIntNumber < 1 || bonusIntNumber > 45) { // 0이하거나 45보다 큰 수가 있다면 예외 발생
                throw new IllegalArgumentException("보너스 번호는 45이하 자연수입니다");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        if(prizeNumberArray.contains(Integer.parseInt(bonusNumber))){ // 당첨 번호에 존재하는 값이라면 예외 발생
            throw new IllegalArgumentException("당첨 번호에 존재하는 번호입니다");
        }
    }
}
