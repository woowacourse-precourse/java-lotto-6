package lotto.model;

import java.util.HashMap;

public class LottoResult {

    private static HashMap<Integer, Integer> result = new HashMap<>();
    public LottoResult(HashMap result) {
        this.result = result;
    }

    enum PrizeMoney {
        FIRST(2000000000){
            int fare(){
                return result.get(0) * money;
            }
        },SECOND(30000000){
            int fare(){
                return result.get(1) * money;
            }
        },THIRD(1500000){
            int fare(){
                return result.get(2) * money;
            }
        },FOURTH(50000){
            int fare(){
                return result.get(3) * money;
            }
        },FIFTH(5000){
            int fare(){
                return result.get(4) * money;
            }
        };
        abstract int fare();
        protected final int money;
        PrizeMoney(int moneyOne){
            money = moneyOne;
        }
    }
    enum Transportation {
        BUS(100) {
            int fare(int distance){
                return distance * BASIC_FARE;
            }
        },
        TRAIN(150) {
            int fare(int distance){
                return distance * BASIC_FARE;
            }
        };
        abstract int fare(int distance);
        protected final int BASIC_FARE;
        Transportation(int basicFare){
            BASIC_FARE = basicFare;
        }
        public int getBasicFare(){
            return BASIC_FARE;
        }
    }

    public static HashMap statistics(int count, int choice) {
        if (count == 3) {
            int num = result.get(4);
            num++;
            result.put(4,num);
        }
        if (count == 4) {
            int num = result.get(3);
            num++;
            result.put(3,num);
        }
        if (count == 5 && choice == 1) {
            int num = result.get(1);
            num++;
            result.put(1,num);
        }
        if (count == 5 && choice == 0) {
            int num = result.get(2);
            num++;
            result.put(2,num);
        }
        if (count == 6) {
            int num = result.get(0);
            num++;
            result.put(0,num);
        }
        return result;
    }

    public static double profit(int purchase) {
        double allMoney = 0;
        for (PrizeMoney p : PrizeMoney.values()) {
            allMoney+=p.fare();
        }
        return allMoney / (purchase * 10);
    }
}
