package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Application {
    public static void main(String[] args) {
        //가격 입력
        int amount = CheckAmountLotto();
        ArrayList<Lotto> lottoList = BuyLotto(amount);
        ArrayList<Integer> prize = ResultLotto();
        int bonusNum = getBonusNumber();

        LottoStats(lottoList, prize, bonusNum, amount);
    }

    public static int getBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());

        return bonusNumber;
    }

    public static void LottoStats(ArrayList<Lotto> lottoList, ArrayList<Integer> prize, int bonusNum, int amount) {
        System.out.println("\n당첨 통계\n---");

        ArrayList<Integer> matchArray = new ArrayList<>();

        for(Lotto l: lottoList) {
            int match = 0;

            List<Integer> lotto = l.getNumbers();

            //일반 번호 확인
            for(Integer i : lotto) {
                if(prize.contains(i)) {
                    match = match+1;
                }
            }

            //보너스 번호 확인
            if(match == 5 && lotto.contains(bonusNum)) {
                matchArray.add(7);
            }
            else {
                matchArray.add(match);
            }
        }

        long match3 = Collections.frequency(matchArray,3);
        long match4 = Collections.frequency(matchArray,4);
        long match5 = Collections.frequency(matchArray,5);
        long match6= Collections.frequency(matchArray,6);
        long matchBonus = Collections.frequency(matchArray,7);

        System.out.println("3개 일치 (5,000원) - "+match3 + "개");
        System.out.println("4개 일치 (50,000원) - "+ match4 + "개");
        System.out.println("5개 일치 (1,500,000원) - "+ match5 + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+ matchBonus+ "개");
        System.out.println("6개 일치 (2,000,000,000원) - "+ match6+ "개");

        long profit = match3*5000 + match4 * 50000+ match5 *1500000 + matchBonus* 30000000 + match6*2000000000;


        System.out.printf("총 수익률은 %.1f%%입니다.", (double)((profit- amount)/amount)*100);

        //LottoResult();
    }

//    public static void LottoResult() {
//
//    }
    public static ArrayList<Integer> ResultLotto() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String lottoNumString = Console.readLine();
        String[] lottoNumArray = lottoNumString.split(",");

        ArrayList<Integer> prize = new ArrayList<>();

        for(String s : lottoNumArray) {
            prize.add(Integer.parseInt(s));
        }
        Collections.sort(prize);
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
        } catch(IllegalArgumentException e) {
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
