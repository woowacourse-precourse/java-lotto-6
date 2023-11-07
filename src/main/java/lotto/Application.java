package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        final int LOTTO_NUMBERS = 6;
        // TODO: 프로그램 구현
        boolean validInput = false;
        int buyMoney = 0;

        //구입 금액 입력
        while (!validInput) {
            try {
                System.out.println("구입 금액을 입력해 주세요.");
                buyMoney = getInt();
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 정수 금액을 입력해 주세요.");
            }
        }
        System.out.println();
        //금액을 바탕으로 로또 개수 몇개인지 구함
        int number = moneyToLottoNumber(buyMoney);
        System.out.println(number + "개를 구매했습니다.");

        //로또 객체 생성후, 랜덤 값 할당
        List<Lotto> lottoList = new ArrayList<>();
        lottoToList(number, lottoList);

        //로또 출력
        printLottoNumberList(lottoList);

        //당첨 번호 입력
        validInput = false;
        String winNumbersString = null;
        List<Integer> winNumbersList = null;
        while (!validInput) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                winNumbersString = getString();
                winNumbersList = new ArrayList<>();
                fillWinNumbersList(winNumbersString, winNumbersList);
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }

        //보너스 번호 입력
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = getInt();

        //결과 객체 생성 및 초기화
        Result[] resultList = new Result[number];
        for (int i = 0; i < resultList.length; i++) {
            resultList[i] = new Result();
        }

        //당첨번호와 내가 산 로또 번호 비교
        compareLotto(lottoList, winNumbersList, resultList);
        int targetValue = 5;
        List<Integer> indexOf5 = new ArrayList<>();

        //5개가 일치할때는 보너스 볼이 일치하는지까지 확인
        checkIf5NumIsSame(resultList, targetValue, indexOf5);
        checkBonusNumber(indexOf5, lottoList, bonusNumber, resultList);

        //몇개가 일치하는지 확인
        int[] resultNumbers = new int[5];
        fillResult(resultNumbers, resultList);

        //수익률 계산
        int benefit = calculateBenefit(resultNumbers);
        double benefitRatio = (double) benefit / buyMoney * 100;

        //당첨 통계 출력
        printStatus(resultNumbers, benefitRatio);
    }

    private static void printStatus(int[] resultNumbers, double benefitRatio) {
        System.out.println("당첨 통계");
        System.out.println("3개 일치 (5,000원) - " + resultNumbers[0] + "개");
        System.out.println("4개 일치 (50,000원) - " + resultNumbers[1] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + resultNumbers[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + resultNumbers[3] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + resultNumbers[4] + "개");
        System.out.printf("총 수익률은 %.1f%%입니다.", benefitRatio);
    }

    private static int calculateBenefit(int[] resultNumbers) {
        return 5_000 * resultNumbers[0] + 50_000 * resultNumbers[1] + 1_500_000 * resultNumbers[2]
                + 30_000_000 * resultNumbers[3] + 2_000_000_000 * resultNumbers[4];
    }

    private static void fillResult(int[] resultNumbers, Result[] resultList) {
        resultNumbers[0] = checkNumbers(3, false, resultList);
        resultNumbers[1] = checkNumbers(4, false, resultList);
        resultNumbers[2] = checkNumbers(5, false, resultList);
        resultNumbers[3] = checkNumbers(5, true, resultList);
        resultNumbers[4] = checkNumbers(6, false, resultList);
    }

    private static void printLottoNumberList(List<Lotto> lottoList) {
        for (int i = 0; i < lottoList.size(); i++) {
            System.out.println(lottoList.get(i).getNumbers());
        }
    }

    private static int checkNumbers(int num, boolean isTrue, Result[] resultList) {
        int count = 0;
        for (int i = 0; i < resultList.length; i++) {
            if (resultList[i].getSameNumber() == num) {
                count = checkBoolean(isTrue, resultList, i, count);
            }
        }
        return count;
    }

    private static int checkBoolean(boolean isTrue, Result[] resultList, int i, int count) {
        if (resultList[i].isBonusNum() == isTrue) {
            count++;
        }
        return count;
    }

    private static void checkBonusNumber(List<Integer> indexOf5, List<Lotto> lottoList, int bonusNumber,
                                         Result[] resultList) {
        for (int i = 0; i < indexOf5.size(); i++) {
            boolean bonusNumSame = lottoList.get(indexOf5.get(i)).isNumInList(bonusNumber);
            resultList[i].setBonusNum(bonusNumSame);
        }
    }

    private static void checkIf5NumIsSame(Result[] resultList, int targetValue, List<Integer> indexOf5) {
        for (int i = 0; i < resultList.length; i++) {
            if (resultList[i].getSameNumber() == targetValue) {
                indexOf5.add(i);
            }
        }
    }

    private static void compareLotto(List<Lotto> lottoList, List<Integer> winNumbersList, Result[] resultList) {
        for (int j = 0; j < lottoList.size(); j++) {
            compareOneNumber(winNumbersList, lottoList, j, resultList);
        }
    }

    private static void compareOneNumber(List<Integer> winNumbersList, List<Lotto> lottoList, int j,
                                         Result[] resultList) {
        for (int i = 0; i < 6; i++) {
            boolean isIn = compareNum(winNumbersList.get(i), lottoList.get(j));
            if (isIn) {
                resultList[j].addNum();
            }
        }
    }

    private static boolean compareNum(int number, Lotto lotto) {
        return lotto.isNumInList(number);
    }

    private static void fillWinNumbersList(String winNumbersString, List<Integer> winNumbersList) {
        String[] numbers = winNumbersString.split(",");
        for (String numberStr : numbers) {
            try {
                int tmp = Integer.parseInt(numberStr);
                checkInvalid(tmp);
                winNumbersList.add(tmp);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 올바르지 않은 숫자 형식: " + numberStr);
            }
        }
    }

    private static void checkInvalid(int tmp) {
        if (tmp < 1 || tmp > 45) {
            throw new IllegalArgumentException();
        }
    }

    private static void lottoToList(int number, List<Lotto> lottoList) {
        for (int i = 0; i < number; i++) {
            Lotto tmp = new Lotto(getNumbers());
            lottoList.add(tmp);
        }
    }

    private static List<Integer> getNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private static String getString() {
        return Console.readLine();
    }

    private static int getInt() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private static int moneyToLottoNumber(int buyMoney) {
        return buyMoney / 1000;
    }
}
