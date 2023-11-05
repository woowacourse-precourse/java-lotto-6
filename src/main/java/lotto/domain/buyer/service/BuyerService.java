package lotto.domain.buyer.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.buyer.model.Buyer;

public class BuyerService {

    static final String ERROR_MSG_HEADER = "[ERROR] ";

    public void tryBuy(Buyer buyer) {

        System.out.println("구입금액을 입력해 주세요.");
        String inputMoney = Console.readLine();

        String checkResult = checkMoney(inputMoney);

        if(checkResult.contains(ERROR_MSG_HEADER)) {
            System.out.println(checkResult);
            tryBuy(buyer);
            return;
        }

        buy(buyer, 0);
    }

    public String checkMoney(String inputMoney) {

        //TODO 파싱한 값을 돌려주려면?
        int parsedMoney;

        try {
            parsedMoney = Integer.parseInt(inputMoney);
        } catch (NumberFormatException e){
            return ERROR_MSG_HEADER + "숫자만 입력이 가능합니다.";
        }

        if(parsedMoney == 0 || parsedMoney % 1000 != 0 || parsedMoney < 0) {
            return ERROR_MSG_HEADER + "1000단위의 숫자가 입력되어야 합니다.";
        }

        return "올바른 숫자가 입력되었습니다.";
    }

    public void buy(Buyer buyer, int money) {

        //TODO 로또 구매 로직
    }

    public void tryCheck(Buyer buyer) {

        //TODO 로또 위원회로부터 당첨 여부 조회
    }

    public void tryCalculate(Buyer buyer) {

        //TODO 수익률 계산
    }

}
