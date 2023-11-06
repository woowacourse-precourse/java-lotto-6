package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    public enum Prize {
        NO_PRIZE(0, 0, false),
        THIRD_PRIZE(3, 5000, false),
        FOURTH_PRIZE(4, 50000, false),
        FIFTH_PRIZE(5, 1500000, false),
        FIFTH_PRIZE_WITH_BONUS(5, 30000000, true),
        SIXTH_PRIZE(6, 2000000000, false);

        private final int matNums;
        private final int amountMoney;
        private final boolean isBonus;

        Prize(int matNums, int amountMoney, boolean isBonus) {
            this.matNums = matNums;
            this.amountMoney = amountMoney;
            this.isBonus = isBonus;
        }

        public int getMatNums() {
            return matNums;
        }

        public int getAmountMoney() {
            return amountMoney;
        }

        public boolean isBonus() {
            return isBonus;
        }
    }


    public static int[] winLottoNum(int num) {

        System.out.println("당첨 번호를 입력해 주세요.");
        String[] lottoNumsStr = readLine().split(",");

        //int형 배열 생성
        int[] lottoNums = new int[lottoNumsStr.length];
        for (int i = 0; i < lottoNumsStr.length; i++) {
            lottoNums[i] = Integer.parseInt(lottoNumsStr[i]);
        }

        if (lottoNums.length != 6) {
            throw new IllegalArgumentException("[Error] 6개의 숫자를 입력하세요.");
        }
        return lottoNums;
    }

    public static List<Integer> lottoNums(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }


    public static int bonusNum() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusStr = readLine();
        int bonus = Integer.parseInt(bonusStr);

        return bonus;
    }

    //로또 번호 당첨 개수 확인 메서드
    public static int cntLottoNums(List<Integer> lottoNums, int[] winNums) {
        int cnt = 0;
        for (int num1 : lottoNums) {
            for (int num2 : winNums) {
                if (num1 == num2) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    // 보너스 번호 당첨 확인 메서드
    public static boolean matchingBonus(List<Integer> lottoNums, int bonus) {
        for (int i : lottoNums) {
            if (i == bonus) {
                return true;
            }
        }
        return false;
    }

    // 결과 통계 확인 메서드
    public static String checkResults(int[] results, boolean hasBonus){
        System.out.println("당첨 통계");
        System.out.println("---");
        String totals = null;

        for (Prize prize : Prize.values()) {
            int matNums = prize.getMatNums();
            int prizeAmount = prize.getAmountMoney();
            int count = results[matNums];

            if (count > 0) {
                totals = matNums + "개 일치 (" + prizeAmount + "원) - " + count + "개";
            }
        }
        return totals;
    }

    public static int inputMoney() {
        // 1. lotto input
        System.out.println("구입금액을 입력해 주세요.");

        int lottoInput = Integer.parseInt(readLine());
        if(lottoInput % 1000 != 0) {
            new IllegalArgumentException("[Error] 1,000원 단위로 입력하세요.");
        }
        int num = lottoInput / 1000;
        System.out.println(num + "개를 구매했습니다.");
        return num;
    }



    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int num = inputMoney();
        int[] winNums = winLottoNum(num);
        int bonus = bonusNum();
        List<Integer> results = new ArrayList<>();
        List<Boolean> bonusResults = new ArrayList<>();
        for (int ticket = 0; ticket < num; ticket++) {
            List lottoNumbers = lottoNums();
            int matchedNums = cntLottoNums(lottoNumbers, winNums);
            boolean hasBonusNum = matchingBonus(lottoNumbers, bonus);
            results.add(matchedNums);
            bonusResults.add(hasBonusNum);
            System.out.println(matchedNums + "개 일치");
            System.out.println(hasBonusNum + "보너스?");
            System.out.println(lottoNumbers.toString());
            System.out.println("결과:" + checkResults(winNums, hasBonusNum));
        }
        System.out.println("결과");
        System.out.println(results.toString());
        System.out.println(bonusResults.toString());



    }
}
