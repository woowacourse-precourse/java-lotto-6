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
        PRICE_0("1000"),
        PRICE_1("5000"),
        PRICE_2("50000"),
        PRICE_3("1500000"),
        PRICE_4("3000000"),
        PRICE_5("2000000000");

        private final String price;
        PRICE(String price){
            this.price = price;
        }
        public int getPrice(){
            return Integer.parseInt(price);
        }
    }
}
