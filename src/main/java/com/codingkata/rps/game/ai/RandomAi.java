package com.codingkata.rps.game.ai;

import com.codingkata.rps.game.RpsOptions;

import java.util.Random;

/**
 * Ai for Rock-PaperScissors that chooses an option at random.
 *
 * @author Tim Silhan
 */
public class RandomAi implements RpsAi {
    @Override
    public RpsOptions makeChoice(RpsOptions[] options) {
        Random r = new Random();
        return options[r.nextInt(options.length)];
    }
}
