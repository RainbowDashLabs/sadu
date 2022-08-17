package de.chojo.sadu.examples.datasource;

import com.zaxxer.hikari.HikariDataSource;
import de.chojo.sadu.databases.Postgres;
import de.chojo.sadu.datasource.DataSourceCreator;

public class Create {
    public static void main(String[] args) {
        // Create a new datasource for a postgres database
        HikariDataSource dataSource = DataSourceCreator.create(Postgres.postgres())
                // We configure the usual stuff.
                .configure(config -> config.host("localhost")
                        .port(5432)
                        .user("root")
                        .password("passy")
                        .database("db")
                        // Additionally we set some postgres specific stuff.
                        // This is only possible because we chose the postgres database type.
                        // First we set the schema to use
                        .currentSchema("default")
                        // We also set an application name
                        .applicationName("SADU-Examples")
                )
                // We create the hikari data source
                .create()
                // We set a max of 3 parallel connections.
                .withMaximumPoolSize(3)
                // And define that we want to keep always at least one connecction.
                .withMinimumIdle(1)
                // in the end we build our datasource.
                .build();
    }
}