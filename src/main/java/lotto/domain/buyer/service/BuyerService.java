package lotto.domain.buyer.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.buyer.model.Buyer;

import java.util.HashMap;
import java.util.Map;

public class BuyerService {

    public void tryBuy(Buyer buyer) {

        System.out.println("구입금액을 입력해 주세요.");
        String inputMoney = Console.readLine();

        Map<String, Object> checkResult = checkMoney(inputMoney);

        if(checkResult.get("CODE").toString().startsWith("F")) {
            System.out.println("[ERROR] " + checkResult.get("MSG").toString());
            tryBuy(buyer);
            return;
        }

        //fixme 캐스팅 형변환 사용?
        buy(buyer, (int) checkResult.get("DATA"));
    }

    public Map<String, Object> checkMoney(String inputMoney) {

        Map<String, Object> checkResult = new HashMap<>();
        int parsedMoney;


        //FIXME 15라인을 넘어가지 않게.
        try {
            parsedMoney = Integer.parseInt(inputMoney);
        } catch (NumberFormatException e){
            checkResult.put("CODE", "F-1");
            checkResult.put("MSG", "숫자만 입력이 가능합니다.");

            return checkResult;
        }

        if(parsedMoney == 0 || parsedMoney % 1000 != 0 || parsedMoney < 0) {
            checkResult.put("CODE", "F-2");
            checkResult.put("MSG", "1000단위의 숫자가 입력되어야 합니다.");

            return checkResult;
        }

        checkResult.put("CODE", "S-1");
        checkResult.put("MSG", "올바른 숫자가 입력되었습니다.");
        checkResult.put("DATA", parsedMoney);

        return checkResult;
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
