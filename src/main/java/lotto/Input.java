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
                buyPriceAmountStringCheck(input);

                priceAmount = Integer.parseInt(input);
                priceAmountVaildation(priceAmount);

                System.out.println();
                return priceAmount;
        }
        /**
         * 로또 구매 수량에 String이 있는지 판별
         * @param priceAmount
         */

        public static void buyPriceAmountStringCheck(String priceAmount) {
                if (!priceAmount.matches("\\d+")) {
                        System.out.print("[ERROR] 구입 금액은 숫자만 입력해주세요.");
                        throw new NoSuchElementException();
                } 
        }

        /**
         * 입력값이 1000의 단위로 나누어 떨어져야합니다.
         * @param priceAmount
         * @return 입력값의 유효값 결과를 return
         */
        private static void priceAmountVaildation(int priceAmount) {
                if (priceAmount == 0 || priceAmount % 1000 != 0) {
                        System.out.print("[ERROR] 입력값은 1000원 단위여야 합니다.");
                        throw new IllegalArgumentException();
                }
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
                numberInRangeCheck(bonusNumber);
                bonusNumberDuplicateCheck(winningNumbers, bonusNumber);
                System.out.println();
                return bonusNumber;
        }

        /**
         * 로또 번호가 범위 안에 있는지 검사합니다.
         * @param number
         */
        public static void numberInRangeCheck(int number) {
                if (0 >= number || number >= 46) {
                    System.out.println("[ERROR] 1부터 45까지의 숫자를 입력해주시요.");
                    throw new IllegalArgumentException();
                }
        }

        /**
         * 보너스 번호가 중복되엇는지 테스트 합니다.
         * @param winningNumbers
         * @param bonusNumber
         */
        public static void bonusNumberDuplicateCheck(Lotto winningNumbers, int bonusNumber) {
                for (Integer num : winningNumbers.getWinningNumbers()) {
                    if (num == bonusNumber) {
                            System.out.println("[ERROR] 보너스 번호는 당첨번호와 중복 될 수 없습니다.");
                            throw new IllegalStateException();
                    }
                }
        }

}

