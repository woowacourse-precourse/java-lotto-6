package lotto;

public class Application {
    GameController gameController = new GameController();

    void boot(){
        gameController.start();
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.boot();
    }
}
