package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    private static int count = 0;

    public static void main(String[] args) {
        // 입력 메소드 실행
        int purchaseMoney = purchaseMoney();
        List<Lotto> lottoNumbers = createLottoNumbers();
        List<Integer> winNumbers = winNumber();
        int addNum = addNum();

        System.out.println(purchaseMoney);
        System.out.println(lottoNumbers);
        System.out.println(winNumbers);
        System.out.println(addNum);

        for (int i = 0; i < lottoNumbers.size(); i++){
            Lotto lotto = lottoNumbers.get(i);

            for(int j = 0; j < lotto.getNumbers().size(); j++){
                System.out.print(lotto.getNumbers().get(j) + " ");
            }
            System.out.println();
        }
    }

    // 로또 구입 금액 입력
    public static int purchaseMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        int input = Integer.parseInt(readLine());
        count = input / 1000;
        System.out.println();
        return input;
    }

    // 당첨 번호 입력
    public static List<Integer> winNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = readLine();

        List<Integer> numbers = new ArrayList<>();
        List<String> strNumbers = Arrays.asList(input.split(","));

        for(int i = 0; i < strNumbers.size(); i++){
            numbers.add(Integer.parseInt(strNumbers.get(i)));
        }

        System.out.println();

        return numbers;
    }

    // 보너스 번호 입력
    public static int addNum(){
        System.out.println("보너스 번호를 입력해 주세요.");
        int input = Integer.parseInt(readLine());

        System.out.println();

        return input;
    }

    // 로또 번호 출력
    private static List<Lotto> createLottoNumbers() {
        System.out.println(count + "개를 구매했습니다.");
        List<Lotto> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> randomList = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(randomList);
            Lotto lotto = new Lotto(randomList);
            lotto.printNumber(randomList);
            list.add(lotto);
        }

        System.out.println();

        return list;
    }

}
