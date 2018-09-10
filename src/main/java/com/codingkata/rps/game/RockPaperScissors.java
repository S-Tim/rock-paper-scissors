package com.codingkata.rps.game;

import com.codingkata.rps.game.ai.RpsAi;

import java.util.List;
import java.util.Map;

public abstract class RockPaperScissors {
    private final Map<RpsOptions, List<RpsOptions>> ruleSet;
    private final RpsVariants variant;
    private RpsAi ai;

    private RpsOptions playerChoice;
    private RpsOptions aiChoice;
    private RpsOutcomes outcome;

    public RockPaperScissors(RpsVariants variant, RpsAi ai) {
        this.variant = variant;
        this.ai = ai;
        this.ruleSet = createRuleSet();
    }

    public RpsOutcomes play(RpsOptions playerChoice) {
        if(playerChoice == null || !ruleSet.keySet().contains(playerChoice)){
            throw new IllegalArgumentException("The player choice is invalid.");
        }

        this.playerChoice = playerChoice;
        this.aiChoice = ai.makeChoice(getValidOptions());
        this.outcome = determineWinner();

        return outcome;
    }

    protected abstract Map<RpsOptions, List<RpsOptions>> createRuleSet();

    private RpsOutcomes determineWinner() {
        if (ruleSet.get(this.playerChoice).contains(this.aiChoice)) {
            return RpsOutcomes.PLAYER_WINS;
        } else if (ruleSet.get(this.aiChoice).contains(this.playerChoice)) {
            return RpsOutcomes.AI_WINS;
        } else {
            return RpsOutcomes.DRAW;
        }
    }

    public RpsOptions[] getValidOptions() {
        return ruleSet.keySet().toArray(new RpsOptions[0]);
    }

    public Map<RpsOptions, List<RpsOptions>> getRuleSet() {
        return ruleSet;
    }

    public RpsVariants getVariant() {
        return variant;
    }

    public RpsOptions getPlayerChoice() {
        return playerChoice;
    }

    public RpsOptions getAiChoice() {
        return aiChoice;
    }

    public RpsOutcomes getOutcome() {
        return outcome;
    }

    public RpsAi getAi() {
        return ai;
    }

    public void setAi(RpsAi ai) {
        this.ai = ai;
    }
}
