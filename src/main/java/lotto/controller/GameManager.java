package lotto.controller;

public class GameManager {
    private int money = -1;
    private InputManager inputManager;

    public GameManager() {
        this.inputManager = new InputManager();
    }

    public void addCoin(){
        while (money == -1){
            money = inputManager.inputMoney();
        }
    }



}
