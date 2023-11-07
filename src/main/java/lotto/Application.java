package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    static final int Lotto_Price = 1000;
    public static void main(String[] args) {
        int lotto_purchase_amount;
        List<Lotto> lottos;
        Lotto winning_numbers;
        int bonus_number;
        
        lotto_purchase_amount = inputLottoPurchase() / Lotto_Price ;
        lottos = lottoIssuance(lotto_purchase_amount);
        printLottos(lottos, lotto_purchase_amount);
        winning_numbers = inputWinningNumbers();
    }

    static Lotto inputWinningNumbers(){
        Lotto winning_numbers;
        String input_winning_numbers;
        System.out.println("당첨 번호를 입력해 주세요");

        while(true){
            try {
                input_winning_numbers = Console.readLine();
                winning_numbers = new Lotto(stringToIntArray(input_winning_numbers));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return winning_numbers;
    }

    static List<Integer> stringToIntArray(String str){
        List<Integer> list_integer;
        String[] str_array = str.split(",");
        try {
            int[] int_array = Arrays.stream(str_array).mapToInt(Integer::parseInt).toArray();
            list_integer = Arrays.stream(int_array).boxed().collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 입력되었습니다.");
        }

        return list_integer;
    }

    static void printLottos(List<Lotto> lottos, int lotto_purchase_amount){
        System.out.println("\n" + Integer.toString(lotto_purchase_amount) + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    static int inputLottoPurchase(){
        int lotto_purchase_amount;
        String input_lotto_purchase;
        System.out.println("구입금액을 입력해 주세요");

        while(true){
            try {
                input_lotto_purchase = Console.readLine();
                lotto_purchase_amount = stringToInt(input_lotto_purchase);
                checkMultiple1000(lotto_purchase_amount);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return lotto_purchase_amount;
    }

    static ArrayList<Lotto> lottoIssuance(int purchase_amount){
        ArrayList<Lotto> lottos = new ArrayList<Lotto>();
        for (int i =0; i < purchase_amount; i++){
            lottos.add(new Lotto(pickLottoNumbers()));
        }
        return lottos;
    }

    static List<Integer> pickLottoNumbers(){
        List<Integer> lotto_numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return lotto_numbers;
    }

    static int stringToInt(String value) throws IllegalArgumentException{
        int num;
        try {
            num = Integer.parseInt(value);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자 값을 입력해야 합니다.");
        }
        return num;
    }

    static void checkMultiple1000(int num) throws IllegalArgumentException{
        if (num % Lotto_Price != 0){
            throw new IllegalArgumentException("[ERROR] 1000의 배수를 입력해야 합니다.");
        }
    }

    static String inputMethod(String announcement){
        System.out.println(announcement);
        return Console.readLine();
    }
}
