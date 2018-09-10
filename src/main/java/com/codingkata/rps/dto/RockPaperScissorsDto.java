package com.codingkata.rps.dto;

import com.codingkata.rps.game.RpsOptions;
import com.codingkata.rps.game.RpsOutcomes;
import com.codingkata.rps.game.RpsVariants;

/**
 * Data-Transfer-Object for RPS games.
 * <p>
 * Encapsulates the state and variant of the game that was played.
 *
 * @author Tim Silhan
 */
public class RockPaperScissorsDto {
    private RpsVariants variant;
    private RpsOptions playerChoice;
    private RpsOptions aiChoice;
    private RpsOutcomes outcome;

    public RockPaperScissorsDto() {

    }

    public RockPaperScissorsDto(RpsVariants variant, RpsOptions playerChoice, RpsOptions aiChoice, RpsOutcomes outcome) {
        this.variant = variant;
        this.playerChoice = playerChoice;
        this.aiChoice = aiChoice;
        this.outcome = outcome;
    }

    public RpsVariants getVariant() {
        return variant;
    }

    public void setVariant(RpsVariants variant) {
        this.variant = variant;
    }

    public RpsOptions getPlayerChoice() {
        return playerChoice;
    }

    public void setPlayerChoice(RpsOptions playerChoice) {
        this.playerChoice = playerChoice;
    }

    public RpsOptions getAiChoice() {
        return aiChoice;
    }

    public void setAiChoice(RpsOptions aiChoice) {
        this.aiChoice = aiChoice;
    }

    public RpsOutcomes getOutcome() {
        return outcome;
    }

    public void setOutcome(RpsOutcomes outcome) {
        this.outcome = outcome;
    }
}
