package lotto;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import camp.nextstep.edu.missionutils.Console;

public class Input {

    public int priceAmountInput() {
        int priceAmount;

        System.out.println("구입금액을 입력해 주세요.");
        priceAmount = Integer.parseInt(Console.readLine());
        if (!priceAmountVaildation(priceAmount)) {
            throw new IllegalArgumentException("[ERROR] 입력값은 1000원 단위여야 합니다.");
        }

        return priceAmount;
    }

    /**
     * 입력값이 1000의 단위로 나누어 떨어져야합니다.
     * @param priceAmount
     * @return 입력값의 유효값 결과를 return
     */
    private boolean priceAmountVaildation(int priceAmount) {
        if (priceAmount % 1000 == 0) 
            return true;
        
        return false;
    }

    /**
     * 당첨 번호와 보너스 번호를 입력받아 Lotto 객체를 생성합니다.
     * @return Lotto 객체 
     */
    public Lotto winningNumberInput() {
        ArrayList<Integer> winningNumber = new ArrayList<Integer>();
        
        System.out.println("당첨 번호를 입력해 주세요.");
        StringTokenizer st = new StringTokenizer(Console.readLine(), ",");
        while (st.hasMoreTokens()) {
            int input = Integer.parseInt(st.nextToken());
            winningNumber.add(input);
        }

        
        return new Lotto(winningNumber);
    } 

    /**
     * 보너스 번호 입력 
     * @return 보너스 번호
     */
    public int bonusNumberInput() {
        System.out.println("\n" + "보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());

        return bonusNumber;
    }

}

