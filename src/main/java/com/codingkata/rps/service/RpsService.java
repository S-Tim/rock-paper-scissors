package com.codingkata.rps.service;

import com.codingkata.rps.dto.RockPaperScissorsDto;
import com.codingkata.rps.dto.RpsVariantInfo;
import com.codingkata.rps.game.RockPaperScissors;
import com.codingkata.rps.game.RpsOptions;
import com.codingkata.rps.game.RpsVariants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Rock-Paper-Scissors service to provide options for playing the different variations
 * <p>
 * It can also return the rules of each variant so that a client can discover them
 * without experimentation.
 *
 * @author Tim Silhan
 */
@Service
public class RpsService {
    private final RpsFactory rpsFactory;
    private List<RpsVariantInfo> ruleSets;

    @Autowired
    public RpsService(RpsFactory rpsFactory) {
        this.rpsFactory = rpsFactory;
    }

    /**
     * Creates a RockPaperScissors instance from the variant and plays
     * a game using the <code>playerChoice</code> parameter.
     *
     * @param variant      Variant of the RPS game.
     * @param playerChoice The option that the player chose.
     * @return A RPS instance that encapsulates the result of the game.
     */
    public RockPaperScissors playGame(RpsVariants variant, RpsOptions playerChoice) {
        if (variant == null) {
            throw new IllegalArgumentException("Variant cannot be null.");
        }
        if (playerChoice == null) {
            throw new IllegalArgumentException("Player choice cannot be null.");
        }

        RockPaperScissors rps = rpsFactory.getRpsInstance(variant);
        rps.play(playerChoice);

        return rps;
    }

    /**
     * Creates a DTO from a RockPaperScissors object.
     *
     * @param rps RockPaperScissors instance.
     * @return DTO of the instance.
     */
    public RockPaperScissorsDto getDto(RockPaperScissors rps) {
        if (rps == null) {
            throw new IllegalArgumentException("Rps cannot be null.");
        }

        return new RockPaperScissorsDto(rps.getVariant(), rps.getPlayerChoice(),
                rps.getAiChoice(), rps.getOutcome());
    }

    /**
     * Gets the rules for all variants of RPS.
     *
     * @return RpsVariantInfo list with the rules of each variant.
     */
    public List<RpsVariantInfo> getRuleSets() {
        if (ruleSets == null) {
            // Only do this once and cache the result because it is
            // potentially an expensive operation
            ruleSets = new ArrayList<>();

            for (RpsVariants variant : RpsVariants.values()) {
                RockPaperScissors rps = rpsFactory.getRpsInstance(variant);
                ruleSets.add(new RpsVariantInfo(rps.getVariant(), rps.getRuleSet()));
            }
        }

        return ruleSets;
    }
}
