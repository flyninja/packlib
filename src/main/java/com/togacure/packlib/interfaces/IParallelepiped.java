package com.togacure.packlib.interfaces;

import java.util.stream.IntStream;
import lombok.NonNull;

/**
 * @author Vitaly Alekseev
 * @since 2/25/2020
 */
public interface IParallelepiped extends Comparable<IParallelepiped> {

    float getHeight();

    float getWidth();

    float getDepth();

    /* default overheads - cube parallelepiped */

    default float getHeightOverhead() {
        return 0;
    }

    default float getWidthOverhead() {
        return 0;
    }

    default float getDepthOverhead() {
        return 0;
    }

    /**
     * Compare two parallelepiped's. If this instance can be incapsulated by another, this method will return 'less than' or 'equals' flag
     * (negative integer or 0).
     * In another case the 'greater than' will returned.
     *
     * @param another
     * @return
     */
    @Override
    default int compareTo(final @NonNull IParallelepiped another) {
        return IntStream.of(Float.compare(getHeight() + getHeightOverhead(), another.getHeight() - another.getHeightOverhead()),
                Float.compare(getWidth() + getWidthOverhead(), another.getWidth() - another.getWidthOverhead()),
                Float.compare(getDepth() + getDepthOverhead(), another.getDepth() - another.getDepthOverhead()))
                .reduce(0,
                        (p, n) -> p <= 0 ? n : p
                );
    }
}
