package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class User {

    private int countTicketIssues;

    private String userInput() {
        return Console.readLine().trim();
    }

    // 로또 구입 금액 입력 및 발행 횟수 확인
    public int countLottoTicketIssues(String input) {
        inputMoneyValidator(input);
        countTicketIssues = Integer.parseInt(input) / 1000;
        return countTicketIssues;
    }

    public void inputMoneyValidator(String input) {
        if(Integer.parseInt(input) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력하세요.");
        }
    }


}
