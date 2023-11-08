package lotto.domain.lotteryCommittee.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.buyer.model.Buyer;
import lotto.domain.lotteryCommittee.model.LotteryCommittee;
import lotto.domain.lotto.model.Lotto;
import org.assertj.core.util.Arrays;

import java.util.*;

public class LotteryCommitteeService {

    static final String SUCCESE_CODE = "[SUCCESS]";
    static final String ERROR_MSG_HEADER = "[ERROR]";
    static final int START_NUMBER = 1;
    static final int END_NUMBER = 45;
    static final int LOTTO_SIZE = 6;

    public void getWeeklyNumber() {

        System.out.println("당첨 번호를 입력해 주세요.");
        String WeeklyNumber = Console.readLine();

        Map<String, Object> checkResult = checkNumber(WeeklyNumber);

        if (!checkResult(checkResult.get("Result").toString())) {
            failWorks(checkNumber(WeeklyNumber).get("Result").toString());
            getWeeklyNumber();
            return;
        }

        return;
    }

    public Map<String, Object> checkNumber(String numbers) {

        Map<String, Object> splitResult = splitNumbers(numbers);
        if (!checkResult(splitResult.get("Result").toString())) {
            return splitResult;
        }

        Map<String, Object> parsingResult = parsingNumbers((String[]) splitResult.get("Data"));
        if (!checkResult(parsingResult.get("Result").toString())) {
            return parsingResult;
        }

        Map<String, Object> dupCheckResult = duplicationCheck((List<Integer>) parsingResult.get("Data"));
        if (!checkResult(dupCheckResult.get("Result").toString())) {
            return dupCheckResult;
        }

        return checkArange((List<Integer>) parsingResult.get("Data"));
    }

    public Map<String, Object> splitNumbers(String numbers) {

        Map<String, Object> resultMap = new HashMap<>();

        String[] splitNumbers = numbers.split(",");

        if (splitNumbers.length != LOTTO_SIZE) {
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

        for (String number : splitNumbers) {
            try {
                parsedNums.add(Integer.parseInt(number));
            } catch (NumberFormatException e) {
                resultMap.put("Result", ERROR_MSG_HEADER + "숫자 이외의 값은 입력할 수 없습니다.");
                return resultMap;
            }
        }

        resultMap.put("Result", SUCCESE_CODE);
        resultMap.put("Data", parsedNums);

        return resultMap;
    }

    public Map<String, Object> duplicationCheck(List<Integer> numbers) {

        Map<String, Object> resultMap = new HashMap<>();

        for (int i = 0; i < numbers.size() - 1; i++) {
            int target = numbers.get(i);
            for (int j = i + 1; j < numbers.size(); j++) {
                if (target == numbers.get(j)) {
                    resultMap.put("Result", ERROR_MSG_HEADER + "중복된 숫자는 입력할 수 없습니다.");
                    return resultMap;
                }
            }
        }

        resultMap.put("Result", SUCCESE_CODE);
        return resultMap;
    }

    public Map<String, Object> checkArange(List<Integer> numbers) {

        Map<String, Object> resultMap = new HashMap<>();

        Collections.sort(numbers);

        int max = numbers.get(0);
        int min = numbers.get(LOTTO_SIZE - 1);

        if (min < START_NUMBER) {
            resultMap.put("Result", ERROR_MSG_HEADER + "입력할 수 있는 번호는 최소 1 입니다.");
            return resultMap;
        }

        if (max > END_NUMBER) {
            resultMap.put("Result", ERROR_MSG_HEADER + "입력할 수 있는 번호는 최대 45 입니다.");
            return resultMap;
        }

        resultMap.put("Result", SUCCESE_CODE);
        resultMap.put("Data", numbers);
        return resultMap;
    }

    public boolean checkResult(String resultMsg) {

        if (resultMsg.startsWith(ERROR_MSG_HEADER)) {
            return false;
        }

        return true;
    }

    public void failWorks(String errorMsg) {

        try {
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println(errorMsg);
            getWeeklyNumber();
        }
    }

    public void announceResult(Buyer buyer) {

        //TODO 결과 발표
    }


}
