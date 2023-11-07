package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.validate.LottoValidator;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Locale;

public class LottoUI {
    public static int getPurchaseAmount() {
        int purchaseAmount;
        while(true){
            try{
                System.out.println("구입금액을 입력해 주세요.");
                purchaseAmount = LottoValidator.validatePurchaseAmount(Console.readLine());
                System.out.println();
                return purchaseAmount;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void printRandomLottos(List<Lotto> lottos, int lottoCnt){
        System.out.println(lottoCnt+"개를 구매했습니다.");
        for(Lotto lotto : lottos){
            List<Integer> numbers = lotto.getNumbers();
            System.out.println(numbers);
        }
        System.out.println();
    }

    public static Lotto getWinningLotto() {
        while(true){
            try{
                System.out.println("당첨 번호를 입력해 주세요.");
                List<Integer> winningNumbers = convertStringToIntegerList(Console.readLine());
                LottoValidator.validateLottoNumber(winningNumbers);
                System.out.println();
                return new Lotto(winningNumbers);
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int getBonusNumber(Lotto winningLotto) {
        while(true){
            try{
                System.out.println("보너스 번호를 입력해 주세요.");
                int bonusNumber = Integer.parseInt(Console.readLine());
                LottoValidator.validateBonusNumber(winningLotto.getNumbers(), bonusNumber);
                System.out.println();
                return bonusNumber;
            }catch (NumberFormatException e) {
                System.out.println("[ERROR] 보너스 번호는 숫자로 입력되어야 합니다.");
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<Integer> convertStringToIntegerList(String input) {
        List<Integer> numbers = new ArrayList<>();
        String[] numberStrings = input.split(",");

        for (String numberString : numberStrings) {
            try {
                numbers.add(Integer.parseInt(numberString.trim()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 당첨 숫자 입력 방식입니다.");
            }
        }
        return numbers;
    }
}