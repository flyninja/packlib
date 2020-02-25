package com.togacure.packlib.interfaces;

import com.togacure.packlib.model.Box;
import lombok.NonNull;

/**
 * @author Vitaly Alekseev
 * @since 2/25/2020
 */
public interface IPackageValidator {

    default boolean isPackageFitInBox(final @NonNull com.togacure.packlib.model.Package pack, final @NonNull Box box) {
        return pack.compareTo(box) <= 0;
    }

}
