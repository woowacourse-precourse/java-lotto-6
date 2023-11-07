package lotto;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import camp.nextstep.edu.missionutils.Console;

public class Input {

    /**
     * 구매할 로또 금액을 입력 받습니다.
     * @return 로또 금액 
     */
    public static int priceAmountInput() {
        int priceAmount = 0;

        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        if (!input.matches("\\d+")) {
            System.out.print("[ERROR]");
            throw new NoSuchElementException("구입 금액은 숫자만 입력해주세요.");
        } 
        priceAmount = Integer.parseInt(input);
       
        if (!priceAmountVaildation(priceAmount)) {
            System.out.print("[ERROR]");
            throw new IllegalArgumentException("입력값은 1000원 단위여야 합니다.");
        }


        System.out.println();
        return priceAmount;
    }

    /**
     * 입력값이 1000의 단위로 나누어 떨어져야합니다.
     * @param priceAmount
     * @return 입력값의 유효값 결과를 return
     */
    private static boolean priceAmountVaildation(int priceAmount) {
        if (priceAmount != 0 || priceAmount % 1000 == 0) 
            return true;
        
        return false;
    }

    /**
     * 당첨 번호와 보너스 번호를 입력받아 Lotto 객체를 생성합니다.
     * @return Lotto 객체 
     */
    public static Lotto winningNumberInput() {
        ArrayList<Integer> winningNumber = new ArrayList<Integer>();
        
        System.out.println("당첨 번호를 입력해 주세요.");
        StringTokenizer st = new StringTokenizer(Console.readLine(), ",");
        while (st.hasMoreTokens()) {
            int input = Integer.parseInt(st.nextToken());
            if (numberRangeCheck(input)) {
                System.out.print("[ERROR]");
                throw new IllegalArgumentException("1부터 45까지의 숫자를 입력해주시요.");
            }
            
            winningNumber.add(input);
        }

        return new Lotto(winningNumber);
    } 

    /**
     * 보너스 번호 입력 
     * @return 보너스 번호
     */
    public static int bonusNumberInput(Lotto winningNumbers) {
        System.out.println("\n" + "보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        if (numberRangeCheck(bonusNumber)) {
            System.out.print("[ERROR]");
            throw new IllegalArgumentException("1부터 45까지의 숫자를 입력해주시요.");
        }
        if (bonusNumberDuplicateCheck(winningNumbers, bonusNumber)) {
            System.out.print("[ERROR]");
            throw new IllegalArgumentException("보너스 숫자는 로또 번호와 중복될 수 없습니다.");
        }
        System.out.println();
        return bonusNumber;
    }

    public static boolean numberRangeCheck(int number) {
        if (1 <= number && number >= 45) 
            return false;
        
        return true;
    }

    public static boolean bonusNumberDuplicateCheck(Lotto winningNumbers, int bonusNumber) {
        for (Integer num : winningNumbers.getWinningNumbers()) {
            if (num == bonusNumber)
                return true;
        }
        return false;
    }

}

