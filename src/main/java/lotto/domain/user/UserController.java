package lotto.domain.user;

import lotto.domain.converter.ConvertService;

public class UserController {
    private final ConvertService convertService;
    private final UserService userService;
    public UserController(ConvertService convertService,  UserService userService){
        this.convertService = convertService;
        this.userService = userService;
    }

    public User createUserWithAssets(final String userInput){
        int asset = convertService.stringToIntegerConverter(userInput);
        return createUserFromAsset(asset);
    }

    public UserLottoResponse buyLotto(final User user){
        return userService.buyAllPurchasableLotto(user);
    }
    public RateOfReturnResponse getRateOfReturn(final User user){return userService.getUserRateOfReturn(user);}
    private User createUserFromAsset(final int asset){
        return userService.createUser(asset);
    }



}
