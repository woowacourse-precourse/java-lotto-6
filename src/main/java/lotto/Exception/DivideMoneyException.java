package lotto.Exception;

public class DivideMoneyException extends IllegalArgumentException{
     private static  final String ERRO_MESSAGE = "금액은 1000원 이상이고 1000원으로 나누어떨어져야합니다. ";

        public DivideMoneyException(){
            super(ERRO_MESSAGE);
        }
}
