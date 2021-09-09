package com.goldencodes.zbattle.manager.phase.ZBattle;

import com.goldencodes.zbattle.util.chat.C;

public class ZBattle {

    /*
     * This represents 10 Minutes
     */
    public static final int MINUTES_IN_GAME = 10 * 60 * 20;

    private static final String[] DESCRIPTION =
            {
                    C.cGreen + "Survivors" + C.Reset + " must last " + C.cYellow + "10 minutes" + C.Reset + " without getting infected by the " + C.cRed + "Zombies.",
                    C.cRed + "Zombies" + C.Reset + " infect as many " + C.cGreen + "Survivors " + C.Reset + "as possible before the times runs out!",
                    "",
                    C.cYellow + "The last team left alive wins!"
            };
    
    public ZBattle() {

    }
}
