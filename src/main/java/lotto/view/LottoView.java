package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.controller.LottoController;


import java.util.ArrayList;
import java.util.List;

public class LottoView {

    public static void print(int number, List<Lotto> lottos){
        System.out.println(number+"개를 구매했습니다.");
        System.out.println(lottos);
    }
    public static List<Integer> inputPrice(){
        LottoController controller = new LottoController();

        System.out.println("당첨 번호를 입력해 주세요.");
        String[] strs = Console.readLine().split(",");
        validate(strs);
        List<Integer> priceNumbers = checkNumbers(strs);

        return priceNumbers;
    }

    public static List<Integer> checkNumbers(String[] strs){
        List<Integer> priceNumbers = new ArrayList<>();
        for(int i=0;i<6;i++){
            int priceNumber = Integer.parseInt(strs[i]);
            validate(priceNumber);
            priceNumbers.add(priceNumber);
        }
        return priceNumbers;
    }

    public static int inputBonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        validate(bonusNumber);
        return bonusNumber;
    }

    private static void validate(int number) {
        if (number <1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
    private static void validate(String[] strs) {
        if (strs.length !=6) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 6개여야합니다.");
        }
    }


}
