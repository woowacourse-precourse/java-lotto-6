package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class PurchaseAmount {
    public static int number_of_lottoes;

    private void print_inputAmount(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    private void inputAmount(){
        String input_amount = readLine();

        int amount;
        try {
            amount = Integer.parseInt(input_amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 숫자가 아닙니다. 1000원 단위의 자연수를 입력해주세요.");
        }

        if(amount < 0 || amount % 1000 != 0){
            throw new IllegalArgumentException("구입금액은 1000원 단위의 자연수로 입력해야 합니다.");
        }

        number_of_lottoes = amount / 1000;
    }

    private void print_number_of_lottoes(){
        System.out.println("\n" + number_of_lottoes + "개를 구매했습니다.");
    }


    private List<Integer> pickLottoNumbers(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private void createLottoes(){
        List<Lotto> lottoes = new ArrayList<>();
        for(int i = 0; i < number_of_lottoes; i++) {
            List<Integer> picked_numbers = pickLottoNumbers();
            Lotto lotto = new Lotto(picked_numbers);

            lottoes.add(lotto);
        }

    }

}
