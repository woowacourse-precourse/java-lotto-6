package lotto.domain.buyer.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.buyer.model.Buyer;
import lotto.domain.lotteryCommittee.model.LotteryCommittee;
import lotto.domain.lotto.model.Lotto;
import lotto.domain.lotto.service.LottoService;
import lotto.domain.reward.model.Reward;

import java.util.*;

public class BuyerService {

    static final String ERROR_MSG_HEADER = "[ERROR]";
    static final int LOTTO_PRICE = 1000;
    static final int LOTTO_SIZE = 6;

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

    public void tryCheck(Buyer buyer, LotteryCommittee committee) {

        List<Lotto> lottos = buyer.getLottos();
        Lotto weeklyLottery = committee.getWeeklyLottery();
        int bonusNum = committee.getBonusNum();

        List<Map<String,String>> allResult = new ArrayList<>();

        for(Lotto lotto : lottos) {
            allResult.add(checkLotto(lotto, weeklyLottery, bonusNum));
        }


        printResult(parsingResult(allResult));
    }

    public List<Reward> parsingResult(List<Map<String, String>> allResult) {

        List<Reward> rewardList = new ArrayList<>();

        for(Map<String, String> result : allResult) {
            String countResult = result.get("Result");

            if(countResult.equals("6")) {
                rewardList.add(Reward.FIRST);
            }

            if(countResult.equals("보너스당첨")) {
                rewardList.add(Reward.SECOND);
            }

            if(countResult.equals("5")) {
                rewardList.add(Reward.THIRD);
            }

            if(countResult.equals("4")) {
                rewardList.add(Reward.FOURTH);
            }

            if(countResult.equals("3")) {
                rewardList.add(Reward.FIFTH);
            }
        }

        return rewardList;
    }

    public Map<String, String> checkLotto(Lotto lotto, Lotto weeklyLottery, int bonusNum) {

        List<Integer> myNumbers = lotto.getNumbers();
        List<Integer> weeklyNumbers = weeklyLottery.getNumbers();
        Map<String, String> resultMap = new HashMap<>();
        int count = 0;

        for(int i=0; i<LOTTO_SIZE; i++) {
            if(weeklyNumbers.contains(myNumbers.get(i))) {
                count++;
            }
        }
        if(count == 5) {
            if(myNumbers.contains(bonusNum)) {
                resultMap.put("Result", "보너스당첨");
                return resultMap;
            }
        }

        resultMap.put("Result", String.valueOf(count));
        return resultMap;
    }

    public void printResult(List<Reward> rewardList) {

        System.out.println("\n당첨 통계\n---\n");

        for(Reward reward : rewardList) {

        }
    }

    public void tryCalculate(Buyer buyer) {

        //TODO 수익률 계산
    }

}
