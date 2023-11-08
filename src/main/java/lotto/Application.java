package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
public class Application {
    public static void main(String[] args) {
        //가격 입력
        int amount = CheckAmountLotto();
        ArrayList<Lotto> lottoList = BuyLotto(amount);
        ArrayList<Integer> prize = ResultLotto();

        LottoStats(lottoList, prize);
    }

    public static void LottoStats(ArrayList<Lotto> lottoList, ArrayList<Integer> prize) {

    }
    public static ArrayList<Integer> ResultLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String lottoNumString = Console.readLine();
        String[] lottoNumArray = lottoNumString.split(",");

        int bonusNumber = Integer.parseInt(Console.readLine());

        ArrayList<Integer> prize = new ArrayList<>();

        for(String s : lottoNumArray) {
            prize.add(Integer.parseInt(s));
        }
        prize.add(bonusNumber);

        return prize;
    }

    public static ArrayList<Lotto> BuyLotto(int amountLotto) {
        int realAmount = amountLotto / 1000;
        System.out.println("\n" + realAmount+ "개를 구매했습니다.");

        ArrayList<Lotto> lottoList = new ArrayList<>();

        RandomLotto(realAmount, lottoList);

        return lottoList;
    }

    public static void RandomLotto(int realAmount, ArrayList<Lotto> lottoList) {
        try {
            for(int i=0; i<realAmount; i++) {
                //한 횟수당 랜덤하게 6개씩 뽑을 것
                List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45,6);
                Collections.sort(numbers);
                CheckNumbers(numbers);

                Lotto lottoInstance = new Lotto(numbers);
                lottoInstance.printNumbers();
                lottoList.add(lottoInstance);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."+ e.getMessage());
        }
    }

    public static void CheckNumbers(List<Integer> numbers) {
        for(int num: numbers) {
            if(num < 1 || num > 45) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static int CheckAmountLotto() {
        boolean validInput = false;
        int amountLotto = 0;

        while(!validInput) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                amountLotto = Integer.parseInt(Console.readLine());
                if(amountLotto % 1000 != 0) {
                    throw new IllegalArgumentException();
                }

                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println("\n[ERROR] 구입 금액은 1000원 단위여야 합니다.");
            }
        }
        return amountLotto;
    }
}
