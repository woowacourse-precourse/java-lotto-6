package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.message.InputExceptionMessage;
import lotto.model.Lotto;

public class InputView {

    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_LENGTH = 6;
    private static final String ONLY_NUMBER = "^[0-9]+$";
    private static final String SPLIT_WITH_COMMA = "^(\\d+,\\d+,\\d+,\\d+,\\d+,\\d+)$";

    public int receiveTotalPrice() {
        while (true) {
            String input = Console.readLine();

            if (!input.matches(ONLY_NUMBER)) {
                System.out.println(InputExceptionMessage.INVALID_PRICE_TYPE);
                continue;
            }

            int totalPrice = Integer.parseInt(input);

            if (totalPrice % LOTTO_PRICE != 0) {
                System.out.println(InputExceptionMessage.INVALID_PRICE);
                continue;
            }
            return totalPrice;
        }
    }

    public Lotto receiveLottoWinning() {
        while (true){
            String input = Console.readLine();
            System.out.println("input = " + input);

            if(!input.matches(SPLIT_WITH_COMMA)){
                System.out.println(InputExceptionMessage.INVALID_LOTTO_NUMBERS);
                continue;
            }

            String replacedInput = input.replace(",", "");

            if (replacedInput.length() != LOTTO_LENGTH) {
                System.out.println(InputExceptionMessage.INVALID_LOTTO_NUMBERS);
                continue;
            }

            if(!replacedInput.matches(ONLY_NUMBER)){
                System.out.println(InputExceptionMessage.INVALID_LOTTO_TYPE);
                continue;
            }

            List<Integer> winningList = Arrays.stream(replacedInput.split(""))
                    .map(Integer::parseInt)
                    .filter(n -> n >= 1 && n <= 45)
                    .sorted(Integer::compare)
                    .toList();
            
            long uniqueLength = winningList.stream().distinct().count();

            if(winningList.size() != uniqueLength){
                System.out.println(InputExceptionMessage.INVALID_LOTTO_DUPLICATED);
                continue;
            }

            if(winningList.size() != LOTTO_LENGTH){
                System.out.println(InputExceptionMessage.INVALID_LOTTO_TYPE);
                continue;
            }

            return new Lotto(winningList);
        }
    }

    public int receiveBonusNumber(Lotto lotto) {
        while (true){
            String input = Console.readLine();
            if (!input.matches(ONLY_NUMBER)) {
                System.out.println(InputExceptionMessage.INVALID_LOTTO_TYPE);
                continue;
            }
            int num = Integer.parseInt(input);

            if (num < 1 || num > 45) {
                System.out.println(InputExceptionMessage.INVALID_LOTTO_TYPE);
                continue;
            }

            if(lotto.getNumbers().contains(num)){
                System.out.println(InputExceptionMessage.DUPLICATED_BONUS_NUMBER);
                continue;
            }

            return num;
        }
    }
}
