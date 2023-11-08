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

    public Lotto getWeeklyNumber() {

        System.out.println("\n당첨 번호를 입력해 주세요.");
        String WeeklyNumber = Console.readLine();

        Map<String, Object> checkResult = checkNumber(WeeklyNumber);
        String resultMsg = checkResult.get("Result").toString();

        if (!checkResult(resultMsg)) {
            failWorks(resultMsg);
            getWeeklyNumber();
            return null;
        }

        Lotto weeklyLotto = new Lotto((List<Integer>) checkResult.get("Data"));

        return weeklyLotto;
    }

    public void getBonusNumber(LotteryCommittee committee) {

        System.out.println("\n보너스 번호를 입력해 주세요.");
        String[] bonusNumber = new String[1];
        bonusNumber[0] = Console.readLine();

        Map<String, Object> checkResult = bonusCheck(bonusNumber, committee);
        String resultMsg = checkResult.get("Result").toString();

        //보너스 넘버는 파싱이랑 어레인지 체크만 하면 된다.
        if (!checkResult(resultMsg)) {
            failWorks(resultMsg);
            getBonusNumber(committee);
            return;
        }

        committee.setBonusNum((int) checkResult.get("Data"));
    }

    public Map<String, Object> bonusCheck(String[] bonusNumber, LotteryCommittee committee) {

        Map<String, Object> parsingResult = parsingNumbers(bonusNumber);
        if (!checkResult(parsingResult.get("Result").toString())) {
            return parsingResult;
        }

        Map<String, Object> arangeCheckResult = checkArange((List<Integer>) parsingResult.get("Data"));
        if (!checkResult(arangeCheckResult.get("Result").toString())) {
            return arangeCheckResult;
        }

        return bonusDupCheck((List<Integer>) parsingResult.get("Data"), committee);
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

    public Map<String, Object> bonusDupCheck(List<Integer> bonusNumber, LotteryCommittee committee) {

        Map<String, Object> resultMap = new HashMap<>();

        int number = bonusNumber.get(0);
        List<Integer> numbers = committee.getWeeklyLottery().getNumbers();

        if (numbers.contains(number)) {
            resultMap.put("Result", ERROR_MSG_HEADER + "보너스 번호도 중복은 불가합니다");
            return resultMap;
        }

        resultMap.put("Result", SUCCESE_CODE);
        resultMap.put("Data", number);
        return resultMap;
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
        int min = numbers.get(numbers.size() - 1);

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
        }
    }

    public void announceResult(Buyer buyer) {

        //TODO 결과 발표
    }


}
