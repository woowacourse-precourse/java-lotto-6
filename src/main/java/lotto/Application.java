package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    public enum Prize {
        THIRD_PRIZE(3, 5000, false, "3개 일치 (5,000원)"),
        FOURTH_PRIZE(4, 50000, false, "4개 일치 (50,000원)"),
        FIFTH_PRIZE(5, 1500000, false, "5개 일치 (1,500,000원)"),
        FIFTH_PRIZE_WITH_BONUS(5, 30000000, true, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
        SIXTH_PRIZE(6, 2000000000, false, "6개 일치 (2,000,000,000원)");

        private final int matNums;
        private final int prizeMoney;
        private final boolean isBonus;
        private final String resultFormat;

        Prize(int matNums, int prizeMoney, boolean isBonus, String resultFormat) {
            this.matNums = matNums;
            this.prizeMoney = prizeMoney;
            this.isBonus = isBonus;
            this.resultFormat = resultFormat;
        }

        public int getMatNums() {
            return matNums;
        }

        public int getPrizeMoney() {
            return prizeMoney;
        }

        public boolean isBonus() {
            return isBonus;
        }

        public String getResultFormat() {
            return resultFormat;
        }
    }


    public static List<Integer> winLottoNum(int num) {

        System.out.println("당첨 번호를 입력해 주세요.");
        List<String> lottoNumsStr = List.of(readLine().split(","));

        //int형 배열 생성
        List<Integer> lottoNums = new ArrayList<>(6);
        for (int i = 0; i < lottoNumsStr.size(); i++) {
            lottoNums.add(Integer.parseInt(lottoNumsStr.get(i)));
        }

        if (lottoNums.size() != 6) {
            throw new IllegalArgumentException("[Error] 6개의 숫자를 입력하세요.");
        }
        return lottoNums;
    }

    public static List<Integer> lottoNums(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> sortedList = new ArrayList<>(numbers);

        // 리스트를 오름차순으로 정렬합니다.
        Collections.sort(sortedList);
//        Collections.sort(numbers);
        return sortedList;
    }


    public static int bonusNum() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusStr = readLine();
        int bonus = Integer.parseInt(bonusStr);

        return bonus;
    }

    //로또 번호 당첨 개수 확인 메서드
    public static int cntLottoNums(List<Integer> lottoNums, List<Integer> winNums) {
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
    public static String checkResults(List<Integer> results, List<Boolean> hasBonus, int num) {
        System.out.println("당첨 통계");
        System.out.println("---");
        StringBuilder resultBuilder = new StringBuilder();
        DecimalFormat decimalFormat = new DecimalFormat("#,###");

        double totalPrize = 0;
        for (Prize prize : Prize.values()) {
            int count = 0;
            int bonusCnt = 0;
            int matNums = prize.getMatNums();
            int prizeAmount = prize.getPrizeMoney();
            boolean bonus = prize.isBonus();
            String resultFormat = prize.getResultFormat();

            // 숫자 포맷을 정의
            String formattedNum = decimalFormat.format(prizeAmount);
            if (results.contains(matNums) && matNums != 5) {
                count++;
            }

            String result = resultFormat.replaceFirst("\\(0원\\)", "(" + formattedNum + "원)");

            result += " - " + count + "개";

            //보너스 볼 통계
            if (results.contains(5) && bonus && hasBonus.contains(true)) {
                count = 0;
                bonusCnt++;
                result = resultFormat.replaceFirst("\\(0원\\)", "(" + formattedNum + "원)");
                result += " - " + bonusCnt + "개";
                totalPrize += prizeAmount * bonusCnt;
            }

            totalPrize += prizeAmount * count;

            resultBuilder.append(result).append("\n");
        }
        double rate = (totalPrize / (num * 1000)) * 100;
        resultBuilder.append("총 수익률은 " + rate + "%입니다.");

        return resultBuilder.toString();
    }

    public static int inputMoney() {
        //로또 구매금액 입력
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                int lottoInput = Integer.parseInt(readLine());
                if (lottoInput % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력하세요.");
                }
                int num = lottoInput / 1000;
                System.out.println(num + "개를 구매했습니다.");
                return num;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효한 숫자를 입력하세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }



    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int num = inputMoney();
        List<Integer> winNums = winLottoNum(num);
        int bonus = bonusNum();
        List<Integer> results = new ArrayList<>();
        List<Boolean> hasBonus = new ArrayList<>();
        for (int ticket = 0; ticket < num; ticket++) {
            List lottoNumbers = lottoNums();
            int matchedNums = cntLottoNums(lottoNumbers, winNums);
            boolean hasBonusNum = matchingBonus(lottoNumbers, bonus);
            results.add(matchedNums);
            hasBonus.add(hasBonusNum);
//            System.out.println(matchedNums + "개 일치");
//            System.out.println(hasBonusNum + "보너스?");
            System.out.println(lottoNumbers.toString());
        }
//        System.out.println("결과");
//        System.out.println(results.toString());
//        System.out.println(bonusResults.toString());
//        System.out.println(checkResults(results, bonusResults));
        System.out.println(checkResults(results, hasBonus, num));


    }
}
