package lotto.domain.lotteryCommittee.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.buyer.model.Buyer;
import org.assertj.core.util.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LotteryCommitteeService {

    static final String ERROR_MSG_HEADER = "[ERROR]";
    static final int START_NUMBER = 1;
    static final int END_NUMBER = 45;

    public void getWeeklyNumber() {

        System.out.println("당첨 번호를 입력해 주세요.");
        String WeeklyNumber = Console.readLine();
        checkNumber(WeeklyNumber);

    }

    public void checkNumber(String numbers) {

        Map<String, Object> splitResult = splitNumbers(numbers);
        if(!checkResult(splitResult)) {
            return;
        }

        String[] splitData = (String[]) Arrays.array(splitResult.get("Data"));

        return;
    }

    public void failWorks(String errorMsg) {

        try {
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e){
            System.out.println(errorMsg);
            getWeeklyNumber();
        }
    }

    public boolean checkResult (Map<String, Object> resultMap) {

        String resultMsg = resultMap.toString();

        if(resultMsg.startsWith(ERROR_MSG_HEADER)) {
            failWorks(resultMsg);
            return false;
        }

        return true;
    }

    public Map<String, Object> splitNumbers(String numbers) {

        Map<String, Object> resultMap = new HashMap<>();

        String[] splitNumbers = numbers.split(",");

        if(splitNumbers.length != 6) {
            resultMap.put("Result", ERROR_MSG_HEADER + "쉼표로 구분된 6자리 숫자가 입력되어야 합니다.");
            return resultMap;
        }

        resultMap.put("Result", "SUCCESS");
        resultMap.put("Data", splitNumbers);
        return resultMap;
    }

//    public Map<String, Object> parsingNumbers(String[] splitNumbers) {
//
//        Map<String, Object> resultMap = new HashMap<>();
//        List<Integer> parsedNumbers = new ArrayList<>();
//
//        for(String number : splitNumbers) {
//            try {
//                int num = Integer.parseInt(number);
//                parsedNumbers.add(num);
//            } catch (NumberFormatException e) {
//                resultMap.put("RESULT", ERROR_MSG_HEADER + "숫자만 입력되어야 합니다.");
//                return resultMap;
//            }
//        }
//        resultMap.put("Result", "SUCCESS");
//        resultMap.put("Data", parsedNumbers);
//
//        return resultMap;
//    }

    public void announceResult(Buyer buyer) {

        //TODO 결과 발표
    }


}
