package com.togacure.packlib.model;

import lombok.Builder;

/**
 * Cube parallelepiped based box implementation with border-width calculation.
 *
 * @author Vitaly Alekseev
 * @since 2/25/2020
 */
public class Box extends AbstractCubeParallelepiped {

    private final float border;

    @Builder
    public Box(float height, float width, float depth, float border) {
        super(height, width, depth);
        this.border = border;
    }

    @Override
    public float getHeightOverhead() {
        return border;
    }

    @Override
    public float getWidthOverhead() {
        return border;
    }

    @Override
    public float getDepthOverhead() {
        return border;
    }
}
