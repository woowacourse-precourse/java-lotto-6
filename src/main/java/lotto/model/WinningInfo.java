package lotto.model;

public class WinningInfo {
    
    private int fifthrank = 0;
    private int fourthrank = 0;
    private int thirdrank = 0;
    private int secondrank = 0;
    private int firstrank = 0;
    private int totalamount = 0;

    public void setFifthRank(){
        this.fifthrank += 1;
        this.totalamount += 5000;
    }
    public void setfourthrank(){
        this.fourthrank += 1;
        this.totalamount += 50000;
    }
    public void setthirdrank(){
        this.thirdrank += 1;
        this.totalamount += 150000;
    }
    public void setsecondrank(){
        this.secondrank += 1;
        this.totalamount += 30000000;
    }
    public void setfirstrank(){
        this.firstrank += 1;
        this.totalamount += 2000000000;
    }

    public int getFifthRank(){
        return fifthrank;
    }
    public int getfourthrank(){
        return fourthrank;
    }
    public int getthirdrank(){
        return thirdrank;
    }
    public int getsecondrank(){
        return secondrank;
    }
    public int getfirstrank(){
        return firstrank;
    }
    public int getTotalAmount(){
        return totalamount;
    }
}
