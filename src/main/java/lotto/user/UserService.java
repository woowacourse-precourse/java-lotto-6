package lotto.user;


public class UserService {

    public User createUser(int assets){
        return new User(assets);
    }

    public int getUserAssets(User user){
        return user.getAsset();
    }
}
