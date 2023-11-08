package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.text.DecimalFormat;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
    private final List<List<Integer>> numbers = new ArrayList<>(); //로또 번호 리스트의 집합
    private int money; //로또 구매 금액
    private List<Integer> select_numbers = new ArrayList<>(); //사용자가 입력한 당첨 번호
    private final int[] ranking = new int[8]; //로또 번호 당첨 횟수 기록용

    public Lotto() { }

    //예외처리 1.로또 번호 개수, 2.로또 번호 중복 여부
    public Lotto(List<Integer> integers) {
        if (integers.size() != 7) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 개수는 7개어야 합니다.");
        }

        Set<Integer> numberSet = new HashSet<>();
        for (Integer num : integers) {
            if (numberSet.contains(num)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
            }
            numberSet.add(num);
        }

        select_numbers = new ArrayList<>(numberSet);
    }
    private void setNumbers() {
        for (int i = 0; i < money / 1000; i++) {
            numbers.add(getNumbers()); //하단 구현
        }
    }

    //예외처리 3.로또 번호 개수(사용자가 입력한 당첨 번호에 대하여), 4.중복 검사(이하동문)
    private void validate() {
        if (select_numbers.size() != 7) {
            System.out.println("[ERROR] 로또 번호 개수는 7개어야 합니다.");
            throw new IllegalArgumentException();
        }

        for (Integer number : select_numbers) {
            if (number > 45 || number < 1) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                throw new IllegalArgumentException();
            }
        }
    }

    //사용자로부터 구입금액을 받는다. while을 이용해, 예외가 발생하면 다시 입력을 받도록 한다.
    //예외처리 5.구입금액이 1000으로 나누어떨어지지 않는 경우, 6.잘못된 금액일 경우(ex: 1000j)
    private void getMoney() {
        String input;
        boolean validInput = false;

        while (!validInput) {
            System.out.println("구입 금액을 입력해 주세요.");
            input = Console.readLine();

            try {
                money = Integer.parseInt(input);
                System.out.println(money);

                if (money % 1000 != 0) {
                    System.out.println("[ERROR] 로또 금액을 잘못 입력하였습니다.");
                    throw new IllegalArgumentException();
                }

                System.out.printf("\n%d개를 구매했습니다.\n", money / 1000);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 올바르지 않은 입력입니다.");
            }
        }
    }

    //numbers 리스트에 저장된 로또 번호를 화면에 출력
    private void viewNumbers() {
        for (List<Integer> number : numbers) {
            System.out.println(number);
        }
    }

    //번호 가져오기
    private List<Integer> getNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    //사용자가 입력하는 당첨 번호와 보너스 번호를 입력받는다
    private void getSelectNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        select_numbers = Stream.of(Console.readLine().split(",")).map(Integer::parseInt).collect(Collectors.toList());
        //System.out.println(select_numbers); 문자열로 출력하도록 수정
        System.out.println(select_numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ")));

        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonus = Integer.parseInt(Console.readLine());
        System.out.println(bonus);
        select_numbers.add(bonus);
        validate(); //유효한가?검사한다
    }

    //구매한 로또 티켓을 모두 검사하여 각 티켓의 당첨 여부를 판단하고, 그 결과를 ranking 배열에 반영
    private void extract() {
        for (List<Integer> number : numbers) {
            checkLottoNumbers(number); //하단 구현
        }
    }

    //구매한 로또 티켓의 번호와 사용자가 선택한 번호를 비교하여 일치하는 숫자의 개수를 계산하고, 이를 기반으로 당첨 여부를 판단
    private void checkLottoNumbers(List<Integer> number) {
        int correctLottoNumbers = 0; //사용자가 선택한 번호와 로또 번호 중 일치하는 숫자의 개수

        for (int i = 0; i < 6; i++) {
            //각 숫자가 select_numbers에 있는지 확인. 일치하는 숫자를 찾으면 correctLottoNumbers 값을 증가
            if (select_numbers.contains(number.get(i))) {
                correctLottoNumbers++;
            }
        }

        //correctLottoNumbers가 5와 같고, 로또 번호 리스트 number가 사용자가 선택한 번호 리스트 select_numbers의 7번째 숫자를 포함하면
        // 이 로또 티켓은 2등(5개 일치 및 보너스 볼 일치)에 해당하므로, ranking 배열의 첫 번째 요소(ranking[0])를 증가
        if (correctLottoNumbers == 5 && number.contains(select_numbers.get(6))) {
            ranking[0]++; // 2등.
        }
        //그렇지 않은 경우(2등이 아닌 경우)
        // ranking 배열의 적절한 위치(ranking[5 - correctLottoNumbers])를 찾아서 해당 위치의 값을 증가
        else {
            ranking[5 - correctLottoNumbers]++;
        }
    }

    //로또 번호 추첨 결과에 대한 통계를 계산하고 화면에 출력
    public void lottoResult() {
        System.out.println("\n당첨 통계\n---");

        int[] prizeAmounts = {5000, 50000, 1500000, 30000000, 2000000000}; //당첨번호에 따른 상금
        String[] prizeNames = {"3개 일치 (5,000원)", "4개 일치 (50,000원)", "5개 일치 (1,500,000원)", "5개 일치, 보너스 볼 일치 (30,000,000원)", "6개 일치 (2,000,000,000원)"};
        int[] matchedCounts = new int[5]; //각 상금 당첨 횟수를 기록
        //인덱스 0은 3개 일치, 인덱스 1은 4개 일치, 그리고 인덱스 2는 5개 일치, 인덱스 3은 5개 일치 및 보너스 볼 일치, 인덱스 4는 6개 일치
        int totalPrize = 0; //총상금

        for (List<Integer> number : numbers) {
            int correctNumbers = 0; //사용자가 선택한 번호와 일치하는 로또 번호의 개수를 추적
            int bonusCorrect = 0; //보너스 번호까지 일치하는 경우를 추적

            //로또 번호(number)에서 6개의 숫자를 가져와서 사용자가 선택한 번호(select_numbers)와 비교하여
            // 일치하는 숫자의 개수를 correctNumbers에 더해준다
            for (int i = 0; i < 6; i++) {
                if (select_numbers.contains(number.get(i))) {
                    correctNumbers++;
                }
            }

            //5개의 일치와 보너스 볼 일치하는 경우라면 bonusCorrect를 1로 설정
            if (correctNumbers == 5 && number.contains(select_numbers.get(6))) {
                bonusCorrect = 1;
            }

            int totalCorrect = correctNumbers + bonusCorrect;
            //3개 이상 일치해야 상금이 있는 경우로 고려되므로, 3 이상일 때만 아래의 작업을 수행한다.
            if (totalCorrect >= 3) {
                matchedCounts[totalCorrect - 3]++; //matchedCounts 배열의 해당하는 위치에 당첨 횟수를 증가
            }
        }

        for (int i = 0; i < matchedCounts.length; i++) {
            System.out.printf("%s - %d개\n", prizeNames[i], matchedCounts[i]);
            totalPrize += matchedCounts[i] * prizeAmounts[i]; //각 등수별로 해당 횟수와 상금을 곱하여 상금 계산 후 totalPrize에 더한다
        }

        //수익률을 계산한다
        float profitRate = (float) (((float) totalPrize / (money / 1000)) * 100 * 0.001);

        // DecimalFormat을 사용하여 소수점 둘째 자리에서 반올림
        DecimalFormat df = new DecimalFormat("#0.0");
        float roundedProfitRate = Float.parseFloat(df.format(profitRate));
        System.out.println("총 수익률은 " + df.format(roundedProfitRate) + "%입니다.");
    }

    //최종적으로 모든 함수를 여기서 집약한다! (Application을 가볍게 만들기)
    void play() {
        getMoney(); // 구입 금액 입력
        setNumbers(); // 로또 번호 랜덤 추첨
        viewNumbers(); // 로또 구매 결과 출력
        getSelectNumbers(); // 당첨, 보너스 번호 입력
        extract(); // 로또 번호 추첨
        lottoResult(); // 결과 출력
    }
}
