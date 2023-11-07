package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.Lotto;

public class GameInput {

    public static void getUserCash() {
        String userCash = Console.readLine();
        int userCashCopy = Integer.parseInt(userCash);
        Lotto gameTicket;
        // gameTicket.setBonusNumber(userCashCopy);
    }

    public static void getUserHopeLottoNumbers() {
        String UserHopeLottoNumbers = Console.readLine();
        List<String> numbers = Arrays.stream(UserHopeLottoNumbers.split(",")).toList();
        List<Integer> numbersCopy = validateNumbersArgument(numbers);
        validate(numbersCopy);
        // Lotto gameTicket = new Lotto(numbersCopy);

        // numbers 리스트 받았음 확인필요 넘버스 카피본 있음
    }
    //private static final String REGEXP_PATTERN_NUMBER = "^[\\d]";

    private static List<Integer> validateNumbersArgument(List<String> Numbers){
        List<Integer> NumbersCopy = new ArrayList<>();
        try{
            for( int i = 0 ; i < Numbers.size() ; i++ ) {
                // 타입에러 어케잡지? 트라이캐치 없이
                NumbersCopy.add(Integer.valueOf(Numbers.get(i)));
            }
        }catch (Exception e){
            throw new IllegalArgumentException();
        }
        return NumbersCopy;
    }

    private static void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static void getUserHopeBonusNumbers() {
        String UserHopeLottoNumbers = Console.readLine();
    }

}
