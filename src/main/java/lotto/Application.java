package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();
        int lottoTotalCount = lottoBuyCount(money);
    }
    static int lottoBuyCount(String money){
        try{
            int lottoTotalCount = Integer.parseInt(money);
            if (lottoTotalCount % 1000 != 0){
                throw new IllegalArgumentException("구매 금액을 1000원 단위로 작성해주세요.");
            }
            return lottoTotalCount;
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력받은 값이 잘못되었습니다.");
        }
    }
}
