package org.seariver;

import org.seariver.screen.LevelScreen;
import org.seariver.screen.TelaInicial;

public class CardPickupGame extends BaseGame {

    public void create() {
        super.create();
        setActiveScreen(new TelaInicial(this));
    }
}
