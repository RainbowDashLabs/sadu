/*
 *     SPDX-License-Identifier: AGPL-3.0-only
 *
 *     Copyright (C) 2022 RainbowDashLabs and Contributor
 */

package de.chojo.sadu.databases;

import de.chojo.sadu.jdbc.SqLiteJdbc;

public class SqLite extends DefaultType<SqLiteJdbc> {

    private static final SqLite type = new SqLite();

    public static SqLite sqlite() {
        return type;
    }

    @Override
    public String createVersionTableQuery(String table) {
        return String.format("CREATE TABLE IF NOT EXISTS %s(major INT, patch INT);", table);
    }

    @Override
    public String getName() {
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