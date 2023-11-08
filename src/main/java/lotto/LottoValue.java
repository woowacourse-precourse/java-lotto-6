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
}
