package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoController {

        public void run(){

        }
        public void inputLottoPrice(){
                LottoView.mentionInputPrice();
                String inputPrice = Console.readLine();
        }
        private void vaildateLottoPrice(String inputPrice){
                if(inputPrice.isEmpty()){
                        throw new IllegalArgumentException("구입금액을 입력해 주세요.");
                }
                if(!inputPrice.matches("[0-9]+")){
                        throw new IllegalArgumentException("구입금액은 숫자만 입력 가능합니다.");
                }
        }
}
