package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        final int LOTTO_NUMBERS = 6;
        // TODO: 프로그램 구현
        System.out.println("구입 금액을 입력해 주세요.");
        int buyMoney = getInt();
        int number = moneyToLottoNumber(buyMoney);
        System.out.println(number + "개를 구매했습니다");
        List<Lotto> lottoList = new ArrayList<>();
        lottoToList(number, lottoList);
        System.out.println("당첨 번호를 입력해 주세요.");
        String winNumbersString = getString();

        List<Integer> winNumbersList = new ArrayList<>();
        fillWinNumbersList(winNumbersString, winNumbersList);
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = getInt();
        int[] resultList = new int[number];

        compareLotto(lottoList, winNumbersList, resultList);

    }

    private static void compareLotto(List<Lotto> lottoList, List<Integer> winNumbersList, int[] resultList) {
        for (int j = 0; j < lottoList.size(); j++) {
            compareOneNumber(winNumbersList, lottoList, j, resultList);
        }
    }

    private static void compareOneNumber(List<Integer> winNumbersList, List<Lotto> lottoList, int j,
                                         int[] resultList) {
        for (int i = 0; i < 6; i++) {
            boolean isIn = compareNum(winNumbersList.get(i), lottoList.get(j));
            if (isIn) {
                resultList[j]++;
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
                Integer tmp = Integer.parseInt(numberStr);
                winNumbersList.add(tmp);
            } catch (NumberFormatException e) {
                // 변환 중에 오류가 발생하면 처리할 수 있음
                System.out.println("올바르지 않은 숫자 형식: " + numberStr);
            }
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
        return Integer.parseInt(Console.readLine());
    }

    private static int moneyToLottoNumber(int buyMoney) {
        return buyMoney / 1000;
    }
}
