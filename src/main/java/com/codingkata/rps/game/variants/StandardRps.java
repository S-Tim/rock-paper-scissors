package com.codingkata.rps.game.variants;

import com.codingkata.rps.game.RockPaperScissors;
import com.codingkata.rps.game.RpsOptions;
import com.codingkata.rps.game.RpsVariants;
import com.codingkata.rps.game.ai.RandomAi;

import java.util.*;

/**
 * Standard variant of Rock-Paper-Scissors
 *
 * @author Tim Silhan
 */
public class StandardRps extends RockPaperScissors {
    public StandardRps() {
        super(RpsVariants.STANDARD, new RandomAi());
    }

    @Override
    protected Map<RpsOptions, List<RpsOptions>> createRuleSet() {
        Map<RpsOptions, List<RpsOptions>> rules = new HashMap<>();
        rules.put(RpsOptions.ROCK, Arrays.asList(RpsOptions.SCISSORS));
        rules.put(RpsOptions.PAPER, Arrays.asList(RpsOptions.ROCK));
        rules.put(RpsOptions.SCISSORS, Arrays.asList(RpsOptions.PAPER));

        return rules;
    }
}
