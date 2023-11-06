package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.Constant.*;

public class LottoService {

    //모델을 수정하는 곳
    //lotto 자체 관련 로직

    public int convertToTimes(String inputMoney) {
        int money = validateMoney(inputMoney);
        if (money % 1000 == 0 )
            return money / 1000;
        throw new IllegalArgumentException("[ERROR] 천원 단위로 입력해주세요.");
    }


    public int validateMoney(String inputMoney){
        String REGEX = "[0-9]+";
        if(!inputMoney.matches(REGEX) || inputMoney.charAt(0) == '0')
            throw new IllegalArgumentException("[ERROR] 금액을 입력해 주세요.");
        return Integer.parseInt(inputMoney);
    }


    public List<Lotto> createLottoes(int times) {
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < times; i++) {
            result.add(createLotto());
        }
        return result;
    }


    public Lotto createLotto() {
        Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        return lotto;
    }


    public Lotto convertToLotto(String inputWinningNum){
        List<String> before = Arrays.stream(inputWinningNum.split(",")).toList();

        validateUserWinningNum(before);

        List<Integer> winningNums = before.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
        return new Lotto(winningNums);
    }

    public void validateUserWinningNum(List<String> numbers){
        //6개 입력했는지
        if(numbers.size() != MAX_LOTTOES_SIZE)
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개만 입력해 주세요.");

        //중복 체크
        if(numbers.stream().distinct().count() != MAX_LOTTOES_SIZE)
            throw new IllegalArgumentException("[ERROR] 중복된 번호는 입력할 수 없습니다.");

        //1부터 45인지 확인
        for(String num : numbers){
            if(validateNum(num)) continue;
        }
    }


    public int validateUserBonusNum(Lotto winningNum, String bonusNum){
        if(validateNum(bonusNum) && !winningNum.getNumbers().contains(Integer.parseInt(bonusNum))){ //숫자인지 확인
           return Integer.parseInt(bonusNum);
        }
        throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복된 번호는 입력할 수 없습니다.");
    }

    public boolean validateNum(String inputNum){ //숫자 하나 확인
        String REGEX = "[0-9]+";
        if(inputNum.matches(REGEX) && (MIN <= Integer.parseInt(inputNum) && Integer.parseInt(inputNum) <= MAX))
            return true;
        throw new IllegalArgumentException("[ERROR] 숫자는 1부터 45까지 입력해 주세요.");
    }


}