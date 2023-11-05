package lotto;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    static Integer money;
    static Integer paper = 0;
    private static List<Integer> winNumbers = new ArrayList<>();
    private static Integer bonusNumber = null;
    private static final List<List<Integer>> lottoTickets = new ArrayList<>();
    static final int[] ranking = new int[8];
    public static Integer InputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        money = Integer.parseInt(Console.readLine());
        return money;
    }
    public static Integer PaperNumber(Integer input) {
        MoneyValidations(input);
        paper = input / 1000;
        System.out.println(paper + "개를 구매했습니다.");
        return paper;
    }
    public static void InputNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputWinNumbers = Console.readLine();
        NumbersValidations(inputWinNumbers);
        winNumbers = Stream.of(inputWinNumbers.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        NumberValidations(winNumbers);
        System.out.println("보너스 번호를 입력해 주세요.");
        bonusNumber = Integer.valueOf(Console.readLine());
        NumberValidations(bonusNumber);
//        winNumbers.add(Integer.parseInt(bonus));
    }
    public static List<Integer> setRandomNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public static void NumbersValidations(String input) {
        if (!input.contains(",")) {
            System.out.println("[ERROR] 쉼표(,)로 구분해 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }
    public static void NumberValidations(List<Integer> input) {
        if (input.size()!=6) {
            System.out.println("[ERROR] 6개의 번호를 입력해주세요.");
            throw new IllegalArgumentException();
        }
        for (Integer number : input) {
            if (number > 45 || number < 1) {
                System.out.println("[ERROR] 1부터 45 사이의 숫자로 입력해주세요.");
                throw new IllegalArgumentException();
            }
        }
        if(input.stream().distinct().collect(Collectors.toList()).size() != 6) {
            System.out.println("중복되지 않게 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }
    public static void NumberValidations(Integer input) {
        if (input > 45 || input < 1) {
            System.out.println("[ERROR] 1부터 45 사이의 숫자로 입력해주세요.");
            throw new IllegalArgumentException();
        }
        if (winNumbers.contains(input)) {
            System.out.println("[ERROR] 당첨 번호와 중복되지 않게 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }

    public static void MoneyValidations(Integer input){
        if (input <= 0){
            System.out.println("[ERROR] 숫자만 입력해주세요.");
            throw new IllegalArgumentException();
        }
        if (input % 1000 != 0) {
            System.out.println("[ERROR] 1,000 단위로만 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }

    public static void makeLottoTicket(Integer PaperNumber) {
        for (int i = 0; i < PaperNumber; i++) {
            List<Integer> lottoNumbers = setRandomNumbers();
            lottoTickets.add(lottoNumbers);
            System.out.println(lottoNumbers);
        }
    }

    public static void Score() {
        for (List<Integer> lottoTicket : lottoTickets) {
            int correct_lotto_numbers = 0;
            for (Integer i : lottoTicket) {
                if (winNumbers.contains(i)) {
                    correct_lotto_numbers++;
                }
            }
            if (correct_lotto_numbers==5 && lottoTicket.contains(bonusNumber)) {
                ranking[0]++; // 2등
            } else {
                ranking[7 - correct_lotto_numbers]++;
            }
        }
        System.out.println("당첨 통계\n---");
        System.out.printf("3개 일치 (5,000원) - %d개\n" , ranking[4]);
        System.out.printf("4개 일치 (50,000원) - %d개\n" , ranking[3]);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n" , ranking[2]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n" , ranking[0]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n" , ranking[1]);
        System.out.printf("총 수익률은 %.1f",
                (float)(ranking[4]*5000+ranking[3]*50000+ranking[2]*1500000+ranking[0]*30000000+ranking[1]*2000000000)/money*100);
        System.out.print("%입니다.");
    }

}
