package com.codingkata.rps.game.ai;

import com.codingkata.rps.game.RpsOptions;

import java.util.Random;

public class RandomAi implements RpsAi {
    @Override
    public RpsOptions makeChoice(RpsOptions[] options) {
        Random r = new Random();
        return options[r.nextInt(options.length)];
    }
}
