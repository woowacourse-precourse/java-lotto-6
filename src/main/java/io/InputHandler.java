package io;

import verifier.BonusNumberVerifier;
import verifier.MoneyVerifier;
import verifier.Verifier;
import verifier.WinnerNumberVerifier;

public final class InputHandler {

    private final Verifier MoneyVerier = new MoneyVerifier();
    private final Verifier BonusVerifier = new BonusNumberVerifier();
    private final Verifier WinnerNumberVerifier = new WinnerNumberVerifier();

    private InputHandler(){

    }

}
