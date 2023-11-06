package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        int cash = inputLottoPayCount();
    }

    private static int inputLottoPayCount() {
        System.out.println("구입금액을 입력해 주세요.");
        try{
            int cash = inputLottoCash();
            checkNotThousandAndNegativeException(cash);
            return cash;
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            inputLottoPayCount();
        }
        return 0;
    }

    private static void checkNotThousandAndNegativeException(int count) {
        if (count % 1000 != 0 || count < 0) throw new IllegalArgumentException("[ERROR] 천원 단위로 입력해주세요.");
    }

    private static int inputLottoCash() {
        int count;
        try{
            count = Integer.parseInt(Console.readLine());
            return count;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 숫자 형식으로 입력해주세요.");
        }
    }
}
