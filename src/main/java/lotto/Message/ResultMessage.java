package lotto.Message;

public class ResultMessage {

    public void startMessage(){
        System.out.println(GameMessage.OUT_RESULT_LOTTO_START_MESSAGE);
    }

    public void firstMessage(int number){
        System.out.println(GameMessage.OUT_RESULT_CORRECT_THREE_MESSAGE + number + "개");
    }

    public void secondMessage(int number){
        System.out.println(GameMessage.OUT_RESULT_CORRECT_FOUR_MESSAGE + number + "개");
    }

    public void thirdMessage(int number){
        System.out.println(GameMessage.OUT_RESULT_CORRECT_FIVE_MESSAGE + number + "개");
    }

     public void fourthMessage(int number){
         System.out.println(GameMessage.OUT_REQUEST_BONUS_NUMBER_MESSAGE + number + "개");
     }

     public void fifthMessage(int number){
         System.out.println(GameMessage.OUT_RESULT_CORRECT_SIX_MESSAGE + number + "개");
     }

}
