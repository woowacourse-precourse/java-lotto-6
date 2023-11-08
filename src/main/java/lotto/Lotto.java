package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Set;

import static PrintEnums.ErrorMessages.OUTPUT_ERROR;
import static PrintEnums.ErrorMessages.OUTPUT_ERROR_THOUSAND;
import static PrintEnums.MagicNumbers.*;


public class Lotto {
    private final List<Integer> numbers;
    //numbers 수정X
    //필드추가 ㅇㅋ

    //생성자로 초기화 List 넣자마자 작동 로또넘버를 입력받음.
    public Lotto(List<Integer> numbers) {
        validateDuplicate(numbers);
        validate(numbers);
        validateLottoNumber(numbers);
        System.out.println(numbers);
        this.numbers = numbers;
    }
    // TODO: 추가 기능 구현

    //numbers의 도메인 검증부
    private void validate(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }


    //https://doing7.tistory.com/145 참고 set 혹은 stream.distinct()이용
    // 중복값 도메인 검증부 제작
    private void validateDuplicate(List<Integer> lottoNumbers) {
        //형변환
        Set<Integer> checkDuplicateNumbers = new HashSet<>(lottoNumbers);
        // != 연산부분 포장해서 true값으로 작업할것?
        if (lottoNumbers.size() != checkDuplicateNumbers.size()) {
            throw new IllegalArgumentException();
        }
        //익셉셔널쪽으로 날릴 것
    }

    private void validateLottoNumber(List<Integer> lottoNumbers) {
        for (int i = 0; i < lottoNumbers.size(); i++) {
            validateInRangeNumber(lottoNumbers.get(i));
        }
    }

    private void validateInRangeNumber(int Number) {
        // 포장필요 magicnumbers
        if (Number < CHECK_NUMBER_ONE.getMagicNumber()) {
            throw new IllegalArgumentException();
        }
        if (CHECK_NUMBER_FOURTYFIVE.getMagicNumber() < Number) {
            throw new IllegalArgumentException();
        }
        //익셉셔널쪽으로 날리기
    }

    private static int bonusNumber;

    public void setBonusNumber(int userBonusNumber) {
        validateInRangeNumber(userBonusNumber);
        bonusNumber = userBonusNumber;
    }


    //리팩토링 필요
    public static List<Integer> pickRandoms() {
        List<Integer> pickRandomnumbers = new ArrayList<>
                (Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(pickRandomnumbers); // reversed 사용시 반대로 정렬됨
        return pickRandomnumbers;
    }

    private static List<Integer> splitTicketNumbers(String tickeNumbers) {
        List<String> ArgNumbers = Arrays.stream(tickeNumbers.split(", ")).toList();
        List<Integer> ticketNumbersCopy = validateNumbersArgument(ArgNumbers);
        return ticketNumbersCopy;
    }
    private static List<Integer> validateNumbersArgument(List<String> Numbers) {
        List<Integer> NumbersCopy = new ArrayList<Integer>();
        try {
            for (int i = 0; i < Numbers.size(); i++) {
                NumbersCopy.add(Integer.parseInt(Numbers.get(i)
                        .replaceAll("[\\[\\]]", "")));
                //정규식 제거

            }
        } catch (IllegalArgumentException e) {
            System.out.println(OUTPUT_ERROR.getErrorMessage() + OUTPUT_ERROR_THOUSAND.getErrorMessage());
        }
        return NumbersCopy;
    }


    public int buyLottoTickets(int moneys) {
        // != 연산부분 포장해서 true값으로 작업할것?
        //익셉셔널쪽으로 날릴것
        int tickets;
        return tickets = moneys / 1000;
    }

    //ticketNumbers와 bonusnumber, numbers 체크
    //일치 및 수익률 계산
    private static List<String> ticketNumbers = new ArrayList<>();

    public void buyTickets(int tickets) {
        for (int i = 0; i < tickets; i++) {
            String str = pickRandoms().toString();
            ticketNumbers.add(str);
            System.out.println(str);
        }
    }

    private List<Integer> placed = Arrays.asList(0, 0, 0, 0, 0);

    //placed 12345순서
    public float earnMoney() {
        for (int i = 0; i < ticketNumbers.size(); i++) {
            List<Integer> splitTicketNumbers = splitTicketNumbers(ticketNumbers.get(i));
            List<Integer> targetNumbers = new ArrayList<Integer>(splitTicketNumbers);
            while (checkPlaced(targetNumbers))
                ;
        }
        return 100 * placed.get(4) * 5000 + placed.get(3) * 50000
                + placed.get(2) * 1500000 + placed.get(1) * 30000000
                + placed.get(0) * 2000000000;
    }

    public List<Integer> getPlaced() {
        return placed;
    }

    //removeAll으로 사용해서 작업
    private boolean checkPlaced(List<Integer> targetNumbers) {
        targetNumbers.removeAll(numbers);
        for (int i = 0; i < placed.size(); i++) {
            if (i == 1) {
                targetNumbers.remove(bonusNumber);
            }
            if (i == 0) {
                i++;
            }
            if (targetNumbers.size() == i - 1) {
                placed.set(i, placed.get(i) + 1);
                return false;
            }
        }
        return false;
    }

}
//            0 6개 값 일치 0
//                1 5값 일치 + 보너스 일치 1 = 0 1-1
//                        2 5개 값 일치 remove 2-1
//            3 4개 값 일치 3-1
//            4 3개 값 일치 4-1
//순서대로 작동 return으로 중간검사 끝
