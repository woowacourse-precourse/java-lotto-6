package lotto.domain.lotteryCommittee.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.buyer.model.Buyer;

public class LotteryCommitteeService {

    static final String ERROR_MSG_HEADER = "[ERROR]";
    static final int START_NUMBER = 1;
    static final int END_NUMBER = 45;

    public void getWeeklyNumber() {

        System.out.println("당첨 번호를 입력해 주세요.");
        String WeeklyNumber = Console.readLine();

        String checkResult = checkNumber(WeeklyNumber);

        if(checkResult.startsWith(ERROR_MSG_HEADER)) {
            try {
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e){
                System.out.println(checkResult);
                getWeeklyNumber();
                return;
            }
        }

        //TODO 이번 주 당첨 번호 입력 (6개 + 보너스 1)
    }

    public String checkNumber(String numbers) {

        String[] splitNumbers = numbers.split(",");

        if(splitNumbers.length != 6) {
            return ERROR_MSG_HEADER + "쉼표로 구분된 6자리 숫자가 입력되어야 합니다.";
        }

        return "성공적으로 입력이 완료되었습니다.";
    }

    public void announceResult(Buyer buyer) {

        //TODO 결과 발표
    }


}
