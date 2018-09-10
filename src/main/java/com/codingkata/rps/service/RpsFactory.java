package com.codingkata.rps.service;

import com.codingkata.rps.game.RockPaperScissors;
import com.codingkata.rps.game.RpsVariants;

/**
 * Factory interface to choose a correct instance of RockPaperScissors
 * base on the variant.
 *
 * @author Tim Silhan
 */
public interface RpsFactory {
    /**
     * Chooses RockPaperScissor implementation based on the variant.
     *
     * @param variant variant of the game.
     * @return an instance that implements the variant.
     */
    RockPaperScissors getRpsInstance(RpsVariants variant);
}
