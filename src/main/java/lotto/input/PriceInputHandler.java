package lotto.input;

import camp.nextstep.edu.missionutils.Console;

/**### 입력
 [] (입력공통사항) 에러상황시 [ERROR]로 시작하는 에러문구를 출력하고 다시 입력받는다.
 [] 로또 구입 금액을 입력받는다.
 - [] 입력받은 금액을 로또의 개수로 변환한다.
 - [] (예외사항) 숫자입력만 있는지, 지정된 범위(100,000)가 넘어가는지, 1000원 이하의 금액이 있는지 확인한다.
 [] 당첨 번호를 입력받는다.
 - [] ","를 구분자로 한다.
 - [] 각 숫자마다 앞뒤 공백은 제거하여 받는다.
 - [] (예외사항) 숫자입력만 있는지, 지정된 범위(1~45)가 넘어가는지, 지정된 갯수(6)이 넘어가는지 확인한다.
 [] 보너스 번호를 입력받는다.
 - [] (예외사항) 숫자입력만 있는지, 지정된 범위(1~45)가 넘어가는지, 지정된 갯수(1)이 넘어가는지 확인한다.
 - [] (예외사항) 보너스번호는 당첨번호에서 고른 숫자와 중복되서는 안된다.
 */
public class PriceInputHandler {

    private static final int ZERO = 0;
    private static final int MIN_PRICE_UNIT = 1000;
    private static final int PURCHASE_MIN = 1000;
    private static final int PURCHASE_MAX = 100000;

    public static int validatePrice(String input) {
        try {
            int price = convertInteger(input);
            validateRange(price, PURCHASE_MIN, PURCHASE_MAX);
            validateUnit(price);
            return price;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 지불할 금액을 다시 입력해주세요.");
            String newInput = Console.readLine();
            return validatePrice(newInput);
        }
    }
    private static int convertInteger(String input){
        return Integer.parseInt(input);
    }
    private static void validateRange(int target, int start, int end){
        if(target < start || target > end) {
            throw new IllegalArgumentException();
        }
    }
    private static void validateUnit (int price){
        if ((price % MIN_PRICE_UNIT) != ZERO) {
            throw new IllegalArgumentException();
        }
    }
}
