package lotto.domain;

import java.util.Map;
import lotto.Message.ErrorMessage;
import lotto.Message.GameMessage;
import lotto.util.MoneyCalculation;

public class Money {

        int money;
        int count;

        public Money(int money) {
            this.money = money;
            checkmoney(money);
        }

        public void checkmoney(int inputMoney) {
            if (inputMoney % 1000 != 0) {
                throw new IllegalArgumentException(ErrorMessage.MONEY_SHOULD_BE_1000.toString());
            } else if (inputMoney < 0) {
                throw new IllegalArgumentException(ErrorMessage.MONEY_SHOUD_BE_POSITIVE_NUMBER.toString());
            } else if (inputMoney % 1000 == 0) {
                this.count = inputMoney / 1000;
            }
        }

        public void printCount(){
            System.out.println(this.count + GameMessage.OUT_QUNTITY_LOTTO_MESSAGE);
        }

        public void minusCount(){
            --count;
        }

        public boolean checkCount(){
            if(count == 0){
                return false;
            }
            return true;
        }

        public double calculateProfit(Map<Integer, Integer> resultLottos){

            long resultSum = calculateResult(resultLottos);

            if(resultSum == 0){
                return 0;
            }

            double percentage = (double) resultSum / this.money * 100;

            return percentage;
        }
        public long calculateResult(Map<Integer, Integer> resultLottos){
            int winnings[] = {5000,50000,1500000,30000000,2000000000};
            long totalWinnings = resultLottos.entrySet().stream()
                    .mapToLong(entry -> {
                        int index = entry.getKey() - 3;
                        int multipliedValue = winnings[index] * entry.getValue();
                        return multipliedValue;
                    }).sum();

            return totalWinnings;
        }



}
