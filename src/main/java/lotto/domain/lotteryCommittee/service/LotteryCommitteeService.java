package lotto.domain.lotteryCommittee.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.buyer.model.Buyer;
import org.assertj.core.util.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LotteryCommitteeService {

    static final String SUCCESE_CODE = "[SUCCESS]";
    static final String ERROR_MSG_HEADER = "[ERROR]";
    static final int START_NUMBER = 1;
    static final int END_NUMBER = 45;

    public void getWeeklyNumber() {

        System.out.println("당첨 번호를 입력해 주세요.");
        String WeeklyNumber = Console.readLine();

        if(!checkResult(checkNumber(WeeklyNumber).get("Result").toString())) {
            failWorks(checkNumber(WeeklyNumber).get("Result").toString());
            getWeeklyNumber();
            return;
        }
    }

    public Map<String, Object> checkNumber(String numbers) {

        Map<String, Object> finalResultMap = new HashMap<>();

        /*
        체크해야 하는 것
        1. 쉼표로 구분된 **6개**의
        2. **숫자**인가?
        3. 1~45 사이의 값인가? (Arange 체크)
        4. 중복된 값이 들어있지는 않은가?
        */

        Map<String, Object> splitResult = splitNumbers(numbers);
        if(!checkResult(splitResult.get("Result").toString())) {
            return splitResult;
        }

        Map<String, Object> parsingResult = parsingNumbers((String[]) splitResult.get("Data"));
        if(!checkResult(parsingResult.get("Result").toString())) {
            return parsingResult;
        }

        finalResultMap.put("Result", SUCCESE_CODE);
        finalResultMap.put("Data", "");
        return finalResultMap;
    }

    public Map<String, Object> splitNumbers(String numbers) {

        Map<String, Object> resultMap = new HashMap<>();

        String[] splitNumbers = numbers.split(",");

        if(splitNumbers.length != 6) {
            resultMap.put("Result", ERROR_MSG_HEADER + "쉼표로 구분된 6개의 숫자가 입력되어야 합니다.");
            return resultMap;
        }

        resultMap.put("Result", SUCCESE_CODE);
        resultMap.put("Data", splitNumbers);

        return resultMap;
    }

    public Map<String, Object> parsingNumbers(String[] splitNumbers) {

        Map<String, Object> resultMap = new HashMap<>();
        List<Integer> parsedNums = new ArrayList<>();

        for(String number : splitNumbers) {
            try {
                 parsedNums.add(Integer.parseInt(number));
            } catch(NumberFormatException e) {
                resultMap.put("Result", ERROR_MSG_HEADER + "숫자 이외의 값은 입력할 수 없습니다.");
                return resultMap;
            }
        }

        resultMap.put("Result", SUCCESE_CODE);
        resultMap.put("Data", parsedNums);

        return resultMap;
    }

    public boolean checkResult(String resultMsg) {

        if(resultMsg.startsWith(ERROR_MSG_HEADER)) {
            return false;
        }

        return true;
    }

    public void failWorks(String errorMsg) {

        try {
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e){
            System.out.println(errorMsg);
            getWeeklyNumber();
        }
    }

    public void announceResult(Buyer buyer) {

        //TODO 결과 발표
    }


}
