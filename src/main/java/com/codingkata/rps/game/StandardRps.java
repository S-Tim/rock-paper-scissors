package com.codingkata.rps.game;

import com.codingkata.rps.game.ai.RandomAi;

import java.util.*;

public class StandardRps extends RockPaperScissors{
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
