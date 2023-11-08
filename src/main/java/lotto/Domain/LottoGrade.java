package lotto.Domain;

public enum LottoGrade {
    THREE_MATCH(3,5000,false,Message.FIFTH),
    FOUR_MATCH(4,50000,false,Message.FOURTH),
    FIVE_MATCH(5,1500000,false,Message.THIRD),
    FIVE_MATCH_BONUS(5,30000000,true,Message.SECOND),
    SIX_MATCH(6,2000000000,false,Message.FIRST),
    LOSING(0,0,false,Message.Losing);

    private int matchNumber;
    private int money;
    private Boolean matchBonus;

    private Message message;


    LottoGrade(int matchNumber, int money, Boolean matchBonus,Message message) {
        this.matchNumber = matchNumber;
        this.money = money;
        this.matchBonus = matchBonus;
        this.message = message;
    }

    public static LottoGrade getLottoGrade(int matchNumber,Boolean matchBonus){
        for(LottoGrade lottoGrade : values()){              //values(Enum의 요소를 순서대로 enum타입의 배열로 리턴)
            if(lottoGrade.matchNumber == matchNumber && lottoGrade.matchBonus == matchBonus){
                return lottoGrade;
            }
        }
        return LOSING;
    }
    public int getMatchNumber() {
        return matchNumber;
    }


    public int getMoney() {
        return money;
    }

    public Message getMessage(){
        return message;
    }


}
