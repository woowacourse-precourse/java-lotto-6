package lotto.Control;

import lotto.View.CallSystemMessage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lotto.DTO.AutoTicketDTO;
import lotto.DTO.DrawWinNumberDTO;
import lotto.DTO.StatResultDTO;
import lotto.DTO.SystemMessageDTO;
import lotto.Model.CheckPurchaseAmount;
import lotto.Model.CheckWinNumber;
import lotto.Model.MakeAutoTicket;
import lotto.Model.MakeTotalProceeds;
import lotto.Model.StringToInt;
import lotto.Model.StringToList;

public class GameProcess {
    CallSystemMessage callMessage = new CallSystemMessage();
    

    PressEnter lottoInputSystem = new PressEnter();

    CheckPurchaseAmount validatecheck = new CheckPurchaseAmount();
    //List<Integer> test;

    public GameProcess(){
        //시작 메세지
        callMessage.printMessage(SystemMessageDTO.INPUT_PURCHASE_AMOUNT,true);
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
        int numberOfTicket = autoTicketDTO.getNumberOfTicket();
        //List<Integer> test;
        System.out.print(numberOfTicket);
        callMessage.printMessage(SystemMessageDTO.OUTPUT_NUMBER_OF_TICKET,true);

        for(int i=0;i<numberOfTicket;i++){
            MakeAutoTicket makeAutoTicket = new MakeAutoTicket();
            autoTicketDTO.setAutoTicket(i, makeAutoTicket.getnumbers());
            System.out.println(autoTicketDTO.getAutoTicket(i));
        }

        //당첨번호 지정
        System.out.println();
        callMessage.printMessage(SystemMessageDTO.INPUT_WINNING_NUMBERS,true);

        lottoInputSystem.plzPressEnter();
        String res2 = lottoInputSystem.getInput();
        StringToList parse3 = new StringToList(res2);
        List<Integer> vall = parse3.getListInteger();

        DrawWinNumberDTO drawWinNumberDTO = new DrawWinNumberDTO(vall);

        //System.out.println(drawWinNumberDTO.getWinNumber());
        System.out.println();
        callMessage.printMessage(SystemMessageDTO.INPUT_BONUS_NUMBER,true);

        lottoInputSystem.plzPressEnter();
        String res3 = lottoInputSystem.getInput();
        StringToInt parse5 = new StringToInt(res3);
        int valll = parse5.getInteger();

        drawWinNumberDTO.setBonusNumber(valll);

        //System.out.println(drawWinNumberDTO.getBonusNumber());

        StatResultDTO statResultDTO = new StatResultDTO();

        CheckWinNumber checkWinNumber = new CheckWinNumber();
        List<Integer> winCount = new ArrayList<>();

        // System.out.println("=================");
        // System.out.println(autoTicketDTO.getAutoTicket(1));
        // System.out.println(drawWinNumberDTO.getWinNumber());
        // System.out.println(drawWinNumberDTO.getBonusNumber());
        // System.out.println("=================");


        for(int i=0;i<numberOfTicket;i++){
            int cnt = checkWinNumber.checkWinNumber(autoTicketDTO.getAutoTicket(i), drawWinNumberDTO.getWinNumber(), drawWinNumberDTO.getBonusNumber());
            
            if(cnt==3) statResultDTO.setWinCount(0, statResultDTO.getWinCount(0)+1);
            if(cnt==4) statResultDTO.setWinCount(1, statResultDTO.getWinCount(1)+1);
            if(cnt==5) statResultDTO.setWinCount(2, statResultDTO.getWinCount(2)+1);
            if(cnt==7) statResultDTO.setWinCount(3, statResultDTO.getWinCount(3)+1);
            if(cnt==6) statResultDTO.setWinCount(4, statResultDTO.getWinCount(4)+1);
        }

        System.out.println();

        callMessage.printMessage(SystemMessageDTO.COMMENT_WINNING_STAT,true);        
        callMessage.printMessage(SystemMessageDTO.HORIZONTAL_RULE,true);

        callMessage.printMessage(SystemMessageDTO.FIFTH_STAT,false);
        System.out.println(statResultDTO.getWinCount(0)+"개");
        callMessage.printMessage(SystemMessageDTO.FOURTH_STAT,false);
        System.out.println(statResultDTO.getWinCount(1)+"개");
        callMessage.printMessage(SystemMessageDTO.THIRD_STAT,false);
        System.out.println(statResultDTO.getWinCount(2)+"개");
        callMessage.printMessage(SystemMessageDTO.SECOND_STAT,false);
        System.out.println(statResultDTO.getWinCount(3)+"개");
        callMessage.printMessage(SystemMessageDTO.FIRST_STAT,false);
        System.out.println(statResultDTO.getWinCount(4)+"개");



        //통계 계산 하기만 하면 됨. prizedto는 쓰는게 맞는지 한번 더 고민

        MakeTotalProceeds makeTotalProceeds = new MakeTotalProceeds();
        makeTotalProceeds.makeTotalProceeds(statResultDTO);
        //System.out.println("현재 총 수익 : " + statResultDTO.getTotalProceeds() + "현재 총 구입 : "+ autoTicketDTO.getPurcahseAmount());
        statResultDTO.setRateOfReturn(statResultDTO.getTotalProceeds(),autoTicketDTO.getPurcahseAmount());

        callMessage.printMessage(SystemMessageDTO.TOTAL_STAT, false);
        System.out.print(statResultDTO.getRateOfReturn() + "%");
        callMessage.printMessage(SystemMessageDTO.POSTPOSITION, false);
    }

}
