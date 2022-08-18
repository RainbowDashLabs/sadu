/*
 *     SPDX-License-Identifier: AGPL-3.0-only
 *
 *     Copyright (C) 2022 RainbowDashLabs and Contributor
 */

package de.chojo.sadu.wrapper.exception;

import de.chojo.sadu.wrapper.QueryBuilder;

import java.sql.SQLException;

/**
 * Exception to wrap {@link Exception} as {@link Exception} thrown during queries executed by {@link QueryBuilder}
 */
public class QueryExecutionException extends SQLException {
    /**
     * Cause of the exception
     */
    private SQLException cause;

    /**
     * Creates a new exception
     *
     * @param message message
     */
    public QueryExecutionException(String message) {
        super(message);
    }

    /**
     * {@inheritDoc}
     *
     * @throws ClassCastException If the throwable is not a {@link SQLException}
     */
    @Override
    public synchronized Throwable initCause(Throwable cause) {
        this.cause = (SQLException) cause;
        return super.initCause(cause);
    }

    @Override
    public String getSQLState() {
        return cause.getSQLState();
    }

    @Override
    public int getErrorCode() {
        return cause.getErrorCode();
    }

    @Override
    public String getMessage() {
        return cause.getMessage();
    }
}
