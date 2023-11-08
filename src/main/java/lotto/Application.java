package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
public class Application {
    static List<Lotto> my_lottery_tickets = new ArrayList<Lotto>();
    static int order_price = 0;
    static int order_numbers = 0;
    static List<Integer> winning_numbers;
    static int bonus_number = 0;

    public static void main(String[] args) {
        Application app = new Application();

        System.out.println("구입 금액을 입력해 주세요.");
        app.get_order_price();
        app.purchase();

        System.out.println("\n당첨 번호를 입력해 주세요.");
        app.get_winning_numbers();

        System.out.println("\n보너스 번호를 입력해 주세요.");
        app.get_bonus_number();
        app.show_result();
    }
    private void is_numeric_only(String s){
        if (!s.matches("[0-9]+")){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자여야 합니다.\n");
        }
    }
    private void is_valid_number(int x){
        if (x < 1 | x > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.\n");
        }
    }
    public void get_order_price() {
        while(true){
            try {
                String userInput = Console.readLine();
                order_price = validate_order_price(userInput);
                order_numbers = order_price / 1000;
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private int validate_order_price(String s){
        is_numeric_only(s);
        int x = Integer.parseInt(s);
        if (x < 1000){
            throw new IllegalArgumentException("[ERROR] 로또 구매 금액은 1000원 이상이어야 합니다.");
        }
        if ((x % 1000) != 0) {
            System.out.println(x % 1000);
            throw new IllegalArgumentException("[ERROR] 로또 구매 금액은 1000원 단위입니다.");
        }
        return x;
    }
    public void get_winning_numbers() {
        while(true) {
            try {
                String userInput = Console.readLine();
                String[] userInput_arr = userInput.split(",");
                validate_winning_numbers(userInput_arr);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private void validate_winning_numbers(String[] arr) {
        List<Integer> new_winning_numbers = new ArrayList<Integer>();
        if (arr.length != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해주세요.");
        }
        for (String s : arr) {
            is_numeric_only(s);
            int nbr = Integer.parseInt(s);
            is_valid_number(nbr);
            new_winning_numbers.add(nbr);
        }
        winning_numbers = new_winning_numbers;
    }
    public void get_bonus_number() {
        while(true) {
            try {
                String userInput = Console.readLine();
                bonus_number = validate_bonus_number(userInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private int validate_bonus_number(String userInput) {
        is_numeric_only(userInput);
        int nbr = Integer.parseInt(userInput);
        is_valid_number(nbr);
        return nbr;
    }
    public void purchase() {
        System.out.printf("\n%d개를 구매했습니다.\n", order_numbers);
        for (int i = 0; i < order_numbers; i++) {
            my_lottery_tickets.add(new Lotto(get_lottery_numbers()));
            my_lottery_tickets.get(i).print_lottery_numbers();

        }
    }
    public List<Integer> get_lottery_numbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
    public int get_result(int[] arr) {
        return arr[1] * 2000000000
                + arr[2] * 30000000
                + arr[3] * 1500000
                + arr[4] * 50000
                + arr[5] * 5000;
    }
    private int[] validate_result() {
        int[] my_result = new int[6];

        for (Lotto ticket : my_lottery_tickets) {
            int rank = ticket.check_winnings(winning_numbers, bonus_number);
            my_result[rank] += 1;
        }
        int sum = Arrays.stream(my_result).sum();
        if (sum != order_numbers) {
            throw new IllegalArgumentException("[ERROR] 로또 결과 개수와 총 구입 개수가 맞지 않습니다.");
        }
        return my_result;
    }

    public void show_result() {
        while(true) {
            try {
                int[] my_result = validate_result();
                int total = get_result(my_result);
                System.out.print("\n당첨 통계\n---\n");
                System.out.printf("3개 일치 (5,000원) - %d개\n", my_result[5]);
                System.out.printf("4개 일치 (50,000원) - %d개\n", my_result[4]);
                System.out.printf("5개 일치 (1,500,000원) - %d개\n", my_result[3]);
                System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", my_result[2]);
                System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", my_result[1]);
                System.out.printf("총 수익률은 %.1f%%입니다.\n", (((float) total / order_price) * 100));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
