package com.codingkata.rps.game.variants;

import com.codingkata.rps.game.RockPaperScissors;
import com.codingkata.rps.game.RpsOptions;
import com.codingkata.rps.game.RpsVariants;
import com.codingkata.rps.game.ai.RandomAi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Well variant of Rock-Paper-Scissors
 *
 * @author Tim Silhan
 */
public class WellRps extends RockPaperScissors {
    public WellRps() {
        super(RpsVariants.WELL, new RandomAi());
    }

    @Override
    protected Map<RpsOptions, List<RpsOptions>> createRuleSet() {
        Map<RpsOptions, List<RpsOptions>> rules = new HashMap<>();
        rules.put(RpsOptions.ROCK, Arrays.asList(RpsOptions.SCISSORS));
        rules.put(RpsOptions.PAPER, Arrays.asList(RpsOptions.ROCK, RpsOptions.WELL));
        rules.put(RpsOptions.SCISSORS, Arrays.asList(RpsOptions.PAPER));
        rules.put(RpsOptions.WELL, Arrays.asList(RpsOptions.ROCK, RpsOptions.SCISSORS));

        return rules;
    }
}
