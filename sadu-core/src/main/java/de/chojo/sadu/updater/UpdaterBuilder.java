/*
 *     SPDX-License-Identifier: AGPL-3.0-only
 *
 *     Copyright (C) 2022 RainbowDashLabs and Contributor
 */

package de.chojo.sadu.updater;

import de.chojo.sadu.jdbc.JdbcConfig;

import javax.sql.DataSource;

public interface UpdaterBuilder<T extends JdbcConfig<?>, S extends UpdaterBuilder<T, ?>> {
    void setSource(DataSource source);
    void setVersion(SqlVersion version);
}
