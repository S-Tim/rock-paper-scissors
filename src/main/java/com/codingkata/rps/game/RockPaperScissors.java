package com.codingkata.rps.game;

import com.codingkata.rps.game.ai.RpsAi;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

/**
 * Abstract base class for Rock-Paper-Scissor games
 *
 * <p>A variant of the RPS game is defined by a rule set and a variant enum value.
 * Subclasses must only implement the {@link #createRuleSet()} method.
 * Valid options are represented by the key set of the rules.
 * The state of the last game played is always persisted in the class attributes.</p>
 *
 * @author Tim Silhan
 */
@Getter
public abstract class RockPaperScissors {
    private final RpsVariants variant;
    @Getter(AccessLevel.NONE)
    private Map<RpsOptions, List<RpsOptions>> ruleSet;
    @Setter
    private RpsAi ai;

    private RpsOptions playerChoice;
    private RpsOptions aiChoice;
    private RpsOutcomes outcome;

    public RockPaperScissors(RpsVariants variant, RpsAi ai) {
        this.variant = variant;
        this.ai = ai;
    }

    /**
     * Plays a game using the <tt>Map</tt> of rules provided by {@link #createRuleSet()} and
     * the <code>playerChoice</code> parameter.
     *
     * @param playerChoice The option that is used for the player
     * @return The result of the game
     */
    public final RpsOutcomes play(RpsOptions playerChoice) {
        if (!getRuleSet().keySet().contains(playerChoice)) {
            throw new IllegalArgumentException("The player choice is invalid.");
        }

        this.playerChoice = playerChoice;
        this.aiChoice = getAi().makeChoice(getValidOptions());
        this.outcome = determineWinner();

        return outcome;
    }

    /**
     * Creates the set of rules used to play the game.
     *
     * <p>Every valid option has to be a key in the map.
     * The corresponding list of options represents each option
     * that loses against the key.</p>
     *
     * @return The rules map
     */
    protected abstract Map<RpsOptions, List<RpsOptions>> createRuleSet();

    private RpsOutcomes determineWinner() {
        if (getRuleSet().get(getPlayerChoice()).contains(getAiChoice())) {
            return RpsOutcomes.PLAYER_WINS;
        } else if (getRuleSet().get(getAiChoice()).contains(getPlayerChoice())) {
            return RpsOutcomes.AI_WINS;
        } else {
            return RpsOutcomes.DRAW;
        }
    }

    public RpsOptions[] getValidOptions() {
        return getRuleSet().keySet().toArray(new RpsOptions[0]);
    }

    public Map<RpsOptions, List<RpsOptions>> getRuleSet() {
        if (this.ruleSet == null) {
            this.ruleSet = createRuleSet();
        }
        return ruleSet;
    }
}
