package lotto.Domain;

public class LottoStats {
    private int matchCountThree;
    private int matchCountFour;
    private int matchCountFive;
    private int matchCountFiveWithBonus;
    private int matchCountSix;

    public int getMatchCountThree(){
        return matchCountThree;
    }

    public int getMatchCountFour(){
        return matchCountFour;
    }

    public int getMatchCountFive(){
        return matchCountFive;
    }

    public int getMatchCountFiveWithBonus(){
        return matchCountFiveWithBonus;
    }

    public int getMatchCountSix(){
        return matchCountSix;
    }

    public void addMatchCountThree(){
        this.matchCountThree += 1;
    }

    public void addMatchCountFour(){
        this.matchCountFour += 1;
    }

    public void addMatchCountFive(){
        this.matchCountFive += 1;
    }

    public void addMatchCountFiveWithBonus(){
        this.matchCountFiveWithBonus += 1;
    }

    public void addMatchCountSix(){
        this.matchCountSix += 1;
    }

}
