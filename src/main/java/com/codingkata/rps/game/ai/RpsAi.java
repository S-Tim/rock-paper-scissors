package com.codingkata.rps.game.ai;

import com.codingkata.rps.game.RpsOptions;

/**
 * Interface for a Rock-Paper-Scissors AI.
 *
 * @author Tim Silhan
 */
public interface RpsAi {
    /**
     * Chooses an option from the <code>options</code> parameter
     *
     * @param options The available options
     * @return The chosen option
     */
    RpsOptions makeChoice(RpsOptions[] options);
}
