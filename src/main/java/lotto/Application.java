package lotto;
import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        int cash = getInputFir();

//        List<Integer> numbers = getInputSec();



    }

    private static int getInputFir() {
        int processedCash = 0;

        while (true){
            System.out.println("구입금액을 입력해 주세요.");
            try{
                String cashStr = Console.readLine();
                processedCash = validInputOne(cashStr);
                break;
            }

            catch(IllegalArgumentException e){
                System.out.println("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
            }
        }

        return processedCash;
    }

    private static int validInputOne(String cashStr){
        try{
            int tempCash = 0;
            tempCash = Integer.parseInt(cashStr);

            if (tempCash % 1000 != 0) {
                throw new IllegalArgumentException();
            }

            return tempCash;
        }
        catch(Exception e){
            throw new IllegalArgumentException();
        }
    }

}
