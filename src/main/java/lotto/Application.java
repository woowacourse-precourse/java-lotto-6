package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.internal.configuration.GlobalConfiguration.validate;

public class Application {
    private final List<List<Integer>> numbers = new ArrayList<>();
    private List<Integer> input_numbers = new ArrayList<>();
    private final int[] ranking = new int[8];
    int total_price;
    public static void main(String[] args) {
        // TODO: 프로그램 구현

//        Lotto lotto = new Lotto();
//
//        lotto.Play();
    }

        public void inputPrice() {
            final int money = 1000;
            int count;
            int total_price;
            String price = Console.readLine();

            while (true) {
                try {
                    System.out.println("구입금액을 입력해 주세요.");
                    price = Console.readLine();
                    total_price = Integer.parseInt(price);
                    count = total_price / money;
                    System.out.printf("%d개를 구매했습니다.", count);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("[ERROR] 숫자를 입력해 주세요.");
                    System.out.println("구입금액을 입력해 주세요.");
                    price = Console.readLine();
                } catch (IllegalArgumentException e) {
                    System.out.println("[ERROR] 1,000원 이상의 금액을 입력해 주세요.");
                    System.out.println("구입금액을 입력해 주세요.");
                    price = Console.readLine();
                }
                return;
            }
    }

        private List<Integer> randomNums() {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            return numbers;
        }

        private void getInputNums() {
            List<Integer> input_numbers = new ArrayList<>();
            System.out.println("당첨 번호를 입력해 주세요.");
            input_numbers = Stream.of(Console.readLine().split(",")).map(Integer::parseInt).collect(Collectors.toList());
            System.out.println("\n보너스 번호를 입력해 주세요.");
            input_numbers.add(Integer.parseInt(Console.readLine()));
            validate();
        }

        public void viewNums() {
            for (List<Integer> number : numbers) {
                System.out.println(number);
            }
        }

        private void checkLottoNums(List<Integer> number) {
        int match_lotto_nums = 0;
        for (int i = 0; i < number.size(); i++) {
            if (input_numbers.get(i).equals(number.get(i))) {
                match_lotto_nums++;
            }
        }
        if (match_lotto_nums==5 && number.contains(input_numbers.get(6))) {
            ranking[0]++; // 2등.
            return;
        }
        ranking[7-match_lotto_nums]++;
    }

    private void result () {
        System.out.println("당첨 통계\n---");

        System.out.printf("3개 일치 (5,000원) - %d개\n" , ranking[4]);
        System.out.printf("4개 일치 (50,000원) - %d개\n" , ranking[3]);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n" , ranking[2]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n" , ranking[0]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n" , ranking[1]);
        System.out.printf("총 수익률은 %.1f",
                (float)(ranking[4]*5000+ranking[3]*50000+ranking[2]*1500000+ranking[0]*30000000+ranking[1]*2000000000)/total_price);
        System.out.print("%입니다.");
    }

//    public void Play() {
//        inputPrice();
//        randomNums();
//        viewNums();
//        getInputNums();
//        result();
    }
}





