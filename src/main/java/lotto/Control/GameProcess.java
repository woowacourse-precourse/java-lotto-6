package lotto.Control;

import lotto.View.CallSystemMessage;

import java.util.List;

import lotto.DTO.AutoTicketDTO;
import lotto.DTO.DrawWinNumberDTO;
import lotto.DTO.SystemMessageDTO;
import lotto.Model.CheckPurchaseAmount;
import lotto.Model.MakeAutoTicket;
import lotto.Model.StringToInt;
import lotto.Model.StringToList;

public class GameProcess {
    CallSystemMessage callMessage = new CallSystemMessage();
    

    PressEnter lottoInputSystem = new PressEnter();

    CheckPurchaseAmount validatecheck = new CheckPurchaseAmount();
    //List<Integer> test;

    public GameProcess(){
        //시작 메세지
        callMessage.printMessage(SystemMessageDTO.INPUT_PURCHASE_AMOUNT);
        //입력 받기, 인트 파스
        lottoInputSystem.plzPressEnter();
        String res = lottoInputSystem.getInput();
        StringToInt parse2 = new StringToInt(res);
        int val = parse2.getInteger();

        System.out.println();
        //DTO에 저장
        AutoTicketDTO autoTicketDTO = new AutoTicketDTO(val);
        //유효 검사 및 티켓 수 획득
        int chongack = autoTicketDTO.getPurcahseAmount();
        //System.out.println(chongack);
        int tt = validatecheck.getNumberOfTicket(chongack);
        //System.out.println(tt);
        autoTicketDTO.setNumberOfTicket(tt);
        int formoon = autoTicketDTO.getNumberOfTicket();
        //List<Integer> test;
        System.out.print(formoon);
        callMessage.printMessage(SystemMessageDTO.OUTPUT_NUMBER_OF_TICKET);

        for(int i=0;i<formoon;i++){
            MakeAutoTicket makeAutoTicket = new MakeAutoTicket();
            autoTicketDTO.setAutoTicket(i, makeAutoTicket.getnumbers());
            System.out.println(autoTicketDTO.getAutoTicket(i));
        }

        //당첨번호 지정
        System.out.println();
        callMessage.printMessage(SystemMessageDTO.INPUT_WINNING_NUMBERS);

        lottoInputSystem.plzPressEnter();
        String res2 = lottoInputSystem.getInput();
        StringToList parse3 = new StringToList(res2);
        List<Integer> vall = parse3.getListInteger();

        DrawWinNumberDTO drawWinNumberDTO = new DrawWinNumberDTO(vall);

        //System.out.println(drawWinNumberDTO.getWinNumber());

        callMessage.printMessage(SystemMessageDTO.INPUT_BONUS_NUMBER);

        lottoInputSystem.plzPressEnter();
        String res3 = lottoInputSystem.getInput();
        StringToInt parse5 = new StringToInt(res3);
        int valll = parse5.getInteger();

        drawWinNumberDTO.setBonusNumber(valll);

        //System.out.println(drawWinNumberDTO.getBonusNumber());


    }

}
