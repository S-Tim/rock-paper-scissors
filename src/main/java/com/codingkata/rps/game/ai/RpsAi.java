package com.codingkata.rps.game.ai;

import com.codingkata.rps.game.RpsOptions;

public interface RpsAi {
    RpsOptions makeChoice(RpsOptions[] options);
}
