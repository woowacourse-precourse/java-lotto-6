package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Get {
    public static List<Integer> convert(String [] tempStr){
        int[] tempInt = Stream.of(tempStr).mapToInt(Integer::parseInt).toArray();
        return Arrays.stream(tempInt).boxed().collect(Collectors.toList());
    }
    public static List<Integer> winningNumber(){ return convert(readLine().split(",")); }
    public static int purchasePrice() {
        int purchasePrice = 0;
        while (true) {
            try {
                Print.message(0);
                purchasePrice = Integer.parseInt(readLine());;
                if (purchasePrice % 1000 != 0) { throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위만 가능합니다.");}
                else { break; }
            }
            catch (NumberFormatException e) { System.out.println("[ERROR] 구매 금액은 숫자로만 입력해주세요."); }
            catch (IllegalArgumentException e) { System.out.println(e.getMessage()); }
        }
        return purchasePrice;
    }
    public static int bonusNumber(Lotto winningLottoNumber){
        int bonusNumber = 0;
        while(true){
            Print.message(3);
            bonusNumber = Integer.parseInt(readLine());;
            try{
                if (bonusNumber > 45 || bonusNumber < 1) {
                    throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                }
                if (winningLottoNumber.getter().contains(bonusNumber)) {
                    throw new IllegalArgumentException("[ERROR] 로또 번호는 중복 되지 않는 숫자로만 구성되어야 합니다.");
                } else { break; }
            } catch (IllegalArgumentException e) { System.out.println(e.getMessage()); }
        }
        return bonusNumber;
    }
}
