package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Computer {
    final String ASK_PRICE = "구입금액을 입력해 주세요.";

    final String BUY_LOTTO_MESSAGE = "개를 구매했습니다.";
    final String ONLY_NUMBER_ERROR_MESSAGE = "[ERROR] 숫자만 입력 가능합니다.";
    final String AMOUNT_OF_MONEY_MUST_DIVIDED_THOUSAND = "[ERROR] 금액은 1000원 단위로 나누어 떨어져야 합니다.";
    final String ASK_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    final String ASK_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    final int LOTTO_PRICE = 1000;
    final int LOTTO_NUMBER = 6;
    final int MIN_NUMBER = 1;
    final int MAX_NUMBER = 45;

    String getPriceFromUser(){
        System.out.println(ASK_PRICE);

        return Console.readLine();
    }

    void validatePrice(String input){
        int amount = 1;

        try{
            amount = Integer.parseInt(input);
        } catch (IllegalArgumentException e){
            System.out.println(ONLY_NUMBER_ERROR_MESSAGE);
        }


        if((amount % LOTTO_PRICE) != 0){
            throw new IllegalArgumentException(AMOUNT_OF_MONEY_MUST_DIVIDED_THOUSAND);
        }
    }

    int changeInputToInt(String input){
        return Integer.parseInt(input);
    }

    void announcePurchase(int amount){
        System.out.println((amount / LOTTO_PRICE)+BUY_LOTTO_MESSAGE);
    }
    List<Lotto> buyLotto(int amount){
        List<Lotto> lottos = new ArrayList<>();

        for(int i = 0; i < (amount / LOTTO_PRICE); i++){
            lottos.add(issueNewLotto());
        }

        return lottos;
    }

    Lotto issueNewLotto(){
        Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(MIN_NUMBER,MAX_NUMBER,LOTTO_NUMBER));
        return lotto;
    }

    void printLottos(List<Lotto> lottos){
        for(Lotto lotto : lottos){
            System.out.println(lotto.toString());
        }
    }

    Lotto getWinningNumber(){
        System.out.println(ASK_WINNING_NUMBER);
        return validateWinningNumber(Console.readLine());
    }

    Lotto validateWinningNumber(String input){
        List<Integer> numbers = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).boxed().collect(
                Collectors.toList());
        Lotto winLotto = new Lotto(numbers);
        return winLotto;
    }

    int getBonusNumber(){
        System.out.println(ASK_BONUS_NUMBER);

        try{
            return Integer.parseInt(Console.readLine());
        } catch (IllegalArgumentException e){
            System.out.println(ONLY_NUMBER_ERROR_MESSAGE);
        }

        return 0;
    }

    void validateBonusNumber(int bonusNumber, Lotto lotto){
        final String RANGE_EXCEPTION_MESSAGE = "[ERROR] 보너스 번호는 1~45 사이의 숫자여야합니다.";
        final String UNIQUE_NUMBER_EXCEPTION_MESSAGE = "[ERROR] 보너스 번호는 로또 번호와 중복되지않아야합니다.";

        if(bonusNumber > MAX_NUMBER || bonusNumber < MIN_NUMBER){
            throw new IllegalArgumentException(RANGE_EXCEPTION_MESSAGE);
        }
        if(lotto.isNumbersContainBonusNumber(bonusNumber)){
            throw new IllegalArgumentException(UNIQUE_NUMBER_EXCEPTION_MESSAGE);
        }
    }
}
