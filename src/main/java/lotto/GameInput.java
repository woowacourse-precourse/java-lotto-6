package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.Lotto;

public class GameInput {

    public static int getUserCash() {
        String userCash = Console.readLine();
        int userCashCopy = Integer.parseInt(userCash);
        return userCashCopy;
        // gameTicket.setBonusNumber(userCashCopy);
    }

    public static List<Integer> getUserHopeLottoNumbers() {
        String UserHopeLottoNumbers = Console.readLine();
        List<Integer> numbersCopy = splitNumbers(UserHopeLottoNumbers);
        validate(numbersCopy);
        return numbersCopy;

        // numbers 리스트 받았음 확인필요 넘버스 카피본 있음
    }
    //private static final String REGEXP_PATTERN_NUMBER = "^[\\d]";

    private static List<Integer> splitNumbers(String Numbers){
        List<String> numbers = Arrays.stream(Numbers.split(",")).toList();
        List<Integer> numbersCopy = validateNumbersArgument(numbers);
        return numbersCopy;
    }

    //ticketNumbers와 bonusnumber, numbers 체크
    //일치 및 수익률 계산
    public int earnMoney( List<Integer> numbers, List<String> ticketNumbers, int bonusnumber ){
        int firstplaced = 0;
        int secondplaced = 0;
        int thirdplaced = 0;
        int fourthplaced = 0;
        int fifthplaced = 0;
        for( int i = 0 ; i < ticketNumbers.size() ; i++){
            List<Integer> splitTicketNumbers = splitNumbers(ticketNumbers.get(i));
            List<Integer> unmatchTargetNumbers = new ArrayList<Integer>(splitTicketNumbers);
            unmatchTargetNumbers.removeAll(numbers);
            if(unmatchTargetNumbers.size()==3){
                fifthplaced++;
            }
            if(unmatchTargetNumbers.size()==2){
                fourthplaced++;
            }
            if(unmatchTargetNumbers.size()==0){
                firstplaced++;
            }
            unmatchTargetNumbers.removeAll(Collections.singleton(bonusnumber));
            if(unmatchTargetNumbers.size()==0){
                secondplaced++;
            }
            if(unmatchTargetNumbers.size()==1){
                thirdplaced++;
            }
        }
        System.out.printf(Messages.CHECK_MATCH_THREE+"%d개\n",fifthplaced);
        System.out.printf(Messages.CHECK_MATCH_FOUR+"%d개\n",fourthplaced);
        System.out.printf(Messages.CHECK_MATCH_FIVE+"%d개\n",thirdplaced);
        System.out.printf(Messages.CHECK_MATCH_BONUS+"%d개\n",secondplaced);
        System.out.printf(Messages.CHECK_MATCH_SIX+"%d개\n",firstplaced);
        return fifthplaced*5000+fourthplaced*50000+thirdplaced*1500000+secondplaced*30000000+firstplaced*2000000000;
        //enum으로 리턴할까?
        //removeAll으로 사용해서
    }

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

    public static int getUserHopeBonusNumbers() {
        String UserHopeLottoNumbers = Console.readLine();
        return Integer.parseInt(UserHopeLottoNumbers);
    }

}
