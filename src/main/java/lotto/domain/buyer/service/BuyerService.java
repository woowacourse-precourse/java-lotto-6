package lotto.domain.buyer.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.buyer.model.Buyer;
import lotto.domain.lotto.model.Lotto;
import lotto.domain.lotto.service.LottoService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuyerService {

    static final String ERROR_MSG_HEADER = "[ERROR]";
    static final int LOTTO_PRICE = 1000;

    public void tryBuy(Buyer buyer) {

        System.out.println("구입금액을 입력해 주세요.");
        int parsedMoney = parsingMoney(Console.readLine());
        String checkResult = checkMoney(parsedMoney);

        if(checkResult.contains(ERROR_MSG_HEADER)) {
            try {
                throw new IllegalArgumentException();
            } catch(IllegalArgumentException e) {
                System.out.println(checkResult);
                tryBuy(buyer);
                return;
            }
        }

        buy(buyer, parsedMoney);
    }

    public int parsingMoney(String inputMoney) {

        try {
            int parsedMoney = Integer.parseInt(inputMoney);
            return parsedMoney;
        } catch (NumberFormatException e1){
            try {
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e2){
                return -1;
            }
        }
    }

    public String checkMoney(int parsedMoney) {

        if(parsedMoney == -1) {
            return ERROR_MSG_HEADER + " 숫자만 입력이 가능합니다.";
        }

        if(parsedMoney == 0 || parsedMoney < 0) {
            return ERROR_MSG_HEADER + "숫자는 0보다 큰 숫자여야 합니다.";
        }

        if(parsedMoney % LOTTO_PRICE != 0) {
            return ERROR_MSG_HEADER + "숫자는 1000 단위로 입력되어야 합니다.";
        }

        return "올바른 숫자가 입력되었습니다.";
    }

    public void buy(Buyer buyer, int money) {

        List<Lotto> lottos = new ArrayList<>();
        int buyingNum = money/LOTTO_PRICE;

        System.out.println("\n%d개를 구매했습니다.".formatted(buyingNum));

        for(int i=0; i<buyingNum; i++) {
            LottoService lottoService = new LottoService();
            lottos.add(lottoService.createLotto());
        }

        buyer.setLottos(lottos);
    }

    public void tryCheck(Buyer buyer) {

        //TODO 로또 위원회로부터 당첨 여부 조회
    }

    public void tryCalculate(Buyer buyer) {

        //TODO 수익률 계산
    }

}
