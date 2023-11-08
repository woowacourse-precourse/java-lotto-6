package LottoGame;

import lotto.*;
import net.bytebuddy.dynamic.scaffold.MethodGraph;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Lottogame {
    public Lottogame(){

    }

    private static final int TicketPrice = 1000;
    private static final int Percentage=100;
    private static InputPrice PlayerInputPrice;
    private static List<Integer> lotto = new ArrayList<>();
    private static List<Lotto> lottoList;
    private static WinningResult winningResult;

    private static List<Lotto> makeLottoToList(int ticketCount){
        lottoList=new ArrayList<>();
        for(int i=0;i<ticketCount;i++){
            lottoList.add(makeLotto());
        }
        return lottoList;
    }

    private static Lotto makeLotto(){
        LottoNumbers lottonumbers = new LottoNumbers();
        lotto = new ArrayList<>();

        lotto=LottoNumbers.pickRandNumbers();
        System.out.println(lotto);
        return new Lotto(lotto);

    }
    public void run(){
        start();
    }




}
