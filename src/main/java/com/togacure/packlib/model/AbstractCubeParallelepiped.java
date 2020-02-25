package com.togacure.packlib.model;

import com.togacure.packlib.interfaces.IParallelepiped;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Vitaly Alekseev
 * @since 2/25/2020
 */
@Getter
@AllArgsConstructor
public abstract class AbstractCubeParallelepiped implements IParallelepiped {

    private final float height;

    private final float width;

    private final float depth;

}
