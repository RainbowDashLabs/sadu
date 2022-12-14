/*
 *     SPDX-License-Identifier: AGPL-3.0-only
 *
 *     Copyright (C) 2022 RainbowDashLabs and Contributor
 */

package de.chojo.sadu.types;

import static de.chojo.sadu.types.SqlType.ofName;

/**
 * Types present in a SqLite database.
 */
public interface SqLiteTypes {
    /**
     * SqLite Text type
     */
    SqlType TEXT = ofName("TEXT");
    /**
     * SqLite integer type. Up to 64 bit.
     */
    SqlType INTEGER = ofName("INTEGER");
    /**
     * SqLite real type
     */
    SqlType REAL = ofName("REAL");
    /**
     * SqLite boolean type
     * Internally interpreted as an INTEGER
     */
    SqlType BOOLEAN = ofName("BOOLEAN", "INTEGER");
    /**
     * SqLite blob type
     */
    SqlType BLOB = ofName("BLOB");
}
