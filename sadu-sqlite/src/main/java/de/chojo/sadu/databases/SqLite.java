/*
 *     SPDX-License-Identifier: AGPL-3.0-only
 *
 *     Copyright (C) 2022 RainbowDashLabs and Contributor
 */

package de.chojo.sadu.databases;

import de.chojo.sadu.jdbc.SqLiteJdbc;

/**
 * Represents a SqLite database.
 */
public class SqLite extends DefaultDatabase<SqLiteJdbc> {

    private static final SqLite type = new SqLite();

    private SqLite() {
    }

    /**
     * The SqLite type.
     *
     * @return database type
     */
    public static SqLite sqlite() {
        return type;
    }

    /**
     * The SqLite type.
     *
     * @return database type
     */
    public static SqLite get() {
        return type;
    }

    @Override
    public String createVersionTableQuery(String table) {
        return String.format("CREATE TABLE IF NOT EXISTS %s(major INT, patch INT);", table);
    }

    @Override
    public String name() {
        return "sqlite";
    }

    @Override
    public SqLiteJdbc jdbcBuilder() {
        return new SqLiteJdbc();
    }

    @Override
    public String[] splitStatements(String queries) {
        return cleanStatements(queries.split(";"));
    }
}
