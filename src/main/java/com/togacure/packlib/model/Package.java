package com.togacure.packlib.model;

import com.togacure.packlib.interfaces.IParallelepiped;
import lombok.Builder;

/**
 * Cube parallelepiped based implementation of package.
 *
 * @author Vitaly Alekseev
 * @since 2/25/2020
 */
public class Package extends AbstractCubeParallelepiped implements IParallelepiped {

    @Builder
    public Package(float height, float width, float depth) {
        super(height, width, depth);
    }

}
