package lotto;

public class LottoValue {
    public enum Value{
        MIN("1"),
        MAX("45");
        private final String value;
        Value(String value){
            this.value = value;
        }

        public int getValue(){
            return Integer.parseInt(value);
        }
    }
    public enum PRICE{
        BUY_PRICE("1000"),
        PRICE_5("5000"),
        PRICE_4("50000"),
        PRICE_3("1500000"),
        PRICE_2("3000000"),
        PRICE_1("2000000000");

        private final String price;
        PRICE(String price){
            this.price = price;
        }
        public int getPrice(){
            return Integer.parseInt(price);
        }
    }
    public enum Reward{
        REWARD_1("4"),
        REWARD_2("3"),
        REWARD_3("2"),
        REWARD_4("1"),
        REWARD_5("0");

        private final String price;
        Reward(String price){
            this.price = price;
        }
        public int getPrice(){
            return Integer.parseInt(price);
        }
    }
}
